/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelabirinto3;

import java.util.Random;

/**
 *
 * @author Tony L
 */
class Monstro extends Thread{

    private Mapa map;
    int xx=11;
    int yy=9;
    
    public Monstro(Mapa m) {
        this.map = m;
    }
    
        @Override
    public void run() {
         try {
             
             
      Random randomGenerator = new Random();
            
            Movimentos mv = new Movimentos(map);
            
            while(true/*xx != map.getX() || yy != map.getY()*/){

                int randomInt = randomGenerator.nextInt(4);                
             
                int vet[];
                vet = mv.direcao(randomInt, xx, yy);
                xx = vet[0];
                yy = vet[1];               
                
                map.setCx(xx);
                map.setCy(yy);
                
                map.Visual();

                Thread.currentThread().sleep(map.getFatThrad());

            }
            
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
