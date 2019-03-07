/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pintamatriz;

/**
 *
 * @author juan
 */
public class LoopJuego extends Thread {
    private Panel panel;
    private Juego juego;
    
    public LoopJuego(Panel p, Juego j) {
        this.panel = p;
        this.juego = j;
    }
    
    @Override
    public void run() {
        while(this.juego.jugando()) {
            this.panel.repaint();
            try {
                this.sleep(15);
            } catch(InterruptedException e){
                System.out.println("error en el hilo");
            }
        }
    }
}
