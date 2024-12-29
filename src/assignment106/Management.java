/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package assignment106;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JOptionPane; 
import java.sql.ResultSet; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author forbuc
 */
public class Management extends javax.swing.JFrame {

    /**
     * Creates new form Management
     */ 
    public Management() {
        initComponents();
        showLogin();
        fillcomboTName();
    }
    
    private void fillcomboTName(){
        try {
            cboTMTable.removeAllItems();
            cboTMTable.addItem("Select");
            Class.forName("com.mysql.jdbc.Driver"); 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/repairdb", "root", "mink123");
            DatabaseMetaData dbmd = con.getMetaData();
            String[] name= {"TABLE"};
            rs = null;
            rs = dbmd.getTables("repairdb", null, "%", name);
            while(rs.next()){
                
                cboTMTable.addItem(rs.getString("Table_Name"));
                
            }
        } catch (Exception e) {JOptionPane.showMessageDialog(this, e);}
    }
    
    
    
    public void ConnectionDetail(){
        url = "jdbc:mysql://localhost:3306/repairdb"; 
        driver = "com.mysql.jdbc.Driver";
        username = "root"; 
        password = "mink123";
    }
    
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String url ;
    String driver ;
    String username ; 
    String password ;
    int count = 0;
    
    public void showLogin(){ 
        ConnectionDetail();
        try{
            con = DriverManager.getConnection(url, username, password);
            
            String sql = "select * from user_login";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery(); 
            DefaultTableModel m = (DefaultTableModel)tblLogin.getModel();
            Object[] row = new Object[2];
            m.setRowCount(0);
            while(rs.next()){ 
                row[0] = rs.getString("user_ID");
                row[1] = rs.getString("password");
                m.addRow(row);
            }
        }catch(Exception e){ 
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    public void showCustomer(){ 
        ConnectionDetail();
        try{
            con = DriverManager.getConnection(url, username, password);
            
            String sql = "select * from customer";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery(); 
            DefaultTableModel m = (DefaultTableModel)tblCus.getModel();
            Object[] row = new Object[7];
            m.setRowCount(0);
            while(rs.next()){ 
                row[0] = rs.getString("Customer_ID");
                row[1] = rs.getString("Customer_Name");
                row[2] = rs.getString("Customer_Add");
                row[3] = rs.getString("Customer_Tel");
                row[4] = rs.getString("Customer_Email");
                row[5] = rs.getString("Customer_Gender");
                row[6] = rs.getString("Customer_Age");
  
                m.addRow(row);
            }
        }catch(Exception e){ 
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    public void showProduct(){ 
        ConnectionDetail();
        try{
            con = DriverManager.getConnection(url, username, password);
            
            String sql = "select * from TV_Products_and_services";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery(); 
            DefaultTableModel m = (DefaultTableModel)tblProduct.getModel();
            Object[] row = new Object[6];
            m.setRowCount(0);
            while(rs.next()){ 
                row [0] = rs.getString("TVproduct_ID");
                row [1] = rs.getString("TVproduct_Name");
                row [2] = rs.getString("TVproduct_Type");
                row [3] = rs.getString("TVproduct_Quantity");
                row [4] = rs.getString("TVproduct_Price");
                row [5] = rs.getString("Customer_ID");
  
                m.addRow(row);
            }
            tblProduct.setModel(m);
        }catch(Exception e){ 
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    void setColor(JPanel panel){ 
        panel.setBackground(new Color(85,65,118));
    }
    
    void resetColor(JPanel panel){ 
        panel.setBackground(new Color(64,43,100));
    }
    
    void tableColor(JPanel panel){ 
        panel.setBackground(new Color(54,33,89));
                
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
        jPanel3 = new javax.swing.JPanel();
        btnLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCustomer = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnService = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnTable = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnExit = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnModification = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        btnOtherTable = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnLoginAdd = new javax.swing.JButton();
        btnLoginUpdate = new javax.swing.JButton();
        btnLoginDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLogin = new javax.swing.JTable();
        txtLoginId = new javax.swing.JTextField();
        txtLoginPassword = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtLoginSearch = new javax.swing.JTextField();
        cboLogin = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        cboCus = new javax.swing.JComboBox<>();
        txtCusSearch = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCus = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnCusAdd = new javax.swing.JButton();
        btnCusUpdate = new javax.swing.JButton();
        btnCusDelete = new javax.swing.JButton();
        txtCusId = new javax.swing.JTextField();
        txtCusName = new javax.swing.JTextField();
        txtCusAdd = new javax.swing.JTextField();
        txtCusTel = new javax.swing.JTextField();
        txtCusEmail = new javax.swing.JTextField();
        txtCusGender = new javax.swing.JTextField();
        txtCusAge = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cboProduct = new javax.swing.JComboBox<>();
        txtProductSearch = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        txtProductId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtProductType = new javax.swing.JTextField();
        txtProductQty = new javax.swing.JTextField();
        txtProductPrice = new javax.swing.JTextField();
        txtCustomer = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btnProductAdd = new javax.swing.JButton();
        btnProductUpdate = new javax.swing.JButton();
        btnProductDelete = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cboColumn = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnCreate = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        cboTMTable = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblTM = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        txtCName = new javax.swing.JTextField();
        cboTMType = new javax.swing.JComboBox<>();
        chkTMN = new javax.swing.JCheckBox();
        chkTMP = new javax.swing.JCheckBox();
        btnTMAdd = new javax.swing.JButton();
        btnTMUpdate = new javax.swing.JButton();
        btnTMDeleteC = new javax.swing.JButton();
        btnTMDropT = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(54, 33, 89));

        btnLogin.setBackground(new java.awt.Color(85, 65, 118));
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLoginMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Login Info");

        javax.swing.GroupLayout btnLoginLayout = new javax.swing.GroupLayout(btnLogin);
        btnLogin.setLayout(btnLoginLayout);
        btnLoginLayout.setHorizontalGroup(
            btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnLoginLayout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        btnLoginLayout.setVerticalGroup(
            btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnLoginLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(20, 20, 20))
        );

        btnCustomer.setBackground(new java.awt.Color(64, 43, 100));
        btnCustomer.setPreferredSize(new java.awt.Dimension(0, 60));
        btnCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCustomerMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCustomerMousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Coustomer Info");

        javax.swing.GroupLayout btnCustomerLayout = new javax.swing.GroupLayout(btnCustomer);
        btnCustomer.setLayout(btnCustomerLayout);
        btnCustomerLayout.setHorizontalGroup(
            btnCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCustomerLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnCustomerLayout.setVerticalGroup(
            btnCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCustomerLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btnService.setBackground(new java.awt.Color(64, 43, 100));
        btnService.setPreferredSize(new java.awt.Dimension(0, 60));
        btnService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnServiceMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnServiceMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Service Info");

        javax.swing.GroupLayout btnServiceLayout = new javax.swing.GroupLayout(btnService);
        btnService.setLayout(btnServiceLayout);
        btnServiceLayout.setHorizontalGroup(
            btnServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnServiceLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnServiceLayout.setVerticalGroup(
            btnServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnServiceLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(20, 20, 20))
        );

        btnTable.setBackground(new java.awt.Color(54, 33, 89));
        btnTable.setPreferredSize(new java.awt.Dimension(0, 60));
        btnTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnTableMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Table Creation");

        javax.swing.GroupLayout btnTableLayout = new javax.swing.GroupLayout(btnTable);
        btnTable.setLayout(btnTableLayout);
        btnTableLayout.setHorizontalGroup(
            btnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTableLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel4)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        btnTableLayout.setVerticalGroup(
            btnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTableLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        btnExit.setBackground(new java.awt.Color(64, 43, 100));
        btnExit.setPreferredSize(new java.awt.Dimension(167, 49));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnExitMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("EXIT");

        javax.swing.GroupLayout btnExitLayout = new javax.swing.GroupLayout(btnExit);
        btnExit.setLayout(btnExitLayout);
        btnExitLayout.setHorizontalGroup(
            btnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnExitLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnExitLayout.setVerticalGroup(
            btnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnExitLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(14, 14, 14))
        );

        btnModification.setBackground(new java.awt.Color(54, 33, 89));
        btnModification.setPreferredSize(new java.awt.Dimension(0, 60));
        btnModification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificationMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnModificationMousePressed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 204, 204));
        jLabel25.setText("Table Modification");

        javax.swing.GroupLayout btnModificationLayout = new javax.swing.GroupLayout(btnModification);
        btnModification.setLayout(btnModificationLayout);
        btnModificationLayout.setHorizontalGroup(
            btnModificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnModificationLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(40, 40, 40))
        );
        btnModificationLayout.setVerticalGroup(
            btnModificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnModificationLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel25)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnOtherTable.setBackground(new java.awt.Color(54, 33, 89));
        btnOtherTable.setPreferredSize(new java.awt.Dimension(0, 60));
        btnOtherTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOtherTableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnOtherTableMousePressed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 204, 204));
        jLabel26.setText("Other Table ");

        javax.swing.GroupLayout btnOtherTableLayout = new javax.swing.GroupLayout(btnOtherTable);
        btnOtherTable.setLayout(btnOtherTableLayout);
        btnOtherTableLayout.setHorizontalGroup(
            btnOtherTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnOtherTableLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnOtherTableLayout.setVerticalGroup(
            btnOtherTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnOtherTableLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel26)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
            .addComponent(btnTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
            .addComponent(btnCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
            .addComponent(btnService, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
            .addComponent(btnModification, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
            .addComponent(btnOtherTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnModification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnOtherTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 0, 210, 642);

        jPanel16.setBackground(java.awt.Color.blue);

        jLabel6.setText("User_ID");

        btnLoginAdd.setText("ADD");
        btnLoginAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginAddActionPerformed(evt);
            }
        });

        btnLoginUpdate.setText("UPDATE");
        btnLoginUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginUpdateActionPerformed(evt);
            }
        });

        btnLoginDelete.setText("DELETE");
        btnLoginDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginDeleteActionPerformed(evt);
            }
        });

