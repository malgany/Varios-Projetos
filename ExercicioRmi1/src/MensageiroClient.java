/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author Tony L
 */
public class MensageiroClient {
    
    public static void main(String args[]){
        try{
            Operador m = (Operador)Naming.lookup("rmi://localhost/MensageiroService");
            
            Scanner s = new Scanner(System.in);
            
            int a = 0,b = 0;
            int o = 0;
            
           System.err.println("Digite o 1 numero: ");
           a = s.nextInt();
           System.err.println("Digite o 2 numero: ");
           b = s.nextInt();
           do{
                System.err.println("Qual operação fazer?:\n"
                        + "1=Soma\n"
                        + "2=Subtracao\n"
                        + "3=Divisao\n"
                        + "4=Multiplicacao\n"
                        + "0=sair");
                o = s.nextInt();
                
                if(o == 1){
                    System.out.println(a+" + "+b+" = "+m.add(a, b));
                }else if(o == 2){
                    System.out.println(a+" - "+b+" = "+m.subtract(a, b));
                }else if(o == 3){
                    System.out.println(a+" / "+b+" = "+m.divide(a, b));
                }else if(o == 4){
                    System.out.println(a+" * "+b+" = "+m.multiply(a, b));
                }
                             
            }while(o!=0);

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
