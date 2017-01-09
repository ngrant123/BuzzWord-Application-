import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by nathangrant
 */
//This code display the current levels are that are available to play when the player picks
// either countries, famous people, or dogs

public class Level1 {


    public int levelN;
    Stage primary;
    Scene primaryScene;
    VBox menu;
    HBox titleContainer;

    LoginSucces loginscreen;
    LevelSelection level;


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

    Gameplay1 gamplay1;

    HBox region1;
    HBox region2;
    HBox region3;
    Stage loginStage;
    Stage loginStage2;

    String name;
    GameData data;





    BorderPane layout;
    Button homeB;
    Button login;
    Button start;
    appGUI gui;
    apptemplate app;

    public Level1(Stage primaryStage) {
        this.primary= primaryStage;

    }

    public Level1(){

    }


    public void start(Stage primaryStage, String name,GameData data1){

        this.name=name;
        data=data1;

        layout=new BorderPane();
        loginStage= new Stage();
        loginStage2= new Stage();


        loginStage.setMaxHeight(primaryStage.getMaxHeight());
        loginStage.setMaxWidth(primaryStage.getMaxWidth());
        loginStage.setMinHeight(primaryStage.getMinHeight()-100);
        loginStage.setMinWidth(primaryStage.getMinWidth()-100);

        loginStage2.setMaxHeight(primaryStage.getMaxHeight());
        loginStage2.setMaxWidth(primaryStage.getMaxWidth());
        loginStage2.setMinHeight(primaryStage.getMinHeight()-100);
        loginStage2.setMinWidth(primaryStage.getMinWidth()-150);


        gamplay1= new Gameplay1(loginStage);
        level= new LevelSelection(loginStage2);

        initStyleT2();
        initStyleG2(name);
        initStyleL2();

        //reset(layout);
        primaryScene= new Scene(layout);
        primary.setScene(primaryScene);
    }



    public void initStyleG2(String name){
        initStyleG(layout,name);
    }

    public void initStyleG(BorderPane layout,String name){

        middleDiagram= new VBox(30);

        region1= new HBox(40);
        Label title= new Label(name);
        title.setFont(Font.font(40));
        title.setTextFill(Color.BLACK);

        title.setMinWidth(100);
        title.setMaxHeight(50);

        region1.getChildren().add(title);

         region2= new HBox(40);

        for(int i=0;i<4;i++){
            button1=new Button();
            int r= 100;
            button1.setShape(new Circle(r));
            button1.setMinHeight(50);
            button1.setMinWidth(50);

            button1.setStyle("-fx-background-color:black");

            region2.getChildren().add(button1);
        }

        region2.setPadding(new Insets(20,20,20,20));

        button5= (Button) region2.getChildren().get(0);
        button5.setText("1");
        button5.setStyle("-fx-text-fill:white;-fx-background-color:black");

        button6= (Button) region2.getChildren().get(1);
        button6.setText("2");
        button6.setStyle("-fx-text-fill:white;-fx-background-color:black");

        button7= (Button) region2.getChildren().get(2);
        button7.setText("3");
        button7.setStyle("-fx-text-fill:white;-fx-background-color:black");

        button8= (Button) region2.getChildren().get(3);
        button8.setText("4");
        button8.setStyle("-fx-text-fill:white;-fx-background-color:black");


        region3= new HBox(40);


        for(int i=0;i<4;i++){
            button2=new Button();
            int r= 100;
            button2.setShape(new Circle(r));
            button2.setMinHeight(50);
            button2.setMinWidth(50);

            button2.setStyle("-fx-background-color:black");

            region3.getChildren().add(button2);
        }

        region3.setPadding(new Insets(20,20,20,20));

        button9= (Button) region3.getChildren().get(0);
        button9.setText("5");
        button9.setStyle("-fx-text-fill:black;-fx-background-color:white");
      //  button9.setDisable(true);

        button10= (Button) region3.getChildren().get(1);
        button10.setText("6");
        button10.setStyle("-fx-text-fill:black;-fx-background-color:white");
      //  button10.setDisable(true);

        button11= (Button) region3.getChildren().get(2);
        button11.setText("7");
        button11.setStyle("-fx-text-fill:black;-fx-background-color:white");
       // button11.setDisable(true);

        button12= (Button) region3.getChildren().get(3);
        button12.setText("8");
        button12.setStyle("-fx-text-fill:black;-fx-background-color:white");
        //button12.setDisable(true);


        if(name.compareTo("Famous People")==0){
            int levelF= data.getfamousL();

            disableCircle(levelF,region2,region3);

            }


            else if (name.compareTo("Countries")==0){

                 int levelC= data.getcountriesL();

                 disableCircle(levelC,region2,region3);

               }
              else{
                    int levelD= data.getdogsL();

                    disableCircle(levelD,region2,region3);
                 }


        middleDiagram.getChildren().add(region1);
        middleDiagram.getChildren().add(region2);
        middleDiagram.getChildren().add(region3);



        middleDiagram.setAlignment(Pos.CENTER);

        layout.setCenter(middleDiagram);
        //  Label title=

        button5.setOnAction(e ->{

            String level= "Level 1";

            reset(layout);
            //primary = loginStage;
            gamplay1.start(loginStage,data,level,name);

            Scene prim2 = gamplay1.getScene();

            loginStage.setScene(prim2);
            loginStage.show();
            primary.close();

        });

        button6.setOnAction(e->{
            String level= "Level 2";

            reset(layout);
            //primary = loginStage;
            gamplay1.start(loginStage,data,level,name);

            Scene prim2 = gamplay1.getScene();
            // this.primaryScene=loginscreen.getScene();

            loginStage.setScene(prim2);
            loginStage.show();
            primary.close();

        });

        button7.setOnAction(e->{

            String level= "Level 3";

            reset(layout);
            //primary = loginStage;
            gamplay1.start(loginStage,data,level,name);

            Scene prim2 = gamplay1.getScene();
            // this.primaryScene=loginscreen.getScene();

            loginStage.setScene(prim2);
            loginStage.show();
            primary.close();
        });
    }

