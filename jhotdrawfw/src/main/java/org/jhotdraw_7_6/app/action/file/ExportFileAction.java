/*
 * @(#)ExportFileAction.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw_7_6.app.action.file;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.jhotdraw_7_6.app.Application;
import org.jhotdraw_7_6.app.ApplicationModel;
import org.jhotdraw_7_6.app.View;
import org.jhotdraw_7_6.app.action.AbstractViewAction;
import org.jhotdraw_7_6.gui.JFileURIChooser;
import org.jhotdraw_7_6.gui.JSheet;
import org.jhotdraw_7_6.gui.URIChooser;
import org.jhotdraw_7_6.gui.Worker;
import org.jhotdraw_7_6.gui.event.SheetEvent;
import org.jhotdraw_7_6.gui.event.SheetListener;
import org.jhotdraw_7_6.net.URIUtil;
import org.jhotdraw_7_6.util.ResourceBundleUtil;

/**
 * Presents a file chooser to the user and then exports the contents of the
 * active view to the chosen file.
 * <p>
 * This action requires that {@link ApplicationModel#createExportChooser}
 * creates an appropriate {@link URIChooser}.
 * <p>
 * This action is called when the user selects the Export item in the File
 * menu. The menu item is automatically created by the application.
 * <p>
 * If you want this behavior in your application, you have to create an action
 * with this ID and put it in your {@code ApplicationModel} in method
 * {@link ApplicationModel#initApplication}. 
 *
 * @author Werner Randelshofer
 * @version $Id: ExportFileAction.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class ExportFileAction extends AbstractViewAction {

    public final static String ID = "file.export";
    private Component oldFocusOwner;

    /** Creates a new instance. */
    public ExportFileAction(Application app,  View view) {
        super(app, view);
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw_7_6.app.Labels");
        labels.configureAction(this, ID);
    }

    
    public void actionPerformed(ActionEvent evt) {
        final View view = (View) getActiveView();
        if (view.isEnabled()) {
            ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw_7_6.app.Labels");

            oldFocusOwner = SwingUtilities.getWindowAncestor(view.getComponent()).getFocusOwner();
            view.setEnabled(false);

            URIChooser fileChooser = getApplication().getExportChooser(view);

            JSheet.showSheet(fileChooser, view.getComponent(), labels.getString("filechooser.export"), new SheetListener() {

                
                public void optionSelected(final SheetEvent evt) {
                    if (evt.getOption() == JFileChooser.APPROVE_OPTION) {
                        final URI uri = evt.getChooser().getSelectedURI();
                        if (evt.getChooser()instanceof JFileURIChooser) {
                        exportView(view, uri, evt.getChooser());
                        } else {
                        exportView(view, uri, null);
                        }
                    } else {
                        view.setEnabled(true);
                        if (oldFocusOwner != null) {
                            oldFocusOwner.requestFocus();
                        }
                    }
                }
            });
        }
    }

    protected void exportView(final View view, final URI uri,
             final URIChooser chooser) {
        view.execute(new Worker() {

            
            protected Object construct() throws IOException {
                view.write(uri,chooser);
                return null;
            }

            
            protected void failed(Throwable value) {
                System.out.flush();
                ((Throwable) value).printStackTrace();
                // FIXME localize this error messsage
                JSheet.showMessageSheet(view.getComponent(),
                        "<html>" + UIManager.getString("OptionPane.css") +
                        "<b>Couldn't export to the file \"" + URIUtil.getName(uri) + "\".<p>" +
                        "Reason: " + value,
                        JOptionPane.ERROR_MESSAGE);
            }

            
            protected void finished() {
                view.setEnabled(true);
                SwingUtilities.getWindowAncestor(view.getComponent()).toFront();
                if (oldFocusOwner != null) {
                    oldFocusOwner.requestFocus();
                }
            }
        });
    }
}
