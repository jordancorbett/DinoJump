package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;

public class Shapes extends Application {

    public static AnimationTimer gameloop;
    public static AnimationTimer jump;
    public static double start = 0;
    public static Pane game = new Pane();
    public static Boolean check = false;
    public static Circle dino = new Circle();
    public static double previous = dino.getTranslateY();
    public static double highscore = 0;
    public static double speed = -9.5;
    public static boolean get = false;
    public static boolean running = false;
    public static Button playagain = new Button("Play Again");
    public static Button highscoree = new Button("WIP");
    public static int secondsPassed = 0;
    public static boolean will = true;


    @Override
    public void start(Stage primaryStage) throws Exception {




        Text GameOver = new Text("Game Over");
        GameOver.setX(700);
        GameOver.setY(400);
        GameOver.setFill(Color.FORESTGREEN);
        GameOver.setFont(javafx.scene.text.Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 100));


// main menu screen
        Pane mainScreen = new Pane();
        Scene mainMenu = new Scene(mainScreen, 1920, 1080);

        javafx.scene.image.Image Background = new Image("sample/Dino Dash 1.jpg");
        ImageView iv = new ImageView();
        iv.setImage(Background);
        mainScreen.getChildren().add(iv);
        iv.setFitHeight(1080);
        iv.setFitWidth(1920);

// game scene
        Scene gameScene = new Scene(game, 1920, 1080);
        game.setStyle("-fx-background-color: skyblue;");










//highscore button
        highscoree.setTranslateX(885);
        highscoree.setTranslateY(0);
        highscoree.setPrefSize(150, 50);
//instructions scene
        Pane instruc = new Pane();
        Scene instrucScene = new Scene(instruc, 1920, 1080);

        javafx.scene.image.Image Instruction = new Image("sample/Dino Dash.jpg");
        ImageView InstructionBackground = new ImageView();
        InstructionBackground.setImage(Instruction);
        instruc.getChildren().add(InstructionBackground);
        InstructionBackground.setFitHeight(1080);
        InstructionBackground.setFitWidth(1920);


//highscore scene
        Pane highScoreP = new Pane();
        Scene highScoreScene = new Scene(highScoreP, 1920, 1080);



//game piece
        dino.getRadius();
        dino.setTranslateX(200);
        dino.setTranslateY(810);
        dino.setFill(Color.RED);
        dino.setRadius(30);
//backround floor

        Rectangle floor = new Rectangle();
        floor.setHeight(240);
        floor.setWidth(1920);
        floor.setX(0);
        floor.setY(840);
        floor.setFill(Color.SADDLEBROWN);
        floor.toBack();
//backround grass
        Rectangle grass = new Rectangle();
        grass.setHeight(30);
        grass.setWidth(1920);
        grass.setX(0);
        grass.setY(840);
        grass.setFill(Color.FORESTGREEN);
        grass.toBack();



        javafx.scene.image.Image ShellOuter = new Image("sample/Shell outer.png");
        ImageView ShellOuterIV = new ImageView();
        ShellOuterIV.setImage(ShellOuter);
        game.getChildren().add(ShellOuterIV);
        ShellOuterIV.setX(1400);
        ShellOuterIV.setY(800);
        ShellOuterIV.setFitHeight(150);
        ShellOuterIV.setFitWidth(150);
        ShellOuterIV.toFront();





//objects
        Rectangle object = new Rectangle();
        object.setHeight(60);
        object.setWidth(10);
        object.setX(1950);
        object.setY(780);
        object.setFill(Color.BLACK);

        Rectangle object1 = new Rectangle();
        object1.setHeight(80);
        object1.setWidth(10);
        object1.setX(2500);
        object1.setY(760);
        object1.setFill(Color.BLACK);

        Rectangle object2 = new Rectangle();
        object2.setHeight(40);
        object2.setWidth(10);
        object2.setX(3020);
        object2.setY(800);
        object2.setFill(Color.BLACK);

        Rectangle object3 = new Rectangle();
        object3.setHeight(40);
        object3.setWidth(10);
        object3.setX(3000);
        object3.setY(800);
        object3.setFill(Color.BLACK);


        Rectangle powerup = new Rectangle ();
        powerup.setHeight(40);
        powerup.setWidth(40);
        powerup.setFill(Color.BLUEVIOLET);
        powerup.setX(10000);
        powerup.setY(675);






