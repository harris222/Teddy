import java.io.*;
import java.util.*;
import java.awt.*;

public class Bubble {
    private int id;
    private String story;
    private int nChild;
    private int [] nextChilds = new int[3];
    final static String FNAME_SUFFIX = ".txt";

    Bubble(int id){
        this.id = id;
        //this.story
        //this.nChild = nChild;
        //this.nextChilds = nextChilds;
    } // Bubble

    public void loadFromFile(){
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(getID() + FNAME_SUFFIX);
        String story = "";
        Scanner s = new Scanner(inputStream);
        setID(s.nextInt());
        setNChild(s.nextInt());
        int [] nextChilds = new int[getNChild()];
        for (int i = 0; i < getNChild(); i++){
            nextChilds[i] = s.nextInt();
        } // for
        setNextChilds(nextChilds, getNChild());
        while (s.hasNextLine()){
            story += s.nextLine();
            story += "\n";
        }
        System.out.println(story);
        setStory(story);
        s.close();

    }

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
        for (int i = 0; i < nChild; i++){
            this.nextChilds[i] = nextChilds[i];
        } // for
    }

}
