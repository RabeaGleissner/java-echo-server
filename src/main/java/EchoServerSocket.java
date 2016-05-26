import java.io.IOException;
import java.net.ServerSocket;

public class EchoServerSocket {
    private ServerSocket serverSocket;

    public EchoServerSocket(int portNumber) {
        try {
            this.serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            System.out.println("Sorry, port number " + portNumber + "is not a correct port.");
        }
    }

    public EchoServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public int getPortNumber() {
        return serverSocket.getLocalPort();
    }

    public void accept() {
        try {
            serverSocket.accept();
        } catch (IOException e) {
            System.out.println("The socket had a problem accepting input");
            System.out.println(e.getMessage());
        }
    }
}
