import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by nathangrant
 *
 */


public class LevelSelection {

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
    Level1 level1;
    Button playerB;
    appGUI homescreen;
    Stage loginStage2;

    Stage loginStage;
    GameData data;
    Stage levelSelectionS;


    BorderPane layout;
    Button homeB;
    Button login;
    Button start;
    appGUI gui;
    apptemplate app;

    public LevelSelection(Stage primaryStage) {
        this.primary= primaryStage;

    }

    public LevelSelection(){

    }


    public void start(Stage primaryStage,GameData data1){

        data=data1;
        levelSelectionS=primaryStage;

        layout=new BorderPane();
        loginStage = new Stage();
        loginStage2= new Stage();

        loginStage.setMaxHeight(primaryStage.getMaxHeight());
        loginStage.setMaxWidth(primaryStage.getMaxWidth());
        loginStage.setMinHeight(primaryStage.getMinHeight()-100);
        loginStage.setMinWidth(primaryStage.getMinWidth()-100);

        loginStage2.setMaxHeight(primaryStage.getMaxHeight());
        loginStage2.setMaxWidth(primaryStage.getMaxWidth());
        loginStage2.setMinHeight(primaryStage.getMinHeight()-100);
        loginStage2.setMinWidth(primaryStage.getMinWidth()-100);


        level1= new Level1(loginStage);
        loginscreen= new LoginSucces(loginStage2);
        //homescreen= new appGUI(loginStage);

        initStyleT2();
        initStyleG2();
        initStyleL2();

        //reset(layout);
        primaryScene= new Scene(layout);
        primary.setScene(primaryScene);

    }
    public Stage getLevelSelectionS(){
        return levelSelectionS;
    }

    public void initStyleG2(){
        initStyleG(layout);
    }

    public void initStyleG(BorderPane layout){

        middleDiagram= new VBox(50);

        HBox region1= new HBox(40);
        Label title= new Label("     Famous People");
        title.setFont(Font.font(40));
        title.setTextFill(Color.WHITE);

        title.setMinWidth(100);

        region1.getChildren().add(title);
        button1=new Button("Famous People");

        region1.getChildren().add(button1);

        region1.setStyle("-fx-background-color:#000000");

        HBox region2= new HBox(40);
        Label title2= new Label("     Countries");
        title2.setFont(Font.font(40));
        title2.setTextFill(Color.WHITE);

        title2.setMinWidth(100);

        region2.getChildren().add(title2);
        button2=new Button("Countries");

        region2.getChildren().add(button2);
        region2.setStyle("-fx-background-color:#000000");


        HBox region3= new HBox(40);
        Label title3= new Label("     Dogs");
        title3.setFont(Font.font(40));
        title3.setTextFill(Color.WHITE);

        title3.setMinWidth(100);

        region3.getChildren().add(title3);
        button3=new Button("Dogs");

        region3.getChildren().add(button3);
        region3.setStyle("-fx-background-color:#000000");

        middleDiagram.getChildren().add(region1);
        middleDiagram.getChildren().add(region2);
        middleDiagram.getChildren().add(region3);

        middleDiagram.setAlignment(Pos.CENTER);

        layout.setCenter(middleDiagram);
        button1.setOnAction(e ->{
            reset(layout);
            //primary = loginStage;
            level1.start(loginStage,"Famous People",data);


            Scene prim2 = level1.getScene();


            loginStage.setScene(prim2);
            loginStage.show();

            primary.close();

        });

        button2.setOnAction(e ->{
            reset(layout);

            level1.start(loginStage,"Countries",data);


            Scene prim2 = level1.getScene();

            loginStage.setScene(prim2);
            loginStage.show();

            primary.close();

        });


        button3.setOnAction(e ->{
            reset(layout);

            level1.start(loginStage,"Dogs",data);

            Scene prim2 = level1.getScene();
            // this.primaryScene=loginscreen.getScene();

            loginStage.setScene(prim2);
            loginStage.show();
            primary.close();

        });
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


        homeB= new Button("Home");
        homeB.setMaxWidth(250);
        homeB.setPadding(new Insets(10,10,10,10));

        homeB.setOnAction(e ->{

            reset(layout);

            loginscreen.start(loginStage2,data);
            Scene prim2 = loginscreen.getScene();

            loginStage2.setScene(prim2);
            loginStage2.show();
            primary.close();


        });

        playerB= new Button("Profile");
        playerB.setMaxWidth(250);
        playerB.setPadding(new Insets(10,10,10,10));

        playerB.setOnAction(e->{

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Player Profile");
            alert.setHeaderText("Profile");
            alert.setContentText("Name: "+data.getName()+"\n Famous Level: "+data.getfamousL()+"\n Countries Level: "+data.getcountriesL()+"\n Dogs Level: "+data.getdogsL());

            alert.showAndWait();


        });

        Label home= new Label("Level Selection");
        home.setFont(Font.font(35));

        home.setStyle("-fx-background-color:white");
        //  home.setStyle("-fx-font:100");

        menu.getChildren().add(home);
        menu.getChildren().add(homeB);
        menu.getChildren().add(playerB);

        layout.setPadding(new Insets(0,100,0,0));

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
