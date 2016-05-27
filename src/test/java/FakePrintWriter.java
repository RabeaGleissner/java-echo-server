import java.io.PrintWriter;
import java.io.Writer;

public class FakePrintWriter extends PrintWriter {

    private String printedMessage;

    public FakePrintWriter(Writer out, boolean autoFlush) {
        super(out, autoFlush);
    }

    public void println(String message) {
       printedMessage = message;
    }

    public String messagePrinted() {
        return printedMessage;
    }
}
