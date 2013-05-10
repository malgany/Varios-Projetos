/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package atpscaval;

import java.io.IOException;
import javafx.application.Application;  
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;  
import javafx.scene.Scene;  
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;  
import javafx.stage.Stage;  
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/*
 * @author ErikLopes
 */
public class AtpsCaval extends Application {
    
    private Group root = new Group();  
    private final int SIZE = 70;     // - Será usado para o tamanho dos Quadrados
    private final int WIDTH = 570;   // - Será usado para a largura da tela principal
    private final int HEIGHT = 570;  // - Será usado para o tamanho da tela
    
    
    public static void main(String[] args)
    {
        launch(args); // - Inicializa a aplicação 
    }
    
    @Override  
    public void start(final Stage primaryStage) throws IOException
    {  
        primaryStage.setTitle("Jogo de Xadrez"); // Nome da janela
        
        // - Cria a tela principal setando o tamanho/altura/ cor de fundo
        Scene tabuleiro = new Scene( root,WIDTH, HEIGHT, Color.rgb(128, 0, 0));  // - A cor de fundo escolhida foi a bordo( combina melhor) :)
              
        // - Instancia  do objeto Mapa.   
        Mapa mapa = new Mapa();

        mapa.Logica();
            
        // - Chama o metodo que ira povoa a tela principal
        mapa.montarMapa(root, SIZE);
        //mapa.montarMapa(root, SIZE, null)     
        
        // - Insere a cena
        primaryStage.setScene(tabuleiro); 
        
        // - Boqueia o redirencionamento por parte do usuario.
        primaryStage.setResizable(false);
        
        // - Chama a tela
        primaryStage.show(); 
        
        // - Aqui chamaria o metodo que valida a movimentação.. :(
                /*tabuleiro.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                //primaryStage.close();
                //primaryStage.show(); 
                System.out.println("oioioi");
            }
        });*/
    } 
    
}

