/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import customSwing.CPanel;
import customSwing.CButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author mainu
 */
public class Home {
    JFrame frame;
    JPanel panel;
    
    JLabel label;
    
    JTextField regNoInputField;
    
    JButton resultBtn;
    JButton teacherInputBtn;
    JButton calculateCGPABtn;
    
    static int regNo;
    String strRegNo;
    

    
    Home(){
        GridBagConstraints c = new GridBagConstraints();
        
        label = new JLabel("Result Management Software");
        label.setLocation(100, 100);
        
        regNoInputField = new JTextField(11);
        
        
        resultBtn = new CButton("See Result");
        resultBtn.addActionListener(new ListenerResult());
        teacherInputBtn = new CButton("Teacher's Input");
        teacherInputBtn.addActionListener(new ListenerTeacherInput());
        calculateCGPABtn = new CButton("Calculate CGPA");
        calculateCGPABtn.addActionListener(new ListenerCGCalculator());
        
        
        panel = new CPanel(new GridBagLayout());
//        panel.setBackground(new Color(217,217,217));
        c.gridx = 0;
        c.gridy = 0;
        panel.add(label, c);
        c.gridy = 1;
        panel.add(regNoInputField, c);
        c.gridy = 2;
        panel.add(resultBtn, c);
        c.gridy = 3;
        panel.add(teacherInputBtn, c);
        c.gridy = 4;
        panel.add(calculateCGPABtn, c);
        
        
        frame = new JFrame();
        frame.add(panel);
        
        frame.setSize(600,768);
        frame.setLocation(300, 00);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private class ListenerTeacherInput implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getActionCommand().equalsIgnoreCase("Teacher's Input")){
                System.out.println("teachers");
                new TeacherLogin();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        }

    }
    
    private class ListenerCGCalculator implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            new ManualCgpa();
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
        
    }
    
    private class ListenerResult implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            try{
                regNo = Integer.parseInt(regNoInputField.getText());
                new StudentInfo(regNo);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(frame, "Please your Registration number ","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
     private static class BlankBoxException  extends Exception {
       
    }
    
}


