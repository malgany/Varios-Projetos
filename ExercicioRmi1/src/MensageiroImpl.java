/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.math.BigInteger;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import sun.security.util.BigInt;

/**
 *
 * @author Tony L
 */
public class MensageiroImpl extends UnicastRemoteObject implements Operador{
    
    public MensageiroImpl() throws RemoteException{
        super();
    }  

    @Override
    public int add(int b1, int b2) throws RemoteException {
        
        return b1+b2;
    }

    @Override
    public int subtract(int b1, int b2) throws RemoteException {
        
        return b1-b2;
    }

    @Override
    public int divide(int b1, int b2) throws RemoteException {
        return b1-b2;
    }

    @Override
    public int multiply(int b1, int b2) throws RemoteException {
        return b2*b2;
    }
}
