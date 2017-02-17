/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import calculations.CalculateCG;
import customSwing.CPanel;
import customSwing.CButton;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import static main.TeacherDataInput.noStudent;

/**
 *
 * @author mainu
 */
public class StudentInfo {
    JFrame frame;
    CPanel panel;
    
    JLabel lblRegNo;
    JLabel lblReg;
    JLabel lblResult;
    
    JTable table;
    
    CButton btnBack;
    CButton btnHome;
    CalculateCG calculate;
    
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
        calculate = new CalculateCG();
        calculate.reset();
        for (int i=0; i<data.length; i++)
        {
            double a= Double.parseDouble((String) data[i][3]);
            double b= Double.parseDouble((String) data[i][2]);
            
            
            calculate.add(a,b);
            
        }
        
        lblResult = new JLabel("Your current CGPA is: "+calculate.getResult()+"    You've completed: "+calculate.getCredit()+" credits");
        
            
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        lblResult.setBorder(border);
        panel = new CPanel(new GridBagLayout());
        c.gridx = 0;
        c.gridy = 0;
        c.weighty=.25;
        panel.add(lblRegNo, c);
        c.gridx = 0;
        c.gridy = 1;
        c.weighty=0;
        panel.add(new JScrollPane(table), c);
        c.gridx = 0;
        c.gridy++;
        c.weighty=.1;
        panel.add(lblResult,c);
        c.gridx = 0;
        c.gridy++;
        c.weighty=.5;
        panel.add(btnBack, c);
        
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocation(300, 0);
        frame.setSize(600, 768);
        frame.add(panel);
        frame.setVisible(true);
    }
    double grade, credit;
    
    public void add(double grd, double crd){
        System.out.println(""+grd+" "+crd);
        if(grd > 0){
            credit += crd;
            grade += grd*crd;
        }
        
    }
    public void reset(){
        credit = 0;
        grade = 0;
    }
    public double getResult(){
        double result;
        result = grade/credit;
        
        return result;
    }
}
