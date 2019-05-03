/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.view.classes;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Gnanod-PC
 */
public class JpanelEdit extends JPanel{

    public JpanelEdit() {
        super();
        setOpaque(false);
    }
    @Override
    protected  void paintComponent(Graphics g){
        g.setColor(new Color(0, 0, 0,150));
        g.fillRoundRect(0,0,getWidth(),getHeight(),50,50);
        super.paintComponent(g);
        
    }
    @Override
    protected void paintBorder(Graphics g){
        g.setColor(new Color(0, 0, 0));
        g.drawRoundRect(0,0, getWidth(),getHeight() ,50 ,50);
    }
    
}
