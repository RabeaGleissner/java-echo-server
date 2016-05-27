import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClientSocket implements AutoCloseable {

    private final Socket clientSocket;

    public EchoClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public OutputStream getOutputStream() {
        try {
            return clientSocket.getOutputStream();
        } catch (IOException e) {
            System.out.println("Could not create output stream");
            System.out.println(e.getMessage());
        }
        return null;
    }

    public InputStream getInputStream() {
        try {
            return clientSocket.getInputStream();
        } catch (IOException e) {
            System.out.println("Could not create input stream");
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
