public class GrepCount {
    private String[] args;
    private boolean ilogic = false;
    private boolean vlogic = false;
    private boolean rlogic = false;
    private String word;
    private String filename;

    public GrepCount(String[] args) {
        this.args = args;
        int index;

        for (index = 0; index < args.length; index++){
            switch (args[index]){
                case "-i":
                    ilogic = true;
                    break;
                case "-v":
                    vlogic = true;
                    break;
                case "-r":
                    rlogic = true;
                    break;
                default:
                    word = args[index];
                    break;
            }
        }
        filename = args[args.length - 1];

    }

    public boolean getIlogic() {
        return ilogic;
    }

    public boolean getRlogic() {
        return rlogic;
    }

    public boolean getVlogic() {
        return vlogic;
    }

    public String getWord() {
        return word;
    }

    public String getFilename() {
        return filename;
    }
}
 