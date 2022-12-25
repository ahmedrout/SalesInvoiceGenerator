/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SalesInvoiceGenerator.model;

import java.util.ArrayList;
import java.util.Date;
import SalesInvoiceGenerator.view.*;
/**
 *
 * @author mokhalid
 */
public class InvoiceHeader {
     private int invoiceNum;
    private String customerName;
    private Date invoiceDate;
    private ArrayList<InvoiceLine> lines;
    
    public InvoiceHeader(int invoiceNum, String customerName , Date invoiceDate){
        this.invoiceNum = invoiceNum;
        this.customerName = customerName;
        this.invoiceDate = invoiceDate;
    }
    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public ArrayList<InvoiceLine> getLines() {
        if (lines == null) {
            lines = new ArrayList<>();
        }
        return lines;
    }

    public void setLines(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    }
    
    public double getTotal() {
        double total = 0.0;
        for (InvoiceLine line : getLines()) {
            total += line.getTotal();
        }
        return total;
    }
    
    public String toCSV() {
        return invoiceNum + "," + SalesInvoiceForm.sdf.format(invoiceDate) + "," + customerName;
    }

    @Override
    public String toString() {
        return "Invoice{" + "num=" + invoiceNum + ", customer=" + customerName + ", date=" + invoiceDate + '}';
    }
    
}
