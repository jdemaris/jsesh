/*
 * @(#)OpenRecentFileAction.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw_7_6.app.action.file;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;

import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.jhotdraw_7_6.app.Application;
import org.jhotdraw_7_6.app.View;
import org.jhotdraw_7_6.app.action.AbstractApplicationAction;
import org.jhotdraw_7_6.gui.JSheet;
import org.jhotdraw_7_6.gui.Worker;
import org.jhotdraw_7_6.gui.event.SheetEvent;
import org.jhotdraw_7_6.gui.event.SheetListener;
import org.jhotdraw_7_6.net.URIUtil;
import org.jhotdraw_7_6.util.ResourceBundleUtil;

/**
 * Loads the specified URI into an empty view. If no empty view is available, a
 * new view is created.
 * <p>
 * This action is called when the user selects an item in the Recent Files
 * submenu of the File menu. The action and the menu item is automatically
 * created by the application, when the {@code ApplicationModel} provides a
 * {@code OpenFileAction}.
 * 
 * @author Werner Randelshofer.
 * @version $Id: OpenRecentFileAction.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class OpenRecentFileAction extends AbstractApplicationAction {

	public final static String ID = "file.openRecent";
	private URI uri;

	/** Creates a new instance. */
	public OpenRecentFileAction(Application app, URI uri) {
		super(app);
		this.uri = uri;
		putValue(Action.NAME, URIUtil.getName(uri));
	}

	public void actionPerformed(ActionEvent evt) {
		final Application app = getApplication();
		if (app.isEnabled()) {
			app.setEnabled(false);
			// Search for an empty view
			View emptyView = app.getActiveView();
			if (emptyView == null || !emptyView.isEmpty()
					|| !emptyView.isEnabled()) {
				emptyView = null;
			}

			final View p;
			if (emptyView == null) {
				p = app.createView();
				app.add(p);
				app.show(p);
			} else {
				p = emptyView;
			}
			openView(p);
		}
	}

	protected void openView(final View view) {
		final Application app = getApplication();
		app.setEnabled(true);

		// If there is another view with the same URI we set the multiple open
		// id of our view to max(multiple open id) + 1.
		int multipleOpenId = 1;
		for (View aView : app.views()) {
			if (aView != view && aView.isEmpty()) {
				multipleOpenId = Math.max(multipleOpenId,
						aView.getMultipleOpenId() + 1);
			}
		}
		view.setMultipleOpenId(multipleOpenId);
		view.setEnabled(false);

		// Open the file
		view.execute(new Worker() {

			protected Object construct() throws IOException {
				boolean exists = true;
				try {
					File f = new File(uri);
					exists = f.exists();
				} catch (IllegalArgumentException e) {
					// The URI does not denote a file, thus we can not check
					// whether the file exists.
				}
				if (exists) {
					view.read(uri, null);
					return null;
				} else {
					ResourceBundleUtil labels = ResourceBundleUtil
							.getBundle("org.jhotdraw_7_6.app.Labels");
					throw new IOException(labels.getFormatted(
							"file.open.fileDoesNotExist.message",
							URIUtil.getName(uri)));
				}
			}

			protected void done(Object value) {
				view.setURI(uri);
				Frame w = (Frame) SwingUtilities.getWindowAncestor(view
						.getComponent());
				if (w != null) {
					w.setExtendedState(w.getExtendedState() & ~Frame.ICONIFIED);
					w.toFront();
				}
				view.setEnabled(true);
				view.getComponent().requestFocus();
			}

			@Override
			protected void finished() {
				app.recomputeWindowMenu();
			}

			protected void failed(Throwable value) {
				value.printStackTrace();
				String message = value.getMessage() != null ? value
						.getMessage() : value.toString();
				ResourceBundleUtil labels = ResourceBundleUtil
						.getBundle("org.jhotdraw_7_6.app.Labels");
				JSheet.showMessageSheet(
						view.getComponent(),
						"<html>"
								+ UIManager.getString("OptionPane.css")
								+ "<b>"
								+ labels.getFormatted(
										"file.open.couldntOpen.message",
										URIUtil.getName(uri)) + "</b><p>"
								+ (message == null ? "" : message),
						JOptionPane.ERROR_MESSAGE, new SheetListener() {

							public void optionSelected(SheetEvent evt) {
								view.setEnabled(true);
							}
						});
			}
		});
	}
}
