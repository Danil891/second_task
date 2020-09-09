import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;

public class test {
    @Test
    public void bot() throws IOException {
        ArrayList<String> botCheck = new ArrayList<>();
        botCheck.add("I don't wanna be needing your love");
        botCheck.add("I just wanna be deep in your love");


        Grep grep = new Grep(false, false, false, "love" , "checkFile.txt");
        ArrayList<String> expected = grep.bot() ;
        assertEquals(botCheck, expected);

    }
    @Test
    public void vBot() throws IOException {
        ArrayList<String> botCheck = new ArrayList<>();
        botCheck.add("You got me begging, begging");
        botCheck.add("And it's killing me when you're away, ooh, baby");

        Grep grep = new Grep(false, true, false, "I" , "checkFile.txt");
        ArrayList<String> expected = grep.vBot() ;

        assertEquals(botCheck, expected);
    }

    @Test
    public void rBot() throws IOException {
        ArrayList<String> botCheck = new ArrayList<>();

        botCheck.add("I don't wanna be needing your love");
        botCheck.add("I just wanna be deep in your love");
        botCheck.add("I just wanna be there where you are");

        Grep grep = new Grep(false, false, true, "nn" , "checkFile.txt");
        ArrayList<String> expected = grep.rBot() ;

        assertEquals(botCheck, expected);

    }
    @Test
    public void vrBot() throws IOException {
        ArrayList<String> botCheck = new ArrayList<>();

        botCheck.add("You got me begging, begging");
        botCheck.add("I'm on my knees");

        Grep grep = new Grep(false, true, true, "[a]+" , "checkFile.txt");
        ArrayList<String> expected = grep.vrBot() ;

        assertEquals(botCheck, expected);

    }
    @Test
    public void iBot() throws IOException {
        ArrayList<String> botCheck = new ArrayList<>();

        botCheck.add("I don't wanna be needing your love");
        botCheck.add("I just wanna be deep in your love");
        botCheck.add("'Cause I really don't care where you are");
        botCheck.add("I just wanna be there where you are");
        botCheck.add("And I gotta get one little taste");

        Grep grep = new Grep(true, false, false, "i" , "checkFile.txt");
        ArrayList<String> expected = grep.iBot() ;

        assertEquals(botCheck, expected);


    }
    @Test
    public  void ivBot() throws IOException {
        ArrayList<String> botCheck = new ArrayList<>();
        botCheck.addAll(Files.readAllLines(Paths.get("checkFile.txt")));

        Grep grep = new Grep(true, true, false, "AnD" , "checkFile.txt");

        ArrayList<String> expected = grep.ivBot() ;
        assertEquals(botCheck, expected);
    }
}
