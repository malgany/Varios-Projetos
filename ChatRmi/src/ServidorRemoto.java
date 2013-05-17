
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
public interface ServidorRemoto extends Remote {
    public void registrarCliente(ClienteRemoto cliente) throws RemoteException;
    public void receberMensagem(String msg) throws RemoteException;
}
