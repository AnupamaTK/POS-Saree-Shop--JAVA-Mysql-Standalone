/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sareecenter.view;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import lk.ijse.sareecenter.common.IDGenarator;
import lk.ijse.sareecenter.controller.OrdersController;
import lk.ijse.sareecenter.controller.PaymentController;
import lk.ijse.sareecenter.dto.OrdersDTO;
import lk.ijse.sareecenter.dto.PaymentDTO;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author User
 */
public class PanelCustomerPayments extends javax.swing.JPanel {

    /**
     * Creates new form panelCustomerPayments
     */
    public PanelCustomerPayments() {
        initComponents();
        btnRefreshActionPerformed(null);
        setSelectType();
         tblPayment.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (tblPayment.getSelectedRow() == -1) {
                    return;
                }

                txtPaymentID.setText(tblPayment.getValueAt(tblPayment.getSelectedRow(), 0).toString());
                txtPaymentDate.setText(tblPayment.getValueAt(tblPayment.getSelectedRow(), 1).toString());
                txtOrderID.setText(tblPayment.getValueAt(tblPayment.getSelectedRow(), 2).toString());
                txtAmount.setText(tblPayment.getValueAt(tblPayment.getSelectedRow(), 3).toString());
                txtDiscount.setText(tblPayment.getValueAt(tblPayment.getSelectedRow(), 4).toString());
                txtNetAmount.setText(tblPayment.getValueAt(tblPayment.getSelectedRow(), 5).toString());
                txtCash.setText(tblPayment.getValueAt(tblPayment.getSelectedRow(), 6).toString());
                txtBalance.setText(tblPayment.getValueAt(tblPayment.getSelectedRow(), 7).toString());

            }
        });
    }
     private void setSelectType() {
        cmbSelectType.removeAllItems();
        cmbSelectType.addItem("Payment ID");
        cmbSelectType.addItem("Order ID");
        cmbSelectType.addItem("Payment Date");
        AutoCompleteDecorator.decorate(cmbSelectType);
    }

    private void setSelectedTypeItems() throws Exception {
        if (cmbSelectType.getSelectedItem() == "Payment ID") {
            setPaymentIDs();
        } else if (cmbSelectType.getSelectedItem() == "Order ID") {
            setOrderIDs();
        } else if (cmbSelectType.getSelectedItem() == "Payment Date") {
            setPaymentDates();
        }
    }

    private void setOrderIDs() throws Exception {
        ArrayList<PaymentDTO> allPayments = PaymentController.getAllPayments();
        cmbSelectItem.removeAllItems();

        if (allPayments == null) {
            return;
        }
        for (PaymentDTO payments : allPayments) {

            cmbSelectItem.addItem(payments.getOID());

        }
        AutoCompleteDecorator.decorate(cmbSelectItem);

    }

    private void setPaymentDates() throws Exception {
        ArrayList<PaymentDTO> allPayments = PaymentController.getAllPayments();
        cmbSelectItem.removeAllItems();

        if (allPayments == null) {
            return;
        }
        for (PaymentDTO payments : allPayments) {

            cmbSelectItem.addItem(payments.getP_date().toString());

        }
        AutoCompleteDecorator.decorate(cmbSelectItem);

    }

    private void setPaymentIDs() throws Exception {
        ArrayList<PaymentDTO> allPayments = PaymentController.getAllPayments();
        cmbSelectItem.removeAllItems();

        if (allPayments == null) {
            return;
        }
        for (PaymentDTO payments : allPayments) {

            cmbSelectItem.addItem(payments.getPID());

        }
        AutoCompleteDecorator.decorate(cmbSelectItem);

    }

    private Date parseDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(PanelPayment.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private void setOrderDates() throws Exception {
        ArrayList<OrdersDTO> allOrders = OrdersController.getAllOrderss();
        cmbSelectItem.removeAllItems();

        if (allOrders == null) {
            return;
        }
        for (OrdersDTO orders : allOrders) {

            cmbSelectItem.addItem(orders.getOID());

        }
        AutoCompleteDecorator.decorate(cmbSelectItem);

    }
     private void clearAllTexts() {
        txtPaymentID.setText("");
        txtPaymentDate.setText("");
        txtOrderID.setText("");
        txtAmount.setText("");
        txtDiscount.setText("");
        txtNetAmount.setText("");
        txtCash.setText("");
        txtBalance.setText("");
    }
      public void getID() {
        String newID;
        try {
            newID = IDGenarator.getNewID("Payment", "pid", "P");
            txtPaymentID.setText(newID);
        } catch (SQLException ex) {
            Logger.getLogger(PanelOrders.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        btnCancel = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPaymentID = new org.jdesktop.swingx.JXTextField();
        txtPaymentDate = new org.jdesktop.swingx.JXTextField();
        txtOrderID = new org.jdesktop.swingx.JXTextField();
        txtAmount = new org.jdesktop.swingx.JXTextField();
        txtDiscount = new org.jdesktop.swingx.JXTextField();
        txtNetAmount = new org.jdesktop.swingx.JXTextField();
        txtCash = new org.jdesktop.swingx.JXTextField();
        txtBalance = new org.jdesktop.swingx.JXTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPayment = new org.jdesktop.swingx.JXTable();
        cmbSelectItem = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cmbSelectType = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(166, 176, 176));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
        });

        btnCancel.setForeground(new java.awt.Color(51, 51, 51));
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/sareecenter/iconsS/Cancel_35px.png"))); // NOI18N
        btnCancel.setToolTipText("Click to clear");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("Balance");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("Cash");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 153));
        jLabel11.setText("Net Amount");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("Discount");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Amount");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Customer Payment ID");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Payment Date");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Order ID");

        txtPaymentID.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPaymentID.setPrompt("Payment ID");
        txtPaymentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaymentIDActionPerformed(evt);
            }
        });

        txtPaymentDate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPaymentDate.setPrompt("Payment Date");

        txtOrderID.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtOrderID.setPrompt("Order ID");

        txtAmount.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtAmount.setPrompt("Amount");

        txtDiscount.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtDiscount.setPrompt("Discount");

        txtNetAmount.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNetAmount.setPrompt("Net Amount");

        txtCash.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtCash.setPrompt("Cash");

        txtBalance.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtBalance.setPrompt("Balance");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtPaymentID, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPaymentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNetAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCash, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPaymentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(txtPaymentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(txtNetAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(txtCash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Select Date");

        btnRefresh.setBackground(new java.awt.Color(204, 204, 204));
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/sareecenter/iconsS/RefreshFrame 1_50px.png"))); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        tblPayment.setForeground(new java.awt.Color(51, 51, 51));
        tblPayment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Payment ID", "Payment Date", "Order ID", "Amount", "Discount", "Net Amount", "Cash", "Balance"
            }
        ));
        tblPayment.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jScrollPane1.setViewportView(tblPayment);

        cmbSelectItem.setBackground(new java.awt.Color(204, 204, 204));
        cmbSelectItem.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cmbSelectItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSelectItem.setToolTipText("To Get Items");
        cmbSelectItem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSelectItemItemStateChanged(evt);
            }
        });
        cmbSelectItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelectItemActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 153));
        jLabel13.setText("View All Customer Payments");

        cmbSelectType.setBackground(new java.awt.Color(204, 204, 204));
        cmbSelectType.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cmbSelectType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSelectType.setToolTipText(" To Get Types");
        cmbSelectType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSelectTypeItemStateChanged(evt);
            }
        });
        cmbSelectType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelectTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSelectType, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(cmbSelectItem, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 988, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSelectType, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSelectItem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        clearAllTexts();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtPaymentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaymentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaymentIDActionPerformed

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
       // getID();
    }//GEN-LAST:event_jPanel1MouseEntered

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        try {
            ArrayList<PaymentDTO> allPayments = PaymentController.getAllPayments();

            DefaultTableModel dtm = (DefaultTableModel) tblPayment.getModel();

            dtm.setRowCount(0);

            for (PaymentDTO payment : allPayments) {

                Object[] rowData = {payment.getPID(),
                    payment.getP_date(),
                    payment.getOID(),
                    payment.getAmount(),
                    payment.getDisount(),
                    payment.getNet_amount(),
                    payment.getCash(),
                    payment.getBalance()};

                dtm.addRow(rowData);

            }
        } catch (Exception ex) {
            Logger.getLogger(PanelPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void cmbSelectItemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSelectItemItemStateChanged
        try {
            if (cmbSelectItem.getSelectedIndex() == -1) {
                return;
            }
            PaymentDTO payments = null;
            if (cmbSelectType.getSelectedItem() == "Order ID") {
                payments = PaymentController.searchPayment(new PaymentDTO(null, null, cmbSelectItem.getSelectedItem().toString(), null, null, null, null, null));

            }
            if (cmbSelectType.getSelectedItem() == "Payment ID") {
                payments = PaymentController.searchPayment(new PaymentDTO(cmbSelectItem.getSelectedItem().toString(), null, null, null, null, null, null, null));
            }
            if (cmbSelectType.getSelectedItem() == "Payment Date") {
                payments = PaymentController.searchPayment(new PaymentDTO(null, cmbSelectItem.getSelectedItem().toString(), null, null, null, null, null, null));
            }

            if (payments == null) {
                return;

            }

            DefaultTableModel dtm = (DefaultTableModel) tblPayment.getModel();
            dtm.setRowCount(0);
            Object[] rowData = {payments.getPID(),
                payments.getP_date(),
                payments.getOID(),
                payments.getAmount(),
                payments.getDisount(),
                payments.getNet_amount(),
                payments.getBalance(),
                payments.getCash()};

            dtm.addRow(rowData);

            /*itemDescriptionText.setText(item.getDescription());
            qtyOnHandText.setText(item.getQtyOnHand() + "");
            itemPriceText.setText(item.getUnitPrice().toPlainString());*/
        } catch (Exception ex) {
            Logger.getLogger(PanelCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbSelectItemItemStateChanged

    private void cmbSelectItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelectItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSelectItemActionPerformed

    private void cmbSelectTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSelectTypeItemStateChanged
        try {
            setSelectedTypeItems();
        } catch (Exception ex) {
            Logger.getLogger(PanelPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbSelectTypeItemStateChanged

    private void cmbSelectTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelectTypeActionPerformed

    }//GEN-LAST:event_cmbSelectTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<String> cmbSelectItem;
    private javax.swing.JComboBox<String> cmbSelectType;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXTable tblPayment;
    private org.jdesktop.swingx.JXTextField txtAmount;
    private org.jdesktop.swingx.JXTextField txtBalance;
    private org.jdesktop.swingx.JXTextField txtCash;
    private org.jdesktop.swingx.JXTextField txtDiscount;
    private org.jdesktop.swingx.JXTextField txtNetAmount;
    private org.jdesktop.swingx.JXTextField txtOrderID;
    private org.jdesktop.swingx.JXTextField txtPaymentDate;
    private org.jdesktop.swingx.JXTextField txtPaymentID;
    // End of variables declaration//GEN-END:variables
}
