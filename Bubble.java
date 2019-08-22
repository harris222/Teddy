import java.io.*;
import java.util.*;
import java.awt.*;

public class Bubble {
    private int id;
    private String story;
    private int nChild;
    private int [] nextChilds;
    final static String FNAME_SUFFIX = ".txt";

    Bubble(int id){
        this.id = id;
        //this.story
        //this.nChild = nChild;
        //this.nextChilds = nextChilds;
    } // Bubble

    public void loadFromFile(){
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(id + FNAME_SUFFIX);
        String story = "";
        try {
            BufferedReader s = new BufferedReader(new InputStreamReader(inputStream));

            /* Not really necessary, but the first character of the file is the id, after all */
            this.id = Character.getNumericValue(s.read());
            s.readLine();
            this.nChild = Character.getNumericValue(s.read());
            s.readLine();
            this.nextChilds = new int[this.nChild];
            for (int i = 0; i < getNChild(); i++){
                this.nextChilds[i] = Character.getNumericValue(s.read());
                s.skip(1);
            } // for
            String newLine = "";
            while ((newLine = s.readLine())!= null){
                story += newLine;
                story += "\n";
            }

            this.story = story;

            /* Output in console log for reference */
            System.out.println(story);

            s.close();
        } catch (IOException e){
            System.out.println("IO Error");
        } // try

    } //loadFromFile

    /* get the ID of current story */
    public int getID(){
        return this.id;
    }

    /* For users to jump around the stories */
    public void setID(int id){
        this.id = id;
    }

    public void setStory(String story){
        this.story = story;
    }

    public String getStory(){
        return this.story;
    }

    public int getNChild(){
        return this.nChild;
    }

    public void setNChild(int nChild){
        this.nChild = nChild;
    }

    public void setNextChilds(int [] nextChilds, int nChild){
        this.nextChilds = new int[nChild];
        for (int i = 0; i < nChild; i++){
            this.nextChilds[i] = nextChilds[i];
        } // for
    }

}
