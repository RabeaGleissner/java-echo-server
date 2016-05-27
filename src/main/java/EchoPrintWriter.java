import java.io.PrintWriter;

public class EchoPrintWriter implements AutoCloseable {

    private final PrintWriter printWriter;

    public EchoPrintWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public void println(String message) {
        printWriter.println(message);
    }

    @Override
    public void close() throws Exception {
        printWriter.close();
    }
}