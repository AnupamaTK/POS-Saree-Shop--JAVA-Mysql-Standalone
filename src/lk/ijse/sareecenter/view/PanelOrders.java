/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sareecenter.view;

import java.awt.Color;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import lk.ijse.sareecenter.common.IDGenarator;
import lk.ijse.sareecenter.common.SystemDate;
import lk.ijse.sareecenter.controller.ItemController;
import lk.ijse.sareecenter.controller.OrderDetailsController;
import lk.ijse.sareecenter.controller.OrdersController;
import lk.ijse.sareecenter.dto.ItemDTO;
import lk.ijse.sareecenter.dto.OrderDetailsDTO;
import lk.ijse.sareecenter.dto.OrdersDTO;
import lk.ijse.sareecenter.dto.PaymentDTO;
import static lk.ijse.sareecenter.view.PanelItem.myClr1;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author User
 */
public class PanelOrders extends javax.swing.JPanel {

    private String pID;

    /**
     * Creates new form panelCustomerPayments
     */
    public PanelOrders() throws Exception {
        initComponents();
        setSelectType();
        btnRefreshActionPerformed(null);
        // getID();
        getPID();
        tblOrders.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (tblOrders.getSelectedRow() == -1) {
                    return;
                }
                String id = tblOrders.getValueAt(tblOrders.getSelectedRow(), 0).toString();
                try {
                    ArrayList<OrderDetailsDTO> allOrderDetails = OrderDetailsController.getAllOrderDetailss();

                    DefaultTableModel dtm = (DefaultTableModel) tblOrderDetails.getModel();

                    dtm.setRowCount(0);

                    for (OrderDetailsDTO orderDetails : allOrderDetails) {
                        if (orderDetails.getOID()== id) {
                            Object[] rowData = {orderDetails.getI_code(),
                                orderDetails.getPrice(),
                                orderDetails.getQty(),};

                            dtm.addRow(rowData);
                        }

                    }
                } catch (Exception ex) {
                    Logger.getLogger(PanelItem.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

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

    private void setSelectType() {
        cmbSelectType.removeAllItems();
        cmbSelectType.addItem("Order id");
        cmbSelectType.addItem("Order Date");
        cmbSelectType.addItem("Customer ID");
        AutoCompleteDecorator.decorate(cmbSelectType);
    }

    private void setSelectedTypeItems() throws Exception {
        if (cmbSelectType.getSelectedItem() == "Order id") {
            setOrderIDs();
        } else if (cmbSelectType.getSelectedItem() == "Order Date") {
            setOrderDates();
        } else if (cmbSelectType.getSelectedItem() == "Customer ID") {
            setCustomerIDs();
        }
    }

    private void setOrderIDs() throws Exception {
        ArrayList<OrdersDTO> allOrders = OrdersController.getAllOrderss();
        cmbSelectedTypeItems.removeAllItems();

        if (allOrders == null) {
            return;
        }
        for (OrdersDTO orders : allOrders) {

            cmbSelectedTypeItems.addItem(orders.getOID());

        }
        AutoCompleteDecorator.decorate(cmbSelectedTypeItems);

    }

    private void setOrderDates() throws Exception {
        ArrayList<OrdersDTO> allOrders = OrdersController.getAllOrderss();
        cmbSelectedTypeItems.removeAllItems();

        if (allOrders == null) {
            return;
        }
        for (OrdersDTO orders : allOrders) {

            cmbSelectedTypeItems.addItem(orders.getO_date().toString());

        }
        AutoCompleteDecorator.decorate(cmbSelectedTypeItems);

    }

    private void setCustomerIDs() throws Exception {
        ArrayList<OrdersDTO> allOrders = OrdersController.getAllOrderss();
        cmbSelectedTypeItems.removeAllItems();

        if (allOrders == null) {
            return;
        }
        for (OrdersDTO orders : allOrders) {

            cmbSelectedTypeItems.addItem(orders.getCid());

        }
        AutoCompleteDecorator.decorate(cmbSelectedTypeItems);

    }

    private void clearItem() {
        txtItemCode.setText("");
        txtBrand.setText("");
        txtType.setText("");
        txtDescription.setText("");
        txtPrice.setText("");
        txtColour.setText("");
        spnrQty.setValue(0);

    }

    private void clearAll() {
        clearItem();
        txtOrderID.setText("");
        txtOrderDate.setText("");
        txtCustID.setText("");
        chbCashCustomer.setSelected(false);
        txtBalance.setText("");
        txtDiscount.setText("");
        txtTotalAmount.setText("");
        txtTotalQty.setText("");
        txtNetAmount.setText("");
        txtCash.setText("");
        txtQtyOnHand.setText("");
        DefaultTableModel dtm = (DefaultTableModel) tblItem.getModel();
        dtm.setRowCount(0);
    }

    private void addToItemTable() {

        try {
            //ArrayList<ItemDTO> allItems = ItemController.getAllItems();
            boolean contain = false;
            DefaultTableModel dtm = (DefaultTableModel) tblItem.getModel();
            int qty = (int) spnrQty.getValue();
            int qtyInT = Integer.parseInt(txtQtyOnHand.getText());
            int newQty = qtyInT - qty;
            int qtyInTable;
            String itemCode = txtItemCode.getText();
            if (tblItem.getRowCount() >= 0) {
                int row = -1;
                contain = false;

                for (int i = 0; i < tblItem.getRowCount(); i++) {
                    if (itemCode.equals((String) tblItem.getValueAt(i, 0))) {
                        row = i;
                        contain = true;
                        qtyInTable = (int) tblItem.getValueAt(i, 6);
                        qty = qty + qtyInTable;

                        int j = JOptionPane.showConfirmDialog(this, "Do you want To Update");
                        if (j == 0) {

                            dtm.setValueAt(qty, row, 6);
                            txtQtyOnHand.setText(Integer.toString(newQty));
                        }

                        break;
                    }
                }
            }

            if (!contain) {
                Object[] rowData = {txtItemCode.getText(),
                    txtType.getText(),
                    txtBrand.getText(),
                    txtColour.getText(),
                    txtDescription.getText(),
                    txtPrice.getText(),
                    spnrQty.getValue(),};

                dtm.addRow(rowData);

                txtQtyOnHand.setText(Integer.toString(newQty));

            }

        } catch (Exception ex) {
            Logger.getLogger(PanelItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setTotal() {
        Double value;
        Double total = 0.0;
        int qty = 0;
        int totalQty = 0;
        int rowCount = tblItem.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            qty = (int) tblItem.getValueAt(i, 6);
            value = Double.parseDouble((String) tblItem.getValueAt(i, 5));
            total += (value * qty);
            totalQty += qty;
        }
        txtTotalAmount.setText(total.toString());
        txtTotalQty.setText(Integer.toString(totalQty));

    }

    private void selectWithItemCode() {
        try {
            String itemCode = txtItemCode.getText();

            ItemDTO item = ItemController.searchItem(new ItemDTO(itemCode, null, null, null, null, null, null, 0));

            txtType.setText(item.getType());
            txtBrand.setText(item.getBrand());
            txtColour.setText(item.getColour());
            txtDescription.setText(item.getDescription());
            txtBrand.setText(item.getBrand());
            txtColour.setText(item.getColour());
            txtPrice.setText(item.getSelling_price().toString());
        } catch (Exception ex) {
            Logger.getLogger(PanelOrders.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getPID() throws SQLException, ClassNotFoundException {
        String newID;

        return newID = IDGenarator.getNewID("Orders", "oid", "O");

    }

    public void getID() {
        String newID;
        try {
            newID = IDGenarator.getNewID("Orders", "oid", "O");
            txtOrderID.setText(newID);
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

        jXTextField14 = new org.jdesktop.swingx.JXTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        btnAdd = new org.jdesktop.swingx.JXButton();
        jLabel1 = new javax.swing.JLabel();
        pnlOrderWithDetails = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnCancel1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        btnGoToItem = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btnAddToTable = new javax.swing.JButton();
        btnGoToCustomer = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        txtDescription = new org.jdesktop.swingx.JXTextField();
        txtType = new org.jdesktop.swingx.JXTextField();
        txtPrice = new org.jdesktop.swingx.JXTextField();
        txtBrand = new org.jdesktop.swingx.JXTextField();
        txtColour = new org.jdesktop.swingx.JXTextField();
        txtCustID = new org.jdesktop.swingx.JXTextField();
        txtOrderDate = new org.jdesktop.swingx.JXTextField();
        txtOrderID = new org.jdesktop.swingx.JXTextField();
        txtTotalQty = new org.jdesktop.swingx.JXTextField();
        txtTotalAmount = new org.jdesktop.swingx.JXTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItem = new org.jdesktop.swingx.JXTable();
        chbCashCustomer = new javax.swing.JCheckBox();
        jLabel25 = new javax.swing.JLabel();
        txtDiscount = new org.jdesktop.swingx.JXTextField();
        jLabel26 = new javax.swing.JLabel();
        txtNetAmount = new org.jdesktop.swingx.JXTextField();
        jLabel27 = new javax.swing.JLabel();
        txtCash = new org.jdesktop.swingx.JXTextField();
        jLabel28 = new javax.swing.JLabel();
        txtBalance = new org.jdesktop.swingx.JXTextField();
        btnCancelOrder = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        spnrQty = new javax.swing.JSpinner();
        btnSaveItemTable = new javax.swing.JButton();
        txtItemCode = new org.jdesktop.swingx.JXTextField();
        jLabel31 = new javax.swing.JLabel();
        txtQtyOnHand = new org.jdesktop.swingx.JXTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblOrders = new org.jdesktop.swingx.JXTable();
        btnRefresh = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        cmbSelectedTypeItems = new javax.swing.JComboBox<>();
        cmbSelectType = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrderDetails = new javax.swing.JTable();

        jXTextField14.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jXTextField14.setPrompt("Description");

        setBackground(new java.awt.Color(153, 153, 153));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setPreferredSize(new java.awt.Dimension(236, 781));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("ORDERS");
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnAdd.setBackground(new java.awt.Color(102, 102, 102));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/sareecenter/iconsS/Plus_35px_1.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setToolTipText("Click to Add order");
        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAdd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddMouseExited(evt);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/sareecenter/iconsS/Bill_40px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(234, 234, 234)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlOrderWithDetails.setBackground(new java.awt.Color(255, 255, 255));
        pnlOrderWithDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlOrderWithDetailsMouseEntered(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 153, 153));
        jLabel23.setText("Total Amount");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("Order ID");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 153, 153));
        jLabel19.setText("Total Qty");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 153, 153));
        jLabel17.setText("Brand");

        btnCancel1.setBackground(new java.awt.Color(255, 255, 255));
        btnCancel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/sareecenter/iconsS/Cancel_30px.png"))); // NOI18N
        btnCancel1.setToolTipText("Click to clear");
        btnCancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancel1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 153));
        jLabel11.setText("Order Date");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 153));
        jLabel14.setText("Item Code");

        jSeparator5.setForeground(new java.awt.Color(0, 153, 153));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 153));
        jLabel15.setText("Colour");

        btnGoToItem.setBackground(new java.awt.Color(255, 255, 255));
        btnGoToItem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGoToItem.setForeground(new java.awt.Color(102, 102, 102));
        btnGoToItem.setText("Select from Item");
        btnGoToItem.setToolTipText("Click to go to Item");
        btnGoToItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGoToItemMouseEntered(evt);
            }
        });
        btnGoToItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoToItemActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 153, 153));
        jLabel20.setText("Description");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 153));
        jLabel16.setText("Price");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 153, 153));
        jLabel22.setText("Type");

        btnAddToTable.setBackground(new java.awt.Color(255, 255, 255));
        btnAddToTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/sareecenter/iconsS/Ok_30px.png"))); // NOI18N
        btnAddToTable.setToolTipText("Click to Add to table");
        btnAddToTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToTableActionPerformed(evt);
            }
        });

        btnGoToCustomer.setBackground(new java.awt.Color(255, 255, 255));
        btnGoToCustomer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGoToCustomer.setForeground(new java.awt.Color(102, 102, 102));
        btnGoToCustomer.setText("Select From Customer");
        btnGoToCustomer.setToolTipText("Click to select Customer");
        btnGoToCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGoToCustomerMouseEntered(evt);
            }
        });
        btnGoToCustomer.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                btnGoToCustomerCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        btnGoToCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoToCustomerActionPerformed(evt);
            }
        });

        jSeparator4.setForeground(new java.awt.Color(0, 153, 153));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("Customer ID");

        jSeparator6.setForeground(new java.awt.Color(0, 153, 153));

        txtDescription.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtDescription.setPrompt("Description");

        txtType.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtType.setPrompt("Type");

        txtPrice.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPrice.setPrompt("Price");

        txtBrand.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtBrand.setPrompt("Brand");

        txtColour.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtColour.setPrompt("Colour");
        txtColour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColourActionPerformed(evt);
            }
        });

        txtCustID.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtCustID.setPrompt("Customer ID");

        txtOrderDate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtOrderDate.setPrompt("Order Date");

        txtOrderID.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtOrderID.setPrompt("Order ID");
        txtOrderID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrderIDActionPerformed(evt);
            }
        });

        txtTotalQty.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtTotalQty.setPrompt("Total Qty");

        txtTotalAmount.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtTotalAmount.setPrompt("Total Amount");

        tblItem.setForeground(new java.awt.Color(51, 51, 51));
        tblItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "Type", "Brand", "Colour", "Description", "Price", "Qty"
            }
        ));
        tblItem.setEditable(false);
        tblItem.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jScrollPane2.setViewportView(tblItem);

        chbCashCustomer.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        chbCashCustomer.setText("Cash  Customer");
        chbCashCustomer.setToolTipText("Click to select cash customer");
        chbCashCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbCashCustomerActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 153, 153));
        jLabel25.setText("Discount");

        txtDiscount.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtDiscount.setPrompt("Discount");
        txtDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiscountActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 153, 153));
        jLabel26.setText("Net Amount");

        txtNetAmount.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNetAmount.setPrompt("Net Amount");
        txtNetAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNetAmountActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 153, 153));
        jLabel27.setText("Cash");

        txtCash.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtCash.setPrompt("Cash");
        txtCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCashActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 153, 153));
        jLabel28.setText("Balance");

        txtBalance.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtBalance.setPrompt("Balance");

        btnCancelOrder.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/sareecenter/iconsS/Cancel_30px.png"))); // NOI18N
        btnCancelOrder.setToolTipText("Click to clear all");
        btnCancelOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelOrderActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 153, 153));
        jLabel32.setText("Qty");

        spnrQty.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        spnrQty.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnrQtyStateChanged(evt);
            }
        });
        spnrQty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                spnrQtyFocusGained(evt);
            }
        });
        spnrQty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spnrQtyMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                spnrQtyMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                spnrQtyMouseReleased(evt);
            }
        });

        btnSaveItemTable.setBackground(new java.awt.Color(255, 255, 255));
        btnSaveItemTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/sareecenter/iconsS/Ok_30px.png"))); // NOI18N
        btnSaveItemTable.setToolTipText("Click to do payments");
        btnSaveItemTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveItemTableActionPerformed(evt);
            }
        });

        txtItemCode.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtItemCode.setPrompt("Item Code");
        txtItemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemCodeActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 153, 153));
        jLabel31.setText("Qty On Hand");

        txtQtyOnHand.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtQtyOnHand.setPrompt("Qty On Hand");

        javax.swing.GroupLayout pnlOrderWithDetailsLayout = new javax.swing.GroupLayout(pnlOrderWithDetails);
        pnlOrderWithDetails.setLayout(pnlOrderWithDetailsLayout);
        pnlOrderWithDetailsLayout.setHorizontalGroup(
            pnlOrderWithDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                .addGroup(pnlOrderWithDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel8)
                        .addGap(79, 79, 79)
                        .addComponent(txtOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(334, 334, 334)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txtOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel9)
                        .addGap(46, 46, 46)
                        .addComponent(txtCustID, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(242, 242, 242)
                        .addComponent(chbCashCustomer)
                        .addGap(18, 18, 18)
                        .addComponent(btnGoToCustomer))
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel14)
                        .addGap(63, 63, 63)
                        .addComponent(txtItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(btnSaveItemTable, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel19)
                        .addGap(41, 41, 41)
                        .addComponent(txtTotalQty, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(txtNetAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel27)
                        .addGap(96, 96, 96)
                        .addComponent(txtCash, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel28)
                        .addGap(25, 25, 25)
                        .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(pnlOrderWithDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(41, 41, 41)
                                .addComponent(txtQtyOnHand, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(pnlOrderWithDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(txtColour, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(spnrQty, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99)
                                .addComponent(btnGoToItem)
                                .addGap(18, 18, 18)
                                .addComponent(btnAddToTable, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        pnlOrderWithDetailsLayout.setVerticalGroup(
            pnlOrderWithDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(pnlOrderWithDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(pnlOrderWithDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(pnlOrderWithDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtCustID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chbCashCustomer)
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnGoToCustomer)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(pnlOrderWithDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(pnlOrderWithDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(pnlOrderWithDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtColour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(pnlOrderWithDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(pnlOrderWithDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(spnrQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnGoToItem))
                    .addComponent(btnAddToTable, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlOrderWithDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(txtQtyOnHand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(pnlOrderWithDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(btnSaveItemTable, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlOrderWithDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(pnlOrderWithDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotalQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addGroup(pnlOrderWithDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtNetAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtCash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlOrderWithDetailsLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancelOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 153, 153));
        jLabel24.setText("View All Orders");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tblOrders.setForeground(new java.awt.Color(51, 51, 51));
        tblOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Date", "Customer ID", "Total Price", "Total Qty"
            }
        ));
        tblOrders.setEditable(false);
        tblOrders.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrdersMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblOrders);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/sareecenter/iconsS/RefreshFrame 1_50px.png"))); // NOI18N
        btnRefresh.setToolTipText("Click to reload");
        btnRefresh.setBorder(null);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setText("View Orders by");

        cmbSelectedTypeItems.setBackground(new java.awt.Color(204, 204, 204));
        cmbSelectedTypeItems.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cmbSelectedTypeItems.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSelectedTypeItems.setToolTipText("Click to select Item");
        cmbSelectedTypeItems.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSelectedTypeItemsItemStateChanged(evt);
            }
        });
        cmbSelectedTypeItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelectedTypeItemsActionPerformed(evt);
            }
        });

        cmbSelectType.setBackground(new java.awt.Color(204, 204, 204));
        cmbSelectType.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cmbSelectType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSelectType.setToolTipText("Click to select Type");
        cmbSelectType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSelectTypeItemStateChanged(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        tblOrderDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Item Code", "Qty", "Price"
            }
        ));
        jScrollPane1.setViewportView(tblOrderDetails);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSelectType, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSelectedTypeItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRefresh)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSelectType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSelectedTypeItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRefresh)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(pnlOrderWithDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlOrderWithDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoToCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoToCustomerActionPerformed
        try {
            chbCashCustomer.setSelected(false);
            new DialogCustomerInOrders(HomePage.homeFrame, true).setVisible(true);
            btnGoToItem.requestFocus();
        } catch (Exception ex) {
            Logger.getLogger(PanelOrders.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnGoToCustomerActionPerformed

    private void btnGoToItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoToItemActionPerformed
        new DialogItemInOrders(HomePage.homeFrame, true).setVisible(true);

        spnrQty.setValue(1);
        spnrQty.requestFocusInWindow();


    }//GEN-LAST:event_btnGoToItemActionPerformed

    private void btnAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseEntered
        btnAdd.setBackground(Color.lightGray);
    }//GEN-LAST:event_btnAddMouseEntered

    private void btnAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseExited
        btnAdd.setBackground(myClr1);
    }//GEN-LAST:event_btnAddMouseExited

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        try {

            OrdersDTO oDTO = new OrdersDTO(txtOrderID.getText(), txtOrderDate.getText(), txtCustID.getText(), new BigDecimal(txtNetAmount.getText()), Integer.parseInt(txtTotalQty.getText()));
            ArrayList<OrderDetailsDTO> orderDetailsDTOs = new ArrayList<>();
            OrderDetailsDTO orderDetailsDTO = null;
            for (int i = 0; i < tblItem.getRowCount(); i++) {
                orderDetailsDTO = new OrderDetailsDTO(txtOrderID.getText(), tblItem.getValueAt(i, 0).toString(), Integer.parseInt(tblItem.getValueAt(i, 6).toString()), new BigDecimal(tblItem.getValueAt(i, 5).toString()));
                orderDetailsDTOs.add(orderDetailsDTO);
            }
            PaymentDTO pDTO;
            pDTO = new PaymentDTO(getPID(), txtOrderDate.getText(), txtOrderID.getText(), new BigDecimal(txtTotalAmount.getText()), new BigDecimal(txtDiscount.getText()), new BigDecimal(txtNetAmount.getText()), new BigDecimal(txtCash.getText()), new BigDecimal(txtBalance.getText()));
            try {
                boolean added = OrdersController.addOrders(oDTO, orderDetailsDTOs, pDTO);
                if (added) {
                    JOptionPane.showMessageDialog(this, "Order Added");
                    btnRefreshActionPerformed(evt);
                    clearAll();

                }

            } catch (Exception ex) {
                Logger.getLogger(PanelOrders.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelOrders.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancel1ActionPerformed
        clearItem();
    }//GEN-LAST:event_btnCancel1ActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        try {
            ArrayList<OrdersDTO> allOrders = OrdersController.getAllOrderss();

            DefaultTableModel dtm = (DefaultTableModel) tblOrders.getModel();

            dtm.setRowCount(0);

            for (OrdersDTO orders : allOrders) {

                Object[] rowData = {orders.getOID(),
                    orders.getO_date(),
                    orders.getCid(),
                    orders.getTotal_price(),
                    orders.getTotal_qty(),};

                dtm.addRow(rowData);

            }
        } catch (Exception ex) {
            Logger.getLogger(PanelOrders.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnRefreshActionPerformed

    private void chbCashCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbCashCustomerActionPerformed
        if (chbCashCustomer.isSelected()) {
            txtCustID.setText("Cash Customer");
            btnGoToItem.requestFocus();
        } else {
            txtCustID.setText("");
            btnGoToCustomer.requestFocus();
        }
    }//GEN-LAST:event_chbCashCustomerActionPerformed

    private void cmbSelectTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSelectTypeItemStateChanged
        try {
            setSelectedTypeItems();
        } catch (Exception ex) {
            Logger.getLogger(PanelOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbSelectTypeItemStateChanged

    private void cmbSelectedTypeItemsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSelectedTypeItemsItemStateChanged
        try {
            if (cmbSelectedTypeItems.getSelectedIndex() == -1) {
                return;
            }
            OrdersDTO orders = null;
            if (cmbSelectType.getSelectedItem().equals("Order id")) {
                orders = OrdersController.searchOrders(new OrdersDTO(cmbSelectedTypeItems.getSelectedItem().toString(), null, null, null, 0));

            }
            if (cmbSelectType.getSelectedItem().equals("Order Date")) {
                orders = OrdersController.searchOrders(new OrdersDTO(null, cmbSelectedTypeItems.getSelectedItem().toString(), null, null, 0));
                System.out.println("in order date");
            }
            if (cmbSelectType.getSelectedItem().equals("Customer ID")) {

                orders = OrdersController.searchOrders(new OrdersDTO(null, null, cmbSelectedTypeItems.getSelectedItem().toString(), null, 0));
            }

            if (orders == null) {
                return;

            }

            DefaultTableModel dtm = (DefaultTableModel) tblOrders.getModel();
            dtm.setRowCount(0);
            Object[] rowData = {orders.getOID(),
                orders.getO_date(),
                orders.getCid(),
                orders.getTotal_price(),
                orders.getTotal_qty()};

            dtm.addRow(rowData);

            /*itemDescriptionText.setText(item.getDescription());
            qtyOnHandText.setText(item.getQtyOnHand() + "");
            itemPriceText.setText(item.getUnitPrice().toPlainString());*/
        } catch (Exception ex) {
            Logger.getLogger(PanelCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbSelectedTypeItemsItemStateChanged

    private void pnlOrderWithDetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlOrderWithDetailsMouseEntered

        txtOrderDate.setText(SystemDate.formatDate);
        getID();
        //txtOrderID.requestFocusInWindow();
        chbCashCustomer.requestFocusInWindow();

    }//GEN-LAST:event_pnlOrderWithDetailsMouseEntered

    private void txtOrderIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrderIDActionPerformed

    }//GEN-LAST:event_txtOrderIDActionPerformed

    private void btnGoToCustomerCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_btnGoToCustomerCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGoToCustomerCaretPositionChanged

    private void txtColourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColourActionPerformed

    }//GEN-LAST:event_txtColourActionPerformed

    private void btnGoToCustomerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGoToCustomerMouseEntered
        btnGoToCustomer.requestFocusInWindow();
    }//GEN-LAST:event_btnGoToCustomerMouseEntered

    private void btnGoToItemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGoToItemMouseEntered
        btnGoToItem.requestFocusInWindow();
    }//GEN-LAST:event_btnGoToItemMouseEntered

    private void btnCancelOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelOrderActionPerformed
        clearAll();


    }//GEN-LAST:event_btnCancelOrderActionPerformed

    private void spnrQtyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnrQtyStateChanged
        /* final int qtyOnHand=Integer.parseInt(txtQtyOnHand.getText());
        txtQtyOnHand.setText(qtyOnHand - (int) spnrQty.getValue());
        btnAddToTable.requestFocusInWindow();*/
    }//GEN-LAST:event_spnrQtyStateChanged

    private void spnrQtyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_spnrQtyFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_spnrQtyFocusGained

    private void spnrQtyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spnrQtyMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_spnrQtyMouseClicked

    private void spnrQtyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spnrQtyMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_spnrQtyMouseExited

    private void spnrQtyMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spnrQtyMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_spnrQtyMouseReleased

    private void btnAddToTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToTableActionPerformed
        addToItemTable();
    }//GEN-LAST:event_btnAddToTableActionPerformed

    private void btnSaveItemTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveItemTableActionPerformed
        setTotal();
        txtDiscount.requestFocusInWindow();
    }//GEN-LAST:event_btnSaveItemTableActionPerformed

    private void txtDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiscountActionPerformed

        double netAmount = Double.parseDouble(txtTotalAmount.getText()) - Double.parseDouble(txtDiscount.getText());
        txtNetAmount.setText(Double.toString(netAmount));
        txtCash.requestFocusInWindow();
    }//GEN-LAST:event_txtDiscountActionPerformed

    private void txtNetAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNetAmountActionPerformed
        //txtCash
    }//GEN-LAST:event_txtNetAmountActionPerformed

    private void txtCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCashActionPerformed
        double balance = Double.parseDouble(txtCash.getText()) - Double.parseDouble(txtNetAmount.getText());
        txtBalance.setText(Double.toString(balance));

    }//GEN-LAST:event_txtCashActionPerformed

    private void txtItemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemCodeActionPerformed
        selectWithItemCode();
    }//GEN-LAST:event_txtItemCodeActionPerformed

    private void cmbSelectedTypeItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelectedTypeItemsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSelectedTypeItemsActionPerformed

    private void tblOrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrdersMouseClicked
        try {
            String orderID=(String) tblOrders.getValueAt(tblOrders.getSelectedRow(),0);
            DefaultTableModel dtmOrderDetails = (DefaultTableModel)tblOrderDetails.getModel();
            ArrayList<OrderDetailsDTO> allByODID = OrderDetailsController.getAllByODID(orderID);
            if(allByODID==null)return;
            dtmOrderDetails.setRowCount(0);
            for (OrderDetailsDTO oDetail : allByODID) {
                Object[] rowDetail={oDetail.getI_code(),oDetail.getPrice(),oDetail.getQty()};
                dtmOrderDetails.addRow(rowDetail);
            }
        } catch (Exception ex) {
            Logger.getLogger(PanelOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_tblOrdersMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnAdd;
    private javax.swing.JButton btnAddToTable;
    private javax.swing.JButton btnCancel1;
    private javax.swing.JButton btnCancelOrder;
    private javax.swing.JButton btnGoToCustomer;
    private javax.swing.JButton btnGoToItem;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSaveItemTable;
    private javax.swing.JCheckBox chbCashCustomer;
    private javax.swing.JComboBox<String> cmbSelectType;
    private javax.swing.JComboBox<String> cmbSelectedTypeItems;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private org.jdesktop.swingx.JXTextField jXTextField14;
    private javax.swing.JPanel pnlOrderWithDetails;
    public static javax.swing.JSpinner spnrQty;
    public static org.jdesktop.swingx.JXTable tblItem;
    private javax.swing.JTable tblOrderDetails;
    private org.jdesktop.swingx.JXTable tblOrders;
    private org.jdesktop.swingx.JXTextField txtBalance;
    public static org.jdesktop.swingx.JXTextField txtBrand;
    private org.jdesktop.swingx.JXTextField txtCash;
    public static org.jdesktop.swingx.JXTextField txtColour;
    public static org.jdesktop.swingx.JXTextField txtCustID;
    public static org.jdesktop.swingx.JXTextField txtDescription;
    private org.jdesktop.swingx.JXTextField txtDiscount;
    public static org.jdesktop.swingx.JXTextField txtItemCode;
    private org.jdesktop.swingx.JXTextField txtNetAmount;
    private org.jdesktop.swingx.JXTextField txtOrderDate;
    private org.jdesktop.swingx.JXTextField txtOrderID;
    public static org.jdesktop.swingx.JXTextField txtPrice;
    public static org.jdesktop.swingx.JXTextField txtQtyOnHand;
    private org.jdesktop.swingx.JXTextField txtTotalAmount;
    private org.jdesktop.swingx.JXTextField txtTotalQty;
    public static org.jdesktop.swingx.JXTextField txtType;
    // End of variables declaration//GEN-END:variables

    private int dupRowNumner(String itemCode) {
        for (int i = 0; i < tblItem.getRowCount(); i++) {
            if (itemCode.equals((String) tblItem.getValueAt(i, 0))) {
                return i;
            }
        }
        return -1;
    }

    public void setQtyOnHand(String itemCode) {
        int rowNumber = dupRowNumner(itemCode);
        int qtyInTable = (int) tblItem.getValueAt(rowNumber, 6);
        txtQtyOnHand.setText(Integer.toString(Integer.parseInt(txtQtyOnHand.getText()) - qtyInTable));

    }
}
