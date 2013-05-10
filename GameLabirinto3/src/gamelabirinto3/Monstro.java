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
    int xx=11,yy=9,x2,y2;
    
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
             
                
                y2=yy;
                x2=xx;
                int vet[];
                vet = mv.direcao(randomInt, xx, yy);
                xx = vet[0];
                yy = vet[1];               
                
                
                map.Matriz[y2][x2] = 1;
                map.Matriz[yy][xx] = 3;
                
                map.Visual();

                Thread.currentThread().sleep(map.getFatThrad());

            }
            
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
