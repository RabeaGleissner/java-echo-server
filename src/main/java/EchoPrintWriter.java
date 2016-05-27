import java.io.PrintWriter;

public class EchoPrintWriter {

    private final PrintWriter printWriter;

    public EchoPrintWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public void println(String message) {
        printWriter.println(message);
    }
}