    public void disableCircle(int level,HBox region2, HBox region3){

        if(level >4) {

            int count= 8- level;

            switch(level){

                case 5:
                    for(int i=1;i<4;i++){
                        Button testB= (Button) region3.getChildren().get(i);
                        testB.setDisable(true);
                    }
                    break;

                case 6:
                    for(int i=2;i<4;i++){
                        Button testB= (Button) region3.getChildren().get(i);
                        testB.setDisable(true);
                    }
                    break;

                case 7:
                    Button testB= (Button) region3.getChildren().get(3);
                    testB.setDisable(true);

                    break;

                case 8:
                    break;
            }
        }
        else {

            switch(level){

                case 1:

                    for(int j=1;j<4;j++){
                        Button testA= (Button) region2.getChildren().get(j);
                        testA.setDisable(true);

                    }
                    for(int i=0;i<4;i++){
                        Button testB= (Button) region3.getChildren().get(i);
                        testB.setDisable(true);
                    }
                    break;

                case 2:
                    for(int j=2;j<4;j++){
                        Button testA= (Button) region2.getChildren().get(j);
                        testA.setDisable(true);

                    }
                    for(int i=0;i<4;i++){
                        Button testB= (Button) region3.getChildren().get(i);
                        testB.setDisable(true);
                    }
                    break;

                case 3:

                    Button testA= (Button) region2.getChildren().get(3);
                    testA.setDisable(true);

                    for(int i=0;i<4;i++){
                        Button testB= (Button) region3.getChildren().get(i);
                        testB.setDisable(true);
                    }

                    break;

                case 4:
                    for(int i=0;i<4;i++){
                        Button testB= (Button) region3.getChildren().get(i);
                        testB.setDisable(true);
                    }


                    break;
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


        homeB.setOnAction( e->{
            level.start(loginStage2,data);
            Scene prim2= level.getScene();

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

        menu.setStyle("-fx-background-color:#000000");

    }

    public void initStyleT(BorderPane layout){

        titleContainer=new HBox();

        titleContainer.setStyle("-fx-background-color:#000000");

        Label title= new Label("     Welcome to BuzzWord");
        title.setFont(Font.font(70));
        title.setTextFill(Color.WHITE);

        title.setMinWidth(1000);

        titleContainer.getChildren().add(title);

        titleContainer.setAlignment(Pos.CENTER);

        layout.setTop(titleContainer);

    }

    public void reset(BorderPane layout){

        this.layout.getChildren().removeAll();
        this.layout= new BorderPane();


    }


}
