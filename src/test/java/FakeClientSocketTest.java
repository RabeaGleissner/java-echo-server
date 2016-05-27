import org.junit.Test;

import java.io.*;

import static junit.framework.TestCase.assertEquals;

public class FakeClientSocketTest {

    @Test
    public void printsWhatWasWrittenToOutputStream() {
        FakeClientSocket fakeClientSocket = new FakeClientSocket();

        ByteArrayOutputStream outputStream = fakeClientSocket.getOutputStream();
        PrintWriter out = new PrintWriter(outputStream, true);
        out.println("hello");

        assertEquals("hello\n", fakeClientSocket.printedMessage());
    }

    @Test
    public void readsGivenInput() throws IOException {
        FakeClientSocket fakeClientSocket = new FakeClientSocket();
        fakeClientSocket.setInput("hello");

        InputStream inputStream = fakeClientSocket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader in = new BufferedReader(inputStreamReader);
        String input = in.readLine();

        assertEquals("hello", input);
    }
}
