/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author mainu
 */
public class CButton extends JButton{
    Dimension d = new Dimension(125, 30);
    
    public CButton(String text){
        super(text);
        super.setBackground(new Color(91,155,213));
        super.setForeground(Color.white);
        super.setPreferredSize(d);
    }
}
