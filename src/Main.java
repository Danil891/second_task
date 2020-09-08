public class Main {
    public static void main(String[] args){
        GrepCount start = new GrepCount(args);
        boolean ilogic = start.getIlogic();
        boolean rlogic = start.getRlogic();
        boolean vlogic = start.getVlogic();
        String word = start.getWord();
        String file = start.getFilename();
        Grep grep = new Grep(ilogic, rlogic, vlogic, word, file);
        grep.bot();
    }


}
