import java.util.ArrayList;

public class GameData {

    private String name;
    private ArrayList words;
    private ArrayList target;
    private ArrayList guessedWords;
    public HandleEvents handler;

    private int famousL;
    private int dogsL;
    private int countriesL;



    public GameData(){

        words= new ArrayList();
        target= new ArrayList();
        guessedWords= new ArrayList();
        handler= new HandleEvents();
    }

    public String getName()
    {
        return this.name;
    }

    public int getfamousL(){
        return famousL;
    }

    public int getdogsL(){

        return dogsL;
    }

    public int getcountriesL(){
        return countriesL;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setFamousL(int level){

        this.famousL=level;

    }

    public void setCountriesL(int level){
        this.countriesL=level;
    }

    public void setDogsL(int level){
        this.dogsL=level;
    }



    public void loadData(){
    }

    public void matchesData(){


    }
}
