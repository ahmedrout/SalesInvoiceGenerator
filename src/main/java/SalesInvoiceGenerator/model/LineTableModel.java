/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SalesInvoiceGenerator.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mokhalid
 */
public class LineTableModel extends AbstractTableModel {
     private String[] columns = {"Item Name", "Item Price", "Count", "Total"};
    private List<InvoiceLine> lines;
    
    public LineTableModel(List<InvoiceLine> lines){
        this.lines = lines;
    }
    
    public List<InvoiceLine> getLines() {
        return lines;
    }
     
    @Override
    public int getRowCount() {
        return lines.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLine line = lines.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return line.getItemName();
            case 1: return line.getItemPrice();
            case 2: return line.getCount();
            case 3: return line.getTotal();
        }
        return "";
    }
    
}
