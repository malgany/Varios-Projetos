/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.io.IOException;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
/**
 *
 * @author ErikLopes
 */
public class Mapa {
    
    
   
    public KeyCode direcao;

    public int tamx, tamy;
    public int x1 = 0, y1 = 0;  // Variáveis globais
    public Circle circulo;
    public Group root;
 
    static final float CIRCU = 35;
            
    public int[][] Matriz;
   

    Mapa(int i, int i0) {        
        this.tamx = i;
        this.tamy = i0;
    }
    
    public int[][] Logica(){
        
        int MatrizLocal[][] = new int[tamx][tamy];

        for (int i = 0; i < tamx; i++) {
            for (int j = 0; j < tamy; j++) {
                    if( (i == 0 || i == 1) && (j == 4 || j == 5) || (i == 1 && (j == 1 || j == 2 || j == 7 || j == 8)) || 
                        (i == 3 && (j != 1 && j != 8) || (i == 4 && (j == 4 || j == 5)) || (i == 5 && (j == 1 || j == 2 || j == 4 || j == 5 || j == 7 || j == 8) || 
                        ((i == 7 && (j != 0 && j != 1 && j != 8 && j != 9)) || (i == 6 && (j==2 || j == 7))) || ((i == 7 || i == 8 || i == 9) && (j == 0 || j == 9)) || (i == 9 && (j !=4 && j !=5)))))
                        MatrizLocal[i][j] = 1;
                    else
                    MatrizLocal[i][j] = 0;               
            }
        }
        return this.Matriz = MatrizLocal;        
}
      
    public  void montarMapa(final Group root, final int SIZE) throws IOException
    {      
        this.root = root;
        
        //this.root = root;
        final Rectangle[][] quadrados = new Rectangle[tamx][tamy]; 
        
        Circle circ = new Circle(35); 
        circ.setFill(Color.YELLOW);
        this.circulo = circ;
        
        
        int posX = 0;  
        int posY = 0;  

        boolean controle = false;  
       
        // - Aqui é a posiçao e a cor 
        for (int x = 0; x < tamx; x++)
        {
            for (int y = 0; y < tamy; y++)
            {           
                quadrados[x][y] = new Rectangle(posX, posY, SIZE, SIZE);
                
                if(Matriz[x][y] == 2)
                    quadrados[x][y].setFill(Color.BLACK);                    
                
                if(Matriz[x][y] == 0){
                    quadrados[x][y].setFill(Color.BLACK); // - Cor de BLACK
                }else
                    quadrados[x][y].setFill(Color.DARKBLUE);  // - Cor de mar                    
                
                root.getChildren().add(quadrados[x][y]); //Adiciona no grupo  
                
                posX += SIZE;                  
            }
            
            posY += SIZE;  
            posX = 0;  
            controle = !controle;           
   
        }
    }
    
    
    public Scene  EventoKeyTab(Scene tabuleiro){
        
       tabuleiro.addEventHandler(KeyEvent.KEY_PRESSED,
                            new EventHandler<KeyEvent>() {
                        @Override public void handle(KeyEvent e) {
                        /*
                         * PENSEI EM FAZER ESSE EVENTO CONTROLAR APENAS A DIREÇÃO 
                         * QUANDO CLICADO. UMA VARIAVEL PRIVADA É
                         * SETADOO O VALOR DA DIREÇÃO, O RESTANTE SERÁ FEITO POR 
                         * OUTRO METODO QUE FARA A VALIDAÇÃO DE PAREDES E MOVIMEN-
                         * TOS DO PAC-MAN.
                         */        
                            direcao = e.getCode();
                            
                            for (int i = 0; i < 10; i++) {
                                for (int j = 0; j < 10; j++) {
                                   System.out.print(Matriz[i][j]); 
                                }
                                System.out.println(e.getCode());
                            }
        root.getChildren().add(circulo);
        
        if(KeyCode.LEFT == direcao){
            circulo.setTranslateX(1*(CIRCU));
            circulo.setTranslateY(1*(CIRCU));
        }else if(KeyCode.RIGHT == direcao){
            circulo.setTranslateX(3*(CIRCU));
            circulo.setTranslateY(3*(CIRCU));
        }else if(KeyCode.UP == direcao){
            circulo.setTranslateX(5*(CIRCU));
            circulo.setTranslateY(5*(CIRCU));
        }else if(KeyCode.DOWN == direcao){
            circulo.setTranslateX(7*(CIRCU));
            circulo.setTranslateY(7*(CIRCU));
        }
                            
                
            }
        });
        
        return null;       
    }
}
    
    
    
    
    
    
    
    
    
    
    

    

