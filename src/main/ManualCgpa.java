/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author mainu
 */
public class ManualCgpa {
    JFrame frame;
    JPanel panel;
    
    JLabel label1;
    JLabel label2;
    
    JTextField gpaInputField;
    JTextField creditInputField;
    
    JButton calculateBtn;
    JButton inputBtn;
    JButton backBtn;
    
    ManualCgpa(){
        label1 = new JLabel("Credit:");
        label2 = new JLabel("GPA:");
        
        gpaInputField = new JTextField(10);
        creditInputField = new JTextField(10);
        
        calculateBtn = new JButton("Calaulate");
        inputBtn = new JButton("Input");
        backBtn = new JButton("Back");
        backBtn.addActionListener(new BackBtnListener());
        
        panel = new JPanel();
        panel.add(label1);
        panel.add(creditInputField);
        panel.add(label2);
        panel.add(gpaInputField);
        panel.add(inputBtn);
        panel.add(calculateBtn);
        panel.add(backBtn);
        
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(200,200);
        frame.setLocation(600,300);
        
    }
    private class BackBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            new Home();
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
        
    }
}
