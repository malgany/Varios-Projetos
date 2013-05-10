/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.*;
import java.util.ArrayList;

/**
 *
 * @author Tony L
 */
public interface Mensageiro extends Remote{
    public ArrayList<String> validaJogador(String nome) throws RemoteException;
    public int[][] tabuleiro(int[][] matriz) throws RemoteException;
    public void atualizatudo(boolean suavez, ArrayList<String> play) throws RemoteException;

    public int[][] getTabuleiro() throws RemoteException;

    public void setTabuleiro(int[][] matriz) throws RemoteException;

    public boolean getVez1() throws RemoteException;
    public boolean getVez2() throws RemoteException;
}