        //back to main menu button
        Button backBTN = new Button("Back to Menu");
        Button resume = new Button("Resume");
        backBTN.setTranslateX(885);
        backBTN.setTranslateY(515);
        backBTN.setPrefSize(150, 50);
        backBTN.setOnAction(actionEvent -> {


            primaryStage.setScene(mainMenu);
            game.getChildren().remove(backBTN);
            game.getChildren().remove(resume);
            game.getChildren().remove(playagain);
            dino.setOpacity(1);
            floor.setOpacity(1);
            object.setOpacity(1);
            object1.setOpacity(1);
            object2.setOpacity(1);
            object3.setOpacity(1);
            object.relocate(1950, 780);
            object1.relocate(2500, 760);
            object2.relocate(3020, 800);
            object3.relocate(3000, 800);
            powerup.relocate(10000, 675);

        });

        resume.setTranslateX(885);
        resume.setTranslateY(465);
        resume.setPrefSize(150, 50);
        resume.setOnAction(actionEvent1 -> {
            grass.setOpacity(1);
            dino.setOpacity(1);
            floor.setOpacity(1);
            object.setOpacity(1);
            object1.setOpacity(1);
            object2.setOpacity(1);
            object3.setOpacity(1);
            game.getChildren().remove(backBTN);
            game.getChildren().remove(resume);
            gameloop.start();
            playerControlsHearing();
        });
        //in game scene pause button activates main menu button
        Button pause = new Button("Pause");
        pause.setOnAction(actionEvent1 -> {

            game.getChildren().add(backBTN);
            game.getChildren().add(resume);
            grass.setOpacity(.7);
            dino.setOpacity(.7);
            floor.setOpacity(.7);
            object.setOpacity(.7);
            object1.setOpacity(.7);
            object2.setOpacity(.7);
            object3.setOpacity(.7);
            gameloop.stop();
            pause.setDisable(true);
            running = false;
        });
//restart button

        playagain.setTranslateX(885);
        playagain.setTranslateY(565);
        playagain.setPrefSize(150, 50);
        playagain.setOnAction(actionEvent1 -> {
            object.relocate(1950, 780);
            object1.relocate(2500, 760);
            object2.relocate(3020, 800);
            object3.relocate(3000, 800);
            powerup.relocate(10000, 675);
            object1.setTranslateX(0);
            object.setTranslateX(0);
            object2.setTranslateX(0);
            object3.setTranslateX(0);
            grass.setOpacity(1);
            dino.setOpacity(1);
            floor.setOpacity(1);
            object.setOpacity(1);
            object1.setOpacity(1);
            object2.setOpacity(1);
            object3.setOpacity(1);
            game.getChildren().remove(backBTN);
            game.getChildren().remove(playagain);
            game.getChildren().remove(GameOver);
            gameloop.start();
            running = true;
            playerControlsHearing();
        });

        Button startBtn = new Button("Start Game");
        startBtn.setTranslateX(810);
        startBtn.setTranslateY(340);
        startBtn.setPrefSize(300, 100);
        startBtn.setOnAction(actionEvent -> {

            primaryStage.setScene(gameScene);
            object.relocate(1950, 780);
            object1.relocate(2500, 760);
            object2.relocate(3020, 800);
            object3.relocate(3000, 800);
            powerup.relocate(10000, 675);
            object1.setTranslateX(0);
            object.setTranslateX(0);
            object2.setTranslateX(0);
            object3.setTranslateX(0);
            grass.setOpacity(1);
            dino.setOpacity(1);
            floor.setOpacity(1);
            object.setOpacity(1);
            object1.setOpacity(1);
            object2.setOpacity(1);
            object3.setOpacity(1);
            game.getChildren().remove(backBTN);
            game.getChildren().remove(playagain);
            game.getChildren().remove(GameOver);
            gameloop.start();
            running = true;
            playerControlsHearing();
            game.getChildren().addAll(highscoree, dino, pause, floor, grass, object, object1, object2, object3, powerup);


        });

        Button instructn = new Button("Instructions");
        instructn.setTranslateX(810);
        instructn.setTranslateY(440);
        instructn.setOnAction(actionEvent -> {

            primaryStage.setScene(instrucScene);

        });

        instructn.setPrefSize(300, 100);
        Button highScore = new Button(" Highscore");
        highScore.setTranslateX(810);
        highScore.setTranslateY(540);
        highScore.setPrefSize(300, 100);
        highScore.setOnAction(actionEvent -> {

            primaryStage.setScene(highScoreScene);


        });


        mainScreen.getChildren().addAll(startBtn, instructn, highScore);


        primaryStage.setTitle("Dinosaur Game");
        primaryStage.setScene(mainMenu);
        primaryStage.show();


//back to menu bytton
        Button backBTN2 = new Button("Back to Menu");
        backBTN2.setTranslateX(1828);
        backBTN2.setTranslateY(3);
        backBTN2.setPrefSize(90, 50);
        backBTN2.setOnAction(actionEvent -> {

            primaryStage.setScene(mainMenu);

        });

