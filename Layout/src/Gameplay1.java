import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by nathangrant
 */
public class Gameplay1 implements Runnable {


    Stage primary;
    Scene primaryScene;
    VBox menu;
    HBox timeR;
    HBox guessedLetters;
    VBox correctWords;
    VBox centergrid;
    ScrollPane scroll;
    VBox target;
    GameData data;
    LevelLayout levelL;
    String Nlevel;
    String nameL;
    Game gameplay;

    int wordTextL;
    Stage loginStage2;


    VBox sideM;
    VBox titleContainer;
    LoginSucces loginscreen;
    LevelSelection level;
    Level1 level2;


    VBox middleDiagram;
    Button button1;
    Button button2;
    Button button3;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    Button button11;
    Button button12;

    HBox region1;
    HBox region2;
    HBox region3;
    Stage loginStage;
    GridPane diagram;
    ScrollPane display;


    LevelSelection levelSelection;


    BorderPane layout;
    Button homeB;
    Button login;
    Button start;
    Button pause;
    appGUI gui;
    apptemplate app;



    public Gameplay1(Stage primaryStage) {
        this.primary = primaryStage;

    }

    public Gameplay1() {

    }


    public void start(Stage primaryStage, GameData data1, String level, String name) {

        this.Nlevel = level;


        this.nameL = name;
        Stage loginStage = new Stage();
        loginStage2= new Stage();
        

        layout = new BorderPane();
        data = data1;
        levelL = new LevelLayout();


        if(Nlevel.compareTo("Level 3")==0){
            if(primaryStage.getMaxWidth()+200>1200.0 || primaryStage.getMaxHeight()+500>1500.0) {
                loginStage.setMaxHeight(primaryStage.getMaxHeight());
                loginStage.setMaxWidth(primaryStage.getMaxWidth());
                loginStage.setMinHeight(800);
                loginStage.setMinWidth(primaryStage.getMinWidth());

                primaryStage.setMinWidth(primaryStage.getMaxWidth()+100);
                primaryStage.setMaxWidth(primaryStage.getMaxHeight()+400);
            }

            else {
                loginStage.setMaxHeight(primaryStage.getMaxHeight());
                loginStage.setMaxWidth(primaryStage.getMaxWidth());
                loginStage.setMinHeight(800);
                loginStage.setMinWidth(primaryStage.getMinWidth());

                primaryStage.setMinWidth(primaryStage.getMaxWidth()+200);
                primaryStage.setMaxWidth(primaryStage.getMaxHeight()+500);

            }

        }
        else {

            loginStage.setMaxHeight(primaryStage.getMaxHeight());
            loginStage.setMaxWidth(primaryStage.getMaxWidth());
            loginStage.setMinHeight(800);
            loginStage.setMinWidth(primaryStage.getMinWidth());
        }


        loginStage2.setMaxHeight(primaryStage.getMaxHeight());
        loginStage2.setMaxWidth(primaryStage.getMaxWidth());
        loginStage2.setMinHeight(800);
        loginStage2.setMinWidth(primaryStage.getMinWidth());


        level2 = new Level1(loginStage2);
        levelSelection = new LevelSelection();
        loginscreen = new LoginSucces(loginStage);
        //level1= new Level1(loginStage2,"s",data);

        initStyleT2();
        initStyleSide2();
        initStyleG2();
        initStyleL2();

        primaryScene = new Scene(layout);
        primary.setScene(primaryScene);


        if (name.compareTo("Famous People") == 0) {

            if (Nlevel.compareTo("Level 1") == 0) {


                File file1 = new File("wordL1.txt");
                levelinit(file1);
                // File file4= new File("wordL1.txt");

            } else if (Nlevel.compareTo("Level 2") == 0) {

                File file1 = new File("wordFL2.txt");
                levelinit(file1);

            } else if (Nlevel.compareTo("Level 3") == 0) {

                File file1 = new File("wordFL3.txt");
                levelinit(file1);

            }


        } else if (name.compareTo("Countries") == 0) {
            if (Nlevel.compareTo("Level 1") == 0) {


                File file1 = new File("wordC1.txt");
                levelinit(file1);
                // File file4= new File("wordL1.txt");

            } else if (Nlevel.compareTo("Level 2") == 0) {

                File file1 = new File("wordC2.txt");
                levelinit(file1);
                // File file4= new File("wordL1.txt");

            } else if (Nlevel.compareTo("Level 3") == 0) {

                File file1 = new File("wordC3.txt");
                levelinit(file1);
            }
        } else if (name.compareTo("Dogs") == 0) {

            if (Nlevel.compareTo("Level 1") == 0) {


                File file1 = new File("wordD1.txt");
                levelinit(file1);
            } else if (Nlevel.compareTo("Level 2") == 0) {

                File file1 = new File("wordD2.txt");
                levelinit(file1);

            } else if (Nlevel.compareTo("Level 3") == 0) {

                File file1 = new File("wordD3.txt");
                levelinit(file1);

            }
        }

    }

