/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


/**
 *
 * @author mainu
 */
public class TeacherDataInput {
    JFrame frame;
    JPanel panel;
    
    JLabel lblCourseName;
    JLabel lblCourseCode;
    JLabel lblNoStudent;
    JLabel lblDept;
    JLabel lblSeasson;
    
    JTextField tfCourseName;
    JTextField tfCourseCode;
    JTextField tfNoStudent;
    JTextField tfDept;
    JTextField tfSeasson;
    
    JTable table;
    
    JButton btnOkay;
    JButton btnInput;
    
    static int noStudent;
    boolean success = false;
    
//    Object[][] data;
    
    TeacherDataInput(){
        GridBagConstraints c = new GridBagConstraints();
        
        lblCourseName = new JLabel("Course Name:");
        lblCourseCode = new JLabel("Course Code:");
        lblNoStudent = new JLabel("No of Student:");
        lblDept = new JLabel("Department:");
        lblSeasson = new JLabel("Seasson:");
        
        tfCourseName = new JTextField(15);
        tfCourseCode = new JTextField(15);
        tfNoStudent = new JTextField(15);
        tfDept = new JTextField(15);
        tfSeasson = new JTextField(15);
        
        
        
        btnInput = new JButton("Input");
        btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                JOptionPane.showMessageDialog(frame, "Hello");
                table.getValueAt(noStudent, noStudent);
                
            }
        });
        
        
        btnOkay = new JButton("Okay");
        
        btnOkay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    if(tfCourseCode.getText().equals("")||tfCourseName.getText().equals("")||tfDept.getText().equals("")||tfSeasson.getText().equals(""))
                        throw new BlankBoxException();
                    noStudent = Integer.parseInt(tfNoStudent.getText());

                    
                    
                    
                    String[] columnName = {"Registration No", "Attendence", "TT1", "TT2", "Attendence"};
                    Object[][] data = new Object[noStudent][5];
                    //Object[][] data = {{"Kathy", "Smith","Snowboarding", new Integer(5), new Boolean(false)}, {"John", "Doe", "Rowing", new Integer(3), new Boolean(true)},{"Sue", "Black", "Knitting", new Integer(2), new Boolean(false)}, {"Jane", "White", "Speed reading", new Integer(20), new Boolean(true)},{"Joe", "Brown", "Pool", new Integer(10), new Boolean(false)}};
                    table = new JTable(data, columnName);
                    c.gridx = 1;
                    c.gridy = 7;
                    c.weighty=1;
                    panel.add(new JScrollPane(table), c);
                    panel.remove(btnOkay);
                    c.gridx = 1;
                    c.gridy = 9;
                    panel.add(btnInput, c);
                    frame.revalidate();
                    frame.repaint();
                } catch (BlankBoxException ex) {
                        JOptionPane.showMessageDialog(frame, "Please Don't leave any box blank ","ERROR",JOptionPane.ERROR_MESSAGE);
                    
//                        throw ex;//this error may be a glitch
                         
                   
                    }
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number ","ERROR",JOptionPane.ERROR_MESSAGE);
//                    throw e;
                }
            }
        });
        
        
        
        
        
         
        panel = new JPanel(new GridBagLayout());
        c.gridx = -1;
        c.gridy = 1;
        panel.add(lblCourseName, c);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(tfCourseName, c);
        c.gridx = -1;
        c.gridy = 2;
        panel.add(lblCourseCode, c);
        c.gridx = 1;
        c.gridy = 2;
        panel.add(tfCourseCode, c);
        c.gridx = -1;
        c.gridy = 3;
        panel.add(lblDept, c);
        c.gridx = 1;
        c.gridy = 3;
        panel.add(tfDept, c);
        c.gridx = -1;
        c.gridy = 4;
        panel.add(lblSeasson, c);
        c.gridx = 1;
        c.gridy = 4;
        panel.add(tfSeasson, c);
        c.gridx = -1;
        c.gridy = 5;
        panel.add(lblNoStudent, c);
        c.gridx = 1;
        c.gridy = 5;
        panel.add(tfNoStudent, c);
        c.gridx = 1;
        c.gridy = 6;
        panel.add(btnOkay, c);

        
        
        
        
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(600, 768);
        frame.setMinimumSize(new Dimension(600, 700));
        frame.setLocation(300,000);
        frame.add(panel);
    }
    public static void main(String[] args) {
        TeacherDataInput td = new TeacherDataInput();
    }
   

    private static class BlankBoxException  extends Exception {
       
    }
    
    
}
