import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketSpy extends ServerSocket {
    public boolean acceptWasCalled = false;

    public ServerSocketSpy() throws IOException {
    }

    public Socket accept() {
        acceptWasCalled = true;
        return null;
    }
}
