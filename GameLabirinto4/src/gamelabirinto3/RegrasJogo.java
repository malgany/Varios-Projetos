/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelabirinto3;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;


/**
 *
 * @author Tony L
 */
public class RegrasJogo{
    
    int xx=0, yy=0;
    /**
     *
     */
    private Mapa map;

    RegrasJogo(Mapa m) {
        this.map = m;
    }
        
    public void Mov(java.awt.event.KeyEvent evt){
        /* * Esse metodo será chamado pela Main
         * Para movimentar e validar..
         */
        int d = -1;
        
        if(evt.getKeyCode() == KeyEvent.VK_UP){
            d = 0;
        }else if(evt.getKeyCode() == KeyEvent.VK_LEFT){
            d = 1;
        }else if(evt.getKeyCode() == KeyEvent.VK_RIGHT){
            d = 2;
        }else if(evt.getKeyCode() == KeyEvent.VK_DOWN){
            d = 3;
        }
        
        
        Movimentos mv = new Movimentos(map);
        
        int vet[];
        //System.out.println(xx+"<-x, y->"+yy);
        vet = mv.direcao(d, xx, yy);
        xx = vet[0];
        yy = vet[1];
        
        map.setX(xx);
        map.setY(yy);
                
        if(xx==map.getCx() && yy==map.getCy()){
            //System.out.println(xx+"=="+map.getCx()+" && "+yy+"=="+map.getCy());
                              
            xx=0;
            yy=0;
            map.setX(xx);
            map.setY(yy);

            if((map.nv-1) < 0){
                JOptionPane.showMessageDialog(null,"GAME OVER ☻");
                System.exit(0);
            }
            JOptionPane.showMessageDialog(null,"Perdeu 1 vida. ☻");
            map.nv=map.nv-1;    
        }else if(xx==11 && yy==9){     
            JOptionPane.showMessageDialog(null,"Parabéns você passou de fase. ☺");
            xx=0;
            yy=0;
            map.setX(xx);
            map.setY(yy);
            System.out.println(map.getFatThrad());
            if(map.getFatThrad()<=5){
                map.setFatThrad(0);
                JOptionPane.showMessageDialog(null,"Fim de jogo você venceu!!!. ☺☺☺☺☺☺☺☺☺☺☺☺");
                System.exit(0);
            }
            map.setFatThrad(map.getFatThrad()-10);
            System.out.println(map.getFatThrad());
            map.nn=map.nn+1;
            
            if(map.nn==10 || map.nn==20 || map.nn==25){           
                map.nv=map.nv+2;
                JOptionPane.showMessageDialog(null,"Você ganhou mais 2 vidas. ☺☺");
            }
        }
        map.Visual();      

    }
    
 
    
        
}
