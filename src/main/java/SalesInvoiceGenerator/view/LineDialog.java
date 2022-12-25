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
 * @author mokhalid
 */
public class LineDialog extends JDialog{
     private JTextField itemNameText;
    private JTextField itemCountText;
    private JTextField itemPriceText;
    
    private JLabel itemNameLabel;
    private JLabel itemCountLabel;
    private JLabel itemPriceLabel;
    private JButton okBut;
    private JButton cancelut;
    
    public LineDialog(SalesInvoiceForm frame){
        itemNameText = new JTextField(20);
        itemNameLabel = new JLabel("Item Name");
        
        itemCountText = new JTextField(20);
        itemCountLabel = new JLabel("Item Count");
        
        itemPriceText = new JTextField(20);
        itemPriceLabel = new JLabel("Item Price");
        
        okBut = new JButton("OK");
        cancelut = new JButton("Cancel");
        
        okBut.setActionCommand("newLineOK");
        cancelut.setActionCommand("newLineCancel");
        
        okBut.addActionListener(frame.getListener());
        cancelut.addActionListener(frame.getListener());
        setLayout(new GridLayout(4, 2));
        
        add(itemNameLabel);
        add(itemNameText);
        add(itemCountLabel);
        add(itemCountText);
        add(itemPriceLabel);
        add(itemPriceText);
        add(okBut);
        add(cancelut);
        setModal(true);
        pack();
    }
    
     public JTextField getItemNameText() {
        return itemNameText;
    }

    public JTextField getItemCountText() {
        return itemCountText;
    }

    public JTextField getItemPriceText() {
        return itemPriceText;
    }
}
