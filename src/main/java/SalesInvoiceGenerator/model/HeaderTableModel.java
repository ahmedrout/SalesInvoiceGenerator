/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SalesInvoiceGenerator.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import SalesInvoiceGenerator.view.*;

/**
 *
 * @author mokhalid
 */
public class HeaderTableModel extends AbstractTableModel{
    private String[] coloumns = {"InvoiceNum", "CustomerName", "InvoiceDate", "Total"}; 
    private List<InvoiceHeader> invoices;
    
    public HeaderTableModel(List<InvoiceHeader> invoices){
        this.invoices = invoices;
    }
    
     @Override
    public int getRowCount() {
        return invoices.size();
    }

    @Override
    public int getColumnCount() {
        return coloumns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return coloumns[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceHeader inv = invoices.get(rowIndex);
        switch (columnIndex) {
            case 0: return inv.getInvoiceNum();
            case 1: return inv.getCustomerName();
            case 2: return SalesInvoiceForm.sdf.format(inv.getInvoiceDate());
            case 3: return inv.getTotal();
        }
        return "";

    }
    
}
