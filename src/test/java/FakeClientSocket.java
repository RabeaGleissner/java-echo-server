import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FakeClientSocket extends Socket {

    private ByteArrayOutputStream outputStream;
    private List<String> message;

    public FakeClientSocket() {
        message = new LinkedList<>();
    }

    public ByteArrayOutputStream getOutputStream() {
         outputStream = new ByteArrayOutputStream();
        return outputStream;
    }

    public String printedMessage() {
        return outputStream.toString();
    }

    public void input(String ... input) {
        message.addAll(Arrays.asList(input));
    }

    public InputStream getInputStream() {
        String word = message.remove(0);
        return new ByteArrayInputStream(word.getBytes());
    }
}
