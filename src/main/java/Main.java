import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) {
        try {
            EchoServer echoServer = new EchoServer(new EchoServerSocket(new ServerSocket(1234)));
            echoServer.start();
        } catch (IOException e) {
            System.out.println("Port 1234 not available");
            e.printStackTrace();
        }
    }
}
