/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static main.TeacherDataInput.noStudent;

/**
 *
 * @author mainu
 */
public class StudentInfo {
    JFrame frame;
    JPanel panel;
    
    JLabel lblRegNo;
    JLabel lblReg;
    
    JTable table;
    
    JButton btnBack;
    
    private int regNo;
    
    StudentInfo(int regNo){
        GridBagConstraints c = new GridBagConstraints();
        DatabaseConnection db = new DatabaseConnection();
        
        this.regNo = regNo;
        db.startConnection();
        
        lblRegNo = new JLabel("Registration No:     " + regNo);
        
        String[] columnName = {"Course name", "Course code", "course credit", "GPA"};
        Object[][] data = db.getData(regNo);
        db.stopConnection();
        table = new JTable(data, columnName);
        
        btnBack = new JButton("Back");
        
        panel = new JPanel(new GridBagLayout());
        c.gridx = -1;
        c.gridy = 0;
        panel.add(lblRegNo, c);
        c.gridx = -1;
        c.gridy = 1;
        panel.add(new JScrollPane(table), c);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(btnBack, c);
        
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 768);
        frame.add(panel);
        frame.setVisible(true);
    }
}
