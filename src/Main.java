import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GrepCount start = new GrepCount(args);
        boolean ilogic = start.getIlogic();
        boolean rlogic = start.getRlogic();
        boolean vlogic = start.getVlogic();
        String word = start.getWord();
        String file = start.getFilename();
        Grep grep = new Grep(ilogic, rlogic, vlogic, word, file);
        grep.start() ;
    }


}
