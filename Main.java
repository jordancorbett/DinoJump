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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {

    public static AnimationTimer gameloop;
    public static AnimationTimer jump;
    public static AnimationTimer jump2;
    public static double start = 0;
    public static Pane game = new Pane();
    public static Boolean check = false;
    public static Boolean check2 = false;
    public static double highscore = 0;
    public static double speed = -8;
    public static boolean get = false;
    public static boolean get2 = false;
    public static boolean running = false;
    public static Button playagain = new Button("Play Again");
    public static Button highscoree = new Button("WIP");
    public static int secondsPassed = 0;
    public static int HighJumpDeterminant = 0;


    @Override
    public void start(Stage primaryStage) throws Exception {


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


        Image Cloud1 = new Image("sample/PixelCloud.png");
        ImageView CloudIV = new ImageView();
        CloudIV.setImage(Cloud1);
        CloudIV.setFitWidth(500);
        CloudIV.setFitHeight(300);
        CloudIV.setX(1920);
        CloudIV.setY(30);

        Image Cloud2 = new Image("sample/PixelCloud2.png");
        ImageView CloudIV2 = new ImageView();
        CloudIV2.setImage(Cloud2);
        CloudIV2.setFitWidth(500);
        CloudIV2.setFitHeight(350);
        CloudIV2.setX(2450);
        CloudIV2.setY(0);

        Image Cloud3 = new Image("sample/PixelCloud3.png");
        ImageView CloudIV3 = new ImageView();
        CloudIV3.setImage(Cloud3);
        CloudIV3.setFitWidth(250);
        CloudIV3.setFitHeight(250);
        CloudIV3.setX(3150);
        CloudIV3.setY(0);


//game piece

        Image dinoFull = new Image("sample/DinoMan.png");
        ImageView dinoFullIV = new ImageView();
        dinoFullIV.setImage(dinoFull);
        dinoFullIV.setFitHeight(60);
        dinoFullIV.setFitWidth(80);
        dinoFullIV.setX(20);
        dinoFullIV.setY(775);

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


//objects


        Image tree1 = new Image("sample/tree1.png");
        ImageView objectt = new ImageView();
        objectt.setImage(tree1);
        objectt.setFitHeight(87.5);
        objectt.setFitWidth(60);
        objectt.setX(1950);
        objectt.setY(780);

        Image tree2 = new Image("sample/tree2.png");
        ImageView objectt1 = new ImageView();
        objectt1.setImage(tree2);
        objectt1.setFitHeight(87.5);
        objectt1.setFitWidth(60);
        objectt1.setX(2500);
        objectt1.setY(780);

        Image tree3 = new Image("sample/tree3.png");
        ImageView objectt2 = new ImageView();
        objectt2.setImage(tree3);
        objectt2.setFitHeight(87.5);
        objectt2.setFitWidth(60);
        objectt2.setX(3020);
        objectt2.setY(780);


        Rectangle object3 = new Rectangle();
        object3.setHeight(40);
        object3.setWidth(10);
        object3.setX(3000);
        object3.setY(800);
        object3.setFill(Color.BLACK);


        Image shellFull = new Image("sample/ShellFull.png");
        ImageView shellFullIV = new ImageView();
        shellFullIV.setImage(shellFull);
        shellFullIV.setFitWidth(50);
        shellFullIV.setFitHeight(50);
        shellFullIV.setX(15000);
        shellFullIV.setY(675);

        Image shellFull2 = new Image("sample/ShellFull.png");
        ImageView shellFullIV2 = new ImageView();
        shellFullIV2.setImage(shellFull2);
        shellFullIV2.setFitWidth(75);
        shellFullIV2.setFitHeight(75);
        shellFullIV2.setX(1700);
        shellFullIV2.setY(50);

        Image HighJump = new Image("sample/HighJump.png");
        ImageView HighJumpIV = new ImageView();
        HighJumpIV.setImage(HighJump);
        HighJumpIV.setFitWidth(50);
        HighJumpIV.setFitHeight(50);
        HighJumpIV.setX(10000);
        HighJumpIV.setY(715);

        Image HighJump2 = new Image("sample/HighJump.png");
        ImageView HighJumpIV2 = new ImageView();
        HighJumpIV2.setImage(HighJump2);
        HighJumpIV2.setFitWidth(75);
        HighJumpIV2.setFitHeight(75);
        HighJumpIV2.setX(1800);
        HighJumpIV2.setY(50);


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
            game.getChildren().removeAll(HighJumpIV2, shellFullIV2);
            dinoFullIV.setOpacity(1);
            floor.setOpacity(1);
            objectt.setOpacity(1);
            objectt1.setOpacity(1);
            objectt2.setOpacity(1);
            object3.setOpacity(1);
            objectt.relocate(1950, 780);
            objectt1.relocate(2500, 780);
            objectt2.relocate(3020, 780);
            object3.relocate(3000, 800);
            shellFullIV.relocate(15000, 675);
            HighJumpIV.relocate(10000, 715);
            shellFullIV.setOpacity(1);
            shellFullIV2.setOpacity(1);
            HighJumpIV.setOpacity(1);
            HighJumpIV2.setOpacity(1);
            shellFullIV.relocate(15000, 675);
            HighJumpIV.relocate(10000, 675);
            CloudIV.relocate(1920, 30);
            CloudIV2.relocate(2450, 30);
            speed = -8.5;
            HighJumpDeterminant = 0;

        });

        resume.setTranslateX(885);
        resume.setTranslateY(465);
        resume.setPrefSize(150, 50);
        resume.setOnAction(actionEvent1 -> {
            grass.setOpacity(1);
            dinoFullIV.setOpacity(1);
            floor.setOpacity(1);
            objectt.setOpacity(1);
            objectt1.setOpacity(1);
            objectt2.setOpacity(1);
            object3.setOpacity(1);
            shellFullIV.setOpacity(1);
            shellFullIV2.setOpacity(1);
            HighJumpIV.setOpacity(1);
            HighJumpIV2.setOpacity(1);
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
            dinoFullIV.setOpacity(.7);
            floor.setOpacity(.7);
            objectt.setOpacity(.7);
            objectt1.setOpacity(.7);
            objectt2.setOpacity(.7);
            object3.setOpacity(.7);
            shellFullIV.setOpacity(.7);
            shellFullIV2.setOpacity(.7);
            HighJumpIV.setOpacity(.7);
            HighJumpIV2.setOpacity(.7);
            gameloop.stop();
            pause.setDisable(true);
            running = false;
        });


        Text GameOver = new Text("Game Over");
        GameOver.setX(700);
        GameOver.setY(400);
        GameOver.setFill(Color.FORESTGREEN);
        GameOver.setFont(javafx.scene.text.Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 100));


