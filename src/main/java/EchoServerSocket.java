import java.io.IOException;
import java.net.ServerSocket;

public class EchoServerSocket {
    private ServerSocket serverSocket;
    private int portNumber;

    public EchoServerSocket(int portNumber) {
        this.portNumber = portNumber;
        try {
            this.serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            System.out.println("Sorry, port number " + portNumber + "is not a correct port.");
        }
    }

    public int getPortNumber() {
        return serverSocket.getLocalPort();
    }
}
