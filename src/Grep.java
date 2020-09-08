import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.Paths.get;

public class Grep {
    private boolean ilogic;
    private boolean vlogic;
    private boolean rlogic;
    private String word;
    private String file;
    private String[] array;

    public Grep(boolean ilogic, boolean vlogic, boolean rlogic, String word, String file){
        this.ilogic = ilogic;
        this.rlogic = rlogic;
        this.vlogic = vlogic;
        this.word = word;
        this.file = file;
    }

    public void bot() throws IOException {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int counter = 0;
        for (String line : Files.readAllLines(Paths.get("/checkFile"))){
            array = line.split( " ");
            for (String element: array){
                if (element.equals( word )) temp.add(counter);

            }
            counter++;
        }
    }

    public void rBot() throws IOException {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int counter = 0;
        for (String line : Files.readAllLines(Paths.get("/checkFile"))) {
            array = line.split(" ");
            for (String element : array) {
                if (element.matches(word)) temp.add(counter);
            }
            counter++;
        }
    }

    public void vBot() throws IOException {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int counter = 0;
        for (String line : Files.readAllLines(Paths.get("/checkFile"))) {
            array = line.split(" ");
            if (!line.contains(word)) temp.add(counter);
            counter++;
        }
    }

    public void iBot() throws IOException {
        ArrayList<String> iArray = new ArrayList<String>();
        for (String line : Files.readAllLines(Paths.get("/checkFile"))){
            iArray.add(line.toLowerCase());
        }
    }



}
