/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Tony L
 */
public class MensageiroImpl extends UnicastRemoteObject implements Mensageiro{

    public String msg; 
    
    public MensageiroImpl() throws RemoteException{
        super();
    }

    public void enviarMensagem(String msg) throws RemoteException {
        this.msg = msg;
        System.out.println(this.msg);
    }

    public String lerMensagem() throws RemoteException {
        return this.msg;
    }    
}
