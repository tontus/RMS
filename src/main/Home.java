/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import customSwing.CPanel;
import customSwing.CButton;
import customSwing.CFrame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author mainu
 */
public class Home {
    CFrame frame;
    CPanel panel;
    
    JLabel label;
    
    JTextField regNoInputField;
    
    CButton resultBtn;
    CButton teacherInputBtn;
    CButton calculateCGPABtn;
    
    static int regNo;
    String strRegNo;
    
    ImageIcon logo = new ImageIcon("/img/logo.png");

    
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
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 2, 0, 2);
        panel.add(label, c);
        c.gridy = 1;
        panel.add(regNoInputField, c);
        c.gridy = 2;
        panel.add(resultBtn, c);
        c.gridy = 3;
        panel.add(teacherInputBtn, c);
        c.gridy = 4;
        panel.add(calculateCGPABtn, c);
        
        
        frame = new CFrame("Result Management Software");
        frame.add(panel);
        frame.setDefaultCloseOperation(CFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(400,568);
        frame.setLocation(400,00);
    }
    
    private class ListenerTeacherInput implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getActionCommand().equalsIgnoreCase("Teacher's Input")){
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


