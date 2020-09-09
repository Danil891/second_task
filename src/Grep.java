import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public ArrayList<String> start() throws IOException {

        ArrayList<String> ss = new ArrayList<String>();

        if (!ilogic && !vlogic && !rlogic ) {
            ss = bot();
        }
        if (!ilogic && !vlogic && rlogic) {
            ss =rBot();
        }
        if (!ilogic && vlogic && !rlogic) {
            ss = vBot();
        }
        if (!ilogic && vlogic && rlogic) {
            ss = vrBot();
        }
        if (ilogic && !vlogic && !rlogic) {
            ss = iBot();
        }
        return ss;
    }

    public ArrayList<String>  sOut(ArrayList<Integer> temp) throws IOException {
        ArrayList<String> strings = new ArrayList<>(Files.readAllLines(get("checkFile.txt")));
        ArrayList<String> cOut = new ArrayList<String>();
        for (int i = 0 ; i < strings.size(); i++){
            if (temp.contains(i)) cOut.add(strings.get(i));
        }
        return cOut;
    }

    public ArrayList<String>  bot() throws IOException {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int counter = 0;
        for (String line : Files.readAllLines(Paths.get("checkFile.txt"))){
            array = line.split( "[\" \"\\,\\&\\.\\-\\;\\:\"...\"]");
            for (String element: array){
                //System.out.println(word);
                if (element.equals( word )) temp.add(counter);

            }
            counter++;
        }
        return sOut(temp);
    }

    public ArrayList<String>  rBot() throws IOException {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int counter = 0;
        for (String line : Files.readAllLines(Paths.get("checkFile.txt"))) {
            Pattern pattern = Pattern.compile(word);
            Matcher match = pattern.matcher(line);
            while (match.find()){
                temp.add(counter);
            }
            counter++;
        }
        return sOut(temp);
    }

    public ArrayList<String>  vBot() throws IOException {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int counter = 0;
        for (String line : Files.readAllLines(Paths.get("checkFile.txt"))) {
            array = line.split( "[\" \"\\,\\&\\.\\-\\;\\:\"...\"\\']");
            if (!line.contains(word)) temp.add(counter);
            counter++;
        }
        return sOut(temp);
    }

    public ArrayList<String>  vrBot() throws IOException {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int counter = 0;
        for (String line : Files.readAllLines(Paths.get("checkFile.txt"))) {
            array = line.split( "[\" \"\\,\\&\\.\\-\\;\\:\"...\"\\']");
            for (String element : array) {
                if (!element.matches(word)) temp.add(counter);
            }
            counter++;
        }
        return sOut(temp);

    }

    public ArrayList<String>  iBot() throws IOException {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int counter = 0;
        for (String line : Files.readAllLines(Paths.get("checkFile.txt"))){
            array = line.split( "[\" \"\\,\\&\\.\\-\\;\\:\"...\"\\']");
            for (int i = 0; i < array.length; i++) array[i] = array[i].toLowerCase();
            for (String element: array){
                if (element.equals( word.toLowerCase() )) temp.add(counter);
            }
            counter++;
        }
        return sOut(temp);
    }
}
