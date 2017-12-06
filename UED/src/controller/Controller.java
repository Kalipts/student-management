package controller;

import model.DBConnection;
import view.View;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Controller {

    private View view;
    private DBConnection model;
    private PreparedStatement statement;
    private ResultSet result;
    private Connection connection;

    public Controller(View view, DBConnection model) {
        this.view = view;
        this.model = model;
        saveEvent();
        deleteEvent();
        fillDataEvent();
        searchEvent();
        mouseEvent();
        updateEvent();
    }

    private void mouseEvent() {
        view.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                int row = view.getTable().getSelectedRow();
                view.getsCodeText().setText(view.getTable().getValueAt(row,0).toString());
                view.getsNameText().setText(view.getTable().getValueAt(row,1).toString());
                view.getClassText().setText(view.getTable().getValueAt(row,2).toString());
                view.getAddressText().setText(view.getTable().getValueAt(row,3).toString());
            }
        });
    }
    private void updateEvent() {
        view.getUpdate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String sql = "update students set sname=?,class=?,address=? where scode=?";
                try {
                    statement = connection.prepareStatement(sql);
                    statement.setString(1,view.getsNameText().getText());
                    statement.setString(2,view.getClassText().getText());
                    statement.setString(3,view.getAddressText().getText());
                    statement.setString(4,view.getsCodeText().getText());
                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Update access");
                    loadData();
                } catch (SQLException e) {
                    System.out.println("Loi " + e.getMessage());
                }
            }
        });
    }
    private void deleteEvent() {
        view.getDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row = view.getTable().getSelectedRow();
                String sCode = view.getTable().getValueAt(row,0).toString();
                String sql = "delete from students where scode=?";
                try {
                    statement = connection.prepareStatement(sql);
                    statement.setString(1,sCode);
                    statement.executeUpdate();
                    loadData();
                } catch (SQLException e) {
                    System.out.println("Loi " + e.getMessage());
                }
            }
        });
    }
    private void fillDataEvent() {
        this.view.getFillData().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                loadData();
            }
        });
    }
    private void searchEvent() {
        this.view.getSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                connection = model.DatabaseConnection();
                String sql = "select * from students where scode=?";
                Vector<String> column = new Vector<>();
                column.addElement("SCODE");
                column.addElement("SNAME");
                column.addElement("CLASS");
                column.addElement("ADDRESS");
                Vector<Vector<String>> data = new Vector<Vector<String>>();
                try {
                    statement = connection.prepareStatement(sql);
                    statement.setString(1,view.getsCodeText().getText());
                    result = statement.executeQuery();
                    while (result.next()) {
                        Vector<String> student = new Vector<String>();
                        student.addElement(result.getString(1));
                        student.addElement(result.getString(2));
                        student.addElement(result.getString(3));
                        student.addElement(result.getString(4));
                        data.add(student);
                    }
                } catch (SQLException e) {
                    System.out.println("loi " + e.getMessage());
                }
                view.getTable().setModel(new DefaultTableModel(data, column));
            }
        });
    }
    private void saveEvent() {
        connection = model.DatabaseConnection();
        this.view.getInsert().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String sql = "insert into students() values (?, ?, ?, ?)";
                try {
                    statement = connection.prepareStatement(sql);
                    statement.setString(1,view.getsCodeText().getText());
                    statement.setString(2,view.getsNameText().getText());
                    statement.setString(3,view.getClassText().getText());
                    statement.setString(4,view.getAddressText().getText());
                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Insert access!");
                    loadData();
                } catch (SQLException e) {
                    System.out.println("Loi " + e.getMessage());
                }
            }
        });
    }
    private void loadData() {

        Vector<String> column = new Vector<>();
        column.addElement("SCODE");
        column.addElement("SNAME");
        column.addElement("CLASS");
        column.addElement("ADDRESS");
        String sql = "select * from students";
        try {
            connection = model.DatabaseConnection();
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
            Vector<Vector<String>> Data = new Vector<>();
            while (result.next()) {
                Vector<String> student = new Vector<>();
                student.addElement(result.getString(1));
                student.addElement(result.getString(2));
                student.addElement(result.getString(3));
                student.addElement(result.getString(4));
                Data.add(student);
            }
            view.getTable().setModel(new DefaultTableModel(Data,column));
        } catch (SQLException e) {
            System.out.println("Loi " + e.getMessage());
        }
    }
}