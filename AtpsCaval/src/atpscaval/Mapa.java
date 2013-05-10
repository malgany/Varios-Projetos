/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package atpscaval;

import com.sun.javafx.iio.ImageFrame;
import com.sun.javafx.iio.common.ImageTools;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.scene.Group;  
import javafx.scene.paint.Color;  
import javafx.scene.shape.Rectangle;  
import javafx.scene.image.*;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import javafx.scene.paint.Paint;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author ErikLopes
 */
public class Mapa {
   
    private int x;  // - Posição  do cavalo 
    private int y;  // - Posição  do cavalo
    int x1=0,y1=0;
    private boolean valida;
   
    public int[][] Matriz;
    // - Tentei colocar a imagem de um cavalo
   // Image img1 = new Image("cavalo.jpg");

    public int[][] Logica(){
        
        
        int MatrizLocal[][] = new int[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                MatrizLocal[i][j] = 0;
            }
        }
        //MatrizLocal[0][0] = 2; 
     
        return this.Matriz = MatrizLocal;        
}
      
    public  void montarMapa(final Group root, final int SIZE) throws IOException
    {
    // - Tentei colocar a imagem de um cavalo
        //Image img = new Image("cavalo.jpg");
        //Icon img = new ImageIcon(getClass().getResource("cavalo.jpg"));
        
        // - Criara os quadrados 8X8 
        final Rectangle[][] quadrados = new Rectangle[8][8];  
        //public int[][] Matriz;
        
        // - Posições X Y
        int posX = 0;  
        int posY = 0;  

        boolean controle = false;  
       
        // - Aqui é a posiçao e a cor 
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++) 
            {
                quadrados[x][y] = new Rectangle(posX, posY, SIZE, SIZE);
                quadrados[x][y].addEventHandler(MouseEvent.MOUSE_CLICKED,
                            new EventHandler<MouseEvent>() {
                        @Override public void handle(MouseEvent e) {
                            
                                int xx, yy;
                                xx = (int) (e.getSceneY()/70);
                                yy = (int) (e.getSceneX()/70);
                                                                 
                                
                                if((x1+1) < 8 && (y1+2) < 8 && Matriz[x1+1][y1+2] == 0 && (x1+1) == xx && (y1+2) == yy){
                                    quadrados[x1][y1].setFill(Color.rgb(61, 43, 31)); 
                                    quadrados[xx][yy].setFill(Color.WHITE);
                                     x1=xx;
                                     y1=yy;
                                     Matriz[xx][yy] = 1;
                                }else if((x1+2) < 8 && (y1+1) < 8 && Matriz[x1+2][y1+1] == 0 && (x1+2) == xx && (y1+1) == yy){
                                     quadrados[x1][y1].setFill(Color.rgb(61, 43, 31));
                                     quadrados[xx][yy].setFill(Color.WHITE);
                                     x1=xx;
                                     y1=yy;
                                     Matriz[xx][yy] = 1;
                                }else if((x1+2) < 8 && (y1-1) >= 0 && Matriz[x1+2][y1-1] == 0 && (x1+2) == xx && (y1-1) == yy){
                                     quadrados[x1][y1].setFill(Color.rgb(61, 43, 31));
                                     quadrados[xx][yy].setFill(Color.WHITE);
                                     x1=xx;
                                     y1=yy;
                                     Matriz[xx][yy] = 1;
                                }else if((x1+1) < 8 && (y1-2) >= 0 && Matriz[x1+1][y1-2] == 0 && (x1+1) == xx && (y1-2) == yy){
                                     quadrados[x1][y1].setFill(Color.rgb(61, 43, 31));
                                     quadrados[xx][yy].setFill(Color.WHITE);
                                     x1=xx;
                                     y1=yy;
                                     Matriz[xx][yy] = 1;
                                }else if((x1-1) >= 0 && (y1-2) >= 0 && Matriz[x1-1][y1-2] == 0 && (x1-1) == xx && (y1-2) == yy){
                                     quadrados[x1][y1].setFill(Color.rgb(61, 43, 31));
                                     quadrados[xx][yy].setFill(Color.WHITE);
                                     x1=xx;
                                     y1=yy;
                                     Matriz[xx][yy] = 1;
                                }else if((x1-2) >= 0 && (y1-1) >= 0 && Matriz[x1-2][y1-1] == 0 && (x1-2) == xx && (y1-1) == yy){
                                     quadrados[x1][y1].setFill(Color.rgb(61, 43, 31));
                                     quadrados[xx][yy].setFill(Color.WHITE);
                                     x1=xx;
                                     y1=yy;
                                     Matriz[xx][yy] = 1;
                                }else if((x1-2) >= 0 && (y1+1) < 8 && Matriz[x1-2][y1+1] == 0 && (x1-2) == xx && (y1+1) == yy){
                                     quadrados[x1][y1].setFill(Color.rgb(61, 43, 31));
                                     quadrados[xx][yy].setFill(Color.WHITE);
                                     x1=xx;
                                     y1=yy;
                                     Matriz[xx][yy] = 1;
                                }else if((x1-1) >= 0 && (y1+2) < 8 && Matriz[x1-1][y1+2] == 0 && (x1-1) == xx && (y1+2) == yy){
                                     quadrados[x1][y1].setFill(Color.rgb(61, 43, 31));  
                                     quadrados[xx][yy].setFill(Color.WHITE);
                                     x1=xx;
                                     y1=yy;
                                     Matriz[xx][yy] = 1;
                                }else{
                                    JOptionPane.showMessageDialog(null, "Movimento inválido");
                                }
                            }
                            });
                
                //if ( controle)
                if(Matriz[x][y] == 0 && controle){
                    quadrados[x][y].setFill(Color.rgb(255, 215, 0)); // - Cor de Ouro
                    controle = false;  
                }else if(Matriz[x][y] == 0 && !controle){  
                    quadrados[x][y].setFill(Color.rgb(183, 65, 14));  // - Cor de ferrugem
                    controle = true;  
                }  
                root.getChildren().add(quadrados[x][y]); //Adiciona no grupo  
                posX += 70;  
                
                // - Aqui iria a imagem do cavalo. Posição inicial do cavalo
                if ( y == 3 && x == 3) // - Deve existir mais uma validação. ex: quadrados[xx][yy] != 1  
                {
                   // - Aqui eh apenas para mostrar onde é a posição inicial do cavalo, nesse programa.
                    quadrados[x][y].setFill(Color.rgb(61, 43, 31));
                    Matriz[x][y] = 1;
                    x1=x;
                    y1=y;
                    
                    
                }
                
          
            }
            
            posY += 70;  
            posX = 0;  
            controle = !controle;           
   
        }
    }
     
    /**
     * @return the xx
     */
    public int getX() {
        return x;
    }

    /**
     * @param xx the xx to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the yy
     */
    public int getY() {
        return y;
    }

    /**
     * @param yy the yy to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the valida
     */
    public boolean isValida() {
        return valida;
    }

    /**
     * @param valida the valida to set
     */
    public void setValida(boolean valida) {
        this.valida = valida;
    }

  
    /**
     * @return the img1
     */    
  
}
    
    
    
    
    
    
    
    
    
    
    

    