    public void levelinit(File file1) {

        try {
            FileReader file2 = new FileReader(file1);
            BufferedReader file3 = new BufferedReader(file2);
            this.gameplay = new Game(layout, file3, data, nameL, Nlevel);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void initStyleSide2() {
        initStyleSide(layout);
    }

    public void initStyleSide(BorderPane layout) {

        sideM = new VBox(30);
        sideM.setMinWidth(70);
        sideM.setPadding(new Insets(10, 40, 0, 0));

        timeR = new HBox();
        timeR.setStyle("-fx-border-radius:5");


        timeR.setMinWidth(50);
        timeR.setPadding(new Insets(10, 10, 10, 10));


        Label title = new Label("Time remaing:");

        title.setLayoutY(50);
        title.setLayoutX(50);

        title.setStyle("-fx-text-fill:red");
        title.setFont(Font.font(20));


        timeR.getChildren().add(title);
        timeR.setStyle("-fx-text-fill:white;-fx-background-color:black");
        //timeR.setPadding(new Insets(20,20,20,20));

        sideM.getChildren().add(timeR);


        guessedLetters = new HBox();



        Label title2 = new Label("");
        title2.setStyle("-fx-text-fill:white");
        title2.setFont(Font.font(20));


        guessedLetters.getChildren().add(title2);
        guessedLetters.setStyle("-fx-text-fill:white;-fx-background-color:black");
        guessedLetters.setPadding(new Insets(20, 20, 20, 20));

        sideM.getChildren().add(guessedLetters);

        correctWords = new VBox(20);

        display = new ScrollPane();
        display.setMaxHeight(170);
        //display.setContent();


        Label title10 = new Label("Words:");
        title10.setStyle("-fx-text-fill:black");
        title10.setFont(Font.font(20));

        correctWords.getChildren().add(title10);
        //display.setContent(title3);


        Label title5 = new Label("Total:");
        //title5.setMinWidth(150);
        title5.setStyle("-fx-text-fill:black");
        title5.setFont(Font.font(35));



        correctWords.getChildren().add(title5);

        display.setContent(correctWords);

        sideM.getChildren().add(display);

        target = new VBox(15);
        target.setStyle("-fx-text-fill:white;-fx-background-color:black");

        Label title6 = new Label("Target");
        title6.setStyle("-fx-text-fill:white");
        title6.setFont(Font.font(20));

        target.getChildren().add(title6);


        if (nameL.compareTo("Famous People") == 0) {

            if (Nlevel.compareTo("Level 1") == 0) {

                File file1 = new File("wordL1.txt");
                setLevelT(file1);

                wordTextL=wordTextL*2;
                Label title7 = new Label(wordTextL + "");
                title7.setStyle("-fx-text-fill:white;-fx-background-color:black");
                title7.setFont(Font.font(20));

                target.getChildren().add(title7);
                sideM.getChildren().add(target);



                layout.setRight(sideM);

            } else if (Nlevel.compareTo("Level 2") == 0) {

                File file1 = new File("wordFL2.txt");
                setLevelT(file1);

                wordTextL = wordTextL * 2;
                Label title7 = new Label(wordTextL + "");
                title7.setStyle("-fx-text-fill:white;-fx-background-color:black");
                title7.setFont(Font.font(20));

                target.getChildren().add(title7);
                sideM.getChildren().add(target);


                layout.setRight(sideM);


            } else if (Nlevel.compareTo("Level 3") == 0) {

                File file1 = new File("wordFL3.txt");
                setLevelT(file1);

                wordTextL=wordTextL*2;
                Label title7 = new Label(wordTextL + "");
                title7.setStyle("-fx-text-fill:white;-fx-background-color:black");
                title7.setFont(Font.font(20));

                target.getChildren().add(title7);
                sideM.getChildren().add(target);


                layout.setRight(sideM);

            }

        } else if (nameL.compareTo("Countries") == 0) {
            if (Nlevel.compareTo("Level 1") == 0) {


                File file1 = new File("wordC1.txt");
                setLevelT(file1);

                wordTextL=wordTextL*2;
                Label title7 = new Label(wordTextL + "");
                title7.setStyle("-fx-text-fill:white;-fx-background-color:black");
                title7.setFont(Font.font(20));

                target.getChildren().add(title7);
                sideM.getChildren().add(target);


                layout.setRight(sideM);

            } else if (Nlevel.compareTo("Level 2") == 0) {

                File file1 = new File("wordC2.txt");
                setLevelT(file1);

                wordTextL=wordTextL*2;
                Label title7 = new Label(wordTextL + "");
                title7.setStyle("-fx-text-fill:white;-fx-background-color:black");
                title7.setFont(Font.font(20));

                target.getChildren().add(title7);
                sideM.getChildren().add(target);


                layout.setRight(sideM);

            } else if (Nlevel.compareTo("Level 3") == 0) {

                File file1 = new File("wordC3.txt");
                setLevelT(file1);

                wordTextL=wordTextL*2;
                Label title7 = new Label(wordTextL + "");
                title7.setStyle("-fx-text-fill:white;-fx-background-color:black");
                title7.setFont(Font.font(20));

                target.getChildren().add(title7);
                sideM.getChildren().add(target);



                layout.setRight(sideM);
            }
        } else if (nameL.compareTo("Dogs") == 0) {

            if (Nlevel.compareTo("Level 1") == 0) {


                File file1 = new File("wordD1.txt");
                setLevelT(file1);

                wordTextL=wordTextL*2;
                Label title7 = new Label(wordTextL + "");
                title7.setStyle("-fx-text-fill:white;-fx-background-color:black");
                title7.setFont(Font.font(20));

                target.getChildren().add(title7);
                sideM.getChildren().add(target);


                layout.setRight(sideM);

            } else if (Nlevel.compareTo("Level 2") == 0) {

                File file1 = new File("wordD2.txt");
                setLevelT(file1);

                wordTextL=wordTextL*2;
                Label title7 = new Label(wordTextL + "");
                title7.setStyle("-fx-text-fill:white;-fx-background-color:black");
                title7.setFont(Font.font(20));

                target.getChildren().add(title7);
                sideM.getChildren().add(target);


                layout.setRight(sideM);

            } else if (Nlevel.compareTo("Level 3") == 0) {

                File file1 = new File("wordD3.txt");
                setLevelT(file1);

                wordTextL=wordTextL*2;
                Label title7 = new Label(wordTextL + "");
                title7.setStyle("-fx-text-fill:white;-fx-background-color:black");
                title7.setFont(Font.font(20));

                target.getChildren().add(title7);
                sideM.getChildren().add(target);


                layout.setRight(sideM);

            }

        }

    }

    public void setLevelT(File file){
        FileReader file2 = null;
        ArrayList wordsCount= new ArrayList();
        try {
            file2 = new FileReader(file);
            BufferedReader file3 = new BufferedReader(file2);

            String word;

            while((word=file3.readLine())!=null){
               // word=file3.readLine().toString();
                if(word.compareTo("-")==0){
                    continue;
                }
                else
                    wordsCount.add(word);

            }

            int length=wordsCount.size();
            wordTextL=length;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //BufferedReader file3 = new BufferedReader(file2);

    }

    public Label create(String literal){
        Label title4= new Label(literal);
        title4.setStyle("-fx-text-fill:black");
        title4.setFont(Font.font(20));

        return title4;
    }

    public void initStyleG2(){
        initStyleG(layout);
    }

    public void initStyleG(BorderPane layout){

        centergrid= new VBox(5);
        diagram= new GridPane();
        diagram.setHgap(20);
        diagram.setVgap(20);
        diagram.setPadding(new Insets(150,20,100,110));

        int j=0;
        int i=0;

        if(Nlevel.compareTo("Level 3")==0){
            while(i<5){

                button1=new Button();
                int r= 150;
                button1.setShape(new Circle(r));
                button1.setMinHeight(70);
                button1.setMinWidth(70);


                button1.setStyle("-fx-text-fill:white;-fx-background-color:black");

                diagram.add(button1,j,i);

                if(j==5){
                    j=0;
                    i++;
                }
                else
                    j++;
            }

        }
        else {

            while (i < 4) {

                button1 = new Button();
                int r = 150;
                button1.setShape(new Circle(r));
                button1.setMinHeight(70);
                button1.setMinWidth(70);


                button1.setStyle("-fx-text-fill:white;-fx-background-color:black");

                diagram.add(button1, j, i);

                if (j == 3) {
                    j = 0;
                    i++;
                } else
                    j++;
            }
        }

        Button button1= (Button) diagram.getChildren().get(0);
        highlight(button1);

        Button button2= (Button) diagram.getChildren().get(1);
        highlight(button2);

        Button button3= (Button) diagram.getChildren().get(2);
        highlight(button3);

        Button button4= (Button) diagram.getChildren().get(3);
        highlight(button4);

        Button button5= (Button) diagram.getChildren().get(4);
        highlight(button5);

        Button button6= (Button) diagram.getChildren().get(5);
        highlight(button6);

        Button button7= (Button) diagram.getChildren().get(6);
        highlight(button7);

        Button button8= (Button) diagram.getChildren().get(7);
        highlight(button8);

        Button button9= (Button) diagram.getChildren().get(8);
        highlight(button9);

        Button button10= (Button) diagram.getChildren().get(9);
        highlight(button10);

        Button button11= (Button) diagram.getChildren().get(10);
        highlight(button11);

        Button button12= (Button) diagram.getChildren().get(11);
        highlight(button12);

        Button button13= (Button) diagram.getChildren().get(12);
        highlight(button13);

        Button button14= (Button) diagram.getChildren().get(13);
        highlight(button14);

        Button button15= (Button) diagram.getChildren().get(14);
        highlight(button15);

        Button button16= (Button) diagram.getChildren().get(15);
        highlight(button16);

        //button1.setText("B");

        button1.setStyle("-fx-text-fill:white;-fx-background-color:black");
        //button1.setStyle("-fx-background-color:black");

        //button2.setText("U");
        button2.setStyle("-fx-text-fill:white;-fx-background-color:black");

        //button5.setText("Z");
        button5.setStyle("-fx-text-fill:white;-fx-background-color:black");

       // button6.setText("Z");
        button6.setStyle("-fx-text-fill:white;-fx-background-color:black");


        //button11.setText("W");
        button11.setStyle("-fx-text-fill:white;-fx-background-color:black");

       // button12.setText("O");
        button12.setStyle("-fx-text-fill:white;-fx-background-color:black");


        //button15.setText("R");
        button15.setStyle("-fx-text-fill:white;-fx-background-color:black");

        //button16.setText("D");
        button16.setStyle("-fx-text-fill:white;-fx-background-color:black");

        centergrid.getChildren().add(diagram);
        pause= new Button("Pause");
        pause.setMinWidth(100);
        pause.setMinHeight(50);







        HBox new1= new HBox();
        //new1.setPadding(new Insets(0,50,0,0));
        new1.setAlignment(Pos.CENTER);
        new1.getChildren().add(pause);

        centergrid.getChildren().add(new1);


        layout.setCenter(centergrid);

        if(nameL.compareTo("Famous People")==0) {

            if (Nlevel.compareTo("Level 1") == 0) {


                File file1 = new File("choicesL1.txt");
                File file4= new File("wordL1.txt");
                try {
                    FileReader file2= new FileReader(file1);
                    BufferedReader file3= new BufferedReader(file2);

                    FileReader file5= new FileReader(file4);
                    BufferedReader file6= new BufferedReader(file5);

                    levelL.setWords(diagram,file3, file6,Nlevel);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                // File file4= new File("wordL1.txt");

            }
            else if (Nlevel.compareTo("Level 2")==0){

                File file1 = new File("choicesL1.txt");
                File file4= new File("wordFL2.txt");
                try {
                    FileReader file2= new FileReader(file1);
                    BufferedReader file3= new BufferedReader(file2);

                    FileReader file5= new FileReader(file4);
                    BufferedReader file6= new BufferedReader(file5);

                    levelL.setWords(diagram,file3, file6,Nlevel);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else if (Nlevel.compareTo("Level 3")==0){

                File file1 = new File("choicesL1.txt");
                File file4= new File("wordFL3.txt");
                try {
                    FileReader file2= new FileReader(file1);
                    BufferedReader file3= new BufferedReader(file2);

                    FileReader file5= new FileReader(file4);
                    BufferedReader file6= new BufferedReader(file5);

                    levelL.setWords(diagram,file3, file6,Nlevel);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
        else if (nameL.compareTo("Countries")==0){
            if (Nlevel.compareTo("Level 1") == 0) {


                File file1 = new File("choicesL1.txt");
                File file4= new File("wordC1.txt");
                try {
                    FileReader file2= new FileReader(file1);
                    BufferedReader file3= new BufferedReader(file2);

                    FileReader file5= new FileReader(file4);
                    BufferedReader file6= new BufferedReader(file5);

                    levelL.setWords(diagram,file3, file6,Nlevel);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                // File file4= new File("wordL1.txt");

            }
            else if (Nlevel.compareTo("Level 2")==0){

                File file1 = new File("choicesL1.txt");
                File file4= new File("wordC2.txt");
                try {
                    FileReader file2= new FileReader(file1);
                    BufferedReader file3= new BufferedReader(file2);

                    FileReader file5= new FileReader(file4);
                    BufferedReader file6= new BufferedReader(file5);

                    levelL.setWords(diagram,file3, file6,Nlevel);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                // File file4= new File("wordL1.txt");

            }
            else if (Nlevel.compareTo("Level 3")==0){

                File file1 = new File("choicesL1.txt");
                File file4= new File("wordC3.txt");
                try {
                    FileReader file2= new FileReader(file1);
                    BufferedReader file3= new BufferedReader(file2);

                    FileReader file5= new FileReader(file4);
                    BufferedReader file6= new BufferedReader(file5);

                    levelL.setWords(diagram,file3, file6,Nlevel);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(nameL.compareTo("Dogs")==0){

            if (Nlevel.compareTo("Level 1") == 0) {


                File file1 = new File("choicesL1.txt");
                File file4= new File("wordD1.txt");
                try {
                    FileReader file2= new FileReader(file1);
                    BufferedReader file3= new BufferedReader(file2);

                    FileReader file5= new FileReader(file4);
                    BufferedReader file6= new BufferedReader(file5);

                    levelL.setWords(diagram,file3, file6,Nlevel);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else if (Nlevel.compareTo("Level 2")==0){

                File file1 = new File("choicesL1.txt");
                File file4= new File("wordD2.txt");
                try {
                    FileReader file2= new FileReader(file1);
                    BufferedReader file3= new BufferedReader(file2);

                    FileReader file5= new FileReader(file4);
                    BufferedReader file6= new BufferedReader(file5);

                    levelL.setWords(diagram,file3, file6,Nlevel);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
            else if (Nlevel.compareTo("Level 3")==0){

                File file1 = new File("choicesL1.txt");
                File file4= new File("wordD3.txt");
                try {
                    FileReader file2= new FileReader(file1);
                    BufferedReader file3= new BufferedReader(file2);

                    FileReader file5= new FileReader(file4);
                    BufferedReader file6= new BufferedReader(file5);

                    levelL.setWords(diagram,file3, file6,Nlevel);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void initStyleT2(){
        initStyleT(layout);
    }

    public void initStyleL2(){
        initStyleL(layout);
    }

    public Stage getStage(){
        return primary;
    }


    public Scene getScene(){
        return primaryScene;
    }



    public void initStyleL(BorderPane layout){
        menu=new VBox(25);


        homeB= new Button("Level Selection");
        homeB.setMaxWidth(250);
        homeB.setPadding(new Insets(10,10,10,10));

        homeB.setOnAction(e->{
            reset(layout);
            gameplay.setGameDetermine(false);

            level2.start(loginStage2,nameL,data);
            Scene prim2 = level2.getScene();
            // this.primaryScene=loginscreen.getScene();

            loginStage2.setScene(prim2);
            loginStage2.show();

            primary.close();

        });



        Label home= new Label("Level Selection");
        home.setFont(Font.font(35));

        home.setStyle("-fx-background-color:white");
        //  home.setStyle("-fx-font:100");

        menu.getChildren().add(home);
        menu.getChildren().add(homeB);

        layout.setPadding(new Insets(0,100,0,0));
        //layout.getLeft().setLayoutX(50);


        layout.setStyle("-fx-background-color:#DCDCDC");
        layout.setLeft(menu);

        //  layout.getLeft().setLayoutX(50);

        menu.setStyle("-fx-background-color:#000000");


    }

    public void initStyleT(BorderPane layout){

        titleContainer=new VBox();

        titleContainer.setStyle("-fx-background-color:#000000");

        Label title= new Label("     Welcome to BuzzWord");
        title.setFont(Font.font(70));
        title.setTextFill(Color.WHITE);

        title.setMinWidth(1000);

        titleContainer.getChildren().add(title);

        Label title2= new Label("     "+nameL);
        title2.setFont(Font.font(50));
        title2.setTextFill(Color.WHITE);

        Label title3= new Label(Nlevel);
        title3.setFont(Font.font(30));
        title3.setTextFill(Color.WHITE);

        titleContainer.setAlignment(Pos.CENTER);
        titleContainer.getChildren().add(title2);
        titleContainer.getChildren().add(title3);

        layout.setTop(titleContainer);
    }

    public void reset(BorderPane layout){

        this.layout.getChildren().removeAll();
        this.layout= new BorderPane();
    }

    public void highlight(Button button) {

        button.setOnAction(e -> {

            button.setStyle("-fx-text-fill:black;-fx-background-color:red");
        });
    }

    @Override
    public void run() {

    }
}
