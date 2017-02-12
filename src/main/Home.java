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
    
    
    Home(){
        GridBagConstraints c = new GridBagConstraints();
        label = new JLabel("Result Management Software");
        label.setLocation(100, 100);
        
        regNoInputField = new JTextField(11);
        
        resultBtn = new JButton("See Result");
        teacherInputBtn = new JButton("Teacher's Input");
        teacherInputBtn.addActionListener(new ButtonListener());
        calculateCGPABtn = new JButton("Calculate CGPA");
        calculateCGPABtn.addActionListener(new CGButtonListener());
        
        
        panel = new JPanel(new GridBagLayout());
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
    
    private class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getActionCommand().equalsIgnoreCase("Teacher's Input")){
                System.out.println("teachers");
                new TeacherLogin();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        }

    }
    
    private class CGButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            new ManualCgpa();
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
        
    }
}


