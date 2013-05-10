/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*
 * @author ErikLopes
 */
public class PacMan extends Application {
    
    private Group root = new Group();  
    private final int SIZE = 70;     // - Será usado para o tamanho dos Quadrados
    private final int WIDTH = 700;   // - Será usado para a largura da tela principal
    private final int HEIGHT = 700;  // - Será usado para o tamanho da tela
    
    
    public static void main(String[] args)
    {
        launch(args); // - Inicializa a aplicação
    }
    
    @Override  
    public void start(final Stage primaryStage) throws IOException
    {
        primaryStage.setTitle("PAC-MAN"); // Nome da janela
        
        // - Cria a tela principal setando o tamanho/altura/ cor de fundo
        Scene tabuleiro = new Scene( root,WIDTH, HEIGHT, Color.rgb(128, 0, 0));
                      
        // - Instancia  do objeto Mapa.   
        Mapa mapa = new Mapa((10),(10));

        //Cria a matriz
        mapa.Logica();
        
        //
        mapa.EventoKeyTab(tabuleiro);
            
        // - Chama o metodo que ira povoa a tela principal
        mapa.montarMapa(root, SIZE);
        //mapa.montarMapa(root, SIZE, null)     
        
        // - Insere a cena
        primaryStage.setScene(tabuleiro); 
        
        // - Boqueia o redirencionamento por parte do usuario.
        primaryStage.setResizable(false);
        
        // - Chama a tela
        primaryStage.show();
    } 

    
}

