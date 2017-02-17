/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import calculations.Result;
import customSwing.CButton;
import customSwing.CFrame;
import customSwing.CPanel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


/**
 *
 * @author mainu
 */
public class TeacherDataInput {
    CFrame frame;
    CPanel panel;
    
    JLabel lblCourseName;
    JLabel lblCourseCode;
    JLabel lblNoStudent;
    JLabel lblCredit;
    JLabel lblSeasson;
    JLabel lblClassNo;
    JLabel lblTT1;
    JLabel lblTT2;
    JLabel lblSemFinal;
   
    
    JTextField tfCourseName;
    JTextField tfCourseCode;
    JTextField tfNoStudent;
    JTextField tfCredit;
    JTextField tfSeasson;
    JTextField tfClassNo;
    JTextField tfTT1;
    JTextField tfTT2;
    JTextField tfSemFinal;
    
    JTable table;
    
    CButton btnOkay;
    CButton btnInput;
    CButton btnHome;
    
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
        lblClassNo = new JLabel("Total Classes:");
        lblTT1 = new JLabel("Total TT1 Number: ");
        lblTT2 = new JLabel("Total TT2 Number: ");
        lblSemFinal = new JLabel("Semester final Marks:");
        
        tfCourseName = new JTextField(15);
        tfCourseCode = new JTextField(15);
        tfNoStudent = new JTextField(15);
        tfCredit = new JTextField(15);
        tfSeasson = new JTextField(15);
        tfClassNo = new JTextField(15);
        tfTT1 = new JTextField(15);
        tfTT2 = new JTextField(15);
        tfSemFinal = new JTextField(15);
                
        btnInput = new CButton("Input");
        btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Result result = new Result();
                inputData = new Object[noStudent][5];
                
                for(int i=0; i<noStudent; i++)
                {
                    
                    inputData[i][0] = table.getValueAt(i, 0);
                    inputData[i][1] = Double.parseDouble(tfCredit.getText());
                    inputData[i][2] = tfCourseName.getText();
                    inputData[i][3] = tfCourseCode.getText();
                    inputData[i][4] = result.getGP(
                            Integer.parseInt(tfClassNo.getText()),
                            Integer.parseInt(tfTT1.getText()),
                            Integer.parseInt(tfTT2.getText()),
                            Integer.parseInt(tfSemFinal.getText()),
                            Integer.parseInt((String) table.getValueAt(i, 1)), 
                            Integer.parseInt((String) table.getValueAt(i, 2)), 
                            Integer.parseInt((String) table.getValueAt(i, 3)), 
                            Integer.parseInt((String) table.getValueAt(i, 4))
                    );
                    System.out.println(""+inputData[i][0]+" " +inputData[i][1]+" "+inputData[i][2]+" "+inputData[i][3]+" "+inputData[i][4]);
                }
                DatabaseConnection db = new DatabaseConnection();
                db.startConnection();
                db.insertData(inputData);
                db.stopConnection();
                
            }
        });
        
        
        btnOkay = new CButton("Okay");
        btnOkay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    if(tfCourseCode.getText().equals("")||tfCourseName.getText().equals("")||tfCredit.getText().equals("")||tfSeasson.getText().equals(""))
                        throw new BlankBoxException();
                    noStudent = Integer.parseInt(tfNoStudent.getText());
                    String[] columnName = {"Registration No", "Attendence", "TT1", "TT2", "Semester Final"};
                    Object[][] data = new Object[noStudent][5];
                    table = new JTable(data, columnName);
                    c.weighty = 0;
                    c.gridx = 0;
                    c.gridy = 6;
                    panel.add(lblClassNo, c);
                    c.gridx = 1;
                    c.gridy = 6;
                    panel.add(tfClassNo, c);
                    c.gridy=7;
                    c.gridx=0;
                    panel.add(lblTT1,c);
                    c.gridx=1;
                    panel.add(tfTT1,c);
                    c.gridy++;
                    c.gridx=0;
                    panel.add(lblTT2,c);
                    c.gridx=1;
                    panel.add(tfTT2,c);
                    c.gridy++;
                    c.gridx=0;
                    panel.add(lblSemFinal,c);
                    c.gridx=1;
                    panel.add(tfSemFinal,c);
                    c.gridx = 0;
                    c.gridy+=2;
                    c.gridwidth=2;
                    c.weighty=1;
                    panel.add(new JScrollPane(table), c);
                    panel.remove(btnOkay);
                    c.weighty=0;
                    c.gridx = 1;
                    c.gridy++;
                    panel.add(btnInput, c);
                    frame.revalidate();
                    frame.repaint();
                } catch (BlankBoxException ex) {
                        JOptionPane.showMessageDialog(frame, "Please Don't leave any box blank ","ERROR",JOptionPane.ERROR_MESSAGE);
                   
                    }
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number ","ERROR",JOptionPane.ERROR_MESSAGE);
//                    throw e;
                }
            }
        });
        
        btnHome = new CButton("Home");
        btnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        
        
        
         
        panel = new CPanel(new GridBagLayout());
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
//        c.gridx = -1;
//        c.gridy = 6;
//        panel.add(lblClassNo, c);
//        c.gridx = 1;
//        c.gridy = 6;
//        panel.add(tfClassNo, c);
        c.gridx = 1;
        c.gridy = 7;
        panel.add(btnOkay, c);
        c.gridx = 1;
        c.gridy = 21;
        panel.add(btnHome, c);

        
        
        
        
        frame = new CFrame();
        frame.setDefaultCloseOperation(CFrame.DISPOSE_ON_CLOSE);
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
