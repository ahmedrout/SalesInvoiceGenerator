/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SalesInvoiceGenerator.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author saad
 */
public class HeaderDialog extends JDialog {
    private JTextField customerNameText;
    private JTextField invoiceDateText;
    
    private JLabel customerNameLabel;
    private JLabel invoiceDateLabel;
    
    private JButton okBut;
    private JButton cancelBut;
    
    public HeaderDialog(SalesInvoiceForm frame) {
        customerNameLabel = new JLabel("Customer Name:");
        customerNameText = new JTextField(20);
        invoiceDateLabel = new JLabel("Invoice Date:");
        invoiceDateText = new JTextField(20);
        okBut = new JButton("OK");
        cancelBut = new JButton("Cancel");
        
        okBut.setActionCommand("newInvoiceOK");
        cancelBut.setActionCommand("newInvoiceCancel");
        
        okBut.addActionListener(frame.getListener());
        cancelBut.addActionListener(frame.getListener());
        setLayout(new GridLayout(3, 2));
        
        add(invoiceDateLabel);
        add(invoiceDateText);
        add(customerNameLabel);
        add(customerNameText);
        add(okBut);
        add(cancelBut);
        setModal(true);
        pack();
    }
    
     public JTextField getCustomerNameText() {
        return customerNameText;
    }

    public JTextField getInvoiceDateText() {
        return invoiceDateText;
    }
}
