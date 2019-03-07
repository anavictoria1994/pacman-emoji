/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pintamatriz;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author juan
 */
public class Pared {
    
    public void pintar(int i, int j, int ancho, int alto, Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(j * ancho, i * alto, ancho, alto);
    }
}
