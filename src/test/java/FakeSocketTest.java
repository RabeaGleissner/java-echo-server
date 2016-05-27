import org.junit.Test;

import java.io.*;

import static junit.framework.TestCase.assertEquals;

public class FakeSocketTest {

    @Test
    public void printsWhatWasWrittenToOutputStream() {
        FakeSocket fakeSocket = new FakeSocket();

        ByteArrayOutputStream outputStream = fakeSocket.getOutputStream();
        PrintWriter out = new PrintWriter(outputStream, true);
        out.println("hello");

        assertEquals("hello\n", fakeSocket.printedMessage());
    }

    @Test
    public void readsGivenInput() throws IOException {
        FakeSocket fakeSocket = new FakeSocket();
        fakeSocket.setInput("hello");

        InputStream inputStream = fakeSocket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader in = new BufferedReader(inputStreamReader);
        String input = in.readLine();

        assertEquals("hello", input);

    }
}