        tblLogin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "user_ID", "password"
            }
        ));
        tblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoginMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblLogin);

        jLabel12.setText("password");

        txtLoginSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginSearchActionPerformed(evt);
            }
        });
        txtLoginSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLoginSearchKeyReleased(evt);
            }
        });

        cboLogin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "user_ID", "password" }));
        cboLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoginActionPerformed(evt);
            }
        });

        jLabel27.setText("Search");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(btnLoginAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLoginUpdate)
                        .addGap(206, 206, 206)
                        .addComponent(btnLoginDelete))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtLoginId, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtLoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(cboLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtLoginSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLoginSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtLoginId, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(66, 66, 66)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoginAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoginDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoginUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", jPanel12);

        cboCus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Customer_ID     ", "Customer_Name", "Customer_Add", "Customer_Tel", "Customer_Email", "Customer_Gender", "Customer_Age" }));

        txtCusSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCusSearchKeyReleased(evt);
            }
        });

        tblCus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer_ID", "Customer_Name", "Customer_Add", "Customer_Tel", "Customer_Email", "Customer_Gender", "Customer_Age"
            }
        ));
        tblCus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCusMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblCus);

        jLabel9.setText("Coustomer_ID");

        jLabel13.setText("Customer_Name");

        jLabel14.setText("Customer_Add");

        jLabel15.setText("Customer_Tel");

        jLabel16.setText("Customer_Email");

        jLabel17.setText("Customer_Gender");

        jLabel18.setText("Customer_Age");

        btnCusAdd.setText("ADD");
        btnCusAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusAddActionPerformed(evt);
            }
        });

        btnCusUpdate.setText("UPDATE");
        btnCusUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusUpdateActionPerformed(evt);
            }
        });

        btnCusDelete.setText("DELETE");
        btnCusDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusDeleteActionPerformed(evt);
            }
        });

        txtCusTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCusTelActionPerformed(evt);
            }
        });

        txtCusEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCusEmailActionPerformed(evt);
            }
        });

        txtCusGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCusGenderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCusAdd, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                            .addGap(19, 19, 19))
                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(9, 9, 9)))
                                    .addComponent(jLabel15))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCusId, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel14Layout.createSequentialGroup()
                                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(txtCusAdd)
                                                    .addComponent(txtCusName)
                                                    .addComponent(txtCusTel, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                                                .addGap(165, 165, 165)
                                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel17)
                                                    .addComponent(jLabel16)
                                                    .addComponent(jLabel18)))
                                            .addGroup(jPanel14Layout.createSequentialGroup()
                                                .addGap(148, 148, 148)
                                                .addComponent(btnCusUpdate)))
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel14Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(btnCusDelete)
                                                    .addComponent(txtCusAge, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel14Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtCusEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtCusGender, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                        .addContainerGap(82, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(cboCus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCusSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCusSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtCusEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtCusGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtCusAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCusAdd)
                            .addComponent(btnCusUpdate)
                            .addComponent(btnCusDelete))
                        .addGap(43, 43, 43))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCusId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCusName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCusAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCusTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(106, 106, 106))))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jPanel10);

        jLabel7.setText("TVproduct_ID");

        cboProduct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "TVproduct_ID", "TVproduct_Name", "TVproduct_Type", "TVproduct_Quantity", "TVproduct_Price", "Customer_ID" }));

        txtProductSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProductSearchKeyReleased(evt);
            }
        });

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TVproduct_TV", "TVproduct_Name", "TVproduct_Type", "TVproduct_Quantity", "TVproduct_Price", "Customer_ID"
            }
        ));
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblProduct);

        jLabel8.setText("TVproduct_Name");

        jLabel19.setText("TVproduct_Type");

        jLabel20.setText("TVproduct_Quantity");

        jLabel21.setText("TVproduct_Price");

        jLabel22.setText("Customer_ID");

        btnProductAdd.setText("ADD");
        btnProductAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductAddActionPerformed(evt);
            }
        });

        btnProductUpdate.setText("UPDATE");
        btnProductUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductUpdateActionPerformed(evt);
            }
        });

        btnProductDelete.setText("DELETE");
        btnProductDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(btnProductAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnProductUpdate)
                        .addGap(190, 190, 190)
                        .addComponent(btnProductDelete))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(cboProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtProductSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(48, 48, 48)
                                .addComponent(txtProductId, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtProductName, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(txtProductType))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtProductQty, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtProductPrice, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtProductId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtProductType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProductAdd)
                    .addComponent(btnProductUpdate)
                    .addComponent(btnProductDelete))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab3", jPanel11);

        jPanel13.setBackground(java.awt.Color.blue);

        jLabel11.setText("Column Number");

        cboColumn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11" }));
        cboColumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboColumnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 582, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(282, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        jLabel10.setText("Table Name");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(63, 63, 63))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cboColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addGap(46, 46, 46)
                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab1", jPanel5);

        jLabel23.setText("Table Name");

        cboTMTable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        cboTMTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTMTableActionPerformed(evt);
            }
        });

        tblTM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblTM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTMMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblTM);

        jLabel24.setText("Column Name");

        cboTMType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        chkTMN.setText("Not Null");

        chkTMP.setText("Primary Key");

        btnTMAdd.setText("Add Column");
        btnTMAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTMAddActionPerformed(evt);
            }
        });

        btnTMUpdate.setText("Update Column");
        btnTMUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTMUpdateActionPerformed(evt);
            }
        });

        btnTMDeleteC.setText("Delete Column");
        btnTMDeleteC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTMDeleteCActionPerformed(evt);
            }
        });

        btnTMDropT.setText("Drop Table");
        btnTMDropT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTMDropTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnTMAdd)
                        .addGap(52, 52, 52)
                        .addComponent(btnTMUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTMDeleteC)
                        .addGap(59, 59, 59)
                        .addComponent(btnTMDropT))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel23)
                            .addGap(39, 39, 39)
                            .addComponent(cboTMTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel24)
                            .addGap(33, 33, 33)
                            .addComponent(txtCName, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(47, 47, 47)
                            .addComponent(cboTMType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(49, 49, 49)
                            .addComponent(chkTMN)
                            .addGap(45, 45, 45)
                            .addComponent(chkTMP))))
                .addContainerGap(99, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(cboTMTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtCName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTMType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkTMN)
                    .addComponent(chkTMP))
                .addGap(75, 75, 75)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTMAdd)
                    .addComponent(btnTMUpdate)
                    .addComponent(btnTMDeleteC)
                    .addComponent(btnTMDropT))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab5", jPanel4);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab6", jPanel7);

        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(210, 60, 770, 570);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 971, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnLoginMouseClicked

    private void btnCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustomerMouseClicked
        jTabbedPane1.setSelectedIndex(1);
        showCustomer();
    }//GEN-LAST:event_btnCustomerMouseClicked

    private void btnServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServiceMouseClicked
        jTabbedPane1.setSelectedIndex(2);
        showProduct();
    }//GEN-LAST:event_btnServiceMouseClicked

    private void btnTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTableMouseClicked
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_btnTableMouseClicked

    private void btnLoginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMousePressed
        setColor(btnLogin);
        resetColor(btnCustomer);
        resetColor(btnService);
        tableColor(btnTable);
        tableColor(btnModification);
        tableColor(btnOtherTable);
    }//GEN-LAST:event_btnLoginMousePressed

    private void btnCustomerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustomerMousePressed
        setColor(btnCustomer);
        resetColor(btnLogin);
        resetColor(btnService);
        tableColor(btnTable);
        tableColor(btnModification);
        tableColor(btnOtherTable);
        
    }//GEN-LAST:event_btnCustomerMousePressed

    private void btnServiceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServiceMousePressed
        setColor(btnService);        
        resetColor(btnLogin);
        resetColor(btnCustomer);
        tableColor(btnTable);
        tableColor(btnModification);
        tableColor(btnOtherTable);
    }//GEN-LAST:event_btnServiceMousePressed

    private void btnTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTableMousePressed
        setColor(btnTable);        
        resetColor(btnLogin);
        resetColor(btnCustomer);
        resetColor(btnService);
        tableColor(btnModification);
        tableColor(btnOtherTable);
    }//GEN-LAST:event_btnTableMousePressed

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnExitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMousePressed
        setColor(btnExit);        
        resetColor(btnLogin);
        resetColor(btnCustomer);
        resetColor(btnService);
        tableColor(btnTable);
        tableColor(btnModification);
        tableColor(btnOtherTable);
    }//GEN-LAST:event_btnExitMousePressed

    private void cboColumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboColumnActionPerformed

        if (cboColumn.getSelectedItem().toString().trim().equalsIgnoreCase("Select")) {
            jPanel6.removeAll();
            jPanel6.revalidate();
            jPanel6.repaint();
        }

        // Parse the selected count as an integer
        //int selectedCount = Integer.parseInt(selectedItem);
        int selectedCount = Integer.parseInt(cboColumn.getSelectedItem().toString());

        // Set up GroupLayout for jPanel6
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Create horizontal and vertical groups for the layout
        javax.swing.GroupLayout.ParallelGroup hGroup = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        javax.swing.GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        // Define component sizes
        java.awt.Dimension textFieldSize = new java.awt.Dimension(100, 25);
        java.awt.Dimension comboBoxSize = new java.awt.Dimension(100, 25);
        java.awt.Dimension checkBoxSize = new java.awt.Dimension(80, 25);

        for (int i = 0; i < selectedCount; i++) {
            
            javax.swing.JLabel lblName = new javax.swing.JLabel("Column Name " + (i + 1));

            javax.swing.JTextField txtType = new javax.swing.JTextField();
            txtType.setPreferredSize(textFieldSize);

            javax.swing.JComboBox<String> cboType = new javax.swing.JComboBox<>(new String[]{"Select", "int", "float", "double", "char(10)", "varchar(25)", "nvarchar(45)"});
            cboType.setPreferredSize(comboBoxSize);

            javax.swing.JCheckBox chkN = new javax.swing.JCheckBox("Not Null ");
            chkN.setPreferredSize(checkBoxSize);

            javax.swing.JCheckBox chkP = new javax.swing.JCheckBox("Primary Key ");
            chkP.setPreferredSize(checkBoxSize);

            // Add components to horizontal and vertical groups
            hGroup.addGroup(layout.createSequentialGroup()
                .addComponent(lblName, 100, 100, 150) 
                .addGap(20) 
                .addComponent(txtType)
                .addGap(40) 
                .addComponent(cboType)
                .addGap(40) 
                .addComponent(chkN)
                .addGap(40)
                .addComponent(chkP));

            vGroup.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblName)
                .addComponent(txtType)
                .addComponent(cboType)
                .addComponent(chkN)
                .addComponent(chkP));
        }

        // Set horizontal and vertical groups
        layout.setHorizontalGroup(hGroup);
        layout.setVerticalGroup(vGroup);

        // Refresh jPanel6
        jPanel6.revalidate();
        jPanel6.repaint();
    }//GEN-LAST:event_cboColumnActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
                                                 
        String tName = txtName.getText();

        // Ensure ConnectionDetail is properly established
        ConnectionDetail();

        try { 
            con = DriverManager.getConnection(url, username, password);
            StringBuilder sql = new StringBuilder("CREATE TABLE " + tName + " (");

            // Debugging: Check the number of components in jPanel6
            JOptionPane.showMessageDialog(this, "Component count in jPanel6: " + jPanel6.getComponentCount());

            /*for (java.awt.Component component : jPanel6.getComponents()) {
                if (component instanceof javax.swing.JPanel) {*/
                    javax.swing.JPanel panel = jPanel6;
                    for(int i=0;i< jPanel6.getComponentCount(); i+=5)
                    // Ensure the panel has the expected number of components
                    if (panel.getComponentCount() >= 5) {
                        String columnName = ((javax.swing.JTextField) panel.getComponent(i+1)).getText();
                        String columnType = ((javax.swing.JComboBox<?>) panel.getComponent(i+2)).getSelectedItem().toString();
                        boolean isNotNull = ((javax.swing.JCheckBox) panel.getComponent(i+3)).isSelected();
                        boolean isPrimaryKey = ((javax.swing.JCheckBox) panel.getComponent(i+4)).isSelected();

                        sql.append(columnName).append(" ").append(columnType);

                        if (isNotNull) {
                            sql.append(" NOT NULL");
                        }
                        if (isPrimaryKey) {
                            sql.append(" PRIMARY KEY");
                        }
                        sql.append(", ");
                    } else {
                        JOptionPane.showMessageDialog(this, "Panel does not have the expected number of components.");
                    }
                
            

            // Remove the last comma and space
            if (sql.length() > 2) {
                sql.setLength(sql.length() - 2);
            }
            sql.append(")");

            // Debugging: Check the generated SQL statement
            JOptionPane.showMessageDialog(this, "SQL: " + sql.toString());

            pstmt = con.prepareStatement(sql.toString());
            pstmt.execute();
            JOptionPane.showMessageDialog(this, "Table Created Successfully!");
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void txtLoginSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginSearchActionPerformed

    private void btnLoginDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginDeleteActionPerformed
        DefaultTableModel model = (DefaultTableModel)tblLogin.getModel();
        int index = tblLogin.getSelectedRow();
        ConnectionDetail();
        try{  
            con = DriverManager.getConnection(url, username, password);
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete?",  "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String sql = "delete from user_login where user_login = '"+txtLoginId.getText()+"'";
                pstmt = con.prepareStatement(sql);
                pstmt.execute(sql);
                showLogin();
                
                txtLoginId.setText(null);
                txtLoginPassword.setText(null);
                
                JOptionPane.showMessageDialog(this, "Deleted Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Deletion Cancelled");
            }
        }catch(Exception e){ 
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnLoginDeleteActionPerformed

    private void txtCusGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCusGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCusGenderActionPerformed

    private void txtCusEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCusEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCusEmailActionPerformed

    private void txtCusTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCusTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCusTelActionPerformed

    private void btnModificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificationMouseClicked
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_btnModificationMouseClicked

    private void btnModificationMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificationMousePressed
        setColor(btnModification);        
        resetColor(btnLogin);
        resetColor(btnCustomer);
        resetColor(btnService);
        tableColor(btnTable);
        tableColor(btnOtherTable);
    }//GEN-LAST:event_btnModificationMousePressed

    private void btnOtherTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOtherTableMouseClicked
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_btnOtherTableMouseClicked

    private void btnOtherTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOtherTableMousePressed
        setColor(btnOtherTable);        
        resetColor(btnLogin);
        resetColor(btnCustomer);
        resetColor(btnService);
        tableColor(btnTable);
        tableColor(btnModification);
    }//GEN-LAST:event_btnOtherTableMousePressed

    private void tblTMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTMMouseClicked
       
    }//GEN-LAST:event_tblTMMouseClicked

    private void tblLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoginMouseClicked
        DefaultTableModel model = (DefaultTableModel)tblLogin.getModel();
        int index = tblLogin.getSelectedRow();
        txtLoginId.setText(model.getValueAt(index, 0).toString());
        txtLoginPassword.setText(model.getValueAt(index, 1).toString());
    }//GEN-LAST:event_tblLoginMouseClicked

    private void btnLoginAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginAddActionPerformed
        ConnectionDetail();
        Object[] row = new Object[2];
        
        row[0] = txtLoginId.getText();
        row[1] = txtLoginPassword.getText();
        DefaultTableModel model = (DefaultTableModel)tblLogin.getModel(); // add directly to table 
        model.addRow(row);

        try{ 
            con = DriverManager.getConnection(url, username, password);
            String sql = "insert into user_login values ('"+txtLoginId.getText()+"', '"+txtLoginPassword.getText()+"')";
            pstmt = con.prepareStatement(sql); 
            pstmt.execute(sql);
            showLogin();
            
            txtLoginId.setText(null);
            txtLoginPassword.setText(null);
            
            JOptionPane.showMessageDialog(this, "Inserted Successful");
        }catch(Exception e){ 
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnLoginAddActionPerformed

    private void btnLoginUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginUpdateActionPerformed
        DefaultTableModel model = (DefaultTableModel)tblLogin.getModel();
        int index = tblLogin.getSelectedRow();
        if (index >= 0){ 
            ConnectionDetail();
            try{ 
                con = DriverManager.getConnection(url, username, password);
                String sql = "update user_login set user_ID = '"+txtLoginId.getText()+"', password = '"+txtLoginPassword.getText()+"' where username = '"+txtLoginId.getText()+"'";
                pstmt = con.prepareStatement(sql); 
                pstmt.executeUpdate(sql);
                showLogin();
                
                txtLoginId.setText(null);
                txtLoginPassword.setText(null);
                
                JOptionPane.showMessageDialog(null, "Update Success");
                
            }catch(Exception e){ 
                JOptionPane.showMessageDialog(this, e);
            }
        }else{ 
            JOptionPane.showMessageDialog(this, "Please select a row to update");
        }
    }//GEN-LAST:event_btnLoginUpdateActionPerformed

    private void cboLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoginActionPerformed
        ConnectionDetail();
        try { 
            //String sql = "describe login"; 
            String sql = "select * from user_login";
            
            
            pstmt = con.prepareStatement(sql); 
            rs = pstmt.executeQuery(); 
            
            tblLogin.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch(Exception e){ 
            JOptionPane.showMessageDialog(this, e);
        }        
    }//GEN-LAST:event_cboLoginActionPerformed

    private void btnCusAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusAddActionPerformed
        ConnectionDetail();
        Object[] row = new Object[7];
        
        row[0] = txtCusId.getText();
        row[1] = txtCusName.getText();
        row[2] = txtCusAdd.getText();
        row[3] = txtCusTel.getText();
        row[4] = txtCusEmail.getText();
        row[5] = txtCusGender.getText();
        row[6] = txtCusAge.getText();
        DefaultTableModel model = (DefaultTableModel)tblCus.getModel(); 
        model.addRow(row);

        try{ 
            con = DriverManager.getConnection(url, username, password);
            String sql = "insert into customer values ('"+txtCusId.getText()+"', '"+txtCusName.getText()+"', "
                    + " '"+txtCusAdd.getText()+"', '"+txtCusTel.getText()+"', "
                    + " '"+txtCusEmail.getText()+"', '"+txtCusGender.getText()+"', "
                    + " '"+txtCusAge.getText()+"')";
            pstmt = con.prepareStatement(sql); 
            pstmt.execute(sql);
            showCustomer();
            
            txtCusId.setText(null);
            txtCusName.setText(null);
            txtCusAdd.setText(null);
            txtCusTel.setText(null);
            txtCusEmail.setText(null);
            txtCusGender.setText(null);
            txtCusAge.setText(null);
            
            JOptionPane.showMessageDialog(this, "Inserted Successful");

        }catch(Exception e){ 
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnCusAddActionPerformed

    private void btnCusUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusUpdateActionPerformed
        DefaultTableModel model = (DefaultTableModel)tblCus.getModel();
        int index = tblCus.getSelectedRow();
        if (index >= 0){ 
            ConnectionDetail();
            try{ 
                con = DriverManager.getConnection(url, username, password);
                String sql = "update customer set Customer_ID = '"+txtCusId.getText()+"', Customer_Name = '"+txtCusName.getText()+"', "
                        + " Customer_Add = '"+txtCusAdd.getText()+"', Customer_Tel = '"+txtCusTel.getText()+"', "
                        + " Customer_Email = '"+txtCusEmail.getText()+"', Customer_Gender = '"+txtCusGender.getText()+"', "
                        + " Customer_Age = '"+txtCusAge.getText()+"' where Customer_ID = '"+txtCusId.getText()+"'";
                        //where username = '"+txtLoginId.getText()+"'";
                pstmt = con.prepareStatement(sql); 
                pstmt.executeUpdate(sql);
                showCustomer();
                
                txtCusId.setText(null);
                txtCusName.setText(null);
                txtCusAdd.setText(null);
                txtCusTel.setText(null);
                txtCusEmail.setText(null);
                txtCusGender.setText(null);
                txtCusAge.setText(null);
            
                JOptionPane.showMessageDialog(null, "Update Success");
                
            }catch(Exception e){ 
                JOptionPane.showMessageDialog(this, e);
            }
        }else{ 
            JOptionPane.showMessageDialog(this, "Please select a row to update");
        }
    }//GEN-LAST:event_btnCusUpdateActionPerformed

    private void tblCusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCusMouseClicked
        DefaultTableModel model = (DefaultTableModel)tblCus.getModel();
        int index = tblCus.getSelectedRow();
        txtCusId.setText(model.getValueAt(index, 0).toString());
        txtCusName.setText(model.getValueAt(index, 1).toString());
        txtCusAdd.setText(model.getValueAt(index, 2).toString());
        txtCusTel.setText(model.getValueAt(index, 3).toString());
        txtCusEmail.setText(model.getValueAt(index, 4).toString());
        txtCusGender.setText(model.getValueAt(index, 5).toString());
        txtCusAge.setText(model.getValueAt(index, 6).toString());
                
    }//GEN-LAST:event_tblCusMouseClicked

    private void btnCusDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusDeleteActionPerformed
        DefaultTableModel model = (DefaultTableModel)tblCus.getModel();
        int index = tblCus.getSelectedRow();
        ConnectionDetail();
        try{  
            con = DriverManager.getConnection(url, username, password);
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete?",  "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String sql = "delete from customer where Customer_ID = '"+txtCusId.getText()+"'";
                pstmt = con.prepareStatement(sql);
                pstmt.execute(sql);
                showCustomer();
                txtCusId.setText(null);
                txtCusName.setText(null);
                txtCusAdd.setText(null);
                txtCusTel.setText(null);
                txtCusEmail.setText(null);
                txtCusGender.setText(null);
                txtCusAge.setText(null);
                
                JOptionPane.showMessageDialog(this, "Deleted Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Deletion Cancelled");
            }
        }catch(Exception e){ 
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnCusDeleteActionPerformed

    private void DisplayDataTM(){ 
        
        ConnectionDetail();
        try{
            if(!(cboTMTable.getSelectedItem().equals("Select"))){
            
            String sql = "select * from "+cboTMTable.getSelectedItem()+" ";
            PreparedStatement pstmt = con.prepareStatement(sql); 
            rs = pstmt.executeQuery();
            
            tblTM.setModel(DbUtils.resultSetToTableModel(rs));
            }
        }catch(Exception e){ 
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    private void btnTMAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTMAddActionPerformed
        String cName = txtCName.getText();
        String dType = cboTMType.getSelectedItem().toString(); 
        String st; 
        String pKey; 
        if (chkTMN.isSelected()){ 
            st = " NOT NULL"; 
        } 
        else{ 
            st = "NULL"; 
        }
        
        if (chkTMP.isSelected()){ 
            pKey = "Primary Key"; 
        } 
        else{ 
           pKey = ""; 
        } 
        
        try{ 
            ConnectionDetail();
            
            String query = "alter table "+cboTMTable.getSelectedItem()+" add "+cName+" "+dType+" "+st+" "+pKey+""; 
            
            pstmt = con.prepareStatement(query); 
            pstmt.execute(); 
            JOptionPane.showMessageDialog(this, "New Colum is added!!!"); 
            DisplayDataTM();
            
        }catch(Exception e){ 
            JOptionPane.showMessageDialog(this, e);
                    
        }
    }//GEN-LAST:event_btnTMAddActionPerformed

    private void btnTMUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTMUpdateActionPerformed
        int index = tblTM.getSelectedRow();
        String oldName = tblTM.getValueAt(index, 0).toString();
        String newName = txtCName.getText();
        String dType = cboTMType.getSelectedItem().toString();
        String st;
        if (chkTMN.isSelected()){ 
            st = "NOT NULL"; 
        } 
        else{ 
            st = "NULL"; 
        }
        try{ 
            ConnectionDetail();
            
            String sql = "alter table "+cboTMTable.getSelectedItem()+" change column "+oldName+" "+newName+" "+dType+" "+st+""; 
            
            pstmt = con.prepareStatement(sql); 
            pstmt.execute(); 
            JOptionPane.showMessageDialog(this, "Colum updated is successful!!!"); 
            DisplayDataTM();
            
        }catch(Exception e){ 
            JOptionPane.showMessageDialog(this, e);          
        }
    }//GEN-LAST:event_btnTMUpdateActionPerformed

    private void btnTMDeleteCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTMDeleteCActionPerformed
        int index = tblTM.getSelectedRow();
        String cName = tblTM.getValueAt(index, 0).toString();
        try{ 
           ConnectionDetail();
            
            String sql = "alter table "+cboTMTable.getSelectedItem()+" drop column "+cName+""; 
            
            pstmt = con.prepareStatement(sql); 
            pstmt.execute(); 
            JOptionPane.showMessageDialog(this, "Colum updated is successful!!!"); 
            DisplayDataTM();
            
        }catch(Exception e){ 
            JOptionPane.showMessageDialog(this, e);            
        }
    }//GEN-LAST:event_btnTMDeleteCActionPerformed

    private void btnTMDropTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTMDropTActionPerformed
        
        ConnectionDetail();
        try{   
            String selectedTable = cboTMTable.getSelectedItem().toString();
            
           // if (!cboTable.getSelectedItem().toString().equalsIgnoreCase("Select")) {
                int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                
                if (confirm == JOptionPane.YES_OPTION){
            String sql = "drop table "+cboTMTable.getSelectedItem()+" ";
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.execute();
            JOptionPane.showMessageDialog(this, "Table Delected Successfully");
            
            cboTMTable.removeItem(cboTMTable.getSelectedItem().toString()); 
            cboTMTable.setSelectedItem("Select");
                }else { 
                    JOptionPane.showMessageDialog(this, "Canceled");
                }
        }catch(Exception e){ 
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnTMDropTActionPerformed
    
    public DefaultTableModel TableModelSetter(ResultSet rs)
    {
        DefaultTableModel model = new DefaultTableModel();
        try {
                int columnCount;
                ResultSetMetaData rsmd = rs.getMetaData();
                columnCount = rsmd.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    model.addColumn(rsmd.getColumnName(i));
                }
                while (rs.next()) {
                    Object[] row = new Object[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        row[i - 1] = rs.getObject(i);
                    }
                    model.addRow(row);
                }
        } catch (Exception e) {JOptionPane.showMessageDialog(this, e);}
        return model;
    }
    private void cboTMTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTMTableActionPerformed
        ConnectionDetail();
        if(cboTMTable.getSelectedItem() == "Select" || cboTMTable.getSelectedIndex() == -1){}
        else{
            try {
                    String sql = "Select * from "+cboTMTable.getSelectedItem()+";";
                    PreparedStatement pstmt = con.prepareStatement(sql);
                    rs = pstmt.executeQuery();
                    tblTM.setModel(TableModelSetter(rs));
                } catch (Exception e) { JOptionPane.showMessageDialog(rootPane, cboTMTable.getSelectedItem());
                }
            }
    }//GEN-LAST:event_cboTMTableActionPerformed

    private void txtLoginSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginSearchKeyReleased
        ConnectionDetail();
        if(cboLogin.getSelectedItem() == "Select" || cboLogin.getSelectedIndex() == -1){}
        else{ 
            try{
                con = DriverManager.getConnection(url, username, password);
                String sql = "select * from user_login where "+cboLogin.getSelectedItem()+" like '%"+txtLoginSearch.getText()+"%' ";
                rs =  pstmt.executeQuery(sql);
                DefaultTableModel m = (DefaultTableModel)tblLogin.getModel();
                m.setRowCount(0);
                Object [] row = new Object[2];
                
                while(rs.next()){ 
                    count++;
                    row [0] = rs.getString("user_ID");
                    row [1] = rs.getString("password");
                    m.addRow(row);
                    
                }
                tblLogin.setModel(m);
            }catch(Exception e){ 
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }//GEN-LAST:event_txtLoginSearchKeyReleased

    private void txtProductSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductSearchKeyReleased
        ConnectionDetail();
        if(cboProduct.getSelectedItem() == "Select" || cboProduct.getSelectedIndex() == -1){}
        else{ 
            try{
                con = DriverManager.getConnection(url, username, password);
                String sql = "select * from TV_Products_and_services where "+cboProduct.getSelectedItem()+" like '%"+txtProductSearch.getText()+"%' ";
                rs =  pstmt.executeQuery(sql);
                DefaultTableModel m = (DefaultTableModel)tblProduct.getModel();
                m.setRowCount(0);
                Object [] row = new Object[7];
                
                while(rs.next()){ 
                    count++;
                    row [0] = rs.getString("TVproduct_ID");
                    row [1] = rs.getString("TVproduct_Name");
                    row [3] = rs.getString("TVproduct_Type");
                    row [4] = rs.getString("TVproduct_Quantity");
                    row [5] = rs.getString("TVproduct_Price");
                    row [6] = rs.getString("Customer_ID");
                    m.addRow(row);
                    
                }
                tblProduct.setModel(m);
            }catch(Exception e){ 
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }//GEN-LAST:event_txtProductSearchKeyReleased

    private void tblProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMouseClicked
        DefaultTableModel model = (DefaultTableModel)tblProduct.getModel();
        int index = tblProduct.getSelectedRow();
        txtProductId.setText(model.getValueAt(index, 0).toString());
        txtProductName.setText(model.getValueAt(index, 1).toString());
        txtProductType.setText(model.getValueAt(index, 2).toString());
        txtProductQty.setText(model.getValueAt(index, 3).toString());
        txtProductPrice.setText(model.getValueAt(index, 4).toString());
        txtCustomer.setText(model.getValueAt(index, 5).toString());
    }//GEN-LAST:event_tblProductMouseClicked

    private void btnProductAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductAddActionPerformed
        ConnectionDetail();
        Object[] row = new Object[6];
        
        row[0] = txtProductId.getText();
        row[1] = txtProductName.getText();
        row[2] = txtProductType.getText();
        row[3] = txtProductQty.getText();
        row[4] = txtProductPrice.getText();
        row[5] = txtCustomer.getText();
        DefaultTableModel model = (DefaultTableModel)tblProduct.getModel(); 
        model.addRow(row);

        try{ 
            con = DriverManager.getConnection(url, username, password);
            String sql = "insert into customer values ('"+txtProductId.getText()+"', '"+txtProductName.getText()+"', "
                    + " '"+txtProductType.getText()+"', '"+txtProductQty.getText()+"', "
                    + " '"+txtProductPrice.getText()+"', '"+txtCustomer.getText()+"' ";
            pstmt = con.prepareStatement(sql); 
            pstmt.execute(sql);
            showProduct();
            
            txtProductId.setText(null);
            txtProductName.setText(null);
            txtProductType.setText(null);
            txtProductQty.setText(null);
            txtProductPrice.setText(null);
            txtCustomer.setText(null);
            
            JOptionPane.showMessageDialog(this, "Inserted Successful");

        }catch(Exception e){ 
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnProductAddActionPerformed

    private void btnProductUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductUpdateActionPerformed
        DefaultTableModel model = (DefaultTableModel)tblProduct.getModel();
        int index = tblProduct.getSelectedRow();
        if (index >= 0){ 
            ConnectionDetail();
            try{ 
                con = DriverManager.getConnection(url, username, password);
                String sql = "update TV_Products_and_services set Customer_ID = '"+txtProductId.getText()+"', Customer_Name = '"+txtProductName.getText()+"', "
                        + " Customer_Add = '"+txtProductType.getText()+"', Customer_Tel = '"+txtProductQty.getText()+"', "
                        + " Customer_Email = '"+txtProductPrice.getText()+"', Customer_Gender = '"+txtCustomer.getText()+"' ";
                        //where username = '"+txtLoginId.getText()+"'";
                pstmt = con.prepareStatement(sql); 
                pstmt.executeUpdate(sql);
                showCustomer();
                
                txtProductId.setText(null);
                txtProductName.setText(null);
                txtProductType.setText(null);
                txtProductQty.setText(null);
                txtProductPrice.setText(null);
                txtCustomer.setText(null);
            
                JOptionPane.showMessageDialog(null, "Update Success");
                
            }catch(Exception e){ 
                JOptionPane.showMessageDialog(this, e);
            }
        }else{ 
            JOptionPane.showMessageDialog(this, "Please select a row to update");
        }
    }//GEN-LAST:event_btnProductUpdateActionPerformed

    private void btnProductDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductDeleteActionPerformed
        DefaultTableModel model = (DefaultTableModel)tblProduct.getModel();
        int index = tblProduct.getSelectedRow();
        ConnectionDetail();
        try{  
            con = DriverManager.getConnection(url, username, password);
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete?",  "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String sql = "delete from TV_Products_and_services where TVproduct_ID = '"+txtProductId.getText()+"'";
                pstmt = con.prepareStatement(sql);
                pstmt.execute(sql);
                showCustomer();
                
                txtProductId.setText(null);
                txtProductName.setText(null);
                txtProductType.setText(null);
                txtProductQty.setText(null);
                txtProductPrice.setText(null);
                txtCustomer.setText(null);;
                
                JOptionPane.showMessageDialog(this, "Deleted Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Deletion Cancelled");
            }
        }catch(Exception e){ 
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnProductDeleteActionPerformed

    private void txtCusSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCusSearchKeyReleased
        ConnectionDetail();
        if(cboCus.getSelectedItem() == "Select" || cboCus.getSelectedIndex() == -1){}
        else{ 
            try{
                con = DriverManager.getConnection(url, username, password);
                String sql = "select * from customer where "+cboCus.getSelectedItem()+" like '%"+txtCusSearch.getText()+"%' ";
                rs =  pstmt.executeQuery(sql);
                DefaultTableModel m = (DefaultTableModel)tblCus.getModel();
                m.setRowCount(0);
                Object [] row = new Object[7];
                
                while(rs.next()){ 
                    count++;
                    row[0] = rs.getString("Customer_ID");
                    row[1] = rs.getString("Customer_Name");
                    row[2] = rs.getString("Customer_Add");
                    row[3] = rs.getString("Customer_Tel");
                    row[4] = rs.getString("Customer_Email");
                    row[5] = rs.getString("Customer_Gender");
                    row[6] = rs.getString("Customer_Age");
                    m.addRow(row);
                    
                }
                tblProduct.setModel(m);
            }catch(Exception e){ 
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }//GEN-LAST:event_txtCusSearchKeyReleased
//import javax.swing.JOptionPane;
//import java.sql.DriverManager;
//import java.sql.*;

    
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
            java.util.logging.Logger.getLogger(Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Management().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnCusAdd;
    private javax.swing.JButton btnCusDelete;
    private javax.swing.JButton btnCusUpdate;
    private javax.swing.JPanel btnCustomer;
    private javax.swing.JPanel btnExit;
    private javax.swing.JPanel btnLogin;
    private javax.swing.JButton btnLoginAdd;
    private javax.swing.JButton btnLoginDelete;
    private javax.swing.JButton btnLoginUpdate;
    private javax.swing.JPanel btnModification;
    private javax.swing.JPanel btnOtherTable;
    private javax.swing.JButton btnProductAdd;
    private javax.swing.JButton btnProductDelete;
    private javax.swing.JButton btnProductUpdate;
    private javax.swing.JPanel btnService;
    private javax.swing.JButton btnTMAdd;
    private javax.swing.JButton btnTMDeleteC;
    private javax.swing.JButton btnTMDropT;
    private javax.swing.JButton btnTMUpdate;
    private javax.swing.JPanel btnTable;
    private javax.swing.JComboBox<String> cboColumn;
    private javax.swing.JComboBox<String> cboCus;
    private javax.swing.JComboBox<String> cboLogin;
    private javax.swing.JComboBox<String> cboProduct;
    private javax.swing.JComboBox<String> cboTMTable;
    private javax.swing.JComboBox<String> cboTMType;
    private javax.swing.JCheckBox chkTMN;
    private javax.swing.JCheckBox chkTMP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblCus;
    private javax.swing.JTable tblLogin;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTable tblTM;
    private javax.swing.JTextField txtCName;
    private javax.swing.JTextField txtCusAdd;
    private javax.swing.JTextField txtCusAge;
    private javax.swing.JTextField txtCusEmail;
    private javax.swing.JTextField txtCusGender;
    private javax.swing.JTextField txtCusId;
    private javax.swing.JTextField txtCusName;
    private javax.swing.JTextField txtCusSearch;
    private javax.swing.JTextField txtCusTel;
    private javax.swing.JTextField txtCustomer;
    private javax.swing.JTextField txtLoginId;
    private javax.swing.JTextField txtLoginPassword;
    private javax.swing.JTextField txtLoginSearch;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtProductId;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductPrice;
    private javax.swing.JTextField txtProductQty;
    private javax.swing.JTextField txtProductSearch;
    private javax.swing.JTextField txtProductType;
    // End of variables declaration//GEN-END:variables
}
