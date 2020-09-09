import java.nio.file.Files;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.nio.file.Paths;

import static java.nio.file.Paths.get;

public class Main {
    public static void main(String[] args) throws IOException {
        GrepCount start = new GrepCount(args);
        boolean ilogic = start.getIlogic();
        boolean rlogic = start.getRlogic();
        boolean vlogic = start.getVlogic();
        String word = start.getWord();
        String file = start.getFilename();
        Grep grep = new Grep(ilogic, vlogic, rlogic, word, file);
        grep.start() ;



        ArrayList<String> ss = grep.start() ;
            System.out.println(ss);
    }

}
