import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class FakeClientSocket extends Socket {

    private ByteArrayOutputStream outputStream;
    private String message;

    public ByteArrayOutputStream getOutputStream() {
         outputStream = new ByteArrayOutputStream();
        return outputStream;
    }

    public String printedMessage() {
        return outputStream.toString();
    }

    public void setInput(String input) throws IOException {
        message = input;
        if (outputStream != null) {
            outputStream.write(input.getBytes());
        }
    }

    public InputStream getInputStream() {
        return new ByteArrayInputStream(message.getBytes());
    }
}
