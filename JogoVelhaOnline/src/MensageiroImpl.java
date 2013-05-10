/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Tony L
 */
public class MensageiroImpl extends UnicastRemoteObject implements Mensageiro{

    protected boolean one = false;
    protected boolean two = false;
    protected boolean vez1;
    protected boolean vez2;
   
    ArrayList<String> play1 = new ArrayList<String> ();
    ArrayList<String> play2 = new ArrayList<String> ();
    
    ArrayList<String> pilhamsg = new ArrayList<String> ();
    
    protected int matriz[][] = new int[3][3];
    
    public MensageiroImpl() throws RemoteException{
        super();
    }

    @Override
    public  ArrayList<String> validaJogador(String nome) throws RemoteException {  
        if(!this.one){
            this.one = true;
            play1.add("1");
            play1.add(nome);
            play1.add("X");
            pilhamsg.add("Jogador 1 conectou-se");
            
            return play1;
            
        }else if(!this.two){
            this.two = true;
            play2.add("2");
            play2.add(nome);
            play2.add("O");
            pilhamsg.add("Jogador 2 conectou-se");
            
            return play2;
            
        }else
            pilhamsg.add("Um terceiro jogador tentou conexão");
        
            return pilhamsg; 
    }

    @Override
    public int[][] tabuleiro(int[][] matriz) throws RemoteException {
        if(matriz[0][0] != 0 && matriz[0][0] != 1 && matriz[0][0] != 2)
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    matriz[i][j] = 0;
                }            
            }
        return this.matriz = matriz;
    }

    @Override
    public void atualizatudo(boolean suavez, ArrayList<String> play) throws RemoteException {
        
        if(play.get(0).equals("1") && suavez){
            this.vez1 = true ;
            this.vez2 = false;
        }else if(play.get(0).equals("2") && suavez){
            this.vez2 = true ;
            this.vez1 = false;
        }
    }

    @Override
    public int[][] getTabuleiro() throws RemoteException {
        return this.matriz;
    }

    @Override
    public void setTabuleiro(int[][] matriz) throws RemoteException {
        this.matriz = matriz;
    }

    @Override
    public boolean getVez1() throws RemoteException {
        return this.vez1;
    }

    @Override
    public boolean getVez2() throws RemoteException {
        return this.vez2;
    }
    
    
}