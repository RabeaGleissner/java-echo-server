import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerSocket extends ServerSocket {
    private ServerSocket serverSocket;

    public EchoServerSocket(ServerSocket serverSocket) throws IOException {
        super();
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
}
