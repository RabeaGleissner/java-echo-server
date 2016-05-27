import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class EchoPrintWriterTest {

    @Test
    public void printsMessageToOutputStream() throws IOException {
        FakePrintWriter fakePrintWriter = new FakePrintWriter(new StringWriter(1), true);
        EchoPrintWriter echoPrintWriter = new EchoPrintWriter(fakePrintWriter);
        String message = "hello";

        echoPrintWriter.println(message);

        assertEquals(message, fakePrintWriter.messagePrinted());
    }
}