        Button backBTN3 = new Button("Back to Menu");
        backBTN3.setTranslateX(1828);
        backBTN3.setTranslateY(3);
        backBTN3.setPrefSize(90, 50);
        backBTN3.setOnAction(actionEvent -> {

            primaryStage.setScene(mainMenu);

        });
// add main menu button to instructions and highscore
        instruc.getChildren().add(backBTN2);
        highScoreP.getChildren().add(backBTN3);




        //animation
        gameloop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(will&&dino.getBoundsInParent().intersects(powerup.getBoundsInParent())||dino.getBoundsInParent().intersects(powerup.getBoundsInParent())||dino.getBoundsInParent().intersects(powerup.getBoundsInParent())||dino.getBoundsInParent().intersects(powerup.getBoundsInParent())) {
                    dino.setOpacity(.7);
                    will = false;
                }
                if(dino.getBoundsInParent().intersects(object.getBoundsInParent())||dino.getBoundsInParent().intersects(object3.getBoundsInParent())||dino.getBoundsInParent().intersects(object2.getBoundsInParent())||dino.getBoundsInParent().intersects(object1.getBoundsInParent())) {
                    will = true;
                    dino.setOpacity(1);
                }

                if(dino.getBoundsInParent().intersects(object.getBoundsInParent())||dino.getBoundsInParent().intersects(object3.getBoundsInParent())||dino.getBoundsInParent().intersects(object2.getBoundsInParent())||dino.getBoundsInParent().intersects(object1.getBoundsInParent())){
                    gameloop.stop();
                    game.getChildren().add(backBTN);
                    game.getChildren().add(playagain);
                    game.getChildren().add(GameOver);
                    grass.setOpacity(.7);
                    dino.setOpacity(.7);
                    floor.setOpacity(.7);
                    object.setOpacity(.7);
                    object1.setOpacity(.7);
                    object2.setOpacity(.7);
                    object3.setOpacity(.7);
                    pause.setDisable(true);
                    running = false;
                    speed = -9.5;
                    highscore = 0;
                    powerup.relocate(10000, 675);
                    game.getScene().setOnKeyPressed(e -> {
                        if (e.getCode() == KeyCode.W || e.getCode() == KeyCode.KP_UP) {

                        }

                    });
                }




                if(dino.getBoundsInParent().intersects(powerup.getBoundsInParent())){

                }



                highscore += .1;


                System.out.println("highscore" +  highscore);




                if (pause.isDisabled())
                    pause.setDisable(false);
                double time = (now - start) / 1000000000.0;


                object.setTranslateX(object.getTranslateX() + speed);
                object1.setTranslateX(object1.getTranslateX() + speed);
                object2.setTranslateX(object3.getTranslateX() + speed);
                object3.setTranslateX(object3.getTranslateX() + speed);
                powerup.setTranslateX(powerup.getTranslateX() + speed);

                if (object.getBoundsInParent().getMaxX() <= -1) {
                    object.relocate(1950, 780);
                    object.setTranslateX(0);
                }
                if (object1.getBoundsInParent().getMaxX() <= -1) {
                    object1.relocate(1950, 760);
                    object1.setTranslateX(0);
                }
                if (object2.getBoundsInParent().getMaxX() <= -1) {
                    object2.relocate(1950, 800);
                    object2.setTranslateX(0);
                }
                if (object3.getBoundsInParent().getMaxX() <= -1) {
                    object3.relocate(1950, 800);
                    object3.setTranslateX(0);
                }
                if (powerup.getBoundsInParent().getMaxX() <= -1) {
                    powerup.relocate(10000, 675);
                    powerup.setTranslateX(0);
                }

                if ((int)highscore % 10 == 0 ) {

                    speed -= 0.000001;

                }

                System.out.println(speed);

            }
        };
        final double[] up = {10};
        final double[] down = {10};
        jump = new AnimationTimer() {
            @Override
            public void handle(long now) {

                if(dino.getTranslateY() <= 650.0105)
                    get = true;
                if(!get) {
                    dino.setTranslateY(dino.getTranslateY() - down[0]);
                    down[0] -= .5;
                    System.out.println(dino.getTranslateY()+" down");
                }
                if(get) {
                    dino.setTranslateY(dino.getTranslateY() + up[0]);
                    up[0] -= .5;
                    System.out.println(dino.getTranslateY() + " up");
                }

                if (810 <= dino.getTranslateY()){
                    jump.stop();
                    get = false;
                    check = false;
                    up[0] = 10;
                    down[0] = 10;
                }

            }
        };
    }





    public static void playerControlsHearing() {
        game.getScene().setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.W|| e.getCode()== KeyCode.KP_UP){
                check = true;
                jump.start();
                check = false;
            };
        });
    }
    public static void main (String[]args){
        launch(args);
    }
}