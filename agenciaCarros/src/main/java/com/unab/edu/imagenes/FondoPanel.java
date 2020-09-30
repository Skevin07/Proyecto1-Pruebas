/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.imagenes;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Mauricio
 */
public class FondoPanel extends JPanel{
    private Image imagen;
    private JFrame formulario;
    public FondoPanel(JFrame pFormulario){
        this.formulario=pFormulario;
    }
    @Override
    public void paint(Graphics g){
        imagen= new ImageIcon(getClass().getResource("/16.jpg")).getImage();
        g.drawImage(imagen, 0,0,getWidth(), getHeight(), formulario);
        setOpaque(false);
        super.paint(g);
    }
}
