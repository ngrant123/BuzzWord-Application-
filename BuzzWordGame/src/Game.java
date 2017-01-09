import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Game extends Thread implements MouseMotionListener{

    int score;
    BorderPane layout;
    ArrayList guessedW;
    ArrayList correctWords;
    ArrayList buttoncontainer;
    ArrayList placementcontainer;
    ArrayList wordcontainer;
    ArrayList numbers;
    ArrayList scores;
    ArrayList indexofSearchB;
    ArrayList indexCompleteS;
    ArrayList colorcontainer;

    boolean game;
    boolean typeProperty;
    boolean startgame;
    boolean tester;
    boolean tester2;
    boolean gamedetermine;



    VBox side;
    HBox guessed;
    HBox timeB;
    VBox targetB;
    HBox pause;




    Text[] progressB;
    Text[] progressW;
    Text[] progressT;
    Text[]progressTimer;
    Text[] progressTest;


    ScrollPane scroll;
    VBox contents;
    StringBuilder testString;
    String word1;

    boolean mouseclickT;
    boolean clearTest;
    boolean pauseButton;
    boolean wordchoice;


    ArrayList wordContainer2;
    int points;
    int j;
    int correctWcount;
    int wordvalue;
    int record;
    int time;
    int count;
    int wordcount;

    int k;
    int solverC;
    int gridC;
    int checkgameS;

    int test;
    int timeR;
    boolean test1;

    GridPane buttonContainer2;
    GameData data;
    String Nlevel;
    String level;
    File file;

    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button pauseB;



    public Game(BorderPane layout, BufferedReader file1, GameData data1, String levelName, String level) {

        test = 0;
        data = data1;
        this.Nlevel = levelName;
        this.level=level;

        this.layout = layout;
        buttoncontainer = new ArrayList();
        placementcontainer = new ArrayList();
        wordcontainer = new ArrayList();
        numbers = new ArrayList();

        start(file1);
        gamedetermine=true;
    }

    public void start(BufferedReader file1) {

        gamedetermine=true;
         mouseclickT=false;
        clearTest=false;
        pauseButton=false;
        typeProperty=false;


        test = 0;
        //STARTS TIMER
        start();
        File starting = new File(System.getProperty("user.dir"));
        file= new File(starting,"219game.txt");

        game=false;

        buttoncontainer = new ArrayList();
        placementcontainer = new ArrayList();
        wordcontainer = new ArrayList();
        numbers = new ArrayList();

        progressB = new Text[26];
        progressW = new Text[26];
        progressT = new Text[26];
        this.progressTimer= new Text[26];

        scores = new ArrayList();


        this.side = (VBox) layout.getRight();
        scroll = (ScrollPane) side.getChildren().get(2);
        contents = (VBox) scroll.getContent();
        contents.getChildren().clear();

        testString = new StringBuilder();



        guessedW = new ArrayList();
        wordContainer2 = new ArrayList();
        int k = 0;
        correctWcount = 0;
        wordvalue = 0;

        String word;

        try {
            while ((word = file1.readLine()) != null) {

                if (word.compareTo("-") == 0) {
                    String word1 = wordcontainer.toString();
                    word1 = word1.replace(",", "");
                    word1 = word1.replace("[", "");
                    word1 = word1.replace("]", "");
                    word1 = word1.replace(" ", "");

                    word1 = word1.trim();

                    wordContainer2.add(word1);

                    for (int j = k - 1; j >= 0; j--) {
                        wordcontainer.remove(j);

                    }
                    k=0;
                } else {
                    wordcontainer.add(word);
                    k++;
                    wordvalue += 2;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int count = wordContainer2.size();

        for (int i = 0; i < wordContainer2.size(); i++) {
            String word1 = wordContainer2.get(i).toString();
            word1 = word1.replace(",", "");
            word1 = word1.replace("[", "");
            word1 = word1.replace("]", "");
            word1 = word1.trim();

            numbers.add(word1.length());

        }


        int i = 0;
        j = 0;

        buttonContainer2 = new GridPane();
        VBox middlecontent = (VBox) layout.getCenter();
        buttonContainer2 = (GridPane) middlecontent.getChildren().get(0);



        if(level.compareTo("Level 3")==0) {
            while (i < 30) {

                buttoncontainer.add(buttonContainer2.getChildren().get(i));

                Button button1 = (Button) buttoncontainer.get(i);
                button1.setOnAction(e -> {

                    gameplayguide2(button1);
                    mouseclickT = true;

                });
                i++;


            }
        }
        else {
            while (i < 16) {

                buttoncontainer.add(buttonContainer2.getChildren().get(i));

                Button button1 = (Button) buttoncontainer.get(i);
                button1.setOnAction(e -> {

                    gameplayguide(button1);
                    mouseclickT = true;

                });
                i++;

            }
        }

            buttonContainer2.setOnKeyPressed(e -> {

                for (int j = 0; j < buttoncontainer.size(); j++) {

                    Button button1 = (Button) buttoncontainer.get(j);
                    char c = button1.getText().charAt(0);
                    if (e.getText().toString().charAt(0) == (char) c) {

                        if (typeProperty == true) {
                            typeProperty = false;
                            continue;

                        } else {

                            if (level.compareTo("Level 3") == 0) {
                                gameplayguide2(button1);
                                break;
                            } else {
                                gameplayguide(button1);
                                break;
                            }
                        }

                    }
                }
            });
            //run();

    }

    public void gameplayguide2(Button button1){

        if (button1.getStyle().compareTo("-fx-text-fill:white;-fx-background-color:black") == 0) {
            //  button1.setStyle("-fx-text-fill:black;-fx-background-color:red");

            if (placementcontainer.size() >= 1) {
                int value1 = (int) placementcontainer.get(placementcontainer.size() - 1);
                int value2 = buttoncontainer.indexOf(button1);


                if (value2 - 1 == value1) {
                    //|| j+1==buttoncontainer.indexOf(button1) || j+4==buttoncontainer.indexOf(button1) || j+4==buttoncontainer.indexOf(button1)) {
                    guessedW.add(button1.getText());
                    j = j - 1;
                    placementcontainer.add(buttoncontainer.indexOf(button1));
                    button1.setStyle("-fx-text-fill:black;-fx-background-color:red");
                    addGuess(progressB, side);

                } else if (value2 + 1 == value1) {

                    guessedW.add(button1.getText());
                    j = j + 1;
                    placementcontainer.add(buttoncontainer.indexOf(button1));
                    button1.setStyle("-fx-text-fill:black;-fx-background-color:red");
                    addGuess(progressB, side);


                } else if (value2 + 6 == value1) {

                    guessedW.add(button1.getText());
                    j = j + 6;
                    placementcontainer.add(buttoncontainer.indexOf(button1));
                    button1.setStyle("-fx-text-fill:black;-fx-background-color:red");
                    addGuess(progressB, side);


                } else if (value2 - 6 == value1) {

                    guessedW.add(button1.getText());
                    j = j - 6;
                    placementcontainer.add(buttoncontainer.indexOf(button1));
                    button1.setStyle("-fx-text-fill:black;-fx-background-color:red");
                    addGuess(progressB, side);

                }
            } else {
                button1.setStyle("-fx-text-fill:black;-fx-background-color:red");
                placementcontainer.add(buttoncontainer.indexOf(button1));
                guessedW.add(button1.getText());
                addGuess(progressB, side);


            }

            for (int j = 0; j < numbers.size(); j++) {
                test=0;
                if (guessedW.size() == (int) numbers.get(j)) {

                    for (int m = 0; m < wordContainer2.size(); m++) {

                        int size = wordContainer2.get(m).toString().length();

                        if(guessedW.size()==wordContainer2.get(m).toString().length()) {
                            for (int l = 0; l < size; l++) {
                                if (l < guessedW.size()) {
                                    if (guessedW.get(l).toString().charAt(0) != wordContainer2.get(m).toString().charAt(l)) {
                                        test += 50;
                                    } else
                                        test += 1;
                                }
                            }
                        }
                    }
                }
                if (test < 20 && test >= 1) {
                    correctWcount++;

                    for (int f = 0; f < guessedW.size(); f++) {
                        String character = (String) guessedW.get(f);


                        char c = character.charAt(0);
                        testString.append(c);
                    }

                    word1 = testString.toString().toUpperCase();


                    for (int g = guessedW.size() - 1; g >= 0; g--) {

                        guessedW.remove(g);
                    }

                    if (numbers.size() == correctWcount) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText("Information Dialog");
                        alert.setContentText("All of the words have been picked");

                        alert.showAndWait();

                        addWord(progressW, side);
                        disableAll(buttoncontainer);
                        //searchB(buttoncontainer);

                        if (Nlevel.compareTo("Famous People") == 0) {
                            if(data.getfamousL()+1<4) {
                                data.setFamousL(data.getfamousL() + 1);
                            }
                        } else if (Nlevel.compareTo("Countries") == 0) {
                            if(data.getcountriesL()+1<4) {
                                data.setCountriesL(data.getcountriesL() + 1);
                            }

                        } else if (Nlevel.compareTo("Dogs") == 0) {
                            if(data.getdogsL()+1<4) {
                                data.setDogsL(data.getdogsL() + 1);
                            }
                        }
                        game=true;
                        data.handler.saveData(data, Paths.get(file.getAbsolutePath()));

                        for (int f = 0; f < placementcontainer.size(); f++) {
                            Button button2 = (Button) buttoncontainer.get((int) placementcontainer.get(f));
                            button2.setStyle("-fx-text-fill:white;-fx-background-color:blue");
                        }

                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText("Information Dialog");
                        alert.setContentText("Correct word picked");

                        alert.showAndWait();
                        addWord(progressW, side);

                        game = true;
                        clearTest=true;

                        for (int f = 0; f < placementcontainer.size(); f++) {
                            Button button2 = (Button) buttoncontainer.get((int) placementcontainer.get(f));
                            button2.setStyle("-fx-text-fill:white;-fx-background-color:blue");
                        }

                        for (int i = placementcontainer.size() - 1; i >= 0; i--) {
                            placementcontainer.remove(i);
                            progressB = new Text[26];
                        }

                        for (int i = placementcontainer.size() - 1; i >= 0; i--) {
                            placementcontainer.remove(i);
                            progressB = new Text[26];
                        }

                        for (int i = guessedW.size() - 1; i >= 0; i--) {
                            guessedW.remove(i);
                            progressB = new Text[26];
                        }

                        testString=new StringBuilder();

                    }

                }
            }
        } else if (button1.getStyle().compareTo("-fx-text-fill:black;-fx-background-color:red") == 0) {

            button1.setStyle("-fx-text-fill:white;-fx-background-color:black");
            String buttonS= button1.getText().toString();
            char c= buttonS.charAt(0);


            removeGuess(progressB,side,c);
            typeProperty=true;
            placementcontainer.remove(placementcontainer.size()-1);

        }



    }
    public void gameplayguide(Button button1){


        if (button1.getStyle().compareTo("-fx-text-fill:white;-fx-background-color:black") == 0) {
            //  button1.setStyle("-fx-text-fill:black;-fx-background-color:red");

            if (placementcontainer.size() >= 1) {
                int value1 = (int) placementcontainer.get(placementcontainer.size() - 1);
                int value2 = buttoncontainer.indexOf(button1);


                if (value2 - 1 == value1) {
                    //|| j+1==buttoncontainer.indexOf(button1) || j+4==buttoncontainer.indexOf(button1) || j+4==buttoncontainer.indexOf(button1)) {
                    guessedW.add(button1.getText());
                    j = j - 1;
                    placementcontainer.add(buttoncontainer.indexOf(button1));
                    button1.setStyle("-fx-text-fill:black;-fx-background-color:red");
                    addGuess(progressB, side);

                } else if (value2 + 1 == value1) {

                    guessedW.add(button1.getText());
                    j = j + 1;
                    placementcontainer.add(buttoncontainer.indexOf(button1));
                    button1.setStyle("-fx-text-fill:black;-fx-background-color:red");
                    addGuess(progressB, side);


                } else if (value2 + 4 == value1) {

                    guessedW.add(button1.getText());
                    j = j + 4;
                    placementcontainer.add(buttoncontainer.indexOf(button1));
                    button1.setStyle("-fx-text-fill:black;-fx-background-color:red");
                    addGuess(progressB, side);


                } else if (value2 - 4 == value1) {

                    guessedW.add(button1.getText());
                    j = j - 4;
                    placementcontainer.add(buttoncontainer.indexOf(button1));
                    button1.setStyle("-fx-text-fill:black;-fx-background-color:red");
                    addGuess(progressB, side);

                }
            } else {
                button1.setStyle("-fx-text-fill:black;-fx-background-color:red");
                placementcontainer.add(buttoncontainer.indexOf(button1));
                guessedW.add(button1.getText());
                addGuess(progressB, side);


            }

            for (int j = 0; j < numbers.size(); j++) {
                test=0;
                if (guessedW.size() == (int) numbers.get(j)) {

                    for (int m = 0; m < wordContainer2.size(); m++) {

                        int size = wordContainer2.get(m).toString().length();

                        if(guessedW.size()==wordContainer2.get(m).toString().length()) {
                            for (int l = 0; l < size; l++) {
                                if (l < guessedW.size()) {
                                    if (guessedW.get(l).toString().charAt(0) != wordContainer2.get(m).toString().charAt(l)) {
                                        test += 50;
                                    } else
                                        test += 1;
                                }
                            }
                        }
                    }
                }
                if (test < 20 && test >= 1) {
                    correctWcount++;

                    for (int f = 0; f < guessedW.size(); f++) {
                        String character = (String) guessedW.get(f);


                        char c = character.charAt(0);
                        testString.append(c);
                    }

                    word1 = testString.toString().toUpperCase();


                    for (int g = guessedW.size() - 1; g >= 0; g--) {

                        guessedW.remove(g);
                    }

                    if (numbers.size() == correctWcount) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText("Information Dialog");
                        alert.setContentText("All of the words have been picked");

                        alert.showAndWait();

                        addWord(progressW, side);
                        disableAll(buttoncontainer);
                        //searchB(buttoncontainer);

                        if (Nlevel.compareTo("Famous People") == 0) {
                            if(data.getfamousL()+1<4) {
                                data.setFamousL(data.getfamousL() + 1);
                            }
                        } else if (Nlevel.compareTo("Countries") == 0) {
                            if(data.getcountriesL()+1<4) {
                                data.setCountriesL(data.getcountriesL() + 1);
                            }

                        } else if (Nlevel.compareTo("Dogs") == 0) {
                            if(data.getdogsL()+1<4) {
                                data.setDogsL(data.getdogsL() + 1);
                            }
                        }
                        game=true;
                        data.handler.saveData(data, Paths.get(file.getAbsolutePath()));

                        for (int f = 0; f < placementcontainer.size(); f++) {
                            Button button2 = (Button) buttoncontainer.get((int) placementcontainer.get(f));
                            button2.setStyle("-fx-text-fill:white;-fx-background-color:blue");
                        }

                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText("Information Dialog");
                        alert.setContentText("Correct word picked");

                        alert.showAndWait();
                        addWord(progressW, side);
                        // disableAll(buttoncontainer);
                        //searchB(buttoncontainer);
                        game = true;
                        clearTest=true;

                        for (int f = 0; f < placementcontainer.size(); f++) {
                            Button button2 = (Button) buttoncontainer.get((int) placementcontainer.get(f));
                            button2.setStyle("-fx-text-fill:white;-fx-background-color:blue");
                        }

                        for (int i = placementcontainer.size() - 1; i >= 0; i--) {
                            placementcontainer.remove(i);
                            progressB = new Text[26];
                        }

                        for (int i = placementcontainer.size() - 1; i >= 0; i--) {
                            placementcontainer.remove(i);
                            progressB = new Text[26];
                        }

                        for (int i = guessedW.size() - 1; i >= 0; i--) {
                            guessedW.remove(i);
                            progressB = new Text[26];
                        }

                        testString=new StringBuilder();

                    }

                }
            }
        } else if (button1.getStyle().compareTo("-fx-text-fill:black;-fx-background-color:red") == 0) {

            button1.setStyle("-fx-text-fill:white;-fx-background-color:black");
            String buttonS= button1.getText().toString();
            char c= buttonS.charAt(0);


            removeGuess(progressB,side,c);
            typeProperty=true;
            placementcontainer.remove(placementcontainer.size()-1);

        }
    }

    public void addGuess(Text[] progressB, VBox side) {
        StringBuilder words = new StringBuilder();


        guessed = (HBox) side.getChildren().get(1);
        HBox addition = new HBox();


        if(clearTest==true){
            guessed.getChildren().clear();
            clearTest=false;

            for (int k = 0; k < 26; k++) {

                if (progressB[k] == null) {
                    String character = (String) guessedW.get(k);


                    char c = character.charAt(0);
                    words.append(c);

                    String word = words.toString().toUpperCase();
                    Label title2 = new Label(word);
                    title2.setStyle("-fx-text-fill:white");
                    title2.setFont(Font.font(20));

                    progressB[k] = new Text(Character.toString(c));
                    guessed.getChildren().addAll(title2);
                    break;
                }

            }
        }
        else {

            for (int k = 0; k < 26; k++) {

                if (progressB[k] == null) {
                    String character = (String) guessedW.get(k);


                    char c = character.charAt(0);
                    words.append(c);

                    String word = words.toString().toUpperCase();
                    Label title2 = new Label(word);
                    title2.setStyle("-fx-text-fill:white");
                    title2.setFont(Font.font(20));

                    progressB[k] = new Text(Character.toString(c));
                    guessed.getChildren().addAll(title2);
                    break;
                }

            }
        }
    }

    public void removeGuess(Text[] progressB, VBox side, char d) {
        StringBuilder words = new StringBuilder();

        //side= (VBox)layout.getRight();
        guessed = (HBox) side.getChildren().get(1);
        guessed.getChildren().clear();

        HBox addition = new HBox();

        // side.getChildren().remove(1);
        int lastW=guessedW.size()-1;

        guessedW.remove(lastW);
        progressTest= new Text[26];

        for(int k=0;k<26;k++){

            if(guessedW.size()==0){
                break;
            }
            else if(k<guessedW.size())
                progressTest[k]= new Text(guessedW.get(k).toString());

        }

        for(int i=0;i<progressTest.length;i++){
            progressB[i]=progressTest[i];
        }
       // progressB=progressTest;


        for(int j=0;j<guessedW.size();j++){

            words.append(guessedW.get(j));
        }

        String word = words.toString().toUpperCase();
        Label title2 = new Label(word);
        title2.setStyle("-fx-text-fill:white");
        title2.setFont(Font.font(20));

        guessed.getChildren().addAll(title2);

    }
            //  side.getChildren().add(addition);



/////////////////////////////////////////////////////////////////////////

    public void addT(Text[] progressB, VBox side) {
        StringBuilder words = new StringBuilder();

        //side= (VBox)layout.getRight();
        timeB = (HBox) side.getChildren().get(0);
        HBox addition = new HBox();


        for (int k = 0; k < 26; k++) {

            if (progressB[k] == null) {
                String character = (String) guessedW.get(k);


                char c = character.charAt(0);
                words.append(c);

                String word = words.toString().toUpperCase();
                Label title2 = new Label(word);
                title2.setStyle("-fx-text-fill:white");
                title2.setFont(Font.font(20));

                progressB[k] = new Text(Character.toString(c));
                guessed.getChildren().addAll(title2);
                break;
            }

            //  side.getChildren().add(addition);

        }
    }

    public void target(Text[] progressT, VBox side) {
        int total2 = 0;
        for (int i = 0; i < numbers.size(); i++) {

            total2 = total2 + (int) numbers.get(i);
        }

        StringBuilder words = new StringBuilder();


        targetB = (VBox) side.getChildren().get(3);
        targetB.getChildren().clear();

        if (progressT[0] == null) {
            String character = total2 + "";


            for (int l = 0; l < character.length(); l++) {
                char c = character.charAt(l);
                words.append(c);

            }


            String word = words.toString().toUpperCase();
            Label title2 = new Label(word);
            title2.setStyle("-fx-text-fill:white");
            title2.setFont(Font.font(20));

            // progressB[k] = new Text(Character.toString(c));
            targetB.getChildren().addAll(title2);

            Label title3 = new Label("TARGET:");
            title3.setStyle("-fx-text-fill:white");
            title3.setFont(Font.font(20));

            targetB.getChildren().addAll(title3);


        }

    }


    public void addWord(Text[] progressW, VBox side) {
        StringBuilder words = new StringBuilder();
        test1 = true;
        ArrayList wordcontainerGW= new ArrayList();

        //side= (VBox)layout.getRight();
        scroll = (ScrollPane) side.getChildren().get(2);
        contents = (VBox) scroll.getContent();

        if(contents.getChildren().size()!=0){

            for(int i=0;i<contents.getChildren().size();i++){
                wordcontainerGW.add(contents.getChildren().get(i));
            }
        }
        word1 = word1.toLowerCase();

        for (int j = 0; j < wordContainer2.size(); j++) {

            test1=true;
            for (int k = 0; k < wordContainer2.get(j).toString().length(); k++) {

                if(k<word1.length()) {
                    if (word1.charAt(k) == wordContainer2.get(j).toString().charAt(k) && test1 == true) {
                        test1 = true;
                        record = j;

                    } else {
                        test1 = false;
                        continue;
                    }
                }
            }
        }


        int length = wordContainer2.get(record).toString().length();
        length = length * 2;
        wordvalue = length;
        scores.add(wordvalue);


                String character = (String) wordContainer2.get(record);

                for (int i = 0; i < character.length(); i++) {
                    char c = character.charAt(i);
                    words.append(c);

                }

                String word = words.toString().toUpperCase();
                Label title2 = new Label(word + " " + wordvalue);
                title2.setStyle("-fx-text-fill:black");
                title2.setFont(Font.font(20));

                int total = 0;
                for (int l = 0; l < scores.size(); l++) {
                    total = total + (int) scores.get(l);
                }

                Label title3 = new Label("Total: " + total);
                title3.setStyle("-fx-text-fill:black");
                title3.setFont(Font.font(20));


                contents.getChildren().clear();

                int k=0;


                for(int i=0;i<=wordcontainerGW.size()-2;i++){
                    Label labelT= (Label) wordcontainerGW.get(i);
                    labelT.setStyle("-fx-text-fill:black");
                    labelT.setFont(Font.font(20));
                    contents.getChildren().addAll(labelT);

                }

                contents.getChildren().addAll(title2);
                contents.getChildren().addAll(title3);
        Label labelT= (Label) contents.getChildren().get(0);

                scroll.setContent(contents);
    }


    public void setGameDetermine(boolean value){
        this.gamedetermine=value;
    }
    @Override
    public void run() {

            if (level.compareTo("Level 1") == 0) {
                timeR = 10;
            } else if (level.compareTo("Level 2") == 0) {
                timeR = 15;
            } else if (level.compareTo("Level 3") == 0) {
                timeR = 30;
            }
            // int i=20;
            VBox middlecontent = (VBox) layout.getCenter();
            pause = (HBox) middlecontent.getChildren().get(1);
            pauseB = (Button) pause.getChildren().get(0);


            try {
                while (timeR >= 0) {
                    while (gamedetermine == true &&timeR >=0) {


                        if (timeR == 0 && game != true) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                    alert.setTitle("Information Dialog");
                                    alert.setHeaderText("Information Dialog");
                                    alert.setContentText("Time is up");

                                    alert.showAndWait();
                                    gamedetermine=false;
                                    //searchB(buttoncontainer);

                                    if (level.compareTo("Level 3") == 0) {
                                        recursionML3(buttoncontainer);
                                        disableAll(buttoncontainer);

                                    } else {
                                        recursionM(buttoncontainer);
                                        disableAll(buttoncontainer);
                                    }


                                }

                            });

                            timeR--;
                            break;

                        } else {

                            pauseB.setOnAction(e -> {

                                this.pauseButton = true;

                                pauseB.setOnAction(event -> {

                                    if (pauseButton == true) {
                                        this.pauseButton = false;
                                    }


                                });

                            });


                            timeR = timeR - 1;
                            this.time = timeR;

                            run1(getText(), getSide());

                            Thread.sleep(1500);
                            if (pauseButton == true) {
                                try {
                                    for (int l = 0; l < buttoncontainer.size(); l++) {
                                        Button button1 = (Button) buttoncontainer.get(l);
                                        //button1.setStyle("-fx-text-fill:black;-fx-background-color:black");
                                        button1.setDisable(true);

                                    }
                                    Thread.sleep(10000);

                                    for (int l = 0; l < buttoncontainer.size(); l++) {
                                        Button button1 = (Button) buttoncontainer.get(l);
                                        //button1.setStyle("-fx-text-fill:black;-fx-background-color:black");
                                        button1.setDisable(false);

                                    }

                                    pauseButton = false;


                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        public void disableAll(ArrayList buttoncontainer1){

            buttoncontainer=buttoncontainer1;

            for(int i=0;i<buttoncontainer.size();i++){

                Button button1= (Button)buttoncontainer.get(i);
                button1.setDisable(true);

            }

        }

        public void searchB(ArrayList buttoncontainer1) {

            buttoncontainer = buttoncontainer1;

            button3= new Button();
            button4= new Button();
            button5= new Button();
            button6= new Button();

            boolean searchT=false;

            indexofSearchB= new ArrayList();
            indexCompleteS= new ArrayList();

            Button buttton1 = (Button) buttoncontainer.get(0);
            int i = 0;
            count = 0;
            gridC = 0;
            k=0;


            while (gridC < buttoncontainer.size() && k<wordContainer2.size()) {
                boolean test = true;
                count = gridC;

                j = 0;
                solverC = 0;
                int count2 = 0;


                String word = wordContainer2.get(k).toString();
                int size = wordContainer2.get(k).toString().length();

                Button button2 = (Button) buttoncontainer.get(count);

                if (button2.getText().charAt(solverC) == word.charAt(j)) {


                    while (test == true && count2 < word.length()+2 && count<buttoncontainer.size()) {
                        button2 = (Button) buttoncontainer.get(count);

                        button2.setStyle("-fx-text-fill:white;-fx-background-color:blue");
                        test = false;
                        indexofSearchB.add(count);

                        if(count-1>=0){
                            if(count==4||count==8||count==12){
                                button4= (Button) buttoncontainer.get(count-4);
                            }
                            else
                                button3 = (Button) buttoncontainer.get(count - 1);
                        }
                        if(count+1< 16){
                            if(count==3||count==7||count==11){
                                button4= (Button) buttoncontainer.get(count+4);
                            }
                            else
                                button4= (Button) buttoncontainer.get(count+1);
                        }
                        if(count+4<16){

                            button5= (Button) buttoncontainer.get(count+4);
                        }

                        if(count-4 >=0){
                            button6=(Button) buttoncontainer.get(count-4);
                        }
                        char test5= word.charAt(j+1);

                            if (button3.getText().toString().compareTo("")!=0 && (button3.getText().charAt(solverC) == word.charAt(j+1))) {
                                button3.setStyle("-fx-text-fill:white;-fx-background-color:blue");

                                indexofSearchB.add(count-1);
                                count = count - 1;
                                count2++;

                                test = true;

                            }
                            else if (button4.getText().toString().compareTo("")!=0 && (button4.getText().charAt(solverC) == word.charAt(j+1))) {
                                button4.setStyle("-fx-text-fill:white;-fx-background-color:blue");

                                indexofSearchB.add(count+1);
                                count = count + 1;
                                count2++;

                                test = true;

                            }

                            else if (button5.getText().toString().compareTo("")!=0 && (button5.getText().charAt(solverC) == word.charAt(j+1))) {
                                button5.setStyle("-fx-text-fill:white;-fx-background-color:blue");

                                indexofSearchB.add(count+4);
                                count = count + 4;
                                count2++;

                                test = true;

                            }
                            else if (button6.getText().toString().compareTo("")!=0 && (button6.getText().charAt(solverC) == word.charAt(j+1))) {
                                button6.setStyle("-fx-text-fill:white;-fx-background-color:blue");

                                indexofSearchB.add(count-4);
                                count = count - 4;
                                count2++;

                                test = true;

                            }
                        if(test==true){
                            j++;
                        }

                        if(test==false) {
                            for (int m = 0; m < buttoncontainer.size(); m++) {
                                Button button1 = (Button) buttoncontainer1.get(m);
                                button1.setStyle("-fx-text-fill:white;-fx-background-color:black");


                            }
                            for(int k=0;k<indexofSearchB.size();k++){
                                indexofSearchB.remove(k);
                            }

                            count2=0;
                        }
                    }

                        if (test == false) {

                            for (int m = 0; m < buttoncontainer.size(); m++) {
                                Button button1 = (Button) buttoncontainer1.get(m);
                                button1.setStyle("-fx-text-fill:white;-fx-background-color:black");
                            }

                            for(int k=0;k<indexofSearchB.size();k++){
                                indexofSearchB.remove(k);
                            }
                            count2=0;
                            j=0;

                        } else if (test == true) {

                            for(int k=0;k<indexofSearchB.size();k++){

                                indexCompleteS.add(indexofSearchB.get(k));
                            }

                            test=true;
                            k++;
                            searchT=true;
                            count2=0;

                        }
                        else if(test==true){
                            j++;
                        }
                    }

                        if (test == true && count2 == word.length()+1) {
                            break;
                        }

                        if(searchT==true){
                            gridC=0;
                            searchT=false;
                        }
                        else
                            gridC++;

                    }

                    int k=0;
                    int j=0;



            while(k<indexCompleteS.size()){

                Button button1= (Button)buttoncontainer.get((Integer) indexCompleteS.get(k));
                button1.setStyle("-fx-text-fill:white;-fx-background-color:blue");

                k++;

                }
            }


            public void recursionML3(ArrayList buttoncontainer1){

                tester2=false;
                buttoncontainer = buttoncontainer1;
                wordchoice=false;
                colorcontainer= new ArrayList();
                startgame=false;

                int i=0;
                int j=0;
                int m=0;
                wordcount=0;
                int count2=0;
                checkgameS=0;

                int color1=0;
                int color2=0;
                int color3=0;


                while(i<buttoncontainer.size() && j<wordContainer2.size()){
                    String word= (String) wordContainer2.get(j);


                    recursionM3((Button)buttoncontainer.get(i),buttoncontainer,i, j,this.wordcount,word.charAt(m), wordContainer2, wordchoice,count2);
                    if(wordchoice==true && this.wordcount==word.length()){
                        j++;
                        i=0;

                        for(int k=0;k<colorcontainer.size();k++){
                            if(j==1) {
                                Button button1 = (Button) buttoncontainer.get((Integer) colorcontainer.get(k));
                                button1.setStyle("-fx-text-fill:white;-fx-background-color:blue");
                                color1++;
                            }
                            else if(j==2){
                                Button button1 = (Button) buttoncontainer.get((Integer) colorcontainer.get(k));
                                button1.setStyle("-fx-text-fill:white;-fx-background-color:red");
                                color2++;

                            }
                            else if(j==3){
                                Button button1 = (Button) buttoncontainer.get((Integer) colorcontainer.get(k));
                                button1.setStyle("-fx-text-fill:white;-fx-background-color: #7FFF00");
                                color3++;

                            }
                        }
                        int counter=0;
                        int counter2=0;
                        int counter3=0;



                        if(color1!=0){
                            for(int a=0;a<color1;a++){
                                Button button1 = (Button) buttoncontainer.get((Integer) colorcontainer.get(a));
                                button1.setStyle("-fx-text-fill:white;-fx-background-color:blue");
                                counter++;
                                counter2++;
                            }
                        }

                        int colorc= color2-counter;

                        if(color2!=0){
                           // --counter;
                            for(int b=0;b<colorc;b++){
                                Button button1 = (Button) buttoncontainer.get((Integer) colorcontainer.get(counter));
                                button1.setStyle("-fx-text-fill:white;-fx-background-color:red");
                                counter2++;
                                counter++;
                            }
                        }

                        this.wordcount=0;
                        count2=0;
                        this.startgame=false;

                        i=0;
                    }
                    else {
                        i++;
                        this.wordcount=0;
                        count2=0;
                        this.startgame=false;
                    }
                }

            }
            public void recursionM(ArrayList buttoncontainer1){



                tester=false;
                buttoncontainer = buttoncontainer1;
                wordchoice=false;
                colorcontainer= new ArrayList();
                startgame=false;

                int i=0;
                int j=0;
                int m=0;
                wordcount=0;
                int count2=0;
                checkgameS=0;

                int color1=0;
                int color2=0;
                int color3=0;


                while(i<buttoncontainer.size() && j<wordContainer2.size()){
                    String word= (String) wordContainer2.get(j);


                    recursionM2((Button)buttoncontainer.get(i),buttoncontainer,i, j,this.wordcount,word.charAt(m), wordContainer2, wordchoice,count2);
                    if(wordchoice==true && this.wordcount==word.length()){
                        j++;
                        i=0;

                        for(int k=0;k<colorcontainer.size();k++){

                            if(j==1) {
                                Button button1 = (Button) buttoncontainer.get((Integer) colorcontainer.get(k));
                                button1.setStyle("-fx-text-fill:white;-fx-background-color:blue");
                                color1++;
                            }
                            else if(j==2){
                                Button button1 = (Button) buttoncontainer.get((Integer) colorcontainer.get(k));
                                button1.setStyle("-fx-text-fill:white;-fx-background-color:red");
                                color2++;

                            }
                            else if(j==3){
                                Button button1 = (Button) buttoncontainer.get((Integer) colorcontainer.get(k));
                                button1.setStyle("-fx-text-fill:white;-fx-background-color: #7FFF00");
                                color3++;

                            }

                        }
                        int counter=0;
                        int counter2=0;
                        int counter3=0;

                        if(color1!=0){
                            for(int a=0;a<color1;a++){
                                Button button1 = (Button) buttoncontainer.get((Integer) colorcontainer.get(a));
                                button1.setStyle("-fx-text-fill:white;-fx-background-color:blue");
                                counter++;
                            }
                        }
                        if(color2!=0){
                            for(int b=0;b<color2-counter;b++){
                                Button button1 = (Button) buttoncontainer.get((Integer) colorcontainer.get(counter));
                                button1.setStyle("-fx-text-fill:white;-fx-background-color:red");
                                counter++;
                                counter2++;
                            }

                        }
                        if(color3!=0){
                            for(int c=0;c<color3-counter2;c++){
                                Button button1 = (Button) buttoncontainer.get((Integer) colorcontainer.get(counter2));
                                button1.setStyle("-fx-text-fill:white;-fx-background-color:#7FFF00");
                                counter3++;
                                counter2++;
                            }
                        }

                        this.wordcount=0;
                        this.startgame=false;
                        count2=0;
                        i=0;
                    }
                    else {
                        i++;
                    }

                }
            }

            public void recursionM2(Button buttoncontainer3,ArrayList buttoncontainer, int count, int tracker, int wordcount,char c,ArrayList wordcontainer,boolean wordchoice,int count2){


                String word= (String)wordcontainer.get(tracker);
                int arrayT=0;
                if (this.startgame == true) {
                    count=count2;
                }

                if(this.wordcount==word.length()){
                    this.wordchoice=true;
                    return;
                }
                //count=count2;


                if( buttoncontainer3.getText().charAt(0)!=c){
                    this.wordchoice=false;

                    if(this.checkgameS==0) {
                        this.startgame = false;
                    }
                    return;

                }
                else {

                    checkgameS++;
                    startgame=true;
                       if (count == 4 || count == 8 && buttoncontainer3.getText().charAt(0) == c && this.wordcount<=word.length()) {
                        colorcontainer.add(count);
                           this.wordcount++;
                           this.wordchoice = true;

                           if(this.wordcount==word.length()){
                               this.wordchoice=true;
                               return;
                           }



                            count2=count+1;
                        recursionM2((Button) buttoncontainer.get(count + 1), buttoncontainer, count,tracker, this.wordcount, word.charAt(this.wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                           // count=count+1;
                        }

                           if(this.wordcount==word.length()){
                               this.wordchoice=true;
                               return;
                           }


                         count2=count+4;
                        recursionM2((Button) buttoncontainer.get(count + 4), buttoncontainer, count,tracker,this.wordcount, word.charAt(this.wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                           // count=count-4;
                        }

                           if(this.wordcount==word.length()){
                               this.wordchoice=true;
                               return;
                           }

                         count2=count-4;
                        recursionM2((Button) buttoncontainer.get(count - 4), buttoncontainer, count,tracker, this.wordcount, word.charAt(this.wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                           // count=count+4;
                        }

                        if(arrayT==3){

                            int removeI= colorcontainer.size()-1;
                            colorcontainer.remove(removeI);
                            this.wordcount--;
                            arrayT = 0;
                        }

                    }
                    else if(count==12 && buttoncontainer3.getText().charAt(0) == c && this.wordcount<=word.length()){
                           colorcontainer.add(count);
                           this.wordcount++;
                           this.wordchoice = true;

                           if(this.wordcount==word.length()){
                               this.wordchoice=true;
                               return;
                           }



                           count2=count+1;
                           recursionM2((Button) buttoncontainer.get(count + 1), buttoncontainer, count,tracker, this.wordcount, word.charAt(this.wordcount), wordcontainer, this.wordchoice,count2);
                           if(this.wordchoice==false){
                               arrayT++;
                           }

                           if(this.wordcount==word.length()){
                               this.wordchoice=true;
                               return;
                           }


                           count2=count-4;
                           recursionM2((Button) buttoncontainer.get(count - 4), buttoncontainer, count,tracker, this.wordcount, word.charAt(this.wordcount), wordcontainer, this.wordchoice,count2);
                           if(this.wordchoice==false){
                               arrayT++;
                           }

                           if(arrayT==2){
                               for(int i=0;i<colorcontainer.size();i++) {
                                   colorcontainer.remove(i);
                               }
                               arrayT=0;
                           }
                    }
                        else if (count == 0 && buttoncontainer3.getText().charAt(0) == c && this.wordcount<=word.length()) {
                        colorcontainer.add(count);
                           this.wordcount++;
                           this.wordchoice = true;

                           if(this.wordcount==word.length()){
                               this.wordchoice=true;
                               return;
                           }

                           count2=count+1;
                        recursionM2((Button) buttoncontainer.get(count + 1), buttoncontainer, count,tracker, this.wordcount, word.charAt(this.wordcount), wordcontainer, this.wordchoice,count2);

                        if(this.wordchoice==false){
                            arrayT++;
                           // count=count-1;
                        }

                           if(this.wordcount==word.length()){
                               this.wordchoice=true;
                               return;
                           }
                           count2=count+4;
                        recursionM2((Button) buttoncontainer.get(count + 4), buttoncontainer, count,tracker, this.wordcount, word.charAt(this.wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                           // count=count-4;
                            arrayT++;
                        }
                        if(arrayT==2){

                            int removeI= colorcontainer.size()-1;
                            colorcontainer.remove(removeI);
                            this.wordcount--;
                            arrayT = 0;
                        }


                    } else if (count == 15 && buttoncontainer3.getText().charAt(0) == c && this.wordcount<=word.length()) {
                        colorcontainer.add(count);
                           this.wordcount++;
                           this.wordchoice = true;

                           if(this.wordcount==word.length()){
                               this.wordchoice=true;
                               return;
                           }

                           count2=count-1;
                        recursionM2((Button) buttoncontainer.get(count - 1), buttoncontainer, count,tracker, this.wordcount, word.charAt(this.wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                           /// count=count+1;
                        }

                           if(this.wordcount==word.length()){
                               this.wordchoice=true;
                               return;
                           }

                         count2=count-4;
                        recursionM2((Button) buttoncontainer.get(count - 4), buttoncontainer, count,tracker, this.wordcount, word.charAt(this.wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                          //  count=count+4;
                        }

                        if(arrayT==2){

                            int removeI= colorcontainer.size()-1;
                            colorcontainer.remove(removeI);
                            this.wordcount--;
                            arrayT = 0;
                        }
                    }

                    else if(count==3 && buttoncontainer3.getText().charAt(0) == c && this.wordcount<=word.length()){
                           this.wordchoice = true;
                        colorcontainer.add(count);
                           this.wordcount++;

                           if(this.wordcount==word.length()){
                               this.wordchoice=true;
                               return;
                           }

                          count2=count-1;
                        recursionM2((Button) buttoncontainer.get(count - 1), buttoncontainer, count,tracker, this.wordcount, word.charAt(this.wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                        }

                           if(this.wordcount==word.length()){
                               this.wordchoice=true;
                               return;
                           }

                         count2=count+4;
                        recursionM2((Button) buttoncontainer.get(count + 4), buttoncontainer, count,tracker, this.wordcount, word.charAt(this.wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                        }

                        if(arrayT==2){

                            int removeI= colorcontainer.size()-1;
                            colorcontainer.remove(removeI);
                            this.wordcount--;
                            arrayT = 0;
                        }

                    }
                    else if(count==7 || count==11 && buttoncontainer3.getText().charAt(0) == c && this.wordcount<=word.length()){
                        colorcontainer.add(count);
                           this.wordchoice = true;
                           this.wordcount++;

                           if(this.wordcount==word.length()){
                               this.wordchoice=true;
                               return;
                           }

                           count2=count-1;
                        recursionM2((Button) buttoncontainer.get(count - 1), buttoncontainer, count,tracker, this.wordcount, word.charAt(this.wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                        }

                           if(this.wordcount==word.length()){
                               this.wordchoice=true;
                               return;
                           }

                        count2=count+4;
                        recursionM2((Button) buttoncontainer.get(count + 4), buttoncontainer, count,tracker, this.wordcount, word.charAt(this.wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                        }

                           if(this.wordcount==word.length()){
                               this.wordchoice=true;
                               return;
                           }

                        count2=count-4;
                        recursionM2((Button) buttoncontainer.get(count - 4), buttoncontainer, count,tracker, this.wordcount, word.charAt(this.wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                        }

                        if(arrayT==3){

                            int removeI= colorcontainer.size()-1;
                            colorcontainer.remove(removeI);
                            this.wordcount--;
                            arrayT = 0;
                        }
                    }
                    else if (count >= 0 && count < 16 && count + 1 < 16 && count - 1 >= 0 && count+4<16 && count -4>=0 && buttoncontainer3.getText().charAt(0) == c && this.wordcount<=word.length()) {
                           //wordcount++;
                           this.wordcount++;
                           this.wordchoice = true;
                           colorcontainer.add(count);

                           if (this.wordcount == word.length()) {
                               this.wordchoice = true;
                               return;
                           }

                           count2 = count + 1;
                           recursionM2((Button) buttoncontainer.get(count + 1), buttoncontainer, count, tracker, this.wordcount, word.charAt(this.wordcount), wordcontainer, this.wordchoice, count2);
                           if (this.wordchoice == false) {
                               arrayT++;
                           }

                           if (this.wordcount == word.length()) {
                               this.wordchoice = true;
                               return;
                           }

                           count2 = count - 1;
                           recursionM2((Button) buttoncontainer.get(count - 1), buttoncontainer, count, tracker, this.wordcount, word.charAt(this.wordcount), wordcontainer, this.wordchoice, count2);
                           if (this.wordchoice == false) {
                               arrayT++;
                           }

                           if (this.wordcount == word.length()) {
                               this.wordchoice = true;
                               return;
                           }

                           count2 = count + 4;
                           recursionM2((Button) buttoncontainer.get(count + 4), buttoncontainer, count, tracker, this.wordcount, word.charAt(this.wordcount), wordcontainer, this.wordchoice, count2);
                           if (this.wordchoice == false) {
                               arrayT++;
                           }

                           if (this.wordcount == word.length()) {
                               this.wordchoice = true;
                               return;
                           }


                               count2 = count - 4;
                               recursionM2((Button) buttoncontainer.get(count - 4), buttoncontainer, count, tracker, this.wordcount, word.charAt(this.wordcount), wordcontainer, this.wordchoice, count2);
                               if (this.wordchoice == false) {
                                   arrayT++;
                               }

                           if (arrayT == 4) {


                               int removeI= colorcontainer.size()-1;
                               colorcontainer.remove(removeI);
                               this.wordcount--;
                               arrayT = 0;
                                }
                           }

                       else if (count >= 0 && count < 16 && count + 1 < 16 && count - 1 >= 0 && count+4<16 && buttoncontainer3.getText().charAt(0) == c && this.wordcount<=word.length()) {
                           this.wordcount++;
                           this.wordchoice = true;
                           colorcontainer.add(count);

                           if(this.wordcount==word.length()){
                               this.wordchoice=true;
                               return;
                           }

                           count2=count+1;
                           recursionM2((Button) buttoncontainer.get(count + 1), buttoncontainer, count,tracker, this.wordcount, word.charAt(this.wordcount), wordcontainer, this.wordchoice,count2);
                           if(this.wordchoice==false){
                               arrayT++;
                           }

                           if(this.wordcount==word.length()){
                               this.wordchoice=true;
                               return;
                           }

                           count2=count-1;
                           recursionM2((Button) buttoncontainer.get(count - 1), buttoncontainer, count,tracker, this.wordcount, word.charAt(this.wordcount), wordcontainer, this.wordchoice,count2);
                           if(this.wordchoice==false){
                               arrayT++;
                           }

                           if(this.wordcount==word.length()){
                               this.wordchoice=true;
                               return;
                           }

                           count2=count+4;
                           recursionM2((Button) buttoncontainer.get(count + 4), buttoncontainer, count,tracker, this.wordcount, word.charAt(this.wordcount), wordcontainer,this.wordchoice,count2);
                           if(this.wordchoice==false){
                               arrayT++;
                           }

                           if (arrayT == 3) {

                               arrayT = 0;
                               int removeI= colorcontainer.size()-1;
                               colorcontainer.remove(removeI);
                               this.wordcount--;
                           }

                       }
                       else if (count >= 0 && count < 16 && count + 1 < 16 && count - 1 >= 0 && count-4<16 && buttoncontainer3.getText().charAt(0) == c && this.wordcount<=word.length()) {
                           this.wordcount++;
                           this.wordchoice = true;
                           colorcontainer.add(count);

                           if(this.wordcount==word.length()){
                               this.wordchoice=true;
                               return;
                           }

                           count2=count+1;
                           recursionM2((Button) buttoncontainer.get(count + 1), buttoncontainer, count,tracker, this.wordcount, word.charAt(this.wordcount), wordcontainer, this.wordchoice,count2);
                           if(this.wordchoice==false){
                               arrayT++;
                           }

                           if(this.wordcount==word.length()){
                               this.wordchoice=true;
                               return;
                           }

                           count2=count-1;
                           recursionM2((Button) buttoncontainer.get(count - 1), buttoncontainer, count,tracker, this.wordcount, word.charAt(this.wordcount), wordcontainer, this.wordchoice,count2);
                           if(this.wordchoice==false){
                               arrayT++;
                           }

                           if(this.wordcount==word.length()){
                               this.wordchoice=true;
                               return;
                           }

                           count2=count-4;
                           recursionM2((Button) buttoncontainer.get(count - 4), buttoncontainer, count,tracker, this.wordcount, word.charAt(this.wordcount), wordcontainer,this.wordchoice,count2);
                           if(this.wordchoice==false){
                               arrayT++;
                           }

                           if (arrayT == 3) {

                               arrayT = 0;
                               int removeI= colorcontainer.size()-1;
                               colorcontainer.remove(removeI);
                               this.wordcount--;
                           }


                       }
                }
                startgame=false;
                checkgameS=0;
               // this.wordcount=0;



            }
            public void recursionM3(Button buttoncontainer3,ArrayList buttoncontainer, int count, int tracker, int wordcount,char c,ArrayList wordcontainer,boolean wordchoice,int count2){

                String word= (String)wordcontainer.get(tracker);
                int arrayT=0;
                if (this.startgame == true) {
                    count=count2;
                }

                if(this.wordcount==word.length()){
                    this.wordchoice=true;
                    return;
                }
                //count=count2;


                if( buttoncontainer3.getText().charAt(0)!=c){
                    this.wordchoice=false;

                    if(this.checkgameS==0) {
                         this.startgame = false;
                    }
                    return;

                }
                else {

                    checkgameS++;
                    startgame=true;
                    if (count == 6 || count == 12 || count == 18 && buttoncontainer3.getText().charAt(0) == c && wordcount<=word.length()) {

                        colorcontainer.add(count);
                        wordcount++;
                        this.wordcount++;
                        this.wordchoice = true;

                        if(this.wordcount==word.length()){
                            this.wordchoice=true;
                            return;
                        }



                        count2=count+1;
                        recursionM3((Button) buttoncontainer.get(count + 1), buttoncontainer, count,tracker, wordcount, word.charAt(wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                        }

                        if(this.wordcount==word.length()){
                            this.wordchoice=true;
                            return;
                        }


                        count2=count+6;
                        recursionM3((Button) buttoncontainer.get(count + 6), buttoncontainer, count,tracker,wordcount, word.charAt(wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                        }

                        if(this.wordcount==word.length()){
                            this.wordchoice=true;
                            return;
                        }


                        count2=count-6;
                        recursionM3((Button) buttoncontainer.get(count - 6), buttoncontainer, count,tracker, wordcount, word.charAt(wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                        }


                        if (arrayT == 3) {

                            arrayT = 0;
                            int removeI= colorcontainer.size()-1;
                            colorcontainer.remove(removeI);
                            this.wordcount--;
                        }

                    }

                    else if (count==24 && buttoncontainer3.getText().charAt(0) == c && wordcount<=word.length()){

                        colorcontainer.add(count);
                        wordcount++;
                        this.wordcount++;
                        this.wordchoice = true;

                        if(this.wordcount==word.length()){
                            this.wordchoice=true;
                            return;
                        }


                        count2=count+1;
                        recursionM3((Button) buttoncontainer.get(count + 1), buttoncontainer, count,tracker, wordcount, word.charAt(wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                        }

                        if(this.wordcount==word.length()){
                            this.wordchoice=true;
                            return;
                        }

                        count2=count-6;
                        recursionM3((Button) buttoncontainer.get(count - 6), buttoncontainer, count,tracker, wordcount, word.charAt(wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                            // count=count+4;
                        }


                        if (arrayT == 2) {

                            arrayT = 0;
                            int removeI= colorcontainer.size()-1;
                            colorcontainer.remove(removeI);
                            this.wordcount--;
                        }
                    }
                    else if (count == 0 && buttoncontainer3.getText().charAt(0) == c && wordcount<=word.length()) {
                        colorcontainer.add(count);
                        wordcount++;
                        this.wordcount++;
                        this.wordchoice = true;

                        if(this.wordcount==word.length()){
                            this.wordchoice=true;
                            return;
                        }

                        count2=count+1;
                        recursionM3((Button) buttoncontainer.get(count + 1), buttoncontainer, count,tracker, wordcount, word.charAt(wordcount), wordcontainer, this.wordchoice,count2);

                        if(this.wordchoice==false){
                            arrayT++;
                        }

                        if(this.wordcount==word.length()){
                            this.wordchoice=true;
                            return;
                        }
                        count2=count+6;
                        recursionM3((Button) buttoncontainer.get(count + 6), buttoncontainer, count,tracker, wordcount, word.charAt(wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            // count=count-4;
                            arrayT++;
                        }

                        if (arrayT == 2) {

                            arrayT = 0;
                            int removeI= colorcontainer.size()-1;
                            colorcontainer.remove(removeI);
                            this.wordcount--;
                        }

                    } else if (count == 29 && buttoncontainer3.getText().charAt(0) == c && wordcount<=word.length()) {
                        colorcontainer.add(count);
                        wordcount++;
                        this.wordcount++;
                        this.wordchoice = true;

                        if(this.wordcount==word.length()){
                            this.wordchoice=true;
                            return;
                        }

                        count2=count-1;
                        recursionM3((Button) buttoncontainer.get(count - 1), buttoncontainer, count,tracker, wordcount, word.charAt(wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                        }

                        if(this.wordcount==word.length()){
                            this.wordchoice=true;
                            return;
                        }

                        count2=count-6;
                        recursionM3((Button) buttoncontainer.get(count - 6), buttoncontainer, count,tracker, wordcount, word.charAt(wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                        }


                        if (arrayT == 2) {

                            arrayT = 0;
                            int removeI= colorcontainer.size()-1;
                            colorcontainer.remove(removeI);
                            this.wordcount--;
                        }
                    }

                    else if(count==5 && buttoncontainer3.getText().charAt(0) == c && wordcount<=word.length()){
                        this.wordchoice = true;
                        colorcontainer.add(count);
                        this.wordcount++;
                        wordcount++;

                        if(this.wordcount==word.length()){
                            this.wordchoice=true;
                            return;
                        }

                        count2=count-1;
                        recursionM3((Button) buttoncontainer.get(count - 1), buttoncontainer, count,tracker, wordcount, word.charAt(wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                        }

                        if(this.wordcount==word.length()){
                            this.wordchoice=true;
                            return;
                        }

                        count2=count+6;
                        recursionM3((Button) buttoncontainer.get(count + 6), buttoncontainer, count,tracker, wordcount, word.charAt(wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                        }

                        if (arrayT == 2) {

                            arrayT = 0;
                            int removeI= colorcontainer.size()-1;
                            colorcontainer.remove(removeI);
                            this.wordcount--;
                        }

                    }
                    else if(count==11 || count==17 || count==23 && buttoncontainer3.getText().charAt(0) == c && wordcount<=word.length()){
                        colorcontainer.add(count);
                        this.wordchoice = true;
                        wordcount++;
                        this.wordcount++;

                        if(this.wordcount==word.length()){
                            this.wordchoice=true;
                            return;
                        }

                        count2=count-1;
                        recursionM3((Button) buttoncontainer.get(count - 1), buttoncontainer, count,tracker, wordcount, word.charAt(wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                        }

                        if(this.wordcount==word.length()){
                            this.wordchoice=true;
                            return;
                        }

                        count2=count+6;
                        recursionM3((Button) buttoncontainer.get(count + 6), buttoncontainer, count,tracker, wordcount, word.charAt(wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                        }

                        if(this.wordcount==word.length()){
                            this.wordchoice=true;
                            return;
                        }

                        count2=count-6;
                        recursionM3((Button) buttoncontainer.get(count - 6), buttoncontainer, count,tracker, wordcount, word.charAt(wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                            /// count=count+4;
                        }

                        if (arrayT == 3) {

                            arrayT = 0;
                            int removeI= colorcontainer.size()-1;
                            colorcontainer.remove(removeI);
                            this.wordcount--;
                        }
                    }
                    else if (count >= 0 && count < 30 && count + 1 < 30 && count - 1 >= 0 && count+6<30 && count -6>=0 && buttoncontainer3.getText().charAt(0) == c && wordcount<=word.length()) {
                        //wordcount++;wordcount++;
                        this.wordchoice = true;
                        colorcontainer.add(count);
                        this.wordcount++;
                        wordcount++;

                        if(this.wordcount==word.length()){
                            this.wordchoice=true;
                            return;
                        }

                        count2=count+1;
                        recursionM3((Button) buttoncontainer.get(count + 1), buttoncontainer, count,tracker, wordcount, word.charAt(wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                        }

                        if(this.wordcount==word.length()){
                            this.wordchoice=true;
                            return;
                        }

                        count2=count-1;
                        recursionM3((Button) buttoncontainer.get(count - 1), buttoncontainer, count,tracker, wordcount, word.charAt(wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                        }

                        if(this.wordcount==word.length()){
                            this.wordchoice=true;
                            return;
                        }

                        count2=count+6;
                        recursionM3((Button) buttoncontainer.get(count + 6), buttoncontainer, count,tracker, wordcount, word.charAt(wordcount), wordcontainer,this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                        }

                        if(this.wordcount==word.length()){
                            this.wordchoice=true;
                            return;
                        }


                        count2=count-6;
                        recursionM3((Button) buttoncontainer.get(count - 6), buttoncontainer, count,tracker, wordcount, word.charAt(wordcount), wordcontainer,this.wordchoice,count2);

                        if(this.wordchoice==false){
                            arrayT++;
                            //  count=count-4;
                        }

                        if (arrayT == 4) {

                            arrayT = 0;
                            int removeI= colorcontainer.size()-1;
                            colorcontainer.remove(removeI);
                            this.wordcount--;
                        }

                    }

                    else if (count >= 0 && count < 30 && count + 1 < 30 && count - 1 >= 0 && count-6>=0 && buttoncontainer3.getText().charAt(0) == c && wordcount<=word.length()){

                        //wordcount++;
                        wordcount++;
                        this.wordcount++;
                        this.wordchoice = true;
                        colorcontainer.add(count);

                        if(this.wordcount==word.length()){
                            this.wordchoice=true;
                            return;
                        }

                        count2=count+1;
                        recursionM3((Button) buttoncontainer.get(count + 1), buttoncontainer, count,tracker, wordcount, word.charAt(wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                        }

                        if(this.wordcount==word.length()){
                            this.wordchoice=true;
                            return;
                        }

                        count2=count-1;
                        recursionM3((Button) buttoncontainer.get(count - 1), buttoncontainer, count,tracker, wordcount, word.charAt(wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                        }

                        if(this.wordcount==word.length()){
                            this.wordchoice=true;
                            return;
                        }

                        if(count- 6 >=0) {
                            tester2=true;
                            count2 = count - 6;
                            recursionM3((Button) buttoncontainer.get(count - 6), buttoncontainer, count, tracker, wordcount, word.charAt(wordcount), wordcontainer, this.wordchoice, count2);
                            if (this.wordchoice == false) {
                                arrayT++;;
                            }
                        }


                        //if(tester==true) {
                        if (arrayT == 3) {

                            arrayT = 0;
                            int removeI= colorcontainer.size()-1;
                            colorcontainer.remove(removeI);
                            this.wordcount--;
                        }
                    }

                    else if(count>=0 && count <30 && count+1<30 && count -1>=0 && count+6<30 && buttoncontainer3.getText().charAt(0) == c && wordcount<=word.length()){
                        //wordcount++;
                        wordcount++;
                        this.wordcount++;
                        this.wordchoice = true;
                        colorcontainer.add(count);

                        if(this.wordcount==word.length()){
                            this.wordchoice=true;
                            return;
                        }

                        count2=count+1;
                        recursionM3((Button) buttoncontainer.get(count + 1), buttoncontainer, count,tracker, wordcount, word.charAt(wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                            //  count=count-1;
                        }

                        if(this.wordcount==word.length()){
                            this.wordchoice=true;
                            return;
                        }

                        count2=count-1;
                        recursionM3((Button) buttoncontainer.get(count - 1), buttoncontainer, count,tracker, wordcount, word.charAt(wordcount), wordcontainer, this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                        }

                        if(this.wordcount==word.length()){
                            this.wordchoice=true;
                            return;
                        }

                        count2=count+6;
                        recursionM3((Button) buttoncontainer.get(count + 6), buttoncontainer, count,tracker, wordcount, word.charAt(wordcount), wordcontainer,this.wordchoice,count2);
                        if(this.wordchoice==false){
                            arrayT++;
                            //  count=count-4;
                        }


                        if (arrayT == 3) {

                            arrayT = 0;
                            int removeI= colorcontainer.size()-1;
                            colorcontainer.remove(removeI);
                            this.wordcount--;
                        }
                    }
                }
                this.startgame=false;
                checkgameS=0;
                //this.wordcount=0;

            }




    public Text[] getText(){
        return this.progressTimer;
    }

    public VBox getSide(){
        return this.side;
    }

    public void run1(Text[] progressTimer, VBox side){

        StringBuilder words = new StringBuilder();

        timeB = (HBox) side.getChildren().get(0);

        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                timeB.getChildren().clear();

            }
        });

        HBox addition = new HBox();


        if(pauseButton==true){
            try {
                for(int l=0;l<buttoncontainer.size();l++){
                    Button button1= (Button) buttoncontainer.get(l);
                    button1.setDisable(true);

                }
                Thread.sleep(10000);

                for(int l=0;l<buttoncontainer.size();l++){
                    Button button1= (Button) buttoncontainer.get(l);
                    button1.setDisable(false);

                }

                pauseButton=false;


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

            for (int k = 0; k < 26; k++) {

                if (progressTimer[k] == null) {
                    String character = "Time Remaining: " + this.time;


                    char c = character.charAt(0);
                    words.append(character);

                    String word = words.toString().toUpperCase();
                    Label title4 = new Label(word);
                    title4.setStyle("-fx-text-fill:red");
                    title4.setFont(Font.font(20));

                    progressTimer[k] = new Text(Character.toString(c));
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            timeB.getChildren().addAll(title4);

                        }
                    });
                    break;
                }
            }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}