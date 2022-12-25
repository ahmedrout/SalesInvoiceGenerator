/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SalesInvoiceGenerator.view;
import SalesInvoiceGenerator.controller.InvoiceListener;
import SalesInvoiceGenerator.model.*;
import SalesInvoiceGenerator.view.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author saad
 */
public class SalesInvoiceForm extends javax.swing.JFrame {

    /**
     * Creates new form SalesInvoiceForm
     */
    public SalesInvoiceForm() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        InvoiceTable = new javax.swing.JTable();
        InvoiceTable.getSelectionModel().addListSelectionListener(listener);
        jScrollPane2 = new javax.swing.JScrollPane();
        LinesTable = new javax.swing.JTable();
        InvoiceNum = new javax.swing.JLabel();
        CustomerName = new javax.swing.JLabel();
        InvoiceDate = new javax.swing.JLabel();
        InvoiceTotal = new javax.swing.JLabel();
        InvoiceNumLabel = new javax.swing.JLabel();
        CustomerNameLabel = new javax.swing.JLabel();
        InvoiceDateLabel = new javax.swing.JLabel();
        InvoiceTotalLabel = new javax.swing.JLabel();
        NewInvoiceBut = new javax.swing.JButton();
        NewInvoiceBut.addActionListener(listener);
        DeleteInvoiceBut = new javax.swing.JButton();
        DeleteInvoiceBut.addActionListener(listener);
        NewLineBut = new javax.swing.JButton();
        NewLineBut.addActionListener(listener);
        DeleteLineBut = new javax.swing.JButton();
        DeleteLineBut.addActionListener(listener);
        InvoiceNum1 = new javax.swing.JLabel();
        InvoiceNum2 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        loadMenuItem.addActionListener(listener);
        saveMenuItem = new javax.swing.JMenuItem();
        saveMenuItem.addActionListener(listener);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        InvoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(InvoiceTable);

        LinesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(LinesTable);

        InvoiceNum.setText("Invoice Num");

        CustomerName.setText("Customer Name");

        InvoiceDate.setText("Invoice Date");

        InvoiceTotal.setText("Invoice Total");

        InvoiceNumLabel.setText("jLabel6");

        CustomerNameLabel.setText("jLabel5");

        InvoiceDateLabel.setText("jLabel7");

        InvoiceTotalLabel.setText("jLabel7");

        NewInvoiceBut.setText("Add New Invoice");

        DeleteInvoiceBut.setText("Delete Invoice");

        NewLineBut.setText("Add New Line");

        DeleteLineBut.setText("Delete Line");

        InvoiceNum1.setText("Invoices Table");

        InvoiceNum2.setText("Invoices Items");

        jMenu3.setText("File");

        loadMenuItem.setText("Load Files");
        jMenu3.add(loadMenuItem);

        saveMenuItem.setText("Save Data");
        jMenu3.add(saveMenuItem);

        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(InvoiceNum1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(InvoiceNum2)))
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InvoiceTotal)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CustomerName)
                                            .addComponent(InvoiceDate))
                                        .addGap(26, 26, 26))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(InvoiceNum)
                                        .addGap(54, 54, 54)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(InvoiceNumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CustomerNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(InvoiceDateLabel)
                                    .addComponent(InvoiceTotalLabel))))
                        .addGap(83, 83, 83))))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(NewInvoiceBut)
                .addGap(35, 35, 35)
                .addComponent(DeleteInvoiceBut)
                .addGap(87, 87, 87)
                .addComponent(NewLineBut)
                .addGap(91, 91, 91)
                .addComponent(DeleteLineBut)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(InvoiceNum1)
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InvoiceNum)
                            .addComponent(InvoiceNumLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CustomerName)
                            .addComponent(CustomerNameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InvoiceDate)
                            .addComponent(InvoiceDateLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InvoiceTotal)
                            .addComponent(InvoiceTotalLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InvoiceNum2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NewInvoiceBut)
                        .addComponent(DeleteInvoiceBut)
                        .addComponent(NewLineBut))
                    .addComponent(DeleteLineBut))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(SalesInvoiceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesInvoiceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesInvoiceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesInvoiceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SalesInvoiceForm frame = new SalesInvoiceForm();
                 frame.setVisible(true);
                 FileOperations fileoperations = new FileOperations(frame);
                  invoices = fileoperations.readFile();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CustomerName;
    private javax.swing.JLabel CustomerNameLabel;
    private javax.swing.JButton DeleteInvoiceBut;
    private javax.swing.JButton DeleteLineBut;
    private javax.swing.JLabel InvoiceDate;
    private javax.swing.JLabel InvoiceDateLabel;
    private javax.swing.JLabel InvoiceNum;
    private javax.swing.JLabel InvoiceNum1;
    private javax.swing.JLabel InvoiceNum2;
    private javax.swing.JLabel InvoiceNumLabel;
    private javax.swing.JTable InvoiceTable;
    private javax.swing.JLabel InvoiceTotal;
    private javax.swing.JLabel InvoiceTotalLabel;
    private javax.swing.JTable LinesTable;
    private javax.swing.JButton NewInvoiceBut;
    private javax.swing.JButton NewLineBut;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables
    
    private InvoiceListener listener = new InvoiceListener(this);
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    public static ArrayList<InvoiceHeader> invoices;
    private HeaderTableModel headerTableModel;
    
    public ArrayList<InvoiceHeader> getInvoices() {
        if (invoices == null) {
            invoices = new ArrayList<>();
        }
        return invoices;
    }

    public void setInvoices(ArrayList<InvoiceHeader> invoices) {
        this.invoices = invoices;
    }

    public HeaderTableModel getHeaderTableModel() {
        return headerTableModel;
    }

    public void setHeaderTableModel(HeaderTableModel headerTableModel) {
        this.headerTableModel = headerTableModel;
    }

    public JTable getInvoicesTable() {
        return InvoiceTable;
    }

    public JTable getLinesTable() {
        return LinesTable;
    }

    public JLabel getCustomerNameLabel() {
        return CustomerNameLabel;
    }

    public JLabel getInvoiceDateLabel() {
        return InvoiceDateLabel;
    }

    public JLabel getInvoiceNumLabel() {
        return InvoiceNumLabel;
    }

    public JLabel getInvoiceTotalLabel() {
        return InvoiceTotalLabel;
    }

    public InvoiceListener getListener() {
        return listener;
    }   

}

