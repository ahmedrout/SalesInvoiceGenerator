/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SalesInvoiceGenerator.controller;

import java.awt.event.ActionListener;
import javax.swing.ListSelectionModel;
import SalesInvoiceGenerator.view.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import SalesInvoiceGenerator.model.*;
import SalesInvoiceGenerator.view.*;
/**
 *
 * @author saad
 */
public class InvoiceListener implements ActionListener , ListSelectionListener{
    private SalesInvoiceForm frame;
    private HeaderDialog headerDialog;
    private LineDialog lineDialog;
    
    public InvoiceListener(SalesInvoiceForm frame){
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ActionListener");

        String actionCommand = e.getActionCommand();
         System.out.println(actionCommand);
        switch (actionCommand) {
            case "Add New Invoice":
                newInvoice();
                break;
            case "Delete Invoice":
                deleteInvoice();
                break;
            case "Add New Line":
                newLine();
                break;
            case "Delete Line":
                deleteLine();
                break;
            case "Load Files":
                loadFiles(null, null);
                break;
            case "Save Data":
                saveData();
                break;
            case "newInvoiceOK":
                newInvoiceOK();
                break;
            case "newInvoiceCancel":
                newInvoiceCancel();
                break;
            case "newLineOK":
                newLineOK();
                break;
            case "newLineCancel":
                newLineCancel();
                break;
        }
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println("ListSelectionListener");

        int row = frame.getInvoicesTable().getSelectedRow();
        System.out.println("Selected Row: " + row);
        if (row > -1 && row < frame.getInvoices().size()) {
            InvoiceHeader inv = frame.getInvoices().get(row);
            frame.getCustomerNameLabel().setText(inv.getCustomerName());
            frame.getInvoiceDateLabel().setText(frame.sdf.format(inv.getInvoiceDate()));
            frame.getInvoiceNumLabel().setText("" + inv.getInvoiceNum());
            frame.getInvoiceTotalLabel().setText("" + inv.getTotal());

            List<InvoiceLine> lines = inv.getLines();
            frame.getLinesTable().setModel(new LineTableModel(lines));
        } else {
            frame.getCustomerNameLabel().setText("");
            frame.getInvoiceDateLabel().setText("");
            frame.getInvoiceNumLabel().setText("");
            frame.getInvoiceTotalLabel().setText("");

            frame.getLinesTable().setModel(new LineTableModel(new ArrayList<InvoiceLine>()));
        }
    }
    
    private void newInvoice() {
        headerDialog = new HeaderDialog(frame);
        headerDialog.setVisible(true);
    }

    private void deleteInvoice() {
        int row = frame.getInvoicesTable().getSelectedRow();
        if (row != -1) {
            frame.getInvoices().remove(row);
            ((HeaderTableModel) frame.getInvoicesTable().getModel()).fireTableDataChanged();
        }
    }

    private void newLine() {
        int selectedInv = frame.getInvoicesTable().getSelectedRow();
        if (selectedInv != -1) {
            lineDialog = new LineDialog(frame);
            lineDialog.setVisible(true);
        }
    }

    private void deleteLine() {
        int row = frame.getLinesTable().getSelectedRow();
        if (row != -1) {
            int headerRow = frame.getInvoicesTable().getSelectedRow();
            LineTableModel lineTableModel = (LineTableModel) frame.getLinesTable().getModel();
            lineTableModel.getLines().remove(row);
            lineTableModel.fireTableDataChanged();
            ((HeaderTableModel) frame.getInvoicesTable().getModel()).fireTableDataChanged();
            frame.getInvoicesTable().setRowSelectionInterval(headerRow, headerRow);
        }
    }

