/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sareecenter.view;

/**
 *
 * @author User
 */
public class SelectionPanelItem extends javax.swing.JPanel {

    /**
     * Creates new form panelItem
     */
    public SelectionPanelItem() {
        initComponents();
        subPanelItem.setVisible(false);
        subPanelItemTypes.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnItem = new javax.swing.JButton();
        btnItemTypes = new javax.swing.JButton();
        subPanelItem = new javax.swing.JPanel();
        btnAddItem = new javax.swing.JButton();
        btnSearchItem = new javax.swing.JButton();
        btnUpdateItem = new javax.swing.JButton();
        btnRemoveItem = new javax.swing.JButton();
        btnViewAllItems = new javax.swing.JButton();
        subPanelItemTypes = new javax.swing.JPanel();
        btnAddItemType = new javax.swing.JButton();
        btnSearchItemType = new javax.swing.JButton();
        btnUpdateItemType = new javax.swing.JButton();
        btnRemoveItemtype = new javax.swing.JButton();
        btnViewAllItemTypes = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(0, 153, 153));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnItem.setBackground(new java.awt.Color(255, 255, 255));
        btnItem.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnItem.setForeground(new java.awt.Color(0, 153, 153));
        btnItem.setText("Item");
        btnItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemActionPerformed(evt);
            }
        });
        jPanel6.add(btnItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, 100));

        btnItemTypes.setBackground(new java.awt.Color(255, 255, 255));
        btnItemTypes.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnItemTypes.setForeground(new java.awt.Color(0, 153, 153));
        btnItemTypes.setText("Item Types");
        btnItemTypes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemTypesActionPerformed(evt);
            }
        });
        jPanel6.add(btnItemTypes, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 170, 100));

        subPanelItem.setBackground(new java.awt.Color(0, 153, 153));
        subPanelItem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddItem.setBackground(new java.awt.Color(255, 255, 255));
        btnAddItem.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAddItem.setForeground(new java.awt.Color(0, 153, 153));
        btnAddItem.setText("Add Item");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });
        subPanelItem.add(btnAddItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 290, -1));

        btnSearchItem.setBackground(new java.awt.Color(255, 255, 255));
        btnSearchItem.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSearchItem.setForeground(new java.awt.Color(0, 153, 153));
        btnSearchItem.setText("Search Item");
        btnSearchItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchItemActionPerformed(evt);
            }
        });
        subPanelItem.add(btnSearchItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 290, -1));

        btnUpdateItem.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdateItem.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnUpdateItem.setForeground(new java.awt.Color(0, 153, 153));
        btnUpdateItem.setText("Update Item");
        btnUpdateItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateItemActionPerformed(evt);
            }
        });
        subPanelItem.add(btnUpdateItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 290, -1));

        btnRemoveItem.setBackground(new java.awt.Color(255, 255, 255));
        btnRemoveItem.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnRemoveItem.setForeground(new java.awt.Color(0, 153, 153));
        btnRemoveItem.setText("Remove Item");
        btnRemoveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveItemActionPerformed(evt);
            }
        });
        subPanelItem.add(btnRemoveItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 290, -1));

        btnViewAllItems.setBackground(new java.awt.Color(255, 255, 255));
        btnViewAllItems.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnViewAllItems.setForeground(new java.awt.Color(0, 153, 153));
        btnViewAllItems.setText("View All Item");
        btnViewAllItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllItemsActionPerformed(evt);
            }
        });
        subPanelItem.add(btnViewAllItems, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 290, -1));

        jPanel6.add(subPanelItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 344, 417));

        subPanelItemTypes.setBackground(new java.awt.Color(0, 153, 153));
        subPanelItemTypes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddItemType.setBackground(new java.awt.Color(255, 255, 255));
        btnAddItemType.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAddItemType.setForeground(new java.awt.Color(0, 153, 153));
        btnAddItemType.setText("Add ItemType");
        btnAddItemType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemTypeActionPerformed(evt);
            }
        });
        subPanelItemTypes.add(btnAddItemType, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 270, -1));

        btnSearchItemType.setBackground(new java.awt.Color(255, 255, 255));
        btnSearchItemType.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSearchItemType.setForeground(new java.awt.Color(0, 153, 153));
        btnSearchItemType.setText("Search Item Type");
        btnSearchItemType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchItemTypeActionPerformed(evt);
            }
        });
        subPanelItemTypes.add(btnSearchItemType, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 270, -1));

        btnUpdateItemType.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdateItemType.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnUpdateItemType.setForeground(new java.awt.Color(0, 153, 153));
        btnUpdateItemType.setText("Update Item Type");
        btnUpdateItemType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateItemTypeActionPerformed(evt);
            }
        });
        subPanelItemTypes.add(btnUpdateItemType, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 270, -1));

        btnRemoveItemtype.setBackground(new java.awt.Color(255, 255, 255));
        btnRemoveItemtype.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnRemoveItemtype.setForeground(new java.awt.Color(0, 153, 153));
        btnRemoveItemtype.setText("Remove Item Type");
        btnRemoveItemtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveItemtypeActionPerformed(evt);
            }
        });
        subPanelItemTypes.add(btnRemoveItemtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 270, -1));

        btnViewAllItemTypes.setBackground(new java.awt.Color(255, 255, 255));
        btnViewAllItemTypes.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnViewAllItemTypes.setForeground(new java.awt.Color(0, 153, 153));
        btnViewAllItemTypes.setText("View All Item Types");
        btnViewAllItemTypes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllItemTypesActionPerformed(evt);
            }
        });
        subPanelItemTypes.add(btnViewAllItemTypes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 270, -1));

        jPanel6.add(subPanelItemTypes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 344, 417));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 370, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnItemTypesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemTypesActionPerformed
        subPanelItem.setVisible(false);
        subPanelItemTypes.setVisible(true);
        HomePage.pnlMain.removeAll();
        HomePage.pnlMain.repaint();
    }//GEN-LAST:event_btnItemTypesActionPerformed

    private void btnSearchItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchItemActionPerformed
        PanelItem panelItem = new PanelItem();
        HomePage.pnlMain.removeAll();
        panelItem.setSize(HomePage.pnlMain.getSize());
        panelItem.setVisible(true);
        HomePage.pnlMain.add(panelItem);
        HomePage.pnlMain.revalidate();
        HomePage.pnlMain.repaint();
    }//GEN-LAST:event_btnSearchItemActionPerformed

    private void btnItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemActionPerformed
        subPanelItem.setVisible(true);
        subPanelItemTypes.setVisible(false);
        HomePage.pnlMain.removeAll();
        HomePage.pnlMain.repaint();
    }//GEN-LAST:event_btnItemActionPerformed

    private void btnSearchItemTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchItemTypeActionPerformed
        PanelItemType panelItemType = new PanelItemType();
        HomePage.pnlMain.removeAll();
        panelItemType.setSize(HomePage.pnlMain.getSize());
        panelItemType.setVisible(true);
        HomePage.pnlMain.add(panelItemType);
        HomePage.pnlMain.revalidate();
        HomePage.pnlMain.repaint();
    }//GEN-LAST:event_btnSearchItemTypeActionPerformed

    private void btnViewAllItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllItemsActionPerformed
        PanelItem panelItem = new PanelItem();
        HomePage.pnlMain.removeAll();
        panelItem.setSize(HomePage.pnlMain.getSize());
        panelItem.setVisible(true);
        HomePage.pnlMain.add(panelItem);
        HomePage.pnlMain.revalidate();
        HomePage.pnlMain.repaint();
    }//GEN-LAST:event_btnViewAllItemsActionPerformed

    private void btnRemoveItemtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveItemtypeActionPerformed
        PanelItemType panelItemType = new PanelItemType();
        HomePage.pnlMain.removeAll();
        panelItemType.setSize(HomePage.pnlMain.getSize());
        panelItemType.setVisible(true);
        HomePage.pnlMain.add(panelItemType);
        HomePage.pnlMain.revalidate();
        HomePage.pnlMain.repaint();
    }//GEN-LAST:event_btnRemoveItemtypeActionPerformed

    private void btnUpdateItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateItemActionPerformed
        PanelItem panelItem = new PanelItem();
        HomePage.pnlMain.removeAll();
        panelItem.setSize(HomePage.pnlMain.getSize());
        panelItem.setVisible(true);
        HomePage.pnlMain.add(panelItem);
        HomePage.pnlMain.revalidate();
        HomePage.pnlMain.repaint();
    }//GEN-LAST:event_btnUpdateItemActionPerformed

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        PanelItem panelItem = new PanelItem();
        HomePage.pnlMain.removeAll();
        panelItem.setSize(HomePage.pnlMain.getSize());
        panelItem.setVisible(true);
        HomePage.pnlMain.add(panelItem);
        HomePage.pnlMain.revalidate();
        HomePage.pnlMain.repaint();
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void btnRemoveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveItemActionPerformed
        PanelItem panelItem = new PanelItem();
        HomePage.pnlMain.removeAll();
        panelItem.setSize(HomePage.pnlMain.getSize());
        panelItem.setVisible(true);
        HomePage.pnlMain.add(panelItem);
        HomePage.pnlMain.revalidate();
        HomePage.pnlMain.repaint();
    }//GEN-LAST:event_btnRemoveItemActionPerformed

    private void btnAddItemTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemTypeActionPerformed
        PanelItemType panelItemType = new PanelItemType();
        HomePage.pnlMain.removeAll();
        panelItemType.setSize(HomePage.pnlMain.getSize());
        panelItemType.setVisible(true);
        HomePage.pnlMain.add(panelItemType);
        HomePage.pnlMain.revalidate();
        HomePage.pnlMain.repaint();
    }//GEN-LAST:event_btnAddItemTypeActionPerformed

    private void btnUpdateItemTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateItemTypeActionPerformed
        PanelItemType panelItemType = new PanelItemType();
        HomePage.pnlMain.removeAll();
        panelItemType.setSize(HomePage.pnlMain.getSize());
        panelItemType.setVisible(true);
        HomePage.pnlMain.add(panelItemType);
        HomePage.pnlMain.revalidate();
        HomePage.pnlMain.repaint();
    }//GEN-LAST:event_btnUpdateItemTypeActionPerformed

    private void btnViewAllItemTypesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllItemTypesActionPerformed
        PanelItemType panelItemType = new PanelItemType();
        HomePage.pnlMain.removeAll();
        panelItemType.setSize(HomePage.pnlMain.getSize());
        panelItemType.setVisible(true);
        HomePage.pnlMain.add(panelItemType);
        HomePage.pnlMain.revalidate();
        HomePage.pnlMain.repaint();
    }//GEN-LAST:event_btnViewAllItemTypesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnAddItemType;
    private javax.swing.JButton btnItem;
    private javax.swing.JButton btnItemTypes;
    private javax.swing.JButton btnRemoveItem;
    private javax.swing.JButton btnRemoveItemtype;
    private javax.swing.JButton btnSearchItem;
    private javax.swing.JButton btnSearchItemType;
    private javax.swing.JButton btnUpdateItem;
    private javax.swing.JButton btnUpdateItemType;
    private javax.swing.JButton btnViewAllItemTypes;
    private javax.swing.JButton btnViewAllItems;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    public static javax.swing.JPanel subPanelItem;
    public static javax.swing.JPanel subPanelItemTypes;
    // End of variables declaration//GEN-END:variables
}
