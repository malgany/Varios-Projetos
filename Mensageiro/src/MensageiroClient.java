/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Tony L
 */
public class MensageiroClient {
    
    public static void main(String args[]){
        try{
            Mensageiro m = (Mensageiro)Naming.lookup("rmi://localhost/MensageiroService");
            System.err.println(m.lerMensagem());
            m.enviarMensagem("Tony");
            if(!m.lerMensagem().equals("")){
                m.lerMensagem();
            }
        }catch(MalformedURLException e){
            System.err.println();
            System.err.println("MalformedURLException: "+ e.toString());
        }catch(RemoteException e){
            System.err.println();
            System.err.println("RemoteException: "+ e.toString());
        }catch(NotBoundException e){
            System.err.println();
            System.err.println("NotBoundException: "+ e.toString());
        }
    }
    
}
