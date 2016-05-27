import java.net.ServerSocket;

public class EchoServerSocket implements  AutoCloseable {
    private ServerSocket serverSocket;
    private EchoClientSocket clientSocket;

    public EchoServerSocket(EchoClientSocket clientSocket, ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        this.clientSocket = clientSocket;
    }

    public int getPortNumber() {
        return serverSocket.getLocalPort();
    }

    public EchoClientSocket accept() {
        return clientSocket;
    }

    public void close() throws Exception {

    }
}
