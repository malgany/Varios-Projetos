package testeanimacao;
import javafx.animation.*;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TesteAnimacao extends Application{
   public static void main(String[] args){
     Application.launch(args);
   }
   @Override
   public void start(Stage stage) throws Exception {            
       GridPane grid = new GridPane();
     grid.setPadding(new Insets(10, 0, 0, 0));
     grid.setHgap(70);
     grid.setVgap(10);
          
     Text t1 = new Text("Fade Transition");
     t1.setFont(Font.font("Tahoma", FontWeight.BOLD, 10));
     grid.add(t1, 1, 0);
     grid.add(startFadeTransition(), 1, 1);

     Text t2 = new Text("Fill Transition");
     t2.setFont(Font.font("Tahoma", FontWeight.BOLD, 10));
     grid.add(t2, 2, 0);
     grid.add(startFillTransition(), 2, 1);

     Text t3 = new Text("Rotate Transition");
     t3.setFont(Font.font("Tahoma", FontWeight.BOLD, 10));
     grid.add(t3, 3, 0);
     grid.add(startRotateTransition(), 3, 1);

     Text t4 = new Text("Scale Transition");
     t4.setFont(Font.font("Tahoma", FontWeight.BOLD, 10));
     grid.add(t4, 1, 2);
     grid.add(startScaleTransition(), 1, 3);

     Text t5 = new Text("Translate Transition");
     t5.setFont(Font.font("Tahoma", FontWeight.BOLD, 10));
     grid.add(t5, 2, 2);
     grid.add(startTranslateTransition(), 2, 3);

     Text t6 = new Text("Stroke Transition");
     t6.setFont(Font.font("Tahoma", FontWeight.BOLD, 10));
     grid.add(t6, 3, 2);
     grid.add(startStrokeTransition(), 3, 3);

     Text t7 = new Text("Sequential Transition");
     t7.setFont(Font.font("Tahoma", FontWeight.BOLD, 10));
     grid.add(t7, 1, 4);
     grid.add(startSequentialTransition(), 1, 5);

     Text t8 = new Text("Path Transition");
     t8.setFont(Font.font("Tahoma", FontWeight.BOLD, 10));
     grid.add(t8, 2, 4);
     grid.add(startPathTransition(), 2, 5);

     Text t9 = new Text("Parallel Transition");
     t9.setFont(Font.font("Tahoma", FontWeight.BOLD, 10));
     grid.add(t9, 3, 4);
     grid.add(startParallelTransition(), 3, 5);

     Scene scene = new Scene(grid);
     stage.setScene(scene);
     stage.setWidth(640);
     stage.setHeight(480);
     stage.show();      
}
   
   public Shape startFadeTransition() {
     Circle circle = new Circle(200, 200, 50, Color.rgb(0, 255, 0));
     FadeTransition fade = new FadeTransition(Duration.millis(3000), circle);
     fade.setFromValue(1.0);
     fade.setToValue(0.1);
     fade.setCycleCount(Transition.INDEFINITE);
     fade.setAutoReverse(true);
     fade.play();
     return circle;
   }
    public Shape startPathTransition() {
         Rectangle rect = new Rectangle(100, 40, 100, 100);
         rect.setArcHeight(50);
         rect.setArcWidth(50);
         rect.setFill(Color.CYAN);

         Path path = new Path();
         path.getElements().add(new MoveTo(0f, 50f));
         path.getElements().add(new CubicCurveTo(40f, 10f, 390f, 240f, 1000, 50f));

         PathTransition pathTransition = new PathTransition();
         pathTransition.setDuration(Duration.millis(10000));
         pathTransition.setNode(rect);
         pathTransition.setPath(path);
         pathTransition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
         pathTransition.setCycleCount(Transition.INDEFINITE);
         pathTransition.setAutoReverse(true);

         pathTransition.play();
         return rect;
    }   
    public Shape startParallelTransition() {
         Rectangle rect = new Rectangle(100, 40, 100, 100);
         rect.setArcHeight(50);
         rect.setArcWidth(50);
         rect.setFill(Color.DARKSALMON);

         final Duration SEC_2 = Duration.millis(2000);
         final Duration SEC_3 = Duration.millis(3000);

         FadeTransition fade = new FadeTransition(SEC_3);
         fade.setFromValue(1.0f);
         fade.setToValue(0.3f);
         fade.setCycleCount(Transition.INDEFINITE);
         fade.setAutoReverse(true);
         TranslateTransition translate = new TranslateTransition(SEC_2);
         translate.setFromX(-100f);
         translate.setToX(100f);
         translate.setCycleCount(Transition.INDEFINITE);
         translate.setAutoReverse(true);
         RotateTransition rotate = new RotateTransition(SEC_3);
         rotate.setByAngle(180f);
         rotate.setCycleCount(Transition.INDEFINITE);
         rotate.setAutoReverse(true);
         ScaleTransition scale = new ScaleTransition(SEC_2);
         scale.setByX(1.5f);
         scale.setByY(1.5f);
         scale.setCycleCount(Transition.INDEFINITE);
         scale.setAutoReverse(true);

         ParallelTransition pt = new ParallelTransition(rect, fade, translate, rotate, scale);
         pt.play();
         return rect;
    }
    public Shape startFillTransition() {
         Circle circle = new Circle(300, 300, 50);
         FillTransition fill = new FillTransition(Duration.millis(3000), circle);
         fill.setFromValue(Color.rgb(0, 0, 0));
         fill.setToValue(Color.rgb(255, 0, 0));
         fill.setCycleCount(Transition.INDEFINITE);
         fill.setAutoReverse(true);
         fill.play();
         return circle;
    }
    public Shape startRotateTransition() {
         Rectangle rect = new Rectangle(100, 40, 100, 100);
         rect.setArcHeight(50);
         rect.setArcWidth(50);
         rect.setFill(Color.BLUE);

         RotateTransition rotate = new RotateTransition(Duration.millis(3000), rect);
         rotate.setByAngle(180);
         rotate.setCycleCount(Transition.INDEFINITE);
         rotate.setAutoReverse(true);
         rotate.play();
         return rect;
    }
    public Shape startScaleTransition() {
         Rectangle rect = new Rectangle(100, 40, 50, 50);
         rect.setArcHeight(0);
         rect.setArcWidth(0);
         rect.setFill(Color.VIOLET);

         ScaleTransition scale = new ScaleTransition(Duration.millis(2000), rect);
         scale.setByX(1.5f);
         scale.setByY(1.5f);
         scale.setCycleCount(Transition.INDEFINITE);
         scale.setAutoReverse(true);
         scale.play();
         return rect;
    }
    public Shape startSequentialTransition() {
         Rectangle rect = new Rectangle(100, 40, 100, 100);
         rect.setArcHeight(50);
         rect.setArcWidth(50);
         rect.setFill(Color.VIOLET);

         final Duration SEC_2 = Duration.millis(2000);
         final Duration SEC_3 = Duration.millis(3000);

         PauseTransition pause = new PauseTransition(Duration.millis(1000));
         FadeTransition fade = new FadeTransition(SEC_3);
         fade.setFromValue(1.0f);
         fade.setToValue(0.3f);
         fade.setCycleCount(Transition.INDEFINITE);
         fade.setAutoReverse(true);
         TranslateTransition translate = new TranslateTransition(SEC_2);
         translate.setFromX(-100f);
         translate.setToX(100f);
         translate.setCycleCount(Transition.INDEFINITE);
         translate.setAutoReverse(true);
         RotateTransition rotate = new RotateTransition(SEC_3);
         rotate.setByAngle(180f);
         rotate.setCycleCount(Transition.INDEFINITE);
         rotate.setAutoReverse(true);
         ScaleTransition scale = new ScaleTransition(SEC_2);
         scale.setByX(1.5f);
         scale.setByY(1.5f);
         scale.setCycleCount(Transition.INDEFINITE);
         scale.setAutoReverse(true);

         SequentialTransition seq = new SequentialTransition(rect, pause, fade, translate,
              rotate, scale);
         seq.play();
         return rect;
    }
    public Shape startStrokeTransition() {
         Rectangle rect = new Rectangle(100, 40, 100, 100);
         rect.setArcHeight(50);
         rect.setArcWidth(50);
         rect.setFill(null);

         StrokeTransition stroke = new StrokeTransition(Duration.millis(3000), rect, Color.RED, Color.BLUE);
         stroke.setCycleCount(Transition.INDEFINITE);
         stroke.setAutoReverse(true);
         stroke.play();
         return rect;
    }
    public Shape startTranslateTransition() {
       Rectangle rect = new Rectangle(100, 40, 100, 100);
       rect.setFill(Color.CORNFLOWERBLUE);
       TranslateTransition translate = new TranslateTransition(Duration.millis(2000), rect);
       translate.setByX(200f);
       translate.setCycleCount(Transition.INDEFINITE);
       translate.setAutoReverse(true);
       translate.play();
       return rect;
    }
}