//restart button

        playagain.setTranslateX(885);
        playagain.setTranslateY(565);
        playagain.setPrefSize(150, 50);
        playagain.setOnAction(actionEvent1 -> {
            objectt.relocate(1950, 780);
            objectt1.relocate(2500, 780);
            objectt2.relocate(3020, 780);
            object3.relocate(3000, 800);
            shellFullIV.relocate(20000, 675);
            HighJumpIV.relocate(15000, 715);
            CloudIV.relocate(1920, 30);
            CloudIV2.relocate(2450, 30);
            CloudIV3.relocate(3150, 30);
            objectt1.setTranslateX(0);
            objectt.setTranslateX(0);
            objectt2.setTranslateX(0);
            object3.setTranslateX(0);
            grass.setOpacity(1);
            dinoFullIV.setOpacity(1);
            floor.setOpacity(1);
            objectt.setOpacity(1);
            objectt1.setOpacity(1);
            objectt2.setOpacity(1);
            object3.setOpacity(1);
            shellFullIV.setOpacity(1);
            shellFullIV2.setOpacity(1);
            HighJumpIV.setOpacity(1);
            HighJumpIV2.setOpacity(1);
            game.getChildren().removeAll(backBTN, shellFullIV2, HighJumpIV2);
            game.getChildren().remove(playagain);
            game.getChildren().remove(GameOver);
            gameloop.start();
            running = true;
            speed = -8.5;
            HighJumpDeterminant = 0;
            playerControlsHearing();


        });

        Button startBtn = new Button("Start Game");
        startBtn.setTranslateX(810);
        startBtn.setTranslateY(340);
        startBtn.setPrefSize(300, 100);
        startBtn.setOnAction(actionEvent -> {

            primaryStage.setScene(gameScene);
            objectt.relocate(1950, 780);
            objectt1.relocate(2500, 780);
            objectt2.relocate(3020, 780);
            object3.relocate(3000, 800);
            shellFullIV.relocate(15000, 675);
            HighJumpIV.relocate(10000, 675);
            CloudIV.relocate(1920, 30);
            CloudIV2.relocate(2450, 30);
            CloudIV3.relocate(3150, 30);
            objectt1.setTranslateX(0);
            objectt.setTranslateX(0);
            objectt2.setTranslateX(0);
            object3.setTranslateX(0);
            grass.setOpacity(1);
            dinoFullIV.setOpacity(1);
            floor.setOpacity(1);
            objectt.setOpacity(1);
            objectt1.setOpacity(1);
            objectt2.setOpacity(1);
            object3.setOpacity(1);
            shellFullIV.setOpacity(1);
            shellFullIV2.setOpacity(1);
            HighJumpIV.setOpacity(1);
            HighJumpIV2.setOpacity(1);
            game.getChildren().remove(backBTN);
            game.getChildren().remove(playagain);
            game.getChildren().remove(GameOver);
            gameloop.start();
            running = true;
            playerControlsHearing();
            game.getChildren().addAll(highscoree, dinoFullIV, pause, floor, grass, objectt, objectt1, objectt2, object3, shellFullIV, HighJumpIV, CloudIV, CloudIV2);
            game.getChildren().removeAll(HighJumpIV2, shellFullIV2);


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

                if (dinoFullIV.getBoundsInParent().intersects(shellFullIV.getBoundsInParent())) {
                    shellFullIV.relocate(25000, 675);
                    speed = -5;
                    HighJumpDeterminant = 1;
                }

                if (dinoFullIV.getBoundsInParent().intersects(HighJumpIV.getBoundsInParent())) {
                    HighJumpIV.relocate(30000, 715);
                    game.getChildren().add(HighJumpIV2);
                    HighJumpDeterminant = 1;
                }

                if (dinoFullIV.getBoundsInParent().intersects(objectt.getBoundsInParent()) || dinoFullIV.getBoundsInParent().intersects(object3.getBoundsInParent()) || dinoFullIV.getBoundsInParent().intersects(objectt2.getBoundsInParent()) || dinoFullIV.getBoundsInParent().intersects(objectt1.getBoundsInParent())) {
                    gameloop.stop();
                    game.getChildren().add(backBTN);
                    game.getChildren().add(playagain);
                    game.getChildren().add(GameOver);
                    grass.setOpacity(.7);
                    dinoFullIV.setOpacity(.7);
                    floor.setOpacity(.7);
                    objectt.setOpacity(.7);
                    objectt1.setOpacity(.7);
                    objectt2.setOpacity(.7);
                    object3.setOpacity(.7);
                    shellFullIV.setOpacity(.7);
                    shellFullIV2.setOpacity(.7);
                    HighJumpIV.setOpacity(.7);
                    HighJumpIV2.setOpacity(.7);
                    pause.setDisable(true);
                    running = false;
                    speed = -9.5;
                    highscore = 0;
                    HighJumpDeterminant = 0;


                    try {
                        FileWriter fw = new FileWriter("sample/HighScores/HighScores.txt", true);
                        BufferedWriter bw = new BufferedWriter(fw);

                        int score = -5;
                        bw.write(score + "\n");
                        bw.close();
                        fw.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


                if (pause.isDisabled())
                    pause.setDisable(false);
                double time = (now - start) / 1000000000.0;


                objectt.setTranslateX(objectt.getTranslateX() + speed);
                objectt1.setTranslateX(objectt1.getTranslateX() + speed);
                objectt2.setTranslateX(object3.getTranslateX() + speed);
                object3.setTranslateX(object3.getTranslateX() + speed);
                shellFullIV.setTranslateX(shellFullIV.getTranslateX() + speed);
                HighJumpIV.setTranslateX(HighJumpIV.getTranslateX() + speed);
                CloudIV.setTranslateX(CloudIV.getTranslateX() + speed);
                CloudIV2.setTranslateX(CloudIV2.getTranslateX() + speed);
                CloudIV3.setTranslateX(CloudIV3.getTranslateX() + speed);

                if (objectt.getBoundsInParent().getMaxX() <= -1) {
                    objectt.relocate(1950, 780);
                    objectt.setTranslateX(0);
                }
                if (objectt1.getBoundsInParent().getMaxX() <= -1) {
                    objectt1.relocate(1950, 780);
                    objectt1.setTranslateX(0);
                }
                if (objectt2.getBoundsInParent().getMaxX() <= -1) {
                    objectt2.relocate(1950, 780);
                    objectt2.setTranslateX(0);
                }
                if (object3.getBoundsInParent().getMaxX() <= -1) {
                    object3.relocate(1950, 800);
                    object3.setTranslateX(0);
                }
                if (shellFullIV.getBoundsInParent().getMaxX() <= -1) {
                    shellFullIV.relocate(15000, 675);
                    shellFullIV.setTranslateX(0);
                }

                if (HighJumpIV.getBoundsInParent().getMaxX() <= -1) {
                    HighJumpIV.relocate(10000, 675);
                    HighJumpIV.setTranslateX(0);
                }

                if (CloudIV.getBoundsInParent().getMaxX() <= -1) {
                    CloudIV.relocate(1920, 30);
                    CloudIV.setTranslateX(0);
                }

                if (CloudIV2.getBoundsInParent().getMaxX() <= -1) {
                    CloudIV2.relocate(2450, 30);
                    CloudIV2.setTranslateX(0);
                }

                if (CloudIV3.getBoundsInParent().getMaxX() <= -1) {
                    CloudIV3.relocate(2450, 30);
                    CloudIV3.setTranslateX(0);
                }

                if ((int) highscore % 10 == 0) {

                    speed -= 0.000001;

                }

//                System.out.println(speed+ "Speed");

            }
        };
        final double[] up = {10};
        final double[] down = {10};
        jump = new AnimationTimer() {
            @Override
            public void handle(long now) {

                if (dinoFullIV.getTranslateY() <= 500)
                    get = true;
                System.out.println("HEYYYYYYYYY");
                if (get) {
                    dinoFullIV.setTranslateY(dinoFullIV.getTranslateY() - down[0]);
                    down[0] -= .5;
                    System.out.println(dinoFullIV.getTranslateY() + " up");
                }
                if (!get) {
                    dinoFullIV.setTranslateY(dinoFullIV.getTranslateY() + up[0]);
                    up[0] -= .5;
                    System.out.println(dinoFullIV.getTranslateY() + "down");
                }

                if (0 <= dinoFullIV.getTranslateY()) {
                    jump.stop();
                    get = false;
                    check = false;
                    up[0] = 10;
                    down[0] = 10;
                }

            }
        };
        final double[] up2 = {15};
        final double[] down2 = {15};
        jump2 = new AnimationTimer() {
            @Override
            public void handle(long now) {

                if (dinoFullIV.getTranslateY() <= 200)
                    get2 = true;
                System.out.println("Test");
                if (get2) {
                    dinoFullIV.setTranslateY(dinoFullIV.getTranslateY() - down2[0]);
                    down2[0] -= .5;
                    System.out.println(dinoFullIV.getTranslateY() + " up");
                }
                if (!get2) {
                    dinoFullIV.setTranslateY(dinoFullIV.getTranslateY() + up2[0]);
                    up2[0] -= .5;
                    System.out.println(dinoFullIV.getTranslateY() + "down");
                    HighJumpDeterminant = 0;
                }

                if (0 <= dinoFullIV.getTranslateY()) {
                    jump2.stop();
                    get2 = false;
                    check = false;
                    up2[0] = 15;
                    down2[0] = 15;
                }

            }
        };


    }


    public static void playerControlsHearing() {
        game.getScene().setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.W || e.getCode() == KeyCode.KP_UP) {
                check = true;
                jump.start();
                check = false;


            }
            if (e.getCode() == KeyCode.D && HighJumpDeterminant == 1) {
                check2 = true;
                jump2.start();
                check2 = false;


            }
            ;


        });


    }


    public static void main(String[] args) {
        launch(args);
    }
}