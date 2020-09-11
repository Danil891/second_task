import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class test {
    @Test
    public void bot() {
        ArrayList<String> botCheck = new ArrayList<>();
        botCheck.add("I don't wanna be needing your love");
        botCheck.add("I just wanna be deep in your love");

        Grep grep = new Grep(false, false, false);

        ArrayList<String> expected = grep.grepBot("love", "checkFile.txt") ;
        assertEquals(botCheck, expected);

    }
    @Test
    public void vBot() {
        ArrayList<String> botCheck = new ArrayList<>();

        botCheck.add("You got me begging, begging");
        botCheck.add("And it's killing me when you're away, ooh, baby");

        Grep grep = new Grep(false, true, false);

        ArrayList<String> expected = grep.grepBot("I", "checkFile.txt") ;

        assertEquals(botCheck, expected);
    }

    @Test
    public void rBot() {
        ArrayList<String> botCheck = new ArrayList<>();

        botCheck.add("I don't wanna be needing your love");
        botCheck.add("I just wanna be deep in your love");
        botCheck.add("I just wanna be there where you are");

        Grep grep = new Grep(false, false, true);

        ArrayList<String> expected = grep.grepBot("nn", "checkFile.txt") ;

        assertEquals(botCheck, expected);

    }

    @Test
    public void vrBot() {
        ArrayList<String> botCheck = new ArrayList<>();

        botCheck.add("You got me begging, begging");
        botCheck.add("I'm on my knees");

        Grep grep = new Grep(false, true, true);

        ArrayList<String> expected = grep.grepBot("[a]+", "checkFile.txt") ;

        assertEquals(botCheck, expected);
    }

    @Test
    public void iBot() throws IOException {
        ArrayList<String> botCheck = new ArrayList<>();

        botCheck.addAll(Files.readAllLines(Paths.get("checkFile.txt")));

        Grep grep = new Grep(true, false, false);

        ArrayList<String> expected = grep.grepBot("i", "checkFile.txt") ;

        assertEquals(botCheck, expected);
    }

    @Test
    public  void ivBot(){

        ArrayList<String> botCheck = new ArrayList<>();
        botCheck.add("I'm something weak");
        botCheck.add("You got me begging, begging");
        botCheck.add("I'm on my knees");
        botCheck.add("I don't wanna be needing your love");
        botCheck.add("I just wanna be deep in your love");
        botCheck.add("'Cause I really don't care where you are");
        botCheck.add("I just wanna be there where you are");

        Grep grep = new Grep(true, true, false);

        ArrayList<String> expected = grep.grepBot("AnD", "checkFile.txt");

        assertEquals(botCheck, expected);
    }

    @Test void irBot(){
        ArrayList<String> botCheck = new ArrayList<>();

        botCheck.add("You got me begging, begging");
        botCheck.add("I don't wanna be needing your love");
        botCheck.add("I just wanna be deep in your love");
        botCheck.add("And it's killing me when you're away, ooh, baby");
        botCheck.add("'Cause I really don't care where you are");
        botCheck.add("I just wanna be there where you are");

        Grep grep = new Grep(true, false, true);

        ArrayList<String> expected = grep.grepBot("[U]+", "checkFile.txt");

        assertEquals(botCheck, expected);
    }

    @Test void ivrBot(){
        ArrayList<String> botCheck = new ArrayList<>();

        botCheck.add("I'm something weak");
        botCheck.add("You got me begging, begging");
        botCheck.add("I'm on my knees");
        botCheck.add("I just wanna be there where you are");

        Grep grep = new Grep(true, true, true);

        ArrayList<String> expected = grep.grepBot("[L]", "checkFile.txt");

        assertEquals(botCheck, expected);

    }
}
