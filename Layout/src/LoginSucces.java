import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by nathangrant
 */

public class LoginSucces  {

    Stage primary;
    Stage loginStage;
    GridPane diagram;
    Button button1;
    GameData data;

    Scene primaryScene;
    VBox menu;
    HBox titleContainer;
    LoginSucces loginscreen;
    LevelSelection level;




    BorderPane layout;
    Button gameMode;
    Button login;
    Button start;
    Button profile;

    appGUI gui;
    apptemplate app;

    public LoginSucces(Stage primaryStage) {
        this.primary= primaryStage;

    }

    public LoginSucces(){

    }

    public BorderPane getLayout(){
        return layout;
    }


    public void start(Stage primaryStage,GameData data1){

        data=data1;

        layout=new BorderPane();
         loginStage = new Stage();

        loginStage.setMaxHeight(primaryStage.getMaxHeight());
        loginStage.setMaxWidth(primaryStage.getMaxWidth());
        loginStage.setMinHeight(primaryStage.getMinHeight());
        loginStage.setMinWidth(primaryStage.getMinWidth());

        level= new LevelSelection(loginStage);
        initStyleT2();
        initStyleG2();
        initStyleL2();


        //reset(layout);
        primaryScene= new Scene(layout);
        primary.setScene(primaryScene);
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

        start= new Button("About this Game");
        start.setMaxWidth(230);
        start.setPadding(new Insets(10,10,10,10));

        start.setOnAction(e->{

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About this game");
            alert.setHeaderText("Game");
            alert.setContentText("BuzzWord is an educational game that allows \nplayers to connect word together and score points");

            alert.showAndWait();


        });

        profile= new Button("Profile");
        profile.setMaxWidth(230);
        profile.setPadding(new Insets(10,10,10,10));

        profile.setOnAction(e->{

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Player Profile");
            alert.setHeaderText("Profile");
            alert.setContentText("Name: "+data.getName()+"\n Famous Level: "+data.getfamousL()+"\n Countries Level: "+data.getcountriesL()+"\n Dogs Level: "+data.getdogsL());

            alert.showAndWait();


        });

        login = new Button("Pick Game Mode");
        login.setMaxWidth(230);
        login.setPadding(new Insets(10,10,10,10));

        Label home= new Label("Home Screen");
        home.setFont(Font.font(35));

        home.setStyle("-fx-background-color:white");
        //  home.setStyle("-fx-font:100");

        menu.getChildren().add(home);

        menu.getChildren().add(login);
        menu.getChildren().add(start);
        menu.getChildren().add(profile);


        // layout=new BorderPane();
        layout.setPadding(new Insets(0,100,0,0));

        layout.setStyle("-fx-background-color:#DCDCDC");
        layout.setLeft(menu);


        menu.setStyle("-fx-background-color:#000000");

        login.setOnAction(e-> {
            reset(layout);

            level.start(loginStage,data);

            Scene prim2 = level.getScene();
            // this.primaryScene=loginscreen.getScene();

            loginStage.setScene(prim2);
            loginStage.show();
            primary.close();

        });
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
