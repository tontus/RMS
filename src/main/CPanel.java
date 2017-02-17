/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

/**
 *
 * @author mainu
 */
public class CPanel extends JPanel{
    Color custom = new Color(217,217,217);
    public CPanel(){
        super.setBackground(custom);
    }

    CPanel(GridBagLayout gridBagLayout) {
        super(gridBagLayout);
        super.setBackground(custom);
    }
}
