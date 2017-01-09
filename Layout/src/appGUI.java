import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Paths;


/**
 * Created by nathangrant
 */


public class appGUI {
    Stage primary;
    Stage loginStage;
    GameData data;
    File file;

    Scene primaryScene;
    VBox menu;
    HBox titleContainer;
    LoginSucces loginscreen;


    BorderPane layout;
    BorderPane layout2;
    Button createNewProf;
    Button login;
    apptemplate app;
    GridPane diagram;
    Button button1;
    boolean test;



    public appGUI( Stage primaryStage, GameData data1){
        this.primary=primaryStage;
        data= data1;
        File starting = new File(System.getProperty("user.dir"));
        file= new File(starting,"219game.txt");

      //  loginStage= primaryStage;

        layout=new BorderPane();
        //Added new BorderPane

        layout2= new BorderPane();
        //loginscreen= new LoginSucces();
        loginStage= new Stage();

        loginStage.setMaxHeight(primaryStage.getMaxHeight());
        loginStage.setMaxWidth(primaryStage.getMaxWidth());
        loginStage.setMinHeight(primaryStage.getMinHeight());
        loginStage.setMinWidth(primaryStage.getMinWidth());
        loginscreen= new LoginSucces(loginStage);

        initStyleT2();
        initStyleG2();
        initStyleL2();

    }

    private void initStyleG2() {
        initStyleG(layout);

    }

    private void initStyleG(BorderPane layout) {

        diagram= new GridPane();
        diagram.setHgap(20);
        diagram.setVgap(20);
        diagram.setPadding(new Insets(150,150,150,150));

        int j=0;
        int i=0;

        while(i<4){

            button1=new Button();
            int r= 100;
            button1.setShape(new Circle(r));
            button1.setMinHeight(50);
            button1.setMinWidth(50);

            button1.setStyle("-fx-background-color:black");

            diagram.add(button1,j,i);

            if(j==3){
                j=0;
                i++;
            }
            else
                j++;
        }

        Button button1= (Button) diagram.getChildren().get(0);
        Button button2= (Button) diagram.getChildren().get(1);
        Button button3= (Button) diagram.getChildren().get(2);
        Button button4= (Button) diagram.getChildren().get(3);
        Button button5= (Button) diagram.getChildren().get(4);
        Button button6= (Button) diagram.getChildren().get(5);
        Button button7= (Button) diagram.getChildren().get(6);
        Button button8= (Button) diagram.getChildren().get(7);
        Button button9= (Button) diagram.getChildren().get(8);
        Button button10= (Button) diagram.getChildren().get(9);
        Button button11= (Button) diagram.getChildren().get(10);
        Button button12= (Button) diagram.getChildren().get(11);
        Button button13= (Button) diagram.getChildren().get(12);
        Button button14= (Button) diagram.getChildren().get(13);
        Button button15= (Button) diagram.getChildren().get(14);
        Button button16= (Button) diagram.getChildren().get(15);

        button1.setText("B");

        button1.setStyle("-fx-text-fill:white;-fx-background-color:black");
        //button1.setStyle("-fx-background-color:black");

        button2.setText("U");
        button2.setStyle("-fx-text-fill:white;-fx-background-color:black");


        button5.setText("Z");
        button5.setStyle("-fx-text-fill:white;-fx-background-color:black");

        button6.setText("Z");
        button6.setStyle("-fx-text-fill:white;-fx-background-color:black");


        button11.setText("W");
        button11.setStyle("-fx-text-fill:white;-fx-background-color:black");

        button12.setText("O");
        button12.setStyle("-fx-text-fill:white;-fx-background-color:black");


        button15.setText("R");
        button15.setStyle("-fx-text-fill:white;-fx-background-color:black");

        button16.setText("D");
        button16.setStyle("-fx-text-fill:white;-fx-background-color:black");

        layout.setCenter(diagram);

    }

    public Stage returnStage(){
        return primary;
    }


    public void initStyleT2(){
        initStyleT(layout);
    }

    public void initStyleL2(){
        initStyleL(layout);
    }



