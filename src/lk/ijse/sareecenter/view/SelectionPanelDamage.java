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
public class SelectionPanelDamage extends javax.swing.JPanel {

    /**
     * Creates new form panelDamage
     */
    public SelectionPanelDamage() {
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

        btnAddDamage = new javax.swing.JButton();
        btnRemoveDamage = new javax.swing.JButton();
        btnUpdateDamage = new javax.swing.JButton();
        btnDeleteDamage = new javax.swing.JButton();
        btnShowAllDamages = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));

        btnAddDamage.setBackground(new java.awt.Color(255, 255, 255));
        btnAddDamage.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAddDamage.setForeground(new java.awt.Color(0, 153, 153));
        btnAddDamage.setText("Add Damage");
        btnAddDamage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDamageActionPerformed(evt);
            }
        });

        btnRemoveDamage.setBackground(new java.awt.Color(255, 255, 255));
        btnRemoveDamage.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnRemoveDamage.setForeground(new java.awt.Color(0, 153, 153));
        btnRemoveDamage.setText("Remove Damage");
        btnRemoveDamage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveDamageActionPerformed(evt);
            }
        });

        btnUpdateDamage.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdateDamage.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnUpdateDamage.setForeground(new java.awt.Color(0, 153, 153));
        btnUpdateDamage.setText("Update Damage");
        btnUpdateDamage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDamageActionPerformed(evt);
            }
        });

        btnDeleteDamage.setBackground(new java.awt.Color(255, 255, 255));
        btnDeleteDamage.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnDeleteDamage.setForeground(new java.awt.Color(0, 153, 153));
        btnDeleteDamage.setText("Delete Damage");
        btnDeleteDamage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDamageActionPerformed(evt);
            }
        });

        btnShowAllDamages.setBackground(new java.awt.Color(255, 255, 255));
        btnShowAllDamages.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnShowAllDamages.setForeground(new java.awt.Color(0, 153, 153));
        btnShowAllDamages.setText("Show All Damages");
        btnShowAllDamages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllDamagesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnShowAllDamages, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteDamage, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateDamage, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoveDamage, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddDamage, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btnAddDamage, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnRemoveDamage, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnUpdateDamage, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnDeleteDamage, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnShowAllDamages, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddDamageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDamageActionPerformed
        PanelDamage PanelDamage = new PanelDamage();
        HomePage.pnlMain.removeAll();
        PanelDamage.setSize(HomePage.pnlMain.getSize());
        PanelDamage.setVisible(true);
        HomePage.pnlMain.add(PanelDamage);
        HomePage.pnlMain.revalidate();
        HomePage.pnlMain.repaint();
    }//GEN-LAST:event_btnAddDamageActionPerformed

    private void btnRemoveDamageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveDamageActionPerformed
        PanelDamage PanelDamage = new PanelDamage();
        HomePage.pnlMain.removeAll();
        PanelDamage.setSize(HomePage.pnlMain.getSize());
        PanelDamage.setVisible(true);
        HomePage.pnlMain.add(PanelDamage);
        HomePage.pnlMain.revalidate();
        HomePage.pnlMain.repaint();
    }//GEN-LAST:event_btnRemoveDamageActionPerformed

    private void btnUpdateDamageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDamageActionPerformed
        PanelDamage panelDamage = new PanelDamage();
        HomePage.pnlMain.removeAll();
        panelDamage.setSize(HomePage.pnlMain.getSize());
        panelDamage.setVisible(true);
        HomePage.pnlMain.add(panelDamage);
        HomePage.pnlMain.revalidate();
        HomePage.pnlMain.repaint();
    }//GEN-LAST:event_btnUpdateDamageActionPerformed

    private void btnDeleteDamageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDamageActionPerformed
        PanelDamage panelDamage = new PanelDamage();
        HomePage.pnlMain.removeAll();
        panelDamage.setSize(HomePage.pnlMain.getSize());
        panelDamage.setVisible(true);
        HomePage.pnlMain.add(panelDamage);
        HomePage.pnlMain.revalidate();
        HomePage.pnlMain.repaint();
    }//GEN-LAST:event_btnDeleteDamageActionPerformed

    private void btnShowAllDamagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllDamagesActionPerformed
        PanelDamage panelDamage = new PanelDamage();
        HomePage.pnlMain.removeAll();
        panelDamage.setSize(HomePage.pnlMain.getSize());
        panelDamage.setVisible(true);
        HomePage.pnlMain.add(panelDamage);
        HomePage.pnlMain.revalidate();
        HomePage.pnlMain.repaint();
    }//GEN-LAST:event_btnShowAllDamagesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDamage;
    private javax.swing.JButton btnDeleteDamage;
    private javax.swing.JButton btnRemoveDamage;
    private javax.swing.JButton btnShowAllDamages;
    private javax.swing.JButton btnUpdateDamage;
    // End of variables declaration//GEN-END:variables
}
