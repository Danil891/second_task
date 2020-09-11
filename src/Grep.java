import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grep {
    private boolean ilogic;
    private boolean vlogic;
    private boolean rlogic;

    public Grep (boolean ilogic, boolean vlogic, boolean rlogic){
        this.ilogic = ilogic;
        this.rlogic = rlogic;
        this.vlogic = vlogic;
    }

    public ArrayList<String> grepBot(String word, String file) {
        ArrayList<String> strings = new ArrayList<>();
        String regex = word;
            Pattern ignIsSelected;
            if (!rlogic) regex = Pattern.quote(word);

            if (ilogic) ignIsSelected = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);

            else ignIsSelected = Pattern.compile(regex);

            try (BufferedReader reader = Files.newBufferedReader(Paths.get(file))) {
                Matcher matcher;
                String currentLine;
                while ((currentLine = reader.readLine()) != null) {
                    matcher = ignIsSelected.matcher(currentLine);
                    if (matcher.find() != vlogic) strings.add(currentLine);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return strings;
        }
    public void sOutResult(ArrayList<String> result) {
        for (String string : result) {
            System.out.println(string);
        }
    }
}

