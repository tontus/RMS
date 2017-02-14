/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import calculations.Result;
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
    JLabel lblCredit;
    JLabel lblSeasson;
    JLabel lblClassNo;
    
    JTextField tfCourseName;
    JTextField tfCourseCode;
    JTextField tfNoStudent;
    JTextField tfCredit;
    JTextField tfSeasson;
    JTextField tfClassNo;
    
    JTable table;
    
    JButton btnOkay;
    JButton btnInput;
    JButton btnHome;
    
    static int noStudent;
    boolean success = false;
    
//    Object[][] data;
    
    static Object[][] inputData;
    
    TeacherDataInput(){
        GridBagConstraints c = new GridBagConstraints();
        
        lblCourseName = new JLabel("Course Name:");
        lblCourseCode = new JLabel("Course Code:");
        lblNoStudent = new JLabel("No of Student:");
        lblCredit = new JLabel("Credit:");
        lblSeasson = new JLabel("Seasson:");
        lblClassNo = new JLabel("Classes:");
        
        tfCourseName = new JTextField(15);
        tfCourseCode = new JTextField(15);
        tfNoStudent = new JTextField(15);
        tfCredit = new JTextField(15);
        tfSeasson = new JTextField(15);
        tfClassNo = new JTextField(15);
        
        
        btnInput = new JButton("Input");
        btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                JOptionPane.showMessageDialog(frame, "Hello");
                Result result = new Result();
                inputData = new Object[noStudent][5];
                for(int i=0; i<noStudent; i++)
                {
                    inputData[i][0] = table.getValueAt(i, 0);
                    inputData[i][1] = Double.parseDouble(tfCredit.getText());
                    inputData[i][2] = tfCourseName.getText();
                    inputData[i][3] = tfCourseCode.getText();
                    inputData[i][4] = result.getGP(Integer.parseInt(tfClassNo.getText()), Integer.parseInt((String) table.getValueAt(i, 1)), Integer.parseInt((String) table.getValueAt(i, 2)), Integer.parseInt((String) table.getValueAt(i, 3)), Integer.parseInt((String) table.getValueAt(i, 4)));
                }
                table.getValueAt(noStudent, noStudent);
                
            }
        });
        
        
        btnOkay = new JButton("Okay");
        btnOkay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    if(tfCourseCode.getText().equals("")||tfCourseName.getText().equals("")||tfCredit.getText().equals("")||tfSeasson.getText().equals("")||tfClassNo.getText().equals(""))
                        throw new BlankBoxException();
                    noStudent = Integer.parseInt(tfNoStudent.getText());

                    
                    
                    
                    String[] columnName = {"Registration No", "Attendence", "TT1", "TT2", "Semester Final"};
                    Object[][] data = new Object[noStudent][5];
                    //Object[][] data = {{"Kathy", "Smith","Snowboarding", new Integer(5), new Boolean(false)}, {"John", "Doe", "Rowing", new Integer(3), new Boolean(true)},{"Sue", "Black", "Knitting", new Integer(2), new Boolean(false)}, {"Jane", "White", "Speed reading", new Integer(20), new Boolean(true)},{"Joe", "Brown", "Pool", new Integer(10), new Boolean(false)}};
                    table = new JTable(data, columnName);
                    panel.add(tfClassNo, c);
                    c.gridx = 1;
                    c.gridy = 8;
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
        
        btnHome = new JButton("Home");
        btnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
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
        panel.add(lblCredit, c);
        c.gridx = 1;
        c.gridy = 3;
        panel.add(tfCredit, c);
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
        c.gridx = -1;
        c.gridy = 6;
        panel.add(lblClassNo, c);
        c.gridx = 1;
        c.gridy = 6;
        panel.add(tfClassNo, c);
        c.gridx = 1;
        c.gridy = 7;
        panel.add(btnOkay, c);
        c.gridx = 1;
        c.gridy = 10;
        panel.add(btnHome, c);

        
        
        
        
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
