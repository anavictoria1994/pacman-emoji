/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pintamatriz;

import javax.swing.JFrame;

/**
 *
 * @author juan
 */
public class Ventana extends JFrame {
    private Panel panel;
    
    public Ventana() {
        this.panel = new Panel();
        
        this.setContentPane(panel);
        this.setTitle("Pinta Matriz");
        this.setSize(600, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.addKeyListener(panel);
        this.setFocusable(true);
        this.setVisible(true);
    }
}
