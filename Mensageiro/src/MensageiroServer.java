/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.Naming;

/**
 *
 * @author Tony L
 */
public class MensageiroServer {

    public MensageiroServer(){
        try{
            Mensageiro m = new MensageiroImpl();
            Naming.rebind("rmi://localhost:1099/MensageiroService",m);            
        }catch(Exception ex){
            System.err.println("Trouble: "+ex);
        }
    }
    
    public static void main(String[] args){
        new MensageiroServer();
    }
}
