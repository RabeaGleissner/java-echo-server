import java.io.OutputStream;
import java.net.Socket;

public class ClientSocketSpy extends Socket {

    private boolean outputStreamReturned = false;

    public OutputStream getOutputStream() {
        outputStreamReturned = true;
        return null;
    }

    public boolean wasOutputStreamReturned () {
        return outputStreamReturned;
    }
}
