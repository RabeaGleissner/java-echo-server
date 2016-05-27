import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public void start(String[] args) {
        int portNumber = Integer.parseInt(args[0]);
        try (
                EchoServerSocket serverSocket = new EchoServerSocket(
                        new EchoClientSocket(new Socket()), new ServerSocket(portNumber));
                EchoClientSocket clientSocket = serverSocket.accept();
                OutputStream outputStream = clientSocket.getOutputStream();

                )
                {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
