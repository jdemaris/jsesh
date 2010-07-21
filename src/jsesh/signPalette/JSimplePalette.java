/*
 * JSimplePalette.java
 *
 * Created on 2 juillet 2007, 15:10
 */

package jsesh.signPalette;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;

/**
 * Simple palette window.
 * @author  rosmord
 */
public class JSimplePalette extends javax.swing.JPanel {
    
    /** Creates new form JSimplePalette */
    public JSimplePalette() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        showContainingButtons = new javax.swing.JButton();
        inUserPaletteCheckBox = new javax.swing.JCheckBox();
        showVariantsButton = new javax.swing.JButton();
        categoryChooserCB = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        glyphInfoText = new javax.swing.JEditorPane();
        showAllCheckBox = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        glyphCodeLabel = new javax.swing.JLabel();
        glyphPictureLabel = new javax.swing.JLabel();
        translitterationFilterField = new javax.swing.JTextField();
        tagChooserCB = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        signTable = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        secondaryTagCB = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        showFilteredContainingButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        showContainingButtons.setIcon(new javax.swing.ImageIcon(getClass().getResource("partof.png"))); // NOI18N
        showContainingButtons.setToolTipText("Display signs which contain the selected sign");

        inUserPaletteCheckBox.setText("user Pal.");
        inUserPaletteCheckBox.setToolTipText("sign should appear in user palette.");

        showVariantsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("var.png"))); // NOI18N
        showVariantsButton.setToolTipText("Display variants of sign");

        categoryChooserCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        glyphInfoText.setEditable(false);
        jScrollPane1.setViewportView(glyphInfoText);

        showAllCheckBox.setText("Show all");
        showAllCheckBox.setToolTipText("Display all signs in the category, including variants");

        jLabel1.setText("Trlt. filter");

        glyphCodeLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        glyphCodeLabel.setText("        ");

        glyphPictureLabel.setBackground(java.awt.Color.white);
        glyphPictureLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(glyphCodeLabel)
                .add(70, 70, 70))
            .add(glyphPictureLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(glyphPictureLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(glyphCodeLabel))
        );

        translitterationFilterField.setColumns(5);
        translitterationFilterField.setToolTipText("Filter for translitteration\n");

        tagChooserCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        tagChooserCB.setToolTipText("Allows to select a sub-category of a hieroglyph family.");

        jLabel2.setText("Family");

        jLabel3.setText("Sub-Family");

        signTable.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        signTable.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        signTable.setVisibleRowCount(-1);
        jScrollPane2.setViewportView(signTable);

        jLabel4.setText("Sub-Sub-Family");

        secondaryTagCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        showFilteredContainingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("partoffiltered.png"))); // NOI18N
        showFilteredContainingButton.setToolTipText("<html>filter <strong>displayed</strong> signs which contain the selected sign  ");

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("stock_left-16.png"))); // NOI18N
        backButton.setToolTipText("<html>previously selected glyphs\n(JSesh remembers the last three selected signs).\n");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel4)
                            .add(jLabel2)
                            .add(showAllCheckBox)
                            .add(jLabel3))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(categoryChooserCB, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(tagChooserCB, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(secondaryTagCB, 0, 202, Short.MAX_VALUE)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 208, Short.MAX_VALUE)
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(translitterationFilterField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(showVariantsButton)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(inUserPaletteCheckBox)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(backButton)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 57, Short.MAX_VALUE)
                                .add(showFilteredContainingButton)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(showContainingButtons))
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))))
                .addContainerGap())
        );

        layout.linkSize(new java.awt.Component[] {jLabel2, jLabel3, jLabel4}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(categoryChooserCB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(tagChooserCB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(secondaryTagCB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(showAllCheckBox)
                    .add(translitterationFilterField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 108, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(9, 9, 9)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(showVariantsButton)
                    .add(showContainingButtons)
                    .add(inUserPaletteCheckBox)
                    .add(showFilteredContainingButton)
                    .add(backButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox categoryChooserCB;
    private javax.swing.JLabel glyphCodeLabel;
    private javax.swing.JEditorPane glyphInfoText;
    private javax.swing.JLabel glyphPictureLabel;
    private javax.swing.JCheckBox inUserPaletteCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox secondaryTagCB;
    private javax.swing.JCheckBox showAllCheckBox;
    private javax.swing.JButton showContainingButtons;
    private javax.swing.JButton showFilteredContainingButton;
    private javax.swing.JButton showVariantsButton;
    private javax.swing.JList signTable;
    private javax.swing.JComboBox tagChooserCB;
    private javax.swing.JTextField translitterationFilterField;
    // End of variables declaration//GEN-END:variables
    
	public javax.swing.JComboBox getCategoryChooserCB() {
		return categoryChooserCB;
	}

	public javax.swing.JLabel getGlyphCodeLabel() {
		return glyphCodeLabel;
	}

	public javax.swing.JEditorPane getGlyphInfoText() {
		return glyphInfoText;
	}

	public javax.swing.JLabel getGlyphPictureLabel() {
		return glyphPictureLabel;
	}

    public JList getSignTable() {
        return signTable;
    }
    
    public javax.swing.JCheckBox getShowAllCheckBox() {
		return showAllCheckBox;
	}

	public javax.swing.JButton getShowContainingButtons() {
		return showContainingButtons;
	}

	public javax.swing.JButton getShowVariantsButton() {
		return showVariantsButton;
	}

	public javax.swing.JTextField getTranslitterationFilterField() {
		return translitterationFilterField;
	}
    
	public javax.swing.JCheckBox getInUserPaletteCheckBox() {
		return inUserPaletteCheckBox;
	}
	
	public javax.swing.JComboBox getTagChooserCB() {
		return tagChooserCB;
	}

    public JComboBox getSecondaryTagCB() {
        return secondaryTagCB;
    }

    public JButton getShowFilteredContainingButton() {
        return showFilteredContainingButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    
  

    

    
}