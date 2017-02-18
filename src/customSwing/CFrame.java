/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customSwing;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author mainu
 */
public class CFrame extends JFrame {
    public CFrame(){
        
    }
    public CFrame(String title){
        super(title);
        super.setIconImage(new ImageIcon(getClass().getResource("/img/logo1.png")).getImage());
        super.setSize(600,768);
        super.setLocation(300, 00);
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
