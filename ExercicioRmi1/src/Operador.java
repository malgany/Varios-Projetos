/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.math.BigInteger;
import java.rmi.*;
import sun.security.util.BigInt;

/**
 *
 * @author Tony L
 */
public interface Operador extends Remote{

    int         add(int b1, int b2) throws RemoteException;
    int    subtract(int b1, int b2) throws RemoteException;
    int      divide(int b1, int b2) throws RemoteException;
    int    multiply(int b1, int b2) throws RemoteException;
    
}
