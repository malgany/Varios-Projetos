/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diagramaestados;

import java.util.Scanner;
/**
 *
 * @author Tony L
 */
public class DiagramaEstados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int x=0, y=1;    
        int l=6, c=5;
        
        int Matriz[][] = new int[l][c];

        Scanner leitor = new Scanner(System.in);
        
        String cc;
       
        Mapa m = new Mapa();
        m.c =c;
        m.l =l;
        
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                Matriz[i][j] = 1;
            }
        }        
        Matriz[0][3] = 0;
        Matriz[1][1] = 0;
        Matriz[1][4] = 0;
        Matriz[2][3] = 0;
        Matriz[3][1] = 0;
        Matriz[4][0] = 0;
        Matriz[4][3] = 0;
        Matriz[5][1] = 0;       
             
        //System.out.printf(m.Visual(c, l));
        
        while(x!=4 || y !=5){
         
            System.out.printf("\n");
            
            cc = leitor.next();
            
                    
            if(cc.equals("W") || cc.equals("w") && y-1>=0 && y-1<=5){
                if(Matriz[y-1][x] == 1){
                 y = y-1;   
                 System.out.printf(m.Visual(x, y));
                 //System.out.println("Posição atual: "+(y)+" "+(x));    
                }//else
                    //System.out.println("Posição inválida!");   
            }else if(cc.equals("A") || cc.equals("a") && x-1>=0 && x-1<=4){
                if(Matriz[y][x-1] == 1){
                 x = x-1;   
                 System.out.printf(m.Visual(x, y));
                 //System.out.println("Posição atual: "+(y)+" "+(x));    
                }//else
                    //System.out.println("Posição inválida!");                 
            }else if(cc.equals("S") || cc.equals("s") && y+1>=0 && y+1<=5){
                if(Matriz[y+1][x] == 1){
                 y = y+1;   
                 System.out.printf(m.Visual(x, y));
                 //System.out.println("Posição atual: "+(y)+" "+(x));    
                }//else
                    //System.out.println("Posição inválida!");                 
            }else if(cc.equals("D") || cc.equals("d") && x+1>=0 && x+1<=4){
                if(Matriz[y][x+1] == 1){
                 x = x+1;   
                 System.out.printf(m.Visual(x, y));
                 //System.out.println("Posição atual: "+(y)+" "+(x));    
                }//else
                    //System.out.println("Posição inválida!");                 
            }else{
                //System.out.println("Posição inválida!");
            }                
        }
    }
}
