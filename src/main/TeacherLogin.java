/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import customSwing.CButton;
import customSwing.CPanel;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author mainu
 */
public class TeacherLogin {
    JFrame frame;
    JPanel panel;
    
    JLabel label;
    
    JTextField teacherID;
    JPasswordField password;
    
    JButton btnLogin;
    JButton btnBack;
    

    
    TeacherLogin(){
        GridBagConstraints c = new GridBagConstraints();
        label = new JLabel("Please Input ID and Password");
        
        teacherID = new JTextField(15);
        teacherID.setName("ID");
        password = new JPasswordField(15);
        
        btnLogin = new CButton("Login");
        btnLogin.addActionListener(listenerLogin);
         
        btnBack = new CButton("Back");
        btnBack.addActionListener(listenerBack);
        
        panel = new CPanel(new GridBagLayout());
        c.gridx = 0;
        c.gridy = 0;
        panel.add(label,c);
        c.gridy = 1;
        panel.add(teacherID, c);
        c.gridy = 2;
        panel.add(password, c);
        c.gridy = 4;
        panel.add(btnLogin, c);
        c.gridy++;
        panel.add(btnBack, c);
        
        frame = new JFrame("Teacher's Login");
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600,768);
        frame.setLocation(300, 00);
        frame.setVisible(true);
    }
    
    ActionListener listenerBack = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            new Home();
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    };
    
    ActionListener listenerLogin = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String id = teacherID.getText();
            String pass = password.getText();
            if(id.equals("admin") && pass.equals("admin")){
                new TeacherDataInput();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        }
    };
}
