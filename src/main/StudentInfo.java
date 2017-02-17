/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
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
    JButton btnHome;
    
    private int regNo;
    
    StudentInfo(int regNo){
        GridBagConstraints c = new GridBagConstraints();
        DatabaseConnection db = new DatabaseConnection();
        
        this.regNo = regNo;
        db.startConnection();
        
        lblRegNo = new JLabel("Registration No:     " + regNo);
        
        String[] columnName = {"Course Name", "Course Code", "Credit", "GPA"};
        Object[][] data = db.getData(regNo);
        db.stopConnection();
        table = new JTable(data, columnName);
        
        btnBack = new CButton("Back");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        
        panel = new CPanel(new GridBagLayout());
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
        frame.setLocation(300, 0);
        frame.setSize(600, 768);
        frame.add(panel);
        frame.setVisible(true);
    }
}
