/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pintamatriz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author juan
 */
public class Panel extends JPanel implements KeyListener {
    private Juego juego;
    private int ancho, alto;
    private LoopJuego loop;
    private JPanel panelPuntaje;
    private JLabel puntajeLa;
    
    private Pared pared;
    private Pacman pacman;
    
    public Panel() {
        this.juego = new Juego();
        this.loop = new LoopJuego(this, juego);
        this.ancho = 50;  // px
        this.alto = 50;  // px
        
        this.pared = new Pared();
        this.pacman = new Pacman();
        
        this.panelPuntaje = new JPanel();
        this.panelPuntaje.setBounds(500, 0, 100, 550);
        this.panelPuntaje.setBackground(Color.white);
        this.add(this.panelPuntaje);
        
        this.puntajeLa = new JLabel(String.valueOf(this.juego.getPuntaje()));
        this.puntajeLa.setBounds(0, 0, 100, 25);
        this.panelPuntaje.add(puntajeLa);
        
        this.setLayout(null);
        this.setBackground(Color.blue);
        this.iniciar();
    }
    
    public void pintarFondo(Graphics g) {
        int[][] matrizAux = this.juego.getMatriz();
        for (int i = 0; i < this.juego.getAlto(); i++) {
            for (int j = 0; j < this.juego.getAncho(); j++) {
                switch(matrizAux[i][j]) {
                    case 0:
                        this.pared.pintar(i, j, ancho, alto, g);
                        break;
                    case 1:
                        g.setColor(Color.green);
                        g.fillRect(j * this.ancho, i * this.alto, this.ancho, this.alto);
                        break;
                    case 2:
                        g.setColor(Color.white);
                        g.fillOval(j * this.ancho + 10, i * this.alto + 10, this.ancho - 20, this.alto - 20);
                        break;
                    case 3:
                        this.pacman.pintar(i, j, ancho, alto, g);
                        break;
                }
            }
        }
    }
    
    @Override
    public void update(Graphics g){
        super.update(g);
        paint(g);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.pintarFondo(g);
    }
    
    public void iniciar() {
        this.juego.empezarJuego();
        this.loop.start();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        switch(ke.getKeyCode()) {
            case KeyEvent.VK_UP:
                this.juego.moverArriba();
                break;
            case KeyEvent.VK_DOWN:
                this.juego.moverAbajo();
                break;
            case KeyEvent.VK_LEFT:
                this.juego.moverIzq();
                break;
            case KeyEvent.VK_RIGHT:
                this.juego.moverDer();
                break;
        }
        this.puntajeLa.setText(String.valueOf(this.juego.getPuntaje()));
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }

}
