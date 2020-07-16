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
public class SelectionPanelReturnItem extends javax.swing.JPanel {

    /**
     * Creates new form SelectionPanelReturnItem
     */
    public SelectionPanelReturnItem() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnReturnItem = new javax.swing.JButton();
        btnSearchreturnItem = new javax.swing.JButton();
        btnUpdateReturnItem = new javax.swing.JButton();
        btnRemoveReturnItem = new javax.swing.JButton();
        btnShowAllreturnItems = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        btnReturnItem.setBackground(new java.awt.Color(255, 255, 255));
        btnReturnItem.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnReturnItem.setForeground(new java.awt.Color(0, 153, 153));
        btnReturnItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/sacreecenter/icons/Plus_48px_1.png"))); // NOI18N
        btnReturnItem.setText("Add Return Item");
        btnReturnItem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReturnItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnItemActionPerformed(evt);
            }
        });

        btnSearchreturnItem.setBackground(new java.awt.Color(255, 255, 255));
        btnSearchreturnItem.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSearchreturnItem.setForeground(new java.awt.Color(0, 153, 153));
        btnSearchreturnItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/sacreecenter/icons/Search_48px.png"))); // NOI18N
        btnSearchreturnItem.setText("Search Return Item");
        btnSearchreturnItem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSearchreturnItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchreturnItemActionPerformed(evt);
            }
        });

        btnUpdateReturnItem.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdateReturnItem.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnUpdateReturnItem.setForeground(new java.awt.Color(0, 153, 153));
        btnUpdateReturnItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/sacreecenter/icons/Available Updates_48px.png"))); // NOI18N
        btnUpdateReturnItem.setText("Update Return Item");
        btnUpdateReturnItem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUpdateReturnItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateReturnItemActionPerformed(evt);
            }
        });

        btnRemoveReturnItem.setBackground(new java.awt.Color(255, 255, 255));
        btnRemoveReturnItem.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnRemoveReturnItem.setForeground(new java.awt.Color(0, 153, 153));
        btnRemoveReturnItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/sacreecenter/icons/Minus_48px.png"))); // NOI18N
        btnRemoveReturnItem.setText("Remove Return Item");
        btnRemoveReturnItem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRemoveReturnItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveReturnItemActionPerformed(evt);
            }
        });

        btnShowAllreturnItems.setBackground(new java.awt.Color(255, 255, 255));
        btnShowAllreturnItems.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnShowAllreturnItems.setForeground(new java.awt.Color(0, 153, 153));
        btnShowAllreturnItems.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/sacreecenter/icons/List_48px.png"))); // NOI18N
        btnShowAllreturnItems.setText("Show All Return Items");
        btnShowAllreturnItems.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnShowAllreturnItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllreturnItemsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnShowAllreturnItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReturnItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSearchreturnItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdateReturnItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemoveReturnItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btnReturnItem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnSearchreturnItem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnUpdateReturnItem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnRemoveReturnItem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnShowAllreturnItems, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturnItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnItemActionPerformed
        PanelReturnItem panelReturnItem = new PanelReturnItem();
        HomePage.pnlMain.removeAll();
        panelReturnItem.setSize(HomePage.pnlMain.getSize());
        panelReturnItem.setVisible(true);
        HomePage.pnlMain.add(panelReturnItem);
        HomePage.pnlMain.revalidate();
        HomePage.pnlMain.repaint();
    }//GEN-LAST:event_btnReturnItemActionPerformed

    private void btnSearchreturnItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchreturnItemActionPerformed
        PanelReturnItem panelReturnItem = new PanelReturnItem();
        HomePage.pnlMain.removeAll();
        panelReturnItem.setSize(HomePage.pnlMain.getSize());
        panelReturnItem.setVisible(true);
        HomePage.pnlMain.add(panelReturnItem);
        HomePage.pnlMain.revalidate();
        HomePage.pnlMain.repaint();
    }//GEN-LAST:event_btnSearchreturnItemActionPerformed

    private void btnUpdateReturnItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateReturnItemActionPerformed
        PanelReturnItem panelReturnItem = new PanelReturnItem();
        HomePage.pnlMain.removeAll();
        panelReturnItem.setSize(HomePage.pnlMain.getSize());
        panelReturnItem.setVisible(true);
        HomePage.pnlMain.add(panelReturnItem);
        HomePage.pnlMain.revalidate();
        HomePage.pnlMain.repaint();
    }//GEN-LAST:event_btnUpdateReturnItemActionPerformed

    private void btnRemoveReturnItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveReturnItemActionPerformed
        PanelReturnItem panelReturnItem = new PanelReturnItem();
        HomePage.pnlMain.removeAll();
        panelReturnItem.setSize(HomePage.pnlMain.getSize());
        panelReturnItem.setVisible(true);
        HomePage.pnlMain.add(panelReturnItem);
        HomePage.pnlMain.revalidate();
        HomePage.pnlMain.repaint();
    }//GEN-LAST:event_btnRemoveReturnItemActionPerformed

    private void btnShowAllreturnItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllreturnItemsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnShowAllreturnItemsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRemoveReturnItem;
    private javax.swing.JButton btnReturnItem;
    private javax.swing.JButton btnSearchreturnItem;
    private javax.swing.JButton btnShowAllreturnItems;
    private javax.swing.JButton btnUpdateReturnItem;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}