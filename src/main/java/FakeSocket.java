import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class FakeSocket extends Socket {

    private ByteArrayOutputStream outputStream;
    private String message;

    public ByteArrayOutputStream getOutputStream() {
         outputStream = new ByteArrayOutputStream();
        return outputStream;
    }

    public String printedMessage() {
        return outputStream.toString();
    }

    public void setInput(String input) {
        message = input;
    }
    public InputStream getInputStream() {
        return new ByteArrayInputStream(message.getBytes());
    }
}
