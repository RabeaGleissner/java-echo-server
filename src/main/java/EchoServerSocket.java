import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerSocket implements AutoCloseable {
    private ServerSocket serverSocket;

    public EchoServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public Socket accept() {
        try {
            return serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void close() throws Exception {

    }
}
