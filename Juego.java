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
public class Juego {
    private Matriz matriz;
    private int ancho, alto;
    private Boolean jugando;
    private int puntaje;
    
    public Juego() {
        this.jugando = false;
        this.matriz = new Matriz();
        this.alto = 10;
        this.ancho = 10;
        this.puntaje = 0;
    }
    
    private void subirPuntaje(int valor) {
        if (valor == 2) {
            this.puntaje++;
        }
    }
    
    public void empezarJuego() {
        this.jugando = true;
    }
    
    public Boolean jugando() {
        return this.jugando;
    }
    
    public int[][] getMatriz() {
        return this.matriz.getMatriz();
    }
    
    public int getAncho() {
        return this.ancho;
    }
    
    public int getAlto() {
        return this.alto;
    }
    
    public void moverArriba() {
        int y = this.matriz.pacy();
        int x = this.matriz.pacx();
        int arriba = ((((y - 1) % 10) + 10) % 10);
        int valorPrev = this.getMatriz()[arriba][x];
        if (valorPrev != 1) {
            this.getMatriz()[y][x] = 0;
            this.matriz.pacy(arriba);
            this.matriz.moverPacman();
            this.subirPuntaje(valorPrev);
        }
    }
    
    public void moverAbajo() {
        int y = this.matriz.pacy();
        int x = this.matriz.pacx();
        int abajo = ((((y + 1) % 10) + 10) % 10);
        int valorPrev = this.getMatriz()[abajo][x];
        if (valorPrev != 1) {
            this.getMatriz()[y][x] = 0;
            this.matriz.pacy(abajo);
            this.matriz.moverPacman();
            this.subirPuntaje(valorPrev);
        }
    }
    
    public void moverIzq() {
        int y = this.matriz.pacy();
        int x = this.matriz.pacx();
        int izq = ((((x - 1) % 10) + 10) % 10);
        int valorPrev = this.getMatriz()[y][izq];
        if (valorPrev != 1) {
            this.getMatriz()[y][x] = 0;
            this.matriz.pacx(izq);
            this.matriz.moverPacman();
            this.subirPuntaje(valorPrev);
        }
    }
    
    public void moverDer() {
        int y = this.matriz.pacy();
        int x = this.matriz.pacx();
        int der = ((((x + 1) % 10) + 10) % 10);
        int valorPrev = this.getMatriz()[y][der];
        if (valorPrev != 1) {
            this.getMatriz()[y][x] = 0;
            this.matriz.pacx(der);
            this.matriz.moverPacman();
            this.subirPuntaje(valorPrev);
        }
    }
    
    public int getPuntaje() {
        return this.puntaje;
    }
}
