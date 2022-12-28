/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SalesInvoiceGenerator.model;

/**
 *
 * @author saad
 */
public class InvoiceLine {
    private String itemName;
    private double itemPrice;
    private int count;
    private InvoiceHeader invoice;
    
    public InvoiceLine(String itemName ,double itemPrice, int count,InvoiceHeader invoice ){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.count = count;
        this.invoice = invoice;
    }
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public InvoiceHeader getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceHeader invoice) {
        this.invoice = invoice;
    }
    
    public double getTotal() {
        return getCount() * getItemPrice();
    }
    
    public String toCSV() {
        return invoice.getInvoiceNum() + "," + itemName + "," + itemPrice + "," + count;
    }
    
    @Override
    public String toString() {
        return "Line{" + "item =" + itemName + ", price =" + itemPrice + ", count =" + count + '}';
    }
    
}
