/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import customSwing.CButton;
import customSwing.CFrame;
import customSwing.CPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author mainu
 */
public class TeacherLogin {
    CFrame frame;
    CPanel panel;
    
    JLabel label;
    
    JTextField teacherID;
    JPasswordField password;
    
    CButton btnLogin;
    CButton btnBack;
    Map userList = new HashMap();
    

    
    TeacherLogin(){
        File login_info = new File("teacher login.csv");
        Scanner sc = null;
        try {
            sc = new Scanner(login_info);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TeacherLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (sc.hasNext())
        {
            String raw = sc.nextLine();
            String[] values = raw.split(",");
            userList.put(values[0],values[1]);
            
        }
        sc.close();
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
        c.insets = new Insets(5, 2, 0, 2);
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
        
        frame = new CFrame("Teacher's Login");
        frame.add(panel);
        frame.setDefaultCloseOperation(CFrame.DISPOSE_ON_CLOSE);
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
            String pass = (String) userList.get(teacherID.getText());
                try {
                    if(pass.equals(password.getText())){
                        new TeacherDataInput();
                        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                    }
                    else{
                        JOptionPane.showMessageDialog(panel, "Login Failed!!!","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                }catch (NullPointerException el) {
                    JOptionPane.showMessageDialog(panel, "Login Failed!!!","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
    };
}
