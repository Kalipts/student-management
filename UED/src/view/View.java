package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class View extends JFrame{
    private JLabel sCodeLabel;
    private JLabel sNameLabel;
    private JLabel classLabel;
    private JLabel addressLabel;
    private JTextField sCodeText;
    private JTextField sNameText;
    private JTextField classText;
    private JTextField addressText;

    private JButton insert;
    private JButton search;
    private JButton fillData;
    private JButton delete;
    private JButton update;

    private JTable table;
    private JScrollPane scroller;

    private JPanel northPanel;
    private JPanel centerPanel;
    private JPanel southPanel;

    public JTable getTable() {
        return table;
    }


    public View() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | javax.swing.UnsupportedLookAndFeelException | IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        // main  frame
        this.setSize(550,450);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);
        // define label and text
        sCodeLabel = new JLabel("SCODE");
        sNameLabel = new JLabel("SNAME");
        classLabel = new JLabel("CLASS");
        addressLabel = new JLabel("ADDRESS");

        sCodeText = new JTextField(7);
        sNameText = new JTextField(20);
        classText = new JTextField(7);
        addressText = new JTextField(20);
        // define button
        insert = new JButton("Insert");
        search = new JButton("Search");
        fillData = new JButton("Fill Data");
        delete = new JButton("Delete");
        update = new JButton("Update");

        table = new JTable();
        scroller = new JScrollPane(table);

        //-------------NORTH--------------------
        northPanel.setLayout(new FlowLayout());
        JLabel title = new JLabel("<html><h1 style='color:#4d79ff'><i><b>"+"STUDENT MANAGEMENT" + "</b></i></h1><html>");
        northPanel.add(title);






        ////////////////////////////////////////////////////////



        JPanel centerNorth = new JPanel();
        JPanel centerSouth = new JPanel();
        centerNorth.setLayout(new GridBagLayout());
        centerSouth.setLayout(new FlowLayout());

        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(centerNorth, BorderLayout.CENTER);
        centerPanel.add(centerSouth, BorderLayout.SOUTH);

        ////////////////////////////
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        // object 1
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0,45,0,0);
        centerNorth.add(sCodeLabel, constraints);
        constraints.weightx = 7;
        constraints.gridx = 1;
        centerNorth.add(sCodeText, constraints);
        // object 2
        constraints.gridx = 0;
        constraints.weightx = 1;
        constraints.gridy ++;
        centerNorth.add(sNameLabel, constraints);
        constraints.gridx = 1;
        constraints.weightx = 7;
        centerNorth.add(sNameText, constraints);
        //object 3
        constraints.gridx = 0;
        constraints.weightx = 1;
        constraints.gridy ++;
        centerNorth.add(classLabel, constraints);
        constraints.gridx = 1;
        constraints.weightx = 7;
        centerNorth.add(classText, constraints);
        //object 4

        constraints.gridx = 0;
        constraints.gridy ++;
        constraints.weightx = 1;
        centerNorth.add(addressLabel, constraints);
        constraints.gridx = 1;
        constraints.weightx = 7;
        centerNorth.add(addressText, constraints);
        //-------------- CENTER -----------------
        centerSouth.add(insert);
        centerSouth.add(search);
        centerSouth.add(fillData);
        centerSouth.add(delete);
        centerSouth.add(update);

        //----------------SOUTH---------------
        southPanel.setPreferredSize(new Dimension(500,200));
        Vector<String> column = new Vector<>();
        column.addElement("SCODE");
        column.addElement("SNAME");
        column.addElement("CLASS");
        column.addElement("ADRESS");

        table.setModel(new DefaultTableModel(null , column));

        southPanel.add(scroller);

        this.setVisible(true);
    }
    public JTextField getsCodeText() {
        return sCodeText;
    }
    public JTextField getsNameText() {
        return sNameText;
    }
    public JTextField getClassText() {
        return classText;
    }
    public JTextField getAddressText() {
        return addressText;
    }
    public JButton getInsert() {
        return insert;
    }
    public JButton getSearch() {
        return search;
    }
    public JButton getFillData() {
        return fillData;
    }
    public JButton getDelete() {
        return delete;
    }
    public JButton getUpdate() {
        return update;
    }
}