import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class LevelLayout {

    Random rand;
    ArrayList duplicate;
    ArrayList transfer;
    String level;
    String L;


    public LevelLayout(){

    }

    public void setWords(GridPane diagram, BufferedReader fileL,BufferedReader fileW,String Nlevel){

        this.level=Nlevel;

        for(int i=0;i<level.length();i++){

            if(level.charAt(i)=='1'||level.charAt(i)=='2'||level.charAt(i)=='3'||level.charAt(i)==4){
                L=String.valueOf(level.charAt(i));
            }
        }
        int levelC= Integer.parseInt(L);

        ArrayList container= new ArrayList();
        ArrayList containerW= new ArrayList();


        duplicate= new ArrayList();
        transfer= new ArrayList();
        boolean test1=false;
        boolean test2= false;
        boolean test3=false;

        int sizeC=0;


        try {
                String word;
                while((word=fileL.readLine())!=null) {

                container.add(word);

                }

                for(int i=0;i<diagram.getChildren().size();i++){

                    transfer.add(diagram.getChildren().get(i));
                }
            duplicate(container,duplicate);


            int count=0;
            int j=0;
            while(count<levelC){
                String word2;

                while((word2=fileW.readLine())!=null){

                    if(word2.compareTo("-")==0){
                        break;
                    }
                    else {
                        containerW.add(word2);
                        sizeC++;
                    }
                }

                if(level.compareTo("Level 3")==0) {
                    int layer4= (int) (Math.random()*(29-0))+0;
                    gameplayLayout2(layer4, containerW, count, diagram);
                    count++;
                }
                else{
                    int layer4= (int) (Math.random()*(15-0))+0;
                    gameplayLayout(layer4, containerW, count, diagram);
                    count++;
                }
            }

            if(level.compareTo("Level 3")==0) {

                while (j != 30) {

                    if ((((Button) diagram.getChildren().get(j)).getText().toString().compareTo("") == 0)) {
                        Button button1 = (Button) transfer.get(j);
                        button1.setText(container.get(j).toString());
                    }
                    j++;

                }
            }
            else
            {
                while (j != 16) {

                    if ((((Button) diagram.getChildren().get(j)).getText().toString().compareTo("") == 0)) {
                        Button button1 = (Button) transfer.get(j);
                        button1.setText(container.get(j).toString());
                    }
                    j++;

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void gameplayLayout2(int layer4, ArrayList containerW, int count,GridPane diagram){
        //duplicate(container,duplicate);

        int i=0;
        //int j=0;
        // int m;
        int k=0;


        Button button1= (Button)transfer.get(layer4);
        //((Button) diagram.getChildren().get(layer4)).setText(containerW.get(i).toString());

        while(i<containerW.size() && containerW.get(i).toString().compareTo("-")!=0){

            if((layer4-1)>=0 && ((Button)diagram.getChildren().get(layer4-1)).getText().toString().compareTo("")==0){

                if(layer4==6|| layer4==12|| layer4==18 || layer4==24){
                    if(((Button)diagram.getChildren().get(layer4-6)).getText().toString().compareTo("")==0){
                        layer4 = layer4 - 6;
                        ((Button) diagram.getChildren().get(layer4)).setText(containerW.get(i).toString());
                    }
                    else if(layer4+6<30 && ((Button)diagram.getChildren().get(layer4+6)).getText().toString().compareTo("")==0){
                        layer4= layer4+6;
                        ((Button)diagram.getChildren().get(layer4)).setText(containerW.get(i).toString());
                    }
                    else if(layer4+1<30 && ((Button)diagram.getChildren().get(layer4+1)).getText().toString().compareTo("")==0){
                        layer4= layer4+1;
                        ((Button)diagram.getChildren().get(layer4)).setText(containerW.get(i).toString());

                    }

                }
                else{
                    if(((Button)diagram.getChildren().get(layer4-1)).getText().toString().compareTo("")==0){
                        layer4= layer4-1;
                        ((Button) diagram.getChildren().get(layer4)).setText(containerW.get(i).toString());
                    }

                }
            }

            else if(layer4+1<30 && ((Button)diagram.getChildren().get(layer4+1)).getText().toString().compareTo("")==0){
                if(layer4==5|| layer4==11|| layer4==17|| layer4==23 && ((Button)diagram.getChildren().get(layer4+6)).getText().toString().compareTo("")==0){
                    layer4= layer4+6;
                    ((Button) diagram.getChildren().get(layer4)).setText(containerW.get(i).toString());
                }
                else if(layer4>=0 && layer4+1<30 && ((Button)diagram.getChildren().get(layer4+1)).getText().toString().compareTo("")==0){

                    layer4=layer4+1;
                    ((Button) diagram.getChildren().get(layer4)).setText(containerW.get(i).toString());
                }

            }
            else {
                if(layer4+6<30 && layer4==0 || layer4==1 || layer4==2 || layer4==3 || layer4==4 || layer4==5 && ((Button)diagram.getChildren().get(layer4+6)).getText().toString().compareTo("")==0){
                    layer4=layer4+6;
                    ((Button)diagram.getChildren().get(layer4)).setText(containerW.get(i).toString());
                }
                else if(layer4-6>=0 && layer4==24 ||layer4==25 || layer4==26 || layer4==27 || layer4==28 || layer4==29 && ((Button)diagram.getChildren().get(layer4-6)).getText().toString().compareTo("")==0){
                    layer4=layer4-6;
                    ((Button)diagram.getChildren().get(layer4)).setText(containerW.get(i).toString());
                }
                else if( layer4+6<30 && ((Button)diagram.getChildren().get(layer4+6)).getText().toString().compareTo("")==0){
                    layer4= layer4+6;
                    ((Button) diagram.getChildren().get(layer4)).setText(containerW.get(i).toString());

                }
                else{

                    //layer4= layer4-6;
                    if(((Button)diagram.getChildren().get(layer4-6)).getText().toString().compareTo("")==0) {
                        layer4= layer4-6;
                        ((Button) diagram.getChildren().get(layer4)).setText(containerW.get(i).toString());
                    }

                }
            }
            i++;


        }
        count++;

        for(int m=containerW.size()-1;m>=0;m--){
            containerW.remove(k);
        }



    }

    public void gameplayLayout(int layer4, ArrayList containerW, int count, GridPane diagram){

        int i=0;

        int k=0;


        Button button1= (Button)transfer.get(layer4);


        while(i<containerW.size() && containerW.get(i).toString().compareTo("-")!=0){

            //((Button) diagram.getChildren().get(layer4)).setText(containerW.get(i).toString());

            if((layer4-1)>=0 && ((Button)diagram.getChildren().get(layer4-1)).getText().toString().compareTo("")==0){

                if(layer4==4|| layer4==8|| layer4==12){
                    if(((Button)diagram.getChildren().get(layer4-4)).getText().toString().compareTo("")==0){
                        layer4 = layer4 - 4;
                        ((Button) diagram.getChildren().get(layer4)).setText(containerW.get(i).toString());
                    }
                    else if(layer4+4<16 && ((Button)diagram.getChildren().get(layer4+4)).getText().toString().compareTo("")==0){
                        layer4= layer4+4;
                        ((Button)diagram.getChildren().get(layer4)).setText(containerW.get(i).toString());
                    }
                    else if(layer4+1<16 && ((Button)diagram.getChildren().get(layer4+1)).getText().toString().compareTo("")==0){
                        layer4= layer4+1;
                        ((Button)diagram.getChildren().get(layer4)).setText(containerW.get(i).toString());

                    }
                    else if(layer4-1>=0 &&  ((Button)diagram.getChildren().get(layer4-1)).getText().toString().compareTo("")==0){
                        layer4=layer4-1;
                        ((Button)diagram.getChildren().get(layer4)).setText(containerW.get(i).toString());
                    }
                }
                else{
                    layer4= layer4-1;
                    ((Button) diagram.getChildren().get(layer4)).setText(containerW.get(i).toString());

                }
            }

            else if(layer4+1<16 && ((Button)diagram.getChildren().get(layer4+1)).getText().toString().compareTo("")==0){
                if(layer4==3|| layer4==7|| layer4==11){
                    layer4= layer4+4;
                    ((Button) diagram.getChildren().get(layer4)).setText(containerW.get(i).toString());
                }
                else if(layer4>=0 && layer4+1<16 && ((Button)diagram.getChildren().get(layer4+1)).getText().toString().compareTo("")==0){

                    layer4=layer4+1;
                    ((Button) diagram.getChildren().get(layer4)).setText(containerW.get(i).toString());
                }
            }
            else {
                if(layer4+4<16 && layer4==0 || layer4==1 || layer4==2 || layer4==3 && ((Button)diagram.getChildren().get(layer4+4)).getText().toString().compareTo("")==0){
                    layer4=layer4+4;
                    ((Button)diagram.getChildren().get(layer4)).setText(containerW.get(i).toString());
                }
                else if(layer4-4>=0 && layer4==12 ||layer4==13 || layer4==14 || layer4==15 && ((Button)diagram.getChildren().get(layer4-4)).getText().toString().compareTo("")==0){
                    layer4=layer4-4;
                    ((Button)diagram.getChildren().get(layer4)).setText(containerW.get(i).toString());
                }
                else if( layer4+4<16 && ((Button)diagram.getChildren().get(layer4+4)).getText().toString().compareTo("")==0){
                    layer4= layer4+4;
                    ((Button) diagram.getChildren().get(layer4)).setText(containerW.get(i).toString());

                }
                else{
                    layer4= layer4-4;
                    ((Button) diagram.getChildren().get(layer4)).setText(containerW.get(i).toString());

                }
            }
            i++;


        }
        count++;

        for(int m=containerW.size()-1;m>=0;m--){
            containerW.remove(k);
        }



    }

    public void recursionL(GridPane diagram, int point, ArrayList duplicate,int i){

        ((Button)diagram.getChildren().get(point)).setText(duplicate.get(i).toString());

        if(point>=0){

        }

    }

    public void duplicate(ArrayList container, ArrayList duplicate){

        int size= container.size();

        for(int i=0;i<size-3;i++){

            String test=container.get(i).toString();
            if(test.compareTo("4")==0) {
              // container.remove(i);

                for (int j = i+1; j < i+6; j++) {
                    duplicate.add(container.get(j));

                }
                duplicate.add("-");

                container.remove(i);

            }
                else if(test.compareTo("5")==0) {

                        for(int k=i+1;k<i+6;k++){
                            duplicate.add(container.get(k));
                        }
                        duplicate.add("-");

                container.remove(i);


                    }
        }

    }

}
