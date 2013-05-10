/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.Naming;

/**
 *
 * @author Tony L
 */
public class Servidor {

    public Servidor(){
        try{
            Mensageiro m = new MensageiroImpl();
            Naming.rebind("rmi://localhost/MensageiroService",m);
        }catch(Exception ex){
            System.err.println("Trouble: "+ex);
        }
    }
    
    public static void main(String[] args){
        new Servidor();
    }
}
