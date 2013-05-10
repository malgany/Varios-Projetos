/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelabirinto3;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Tony L
 */
class Mapa {

    private int x;
    private int y;
    private int cx=3;
    private int cy=6;
    private int fatThrad = 300;

    public int[][] Matriz;
    JTextArea jt;
    JLabel LNroVida, LNroNivel;
    int l, c, nv=5, nn=1;
    
    public void MovObj(JTextArea j, JLabel LNroVida, JLabel LNroNivel){
        this.jt = j;
        this.LNroVida=LNroVida;
        this.LNroNivel=LNroNivel;//Integer.toString(b)
    }
        
    public int[][] Logica(int linha, int coluna){
        
        this.l = linha;
        this.c = coluna;
        
        int MatrizLocal[][] = new int[linha][coluna];

        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                MatrizLocal[i][j] = 1;
            }
        }
        MatrizLocal[0][0] = 2; 
        MatrizLocal[0][3] = 0;
        MatrizLocal[1][1] = 0;
        MatrizLocal[1][4] = 0;
        MatrizLocal[2][3] = 0;
        MatrizLocal[3][1] = 0;
        MatrizLocal[4][0] = 0;
        MatrizLocal[4][3] = 0;
        MatrizLocal[5][1] = 0; 
     
        return this.Matriz = MatrizLocal;        
    }
    
    public synchronized void Visual() {
        int cont = 0;
        String Monta = "";
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                if(Matriz[i][j] == 0){
                    Monta += "█ ";    
                }else if(Matriz[i][j] == 1){
                    Monta += "▒ ";
                }else if(Matriz[i][j] == 2){
                    Monta += "☺ ";
                }else if(Matriz[i][j] == 3){
                        Monta += "☻ ";
                }
                cont++;
                if (cont == c) {
                    Monta += "\n";
                    cont = 0;
                }
            }
        }
        
        LNroVida.setText(Integer.toString(nv));
        LNroNivel.setText(Integer.toString(nn));
    
                        
        jt.setText(Monta+"                                                         /\\\n"
                + "                                                          |\n"
                + "                                                     Saída");
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the cx
     */
    public int getCx() {
        return cx;
    }

    /**
     * @param cx the cx to set
     */
    public void setCx(int cx) {
        this.cx = cx;
    }

    /**
     * @return the cy
     */
    public int getCy() {
        return cy;
    }

    /**
     * @param cy the cy to set
     */
    public void setCy(int cy) {
        this.cy = cy;
    }

    /**
     * @return the fatThrad
     */
    public int getFatThrad() {
        return fatThrad;
    }

    /**
     * @param fatThrad the fatThrad to set
     */
    public void setFatThrad(int fatThrad) {
        this.fatThrad = fatThrad;
    }
    
}
