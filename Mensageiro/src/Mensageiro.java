/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.*;

/**
 *
 * @author Tony L
 */
public interface Mensageiro extends Remote{

    public void enviarMensagem(String msg) throws RemoteException;
    public String lerMensagem() throws RemoteException;
    
}
