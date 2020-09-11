import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;


public class GrepCount {
    @Option(name = "-v", metaVar = "все кроме")
    private boolean vlogic;

    @Option(name = "-r", metaVar = "все по шаблону")
    private boolean rlogic;

    @Option(name = "-i", metaVar = "без регистра")
    private boolean ilogic;

    @Argument(required = true, metaVar = "слово")
    private String word;

    @Argument(required = true, metaVar = "имя файла")
    private String filename;




    /*public GrepCount() {

    }
*/
    public static void main(String[] args) { new GrepCount().launch(args);
    }
    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("You are mistaken\n " +
                    "Use only -v, -i, -r");
            parser.printUsage(System.err);
            System.exit(-2);
        }

        Grep grep = new Grep(ilogic, rlogic, vlogic);

        grep.sOutResult(grep.grepBot(word, filename));
    }

}
 