import com.fasterxml.jackson.core.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by nathangrant
 */
public class HandleEvents {

    private ArrayList name;
    private ArrayList level;
    private ArrayList Levels;
    private ArrayList words;
    private ArrayList Target;
    private ArrayList guessedWords;
    private GameData data;
    private File file;

    public static final String LEVELS="LEVELS";
    public static final String NAMES="NAMES";
    public static final String FAMOUSL="FAMOUSL";
    public static final String DOGSL="DOGSL";
    public static final String COUNTRIESL="COUNTRIESL";


    public void saveData(GameData data, Path to) {



        name= new ArrayList();
        level= new ArrayList();
        Levels= new ArrayList();

        FileReader file3= null;

        try {
            file3 = new FileReader(to.toFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader file4= new BufferedReader(file3);

        File starting = new File(System.getProperty("user.dir"));
        file= new File(starting,"219game.txt");
        Path from= Paths.get(file.getAbsolutePath());

        ArrayList test= new ArrayList();
        ArrayList Leveltest= new ArrayList();



        JsonFactory jsonFactory = new JsonFactory();
        OutputStream out= null;
        try {
            if(file4.readLine()==null) {
                out = Files.newOutputStream(to);
                JsonGenerator generator = jsonFactory.createGenerator(out, JsonEncoding.UTF8);

                generator.writeStartObject();
                generator.writeFieldName(NAMES);

                name.add(data.getName());
                generator.writeStartArray(name.size());

                for (int i = 0; i < name.size(); i++) {

                    generator.writeString(name.get(i).toString());
                }
                generator.writeEndArray();

                generator.writeFieldName(LEVELS);
                generator.writeStartArray(name.size());

                level.add(1);
                data.setFamousL(1);

                level.add(1);
                data.setCountriesL(1);

                level.add(1);
                data.setDogsL(1);

                Levels.add(level);

                for (int i = 0; i < name.size(); i++) {

                    generator.writeString(Levels.get(i).toString());
                }
                generator.writeEndArray();
                generator.writeEndObject();

                generator.close();
            }
            else{

                JsonParser jsonParser = jsonFactory.createParser(Files.newInputStream(from));
                out = Files.newOutputStream(to);
                JsonGenerator generator = jsonFactory.createGenerator(out, JsonEncoding.UTF8);

                generator.writeStartObject();
                generator.writeFieldName(NAMES);
                name.add(data.getName());

                level.add(data.getfamousL());
                level.add(data.getcountriesL());
                level.add(data.getdogsL());
                Levels.add(level);

                while(!jsonParser.isClosed()){
                    JsonToken token= jsonParser.nextToken();

                    if(JsonToken.FIELD_NAME.equals(token)){
                        String fieldname= jsonParser.getCurrentName();

                        switch(fieldname){

                            case(NAMES):
                                jsonParser.nextToken();
                                while(jsonParser.nextToken() != JsonToken.END_ARRAY)
                                    //jsonParser.nextToken();
                                    test.add(jsonParser.getText());
                                break;

                            case(LEVELS):
                                jsonParser.nextToken();
                                while(jsonParser.nextToken() != JsonToken.END_ARRAY)
                                    Leveltest.add(jsonParser.getText());
                                break;

                        }
                    }
                }

                for(int i=0;i<test.size();i++){

                    name.add(test.get(i));
                }

                for(int i=0;i<Leveltest.size();i++){
                    Levels.add(Leveltest.get(i));
                }
                generator.writeStartArray(name.size());

                for (int i = 0; i < name.size(); i++) {

                    generator.writeString(name.get(i).toString());
                }

                generator.writeEndArray();

                generator.writeFieldName(LEVELS);
                generator.writeStartArray(Levels.size());

                for (int i = 0; i < Levels.size(); i++) {

                    generator.writeString(Levels.get(i).toString());
                }
                generator.writeEndArray();
                generator.writeEndObject();

                generator.close();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadData(){
    }

    public boolean matchesData(String name,Path from,GameData data1) {
        data=data1;

        JsonFactory jsonFactory = new JsonFactory();
        ArrayList test= new ArrayList();
        ArrayList Levels= new ArrayList();
        try {
            JsonParser jsonParser = jsonFactory.createParser(Files.newInputStream(from));

            while(!jsonParser.isClosed()){
                JsonToken token= jsonParser.nextToken();

                if(JsonToken.FIELD_NAME.equals(token)){
                    String fieldname= jsonParser.getCurrentName();

                    switch(fieldname){

                        case(NAMES):
                            jsonParser.nextToken();
                            while(jsonParser.nextToken() != JsonToken.END_ARRAY)
                              //jsonParser.nextToken();
                              test.add(jsonParser.getText());
                            break;


                        case(LEVELS):
                            jsonParser.nextToken();
                            while(jsonParser.nextToken() != JsonToken.END_ARRAY)
                                //jsonParser.nextToken();
                                Levels.add(jsonParser.getText());
                            break;
                    }
                }
            }

            int j=0;

            boolean decision=false;
            for(int i=0;i<test.size();i++){
                String name1=test.get(i).toString();

                if(name1.compareTo(name)==0){
                    data.setName(name);
                    decision=true;
                            break;

                }
                else
                    j++;
            }

            if(decision==true) {

                String level = (String) Levels.get(j);
                int a = Integer.parseInt(String.valueOf(level.charAt(1)));
                int b = Integer.parseInt(String.valueOf(level.charAt(4)));
                int c = Integer.parseInt(String.valueOf(level.charAt(7)));


                data.setFamousL(a);
                data.setCountriesL(b);
                data.setDogsL(c);

                return true;
            }
            else
                return false;


        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
