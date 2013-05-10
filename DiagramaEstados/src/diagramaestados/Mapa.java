/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diagramaestados;

/**
 *
 * @author Tony L
 */
public class Mapa {
    
    String Monta = "";
    int l, c;
    
    public String Visual(int x, int y){
       int cont=0;

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {                
                if(y==i && x==j)
                    Monta += "•  ";
                else if(i==0 && j==3)
                    Monta += "#  ";
                else if(i==1 && j==1)
                    Monta += "#  ";
                else if(i==1 && j==4)
                    Monta += "#  ";
                else if(i==2 && j==3)
                    Monta += "#  ";
                else if(i==3 && j==1)
                    Monta += "#  ";
                else if(i==4 && j==0)
                    Monta += "#  ";
                else if(i==4 && j==3)
                    Monta += "#  ";
                else if(i==5 && j==1)
                    Monta += "#  ";
                else
                    Monta += "O  ";
                cont++;
                if(cont==5){
                    Monta +="\n";
                    cont=0;
                }
            }            
        }
        return Monta;
    }
}