/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import calculations.CalculateCG;
import customSwing.CButton;
import customSwing.CFrame;
import customSwing.CPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author mainu
 */
public class ManualCgpa {
    CFrame frame;
    CPanel panel;
    
    JLabel label1;
    JLabel label2;
    JLabel creditViewer;
    JLabel cgpViewer;
    
    JTextField gpaInputField;
    JTextField creditInputField;
    
    CButton calculateBtn;
    CButton inputBtn;
    CButton backBtn;
    
    static double credit = 0, grade = 0;
    
    static CalculateCG calculator = new CalculateCG();
    
    ManualCgpa(){
        GridBagConstraints c = new GridBagConstraints();
        label1 = new JLabel("Credit:");
        label2 = new JLabel("GPA:");
        creditViewer = new JLabel("Credit:       " + credit);
        cgpViewer = new JLabel("CGPA:       " + grade);
        
        gpaInputField = new JTextField(10);
        creditInputField = new JTextField(10);
        
        inputBtn = new CButton("Input");
        inputBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                calculator.add(Double.parseDouble(gpaInputField.getText()), Double.parseDouble(creditInputField.getText()));
                System.out.println("" + calculator.getResult());
                credit = calculator.getCredit();
                grade = calculator.getResult();
                grade =Double.parseDouble(new DecimalFormat("##.##").format(grade));
                creditViewer.setText("Credit:       " + credit);
                cgpViewer.setText("CGPA:       " + grade);
                frame.revalidate();
                frame.repaint();
            }
        });
        backBtn = new CButton("Back");
        backBtn.addActionListener(new BackBtnListener());
        
        
        
        
        panel = new CPanel(new GridBagLayout());
        c.insets = new Insets(5, 2, 0, 2);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth=2;
        panel.add(creditViewer, c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth=2;
        panel.add(cgpViewer, c);
        c.gridx = -1;
        c.gridy = 2;
        c.gridwidth=1;
        panel.add(label1, c);
        c.gridx = 1;
        c.gridy = 2;
        panel.add(creditInputField, c);
        c.gridx = -1;
        c.gridy = 3;
        panel.add(label2, c);
        c.gridx = 1;
        c.gridy = 3;
        panel.add(gpaInputField, c);
        c.gridx = 1;
        c.gridy = 4;
        panel.add(inputBtn, c);
        c.gridx = 1;
        c.gridy = 5;
        panel.add(backBtn, c);
        
        frame = new CFrame();
        frame.setDefaultCloseOperation(CFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(600,768);
        frame.setLocation(300,00);
    }
    private class BackBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            new Home();
            credit = 0;
            grade  = 0;
            calculator.reset();
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
        
    }
}
