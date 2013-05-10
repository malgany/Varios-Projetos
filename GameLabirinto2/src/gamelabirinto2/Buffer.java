/*
 *  X & Y :: Posição atual do 
 * 
 * 
 */
package gamelabirinto2;

/**
 *
 * @author Tony L
 */
public class Buffer {

    private int cx, cy;

    public synchronized String Visual(int x, int y, int l, int c) {
        int cont = 0;
        String Monta = "";
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                if (y == i && x == j) {
                    Monta += "☺ ";
                } else if (this.cx == i && this.cy == j){
                    Monta += "☻ ";
                }else if (i == 0 && j == 3) {
                    Monta += "█ ";
                } else if (i == 1 && j == 1) {
                    Monta += "█ ";
                } else if (i == 1 && j == 4) {
                    Monta += "█ ";
                } else if (i == 2 && j == 3) {
                    Monta += "█ ";
                } else if (i == 3 && j == 1) {
                    Monta += "█ ";
                } else if (i == 4 && j == 0) {
                    Monta += "█ ";
                } else if (i == 4 && j == 3) {
                    Monta += "█ ";
                } else if (i == 5 && j == 1) {
                    Monta += "█ ";
                } else {
                    Monta += "▒ ";
                }
                cont++;
                if (cont == c) {
                    Monta += "\n";
                    cont = 0;
                }
            }
        }
        return Monta;
    }

    public void setCx(int cx) {
        this.cx = cx;
    }

    /**
     * @param cy the cy to set
     */
    public void setCy(int cy) {
        this.cy = cy;
    }
}
