import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClientSocket {

    private final Socket clientSocket;

    public EchoClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public OutputStream getOutputStream() {
        try {
            return clientSocket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
