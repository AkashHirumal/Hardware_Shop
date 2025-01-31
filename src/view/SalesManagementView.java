/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.CustomerManagementController;
import controller.InventoryManagementController;
import controller.SalesManagementController;
import java.awt.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Customer;
import model.Item;
import model.Sale;

/**
 *
 * @author Akash
 */
public class SalesManagementView extends javax.swing.JFrame {

    /**
     * Creates new form InventoryManagementView
     */
    public SalesManagementView() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Hardware Shop Management System - Dashboard");
        loadtable();
        loadItemCombo();
        loadCustomerCombo();
    }

    private void loadItemCombo() {
        try {
            ArrayList<Item> itemsList = InventoryManagementController.getAllItems();
            int id = 1;
            for (Item item : itemsList) {
                cmbItem.addItem(item.toString());
                id++;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SalesManagementView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadCustomerCombo() {
        try {
            ArrayList<Customer> customerList = CustomerManagementController.getAllCustomers();
            int id = 1;
            for (Customer customer : customerList) {
                cmbCustomer.addItem(customer.toString());
                id++;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SalesManagementView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void loadtable() {
        try {
            ArrayList<Sale> salesList = SalesManagementController.getAllSales();
            DefaultTableModel dtm = (DefaultTableModel) tblSales.getModel();
            dtm.setRowCount(0);
            int id = 1;
            for (Sale sale : salesList) {
                Object[] rowData = {sale.getId(), InventoryManagementController.getNameById(sale.getItemId()), CustomerManagementController.getNameById(sale.getCustomerId()), sale.getQty(), sale.getTotalPrice()};
                dtm.addRow(rowData);
                id++;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SalesManagementView.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtStartDate = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();
        lblTotalSales = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSales = new javax.swing.JTable();
        btnRecordSale = new javax.swing.JButton();
        txtSEndDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblSalesTotal = new javax.swing.JLabel();
        cmbItem = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cmbCustomer = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnInventoryManagement1 = new javax.swing.JButton();
        btnSalesManagement1 = new javax.swing.JButton();
        btnCustomerManagement1 = new javax.swing.JButton();
        btnReports1 = new javax.swing.JButton();
        btnSettings1 = new javax.swing.JButton();
        btnLogOut2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setText("Sales Management");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Start Date (YYYY-MM-DD)");

        txtStartDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtStartDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStartDateActionPerformed(evt);
            }
        });

        btnFilter.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFilter.setText("Filter");
        btnFilter.setToolTipText("");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        lblTotalSales.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Select Item");

        tblSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Item", "Customer", "Quantity", "Total"
            }
        ));
        jScrollPane2.setViewportView(tblSales);

        btnRecordSale.setBackground(new java.awt.Color(255, 204, 204));
        btnRecordSale.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRecordSale.setText("Record Sale");
        btnRecordSale.setToolTipText("");
        btnRecordSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecordSaleActionPerformed(evt);
            }
        });

        txtSEndDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSEndDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSEndDateActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("End Date (YYYY-MM-DD)");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Filter Sales");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Total Sales :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Sale Details");

        lblSalesTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSalesTotal.setText("Sales Total");

        cmbItem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Select Customer");

        cmbCustomer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Quantity");

        txtQuantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnInventoryManagement1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnInventoryManagement1.setText("Inventory Management");
        btnInventoryManagement1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryManagement1ActionPerformed(evt);
            }
        });

        btnSalesManagement1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSalesManagement1.setText("Sales Management");
        btnSalesManagement1.setToolTipText("");
        btnSalesManagement1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalesManagement1ActionPerformed(evt);
            }
        });

        btnCustomerManagement1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCustomerManagement1.setText("Customer Management");
        btnCustomerManagement1.setToolTipText("");
        btnCustomerManagement1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerManagement1ActionPerformed(evt);
            }
        });

        btnReports1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReports1.setText("Reports");
        btnReports1.setToolTipText("");
        btnReports1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReports1ActionPerformed(evt);
            }
        });

        btnSettings1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSettings1.setText("Settings");
        btnSettings1.setToolTipText("");
        btnSettings1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettings1ActionPerformed(evt);
            }
        });

        btnLogOut2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLogOut2.setText("LogOut");
        btnLogOut2.setToolTipText("");
        btnLogOut2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOut2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCustomerManagement1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnReports1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSettings1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLogOut2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSalesManagement1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInventoryManagement1))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnInventoryManagement1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalesManagement1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCustomerManagement1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReports1)
                .addGap(12, 12, 12)
                .addComponent(btnSettings1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogOut2)
                .addContainerGap(380, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel1))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(txtSEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel9)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblSalesTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(214, 214, 214)
                                        .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(88, 88, 88)
                                .addComponent(lblTotalSales, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbItem, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel11))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(7, 7, 7)
                                            .addComponent(cmbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtQuantity))))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(btnRecordSale, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotalSales)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel7)
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(10, 10, 10)
                                        .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel5)
                                        .addGap(0, 0, 0)
                                        .addComponent(txtSEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(lblSalesTotal))
                                    .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbItem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cmbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRecordSale, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        String startDate = txtStartDate.getText();
        String endDate = txtSEndDate.getText();
        Double getTotal = 0.0;
        try {
            ArrayList<Double> totalList = SalesManagementController.getTotalByDates(startDate, endDate);
            for(Double price : totalList){
                getTotal+=price;
            }
            lblSalesTotal.setText(String.valueOf(getTotal));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SalesManagementView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnRecordSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecordSaleActionPerformed
        try {
            String selectedItem = cmbItem.getSelectedItem().toString();
            String[] itemParts = selectedItem.split(" - ");
            String itemNameAndId = itemParts[0];
            
            String selectedCustomer = cmbCustomer.getSelectedItem().toString();
            String[] customerParts = selectedCustomer.split(" - ");
            String customerNameAndId = customerParts[0];
            
            int itemId = Integer.parseInt(itemNameAndId.split(" \\(ID: ")[1].replace(")", ""));
            int customerID = Integer.parseInt(customerNameAndId.split(" \\(ID: ")[1].replace(")", ""));
            Integer qty = Integer.parseInt(txtQuantity.getText());
            Double unitPrice = InventoryManagementController.getUnitPriceById(itemId);
            Double total = qty*unitPrice;
            
            boolean isInserted = SalesManagementController.insertItem( new Sale(0, itemId, customerID, qty, total));
            if(isInserted){
                JOptionPane.showMessageDialog(null, "Sale Added");
                loadtable();
            }else{
                JOptionPane.showMessageDialog(null, "Sale Not Added");
            }
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SalesManagementView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

    }//GEN-LAST:event_btnRecordSaleActionPerformed

    private void txtSEndDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSEndDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSEndDateActionPerformed

    private void txtStartDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStartDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStartDateActionPerformed

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void btnInventoryManagement1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryManagement1ActionPerformed
        new CustomerManagementView().setVisible(true);
    }//GEN-LAST:event_btnInventoryManagement1ActionPerformed

    private void btnSalesManagement1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalesManagement1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalesManagement1ActionPerformed

    private void btnCustomerManagement1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerManagement1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCustomerManagement1ActionPerformed

    private void btnReports1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReports1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReports1ActionPerformed

    private void btnSettings1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettings1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSettings1ActionPerformed

    private void btnLogOut2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOut2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogOut2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SalesManagementView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesManagementView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesManagementView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesManagementView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesManagementView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCustomerManagement1;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnInventoryManagement1;
    private javax.swing.JButton btnLogOut2;
    private javax.swing.JButton btnRecordSale;
    private javax.swing.JButton btnReports1;
    private javax.swing.JButton btnSalesManagement1;
    private javax.swing.JButton btnSettings1;
    private javax.swing.JComboBox<String> cmbCustomer;
    private javax.swing.JComboBox<String> cmbItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblSalesTotal;
    private javax.swing.JLabel lblTotalSales;
    private javax.swing.JTable tblSales;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSEndDate;
    private javax.swing.JTextField txtStartDate;
    // End of variables declaration//GEN-END:variables
}
