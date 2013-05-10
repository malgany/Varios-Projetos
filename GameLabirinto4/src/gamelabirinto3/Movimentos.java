/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelabirinto3;

import java.awt.event.KeyEvent;

/**
 *
 * @author Tony L
 */



class Movimentos {
    
    private Mapa map;
    
    Movimentos(Mapa m){
        this.map = m;
    }
    
       public int[] direcao(int d, int xx, int yy){
        //System.out.println(xx+"<-x, y->"+yy);
        int vet[] = new int[2];
        
        if (d == 0){
            if(yy-1>=0 && yy-1<=map.c){
                if(map.Matriz[yy-1][xx] == 1){
                    yy = yy-1;                
            }   
        }
        } else if(d == 1){
            if(xx-1>=0 && xx-1<=map.l){
                if(map.Matriz[yy][xx-1] == 1){
                    xx = xx-1;
            }   
        }
        } else if(d == 2){
            if(xx+1>=0 && xx+1<map.c){
                if(map.Matriz[yy][xx+1] == 1){
                 xx = xx+1;
            }   
        }
        } else if(d == 3){
            if(yy+1>=0 && yy+1<map.l){
                if(map.Matriz[yy+1][xx] == 1){
                    yy = yy+1;
                }   
            }
        }
        
        vet[0] = xx;
        vet[1] = yy;
        
        return vet;
    }
    
    
}
