/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pintamatriz;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author juan
 */
public class Pacman {
    private ImageIcon imagen;
    
    public Pacman() {
        this.imagen = new ImageIcon("src/pintamatriz/popo.png");
    }
    
    public void pintar(int i, int j, int ancho, int alto, Graphics g) {
        g.drawImage(this.imagen.getImage(), j * ancho, i * alto, ancho, alto, null);
    }
}
