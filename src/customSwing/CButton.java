/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customSwing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author mainu
 */
public class CButton extends JButton implements MouseListener{
    Dimension d = new Dimension(125, 30);
    
    public CButton(String text){
        super(text);
        super.setBackground(new Color(91,155,213));
        super.setForeground(Color.white);
        super.setPreferredSize(d);
        super.addMouseListener(this);
        super.setBorderPainted(false);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        }

    @Override
    public void mousePressed(MouseEvent e) {
        }

    @Override
    public void mouseReleased(MouseEvent e) {
        }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.setBackground(new Color(77,132,181));
        }

    @Override
    public void mouseExited(MouseEvent e) {
        super.setBackground(new Color(91,155,213));
        }
}
