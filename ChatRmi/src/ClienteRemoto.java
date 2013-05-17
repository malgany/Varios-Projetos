
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jorge
 */
public interface ClienteRemoto extends Remote {
    public void receberMensagem(String msg) throws RemoteException;
}
