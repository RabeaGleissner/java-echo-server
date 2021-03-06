import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FakeClientSocket extends Socket {

    private ByteArrayOutputStream outputStream;
    private final List<String> messages;

    public FakeClientSocket() {
        messages = new LinkedList<>();
    }

    public ByteArrayOutputStream getOutputStream() {
        outputStream = new ByteArrayOutputStream();
        return outputStream;
    }

    public String printedMessage() {
        return outputStream.toString();
    }

    public void input(String ... input) {
        messages.addAll(Arrays.asList(input));
    }

    public InputStream getInputStream() {
        String word = messages.remove(0);
        return new ByteArrayInputStream(word.getBytes());
    }
}
