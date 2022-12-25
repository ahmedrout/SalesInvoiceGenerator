/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SalesInvoiceGenerator.model;
import SalesInvoiceGenerator.view.*;
import SalesInvoiceGenerator.model.*;
import SalesInvoiceGenerator.controller.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
/**
 *
 * @author mokhalid
 */
public class FileOperations {
   private final SalesInvoiceForm frame;
    private final  DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    
    public FileOperations(SalesInvoiceForm frame) {
        this.frame = frame;
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
                    String[] parts = headerLine.split(",");  // "1,22-11-2020,Ali"  ==>  ["1", "22-11-2020", "Ali"]
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
    public ArrayList<InvoiceHeader>readFile() {
        String invoicesPath = System.getProperty("user.dir")+"/InvoiceHeader.csv";
        File invoicesFile = new File(invoicesPath);
        FileReader invoicesReader;
        CSVReader invoicesCsvReader ;
        ArrayList<InvoiceHeader> invoices = null;

        String itemsPath = System.getProperty("user.dir")+"/InvoiceLine.csv";
        File itemsFile = new File(itemsPath);
        FileReader itemsReader;
        CSVReader itemsCsvReader ;
        ArrayList<InvoiceLine> items ;

	try {
            invoicesReader = new FileReader(invoicesFile);
            invoicesCsvReader = new CSVReader(invoicesReader);
            List<String[]> invoicesRecords = invoicesCsvReader.readAll();
            Iterator<String[]> iter = invoicesRecords.iterator();
            invoices = new ArrayList<>();
            while (iter.hasNext()) {
                String[] line = iter.next();
                String id = line[0];
                int invoiceId = Integer.parseInt(id);
                String date = line[1];
                Date invoiceDate = dateFormat.parse(date);
                String custName = line[2];
                InvoiceHeader salesInvoice = new InvoiceHeader(invoiceId,custName,invoiceDate);
                invoices.add(salesInvoice);
            }
            System.out.println(invoices.toString());
            frame.setInvoices(invoices);
            ////////////////////Items Read//////////////
            itemsReader = new FileReader(itemsFile);
            itemsCsvReader = new CSVReader(itemsReader);
            List<String[]> itesmRecords = itemsCsvReader.readAll();
            Iterator<String[]> it = itesmRecords.iterator();
            items = new ArrayList<>();
        InvoiceHeader inv = null;
        while (it.hasNext()) {
                String[] line = it.next();
                String id = line[0];
                int invId = Integer.parseInt(id);
                String itemName =(line[1]);
                String price = line[2];
                double itemPrice =(Double.parseDouble(price));
                String quan = line[3];
                int count = Integer.parseInt(quan);
                inv = getInvoiceByNum(invId);
                InvoiceLine invoiceItem = new InvoiceLine(itemName,itemPrice,count,inv);
                items.add(invoiceItem);
                inv.setLines(items);
            }

            HeaderTableModel invoiceTableModel = new  HeaderTableModel (invoices);
            frame.setHeaderTableModel(invoiceTableModel);
            frame.getInvoicesTable().setModel(invoiceTableModel);
            System.out.println(items);
            itemsCsvReader.close();
        }
        catch (ParseException ex) {
            System.out.println("ParseException");
        }
        catch (FileNotFoundException  e) {
            System.out.println("file not found");
        }
        catch (IOException e) {
                System.out.println("Wrong File");
                JOptionPane.showMessageDialog(this.frame, "Wrong File");
            }
        catch (CsvValidationException ex) {
            System.out.println("CsvValidationException");
        }
        catch (CsvException ex) {
            System.out.println("CsvException");
        }
        return invoices;
    }
    public void writeFile(){
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
    private InvoiceHeader getInvoiceByNum(int num) {
        for (InvoiceHeader inv : frame.getInvoices()) {
            if (num == inv.getInvoiceNum()) {
                return inv;
            }
        }
        return null;
    }
    /*
    public void  writeFile() {
        TableModel invoicesModel ;
        TableModel itemsModel ;
        JTable invoicesTable = frame.getInvoicesTable();
        JTable itemsTable = frame.getInvoicesTable();
        String invoicesPath = System.getProperty("user.dir")+"/InvoiceHeader.csv";
        String itemsPath = System.getProperty("user.dir")+"/InvoiceLine.csv";
        FileWriter invoicesWriter;
        FileWriter itemsWriter;
        try {
            invoicesModel = invoicesTable.getModel();
            invoicesWriter = new FileWriter(new File(invoicesPath));
            for (int i = 0; i < invoicesModel.getColumnCount(); i++) {
                invoicesWriter.write(invoicesModel.getColumnName(i) + ",");
            }
            invoicesWriter.write("\n");
            for (int i = 0; i < invoicesModel.getRowCount(); i++) {
                for (int j = 0; j < invoicesModel.getColumnCount(); j++) {
                    invoicesWriter.write(invoicesModel.getValueAt(i, j).toString() + ",");
                }
                invoicesWriter.write("\n");
            }
            invoicesWriter.close();

            itemsModel = itemsTable.getModel();
            itemsWriter = new FileWriter(new File(itemsPath));
            for (int i = 0; i < itemsModel.getColumnCount(); i++) {
                itemsWriter.write(itemsModel.getColumnName(i) + ",");
            }
            itemsWriter.write("\n");
            for (int i = 0; i < itemsModel.getRowCount(); i++) {
                for (int j = 0; j < itemsModel.getColumnCount(); j++) {
                    itemsWriter.write(itemsModel.getValueAt(i, j).toString() + ",");
                }
                itemsWriter.write("\n");
            }
            itemsWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
}
