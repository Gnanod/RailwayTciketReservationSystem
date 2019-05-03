/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.view.classes;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Gnanod-PC
 */
public class JpanelEdit1 extends JPanel{
    
    public JpanelEdit1() {
        super();
        setOpaque(false);
    }
    @Override
    protected  void paintComponent(Graphics g){
        g.setColor(new Color(255, 255,255,150));
        g.fillRoundRect(0,0,getWidth(),getHeight(),50,50);
        super.paintComponent(g);
        
    }
    @Override
    protected void paintBorder(Graphics g){
        g.setColor(new Color(0, 0, 0));
        g.drawRoundRect(0,0, getWidth()-1,getHeight()-1 ,50 ,50);
    }

   
}
