/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package linguagem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Tony L
 */
public class Linguagem {

    /**
     * @param args the command line arguments
     */
    
    List<String> pilha;
    List<String> valores;
    
    public static void main(String[] args) {
            
        File file = new File("C:\\Users\\Tony L\\Documents\\NetBeansProjects\\Linguagem\\tony.txt");  
        try {  
            FileReader reader = new FileReader(file);  
            try (BufferedReader input = new BufferedReader(reader)) {
                String linha;  
                while ((linha = input.readLine()) != null) {  
                    System.out.println(linha);  
                }
            }  
        } catch (IOException ioe) {  
            System.out.println(ioe);  
        }  


        //HashMap h = new HashMap();
        //h.put(chave, valor);
   
    }
    
    public static boolean SyntaxCorreta( String estruturaLinguagem, String nomePrograma)
    {
        // ler arquivo de estrutura
        // ler arquivo de prorgrama
        
        // passar por todas as linhas do programa
        // para cada linha do programa verificar se tem
        // uma estrutura correspondente
        
        // se tudo certo volta true
        
        // se tem algum erro escreve o erro no console
        // se tem algum erro volta false
        return true;
    }
    
    public void adicionarPilha( String nome)
    {
        pilha.add(nome);
        valores.add("");
    }
    public void atribuirPilha( String nome, String valor)
    {
          int posicao = pilha.indexOf(nome);
          valores.set(posicao, valor);
    }
}
