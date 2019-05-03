/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.view.classes;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Gnanod-PC
 */
public class JTextFieldEdit extends javax.swing.JTextField{
    public JTextFieldEdit(int size) {
        super(size);
        setOpaque(false);
    }
   @Override
    protected  void paintComponent(Graphics g){
        g.setColor(new Color(0, 0, 0,100));
        g.fillRoundRect(0,0,getWidth()-1,getHeight()-1,20,20);
        super.paintComponent(g);
      
    }
     @Override
    protected void paintBorder(Graphics g){
        g.setColor(new Color(0, 0, 0,100));
        g.drawRoundRect(0,0, getWidth()-1,getHeight()-1 ,20 ,20);
    }
}
