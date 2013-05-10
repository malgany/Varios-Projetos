/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelabirinto2;

/**
 *
 * @author Tony L
 */
public class Mapa {
    
    private Buffer buffer;
    public int[][] Matriz;
    int l, c;
     
    public String MontaMapa(int x, int y){  
        Buffer b = new Buffer();
        this.buffer = b;
        
        return this.buffer.Visual(x, y, l, c);
    }
    
    public int[][] Logica(int linha, int coluna){
        //int linha=6, coluna=5;        
        this.l = linha;
        this.c = coluna;
        
        int Matris[][] = new int[linha][coluna];

        
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                Matris[i][j] = 1;
            }
        }        
        Matris[0][3] = 0;
        Matris[1][1] = 0;
        Matris[1][4] = 0;
        Matris[2][3] = 0;
        Matris[3][1] = 0;
        Matris[4][0] = 0;
        Matris[4][3] = 0;
        Matris[5][1] = 0; 
     
        return this.Matriz = Matris;
        
    }    
}