    public void initStyleL(BorderPane layout){
        menu=new VBox(25);

        primaryScene= new Scene(layout);
        primary.setScene(primaryScene);

        createNewProf= new Button("Create New Profile");
        createNewProf.setMaxWidth(230);
        createNewProf.setPadding(new Insets(10,10,10,10));

        createNewProf.setOnAction( e->{

            loginscreen.start(loginStage,data);
            Scene prim2 = loginscreen.getScene();

            Stage loginStage3= new Stage();
            loginStage3.setMaxHeight(400);
            loginStage3.setMaxWidth(390);
            loginStage3.setMinHeight(250);
            loginStage3.setMinWidth(390);

            GridPane loginGame2= new GridPane();
            loginGame2.setStyle("-fx-background-color:#000000");

            loginGame2.setVgap(20);
            loginGame2.setHgap(20);

            TextField text1=  new TextField();
            TextField text2=  new TextField();

            Label name1= new Label("First Name:");
            name1.setTextFill(Color.WHITE);
            Label name2= new Label("Last Name:");
            name2.setTextFill(Color.WHITE);

            Label title= new Label("Welcome To BuzzWord!");
            title.setTextFill(Color.WHITE);

            Button login3= new Button("Sign in");


            login3.setOnAction(event -> loginStage3.close());


            loginGame2.add(title,0,0);
            loginGame2.add(name1,0,1);
            loginGame2.add(text1,1,1);
            loginGame2.add(name2,0,2);
            loginGame2.add(text2,1,2);
            loginGame2.add(login3,0,3);


            Scene scene2= new Scene(loginGame2,200,200);

            loginStage3.setScene(scene2);
            loginStage3.showAndWait();

            data.setName(text1.getText());
            data.handler.saveData(data, Paths.get(file.getAbsolutePath()));

           // login3.setOnAction(event -> loginStage.close());
            loginStage.show();

            primary.close();

            primary.setScene(prim2);

            this.primaryScene=prim2;
            setBorderPane(loginscreen.getLayout());

            loginStage.setScene(prim2);



        });

        login = new Button("Login");
        login.setMaxWidth(230);
        login.setPadding(new Insets(10,10,10,10));

        Label home= new Label("Home Screen");
        home.setFont(Font.font(35));

        home.setStyle("-fx-background-color:white");
      //  home.setStyle("-fx-font:100");

        menu.getChildren().add(home);
        menu.getChildren().add(createNewProf);
        menu.getChildren().add(login);


       // layout=new BorderPane();
        layout.setPadding(new Insets(0,100,0,0));


        layout.setStyle("-fx-background-color:#DCDCDC");

        layout.setLeft(menu);

        menu.setStyle("-fx-background-color:#000000");


        login.setOnAction(e-> {
            test=false;

            loginscreen.start(loginStage,data);

            Scene prim2 = loginscreen.getScene();

            Stage loginStage2= new Stage();
            loginStage2.setMaxHeight(200);
            loginStage2.setMaxWidth(290);
            loginStage2.setMinHeight(170);
            loginStage2.setMinWidth(270);

            GridPane loginGame= new GridPane();
            loginGame.setStyle("-fx-background-color:#000000");
            loginGame.setVgap(20);
            loginGame.setHgap(20);

            TextField text1=  new TextField();
            TextField text2=  new TextField();

            Label name1= new Label("First Name:");
            name1.setTextFill(Color.WHITE);
            Label name2= new Label("Last Name:");
            name2.setTextFill(Color.WHITE);
            //String name6=text1.getText();

            Button loginB= new Button("Login");

            loginGame.add(name1,0,0);
            loginGame.add(name2,0,1);
            loginGame.add(text1,1,0);
            loginGame.add(text2,1,1);
            loginGame.add(loginB,0,2);

            Scene scene1= new Scene(loginGame,200,200);

            loginStage2.setScene(scene1);
            loginStage2.show();
           // String name6=text1.getText();


        if(test==false) {
            loginB.setOnAction(event -> {
                String name6=text1.getText();
                if (data.handler.matchesData(name6, Paths.get(file.getAbsolutePath()),data) == true) {

                    data.setName(name6);
                    loginStage2.close();

                    loginStage.show();
                    primary.close();

                    primary.setScene(prim2);

                    this.primaryScene = prim2;
                    setBorderPane(loginscreen.getLayout());
                    //MESSED UP LAYOUT

                    loginStage.setScene(prim2);

                    this.test=true;
                } else {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Information Dialog");
                    alert.setContentText("This does not match any of the previous logins");

                    alert.showAndWait();

                }

            });
        }

            if(test==true) {

                loginStage.show();
                primary.close();

                primary.setScene(prim2);

                this.primaryScene = prim2;
                setBorderPane(loginscreen.getLayout());

                loginStage.setScene(prim2);
            }

        });
    }

    public void setBorderPane(BorderPane pane){
        this.layout=pane;
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

    public void setStage(Stage new1){

        primary=new1;
    }
}
