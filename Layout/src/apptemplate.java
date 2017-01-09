/**
 * Created by nathangrant
 *
 */

import javafx.application.Application;
import javafx.stage.Stage;


public class apptemplate extends Application{

    public appGUI gui;

    public int maxH= 1000;
    public int maxW=1000;
    public int minH=600;
    public int minW=800;
    public GameData game;



    public void start(Stage primaryStage) throws Exception {
        primaryStage.setMaxHeight(maxH);
        primaryStage.setMaxWidth(maxW);
        primaryStage.setMinHeight(minH);
        primaryStage.setMinWidth(minW);

        game= new GameData();
        gui= new appGUI(primaryStage,game);
        primaryStage.show();

    }

    public appGUI getGUI(){
        return this.gui;
    }


}