    public void loadFiles(String headrPath, String linePath) {
        File headerFile = null;
        File lineFile = null;
        if (headrPath == null && linePath == null) {
            JFileChooser fc = new JFileChooser();
            int result = fc.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                headerFile = fc.getSelectedFile();
                result = fc.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    lineFile = fc.getSelectedFile();
                }
            }
        } else {
            headerFile = new File(headrPath);
            lineFile = new File(linePath);
        }

        if (headerFile != null && lineFile != null) {
            try {
                List<String> headerLines = Files.lines(Paths.get(headerFile.getAbsolutePath())).collect(Collectors.toList());
                List<String> lineLines = Files.lines(Paths.get(lineFile.getAbsolutePath())).collect(Collectors.toList());
                frame.getInvoices().clear();
                for (String headerLine : headerLines) {
                    String[] parts = headerLine.split(",");  // "1,22-11-2020,saad"  ==>  ["1", "22-11-2020", "saad"]
                    String numString = parts[0];
                    String dateString = parts[1];
                    String name = parts[2];
                    int num = Integer.parseInt(numString);
                    Date date = SalesInvoiceForm.sdf.parse(dateString);
                    InvoiceHeader inv = new InvoiceHeader(num, name, date);
                    frame.getInvoices().add(inv);
                }
                System.out.println("Check point");
                for (String lineLine : lineLines) {
                    String[] parts = lineLine.split(",");
                    int num = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    int count = Integer.parseInt(parts[3]);
                    InvoiceHeader inv = getInvoiceByNum(num);
                    InvoiceLine line = new InvoiceLine(name, price, count, inv);
                    inv.getLines().add(line);
                }
                System.out.println("Check point");
                frame.getInvoicesTable().setModel(new HeaderTableModel(frame.getInvoices()));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private InvoiceHeader getInvoiceByNum(int num) {
        for (InvoiceHeader inv : frame.getInvoices()) {
            if (num == inv.getInvoiceNum()) {
                return inv;
            }
        }
        return null;
    }

    private void saveData() {
        String invoicesData = "";
        String linesData = "";
        for (InvoiceHeader invoice : frame.getInvoices()) {
            invoicesData += invoice.toCSV();
            invoicesData += "\n";
            for (InvoiceLine line : invoice.getLines()) {
                linesData += line.toCSV();
                linesData += "\n";
            }
        }

        JFileChooser fc = new JFileChooser();
        int result = fc.showSaveDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = fc.getSelectedFile();
            result = fc.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File lineFile = fc.getSelectedFile();
                try {
                    FileWriter headerFW = new FileWriter(headerFile);
                    headerFW.write(invoicesData);
                    headerFW.flush();
                    headerFW.close();

                    FileWriter lineFW = new FileWriter(lineFile);
                    lineFW.write(linesData);
                    lineFW.flush();
                    lineFW.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error while saving data", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void newInvoiceOK() {
        String customer = headerDialog.getCustomerNameText().getText();
        String date = headerDialog.getInvoiceDateText().getText();
        headerDialog.setVisible(false);
        headerDialog.dispose();
        int num = getNextInvoiceNum();
        try {
            Date invDate = frame.sdf.parse(date);
            InvoiceHeader inv = new InvoiceHeader(num, customer, invDate);
            frame.getInvoices().add(inv);
            ((HeaderTableModel) frame.getInvoicesTable().getModel()).fireTableDataChanged();
        } catch (ParseException pex) {
            JOptionPane.showMessageDialog(frame, "Error in date format", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int getNextInvoiceNum() {
        int num = 1;
        for (InvoiceHeader inv : frame.getInvoices()) {
            if (inv.getInvoiceNum()> num) {
                num = inv.getInvoiceNum();
            }
        }
        return num + 1;
    }

    private void newInvoiceCancel() {
        headerDialog.setVisible(false);
        headerDialog.dispose();
    }

    private void newLineOK() {
        int selectedInv = frame.getInvoicesTable().getSelectedRow();
        if (selectedInv != -1) {
            InvoiceHeader inv = frame.getInvoices().get(selectedInv);
            String name = lineDialog.getItemNameText().getText();
            String priceStr = lineDialog.getItemPriceText().getText();
            String countStr = lineDialog.getItemCountText().getText();
            lineDialog.setVisible(false);
            lineDialog.dispose();
            double price = Double.parseDouble(priceStr);
            int count = Integer.parseInt(countStr);
            InvoiceLine line = new InvoiceLine(name, price, count, inv);
            inv.getLines().add(line);
            ((LineTableModel) frame.getLinesTable().getModel()).fireTableDataChanged();
            ((HeaderTableModel) frame.getInvoicesTable().getModel()).fireTableDataChanged();
            frame.getInvoicesTable().setRowSelectionInterval(selectedInv, selectedInv);
        }
    }

    private void newLineCancel() {
        lineDialog.setVisible(false);
        lineDialog.dispose();
    }

}
