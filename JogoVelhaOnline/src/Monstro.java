
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tony L
 */
class Monstro extends Thread{

    protected Mensageiro m;
    protected int[][] matriz;
    protected boolean suavez;
    JButton jb00, jb01, jb02, jb10, jb11, jb12, jb20, jb21, jb22;
    
    ArrayList<String> play = new ArrayList<String> ();
    
    public Monstro(Mensageiro m, int[][] matriz, boolean suavez, ArrayList<String> play, 
            JButton jb00, JButton jb01, JButton jb02, JButton jb10, JButton jb11, 
            JButton jb12, JButton jb20, JButton jb21, JButton jb22) {
        this.m = m;
        this.matriz = matriz;
        this.suavez = suavez;
        this.play = play;
        this.jb00 = jb00;
        this.jb01 = jb01;
        this.jb02 = jb02;
        this.jb10 = jb10;
        this.jb11 = jb11;
        this.jb12 = jb12;
        this.jb20 = jb20;
        this.jb21 = jb21;
        this.jb22 = jb22;
    }
    
        @Override
    public void run() {
        try {
            while(true){
                try {
                    if(this.play.get(0).equals("1")){
                        System.out.println("Entrou no if thread :: "+this.suavez);
                        this.suavez = m.getVez1();
                    }else{
                        this.suavez = m.getVez2();
                        System.out.println("Entrou no else thread :: "+this.suavez);
                    }
                    
                    if(this.suavez == true){
                        this.m.atualizatudo(this.suavez, this.play);
                        System.out.println("Entrou no atualiza tudo");
                    }
                    
                    this.matriz = m.getTabuleiro();
                    
                    //if(this.suavez)
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                System.out.println("["+i+"]["+j+"]");

                                if(i == 0 && j == 0 && this.matriz[i][j] == 1)
                                    this.jb00.setText("X");
                                else if(i == 0 && j == 0 && this.matriz[i][j] == 2)
                                    this.jb00.setText("O");

                                else if(i == 0 && j == 1 && this.matriz[i][j] == 1)
                                    this.jb01.setText("X");
                                else if(i == 0 && j == 1 && this.matriz[i][j] == 2)
                                    this.jb01.setText("O");

                                else if(i == 0 && j == 2 && this.matriz[i][j] == 1)
                                    this.jb02.setText("X");
                                else if(i == 0 && j == 2 && this.matriz[i][j] == 2)
                                    this.jb02.setText("O");

                                else if(i == 1 && j == 0 && this.matriz[i][j] == 1)
                                    this.jb10.setText("X");
                                else if(i == 1 && j == 0 && this.matriz[i][j] == 2)
                                    this.jb10.setText("O");

                                else if(i == 1 && j == 1 && this.matriz[i][j] == 1)
                                    this.jb11.setText("X");
                                else if(i == 1 && j == 1 && this.matriz[i][j] == 2)
                                    this.jb11.setText("O");

                                else if(i == 1 && j == 2 && this.matriz[i][j] == 1)
                                    this.jb12.setText("X");
                                else if(i == 1 && j == 2 && this.matriz[i][j] == 2)
                                    this.jb12.setText("O");

                                else if(i == 2 && j == 0 && this.matriz[i][j] == 1)
                                    this.jb20.setText("X");
                                else if(i == 2 && j == 0 && this.matriz[i][j] == 2)
                                    this.jb20.setText("O");

                                else if(i == 2 && j == 1 && this.matriz[i][j] == 1)
                                    this.jb21.setText("X");
                                else if(i == 2 && j == 1 && this.matriz[i][j] == 2)
                                    this.jb21.setText("O");

                                else if(i == 2 && j == 2 && this.matriz[i][j] == 1)
                                    this.jb22.setText("X");
                                else if(i == 2 && j == 2 && this.matriz[i][j] == 2)
                                    this.jb22.setText("O");
                            }
                        }
                    
                    m.setTabuleiro(this.matriz);
                    
                } catch (RemoteException ex) {
                    Logger.getLogger(Monstro.class.getName()).log(Level.SEVERE, null, ex);
                }
                Thread.currentThread().sleep(9000);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
        
    private void habilitaTabuleiro() {       
        this.jb00.setEnabled(true);
        this.jb01.setEnabled(true);
        this.jb02.setEnabled(true);
        this.jb10.setEnabled(true);
        this.jb11.setEnabled(true);
        this.jb12.setEnabled(true);
        this.jb20.setEnabled(true);
        this.jb21.setEnabled(true);
        this.jb22.setEnabled(true);
    }
}
