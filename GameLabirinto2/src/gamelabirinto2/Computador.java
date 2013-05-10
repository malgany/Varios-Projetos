/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelabirinto2;

import javax.swing.JOptionPane;

/**
 *
 * @author Tony L
 */
class Computador extends Thread{

    private Mapa buffer;
    public String teste;
    
    public Computador(String teste) {
        this.teste = teste;
        this.buffer = new Mapa();
        JOptionPane.showInputDialog("Chegou??"+teste);
    }
    /*
    @Override
    public void run(){
        try {
            int x=0;
            while (x<3) {         
                
            buffer.setCx(x);
            buffer.setCy(x+1);
             Thread.currentThread().sleep(10000);

            x++;
           } 
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    */

    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet.");
         try {
            int x=0;
            while(x<100){         
                
            buffer.MontaMapa(x, x+1);
            
             Thread.currentThread().sleep(10000);

            x++;
           } 
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
