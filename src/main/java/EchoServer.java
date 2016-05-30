import java.io.*;
import java.net.Socket;

public class EchoServer {

    private final EchoServerSocket echoServerSocket;

    public EchoServer(EchoServerSocket echoServerSocket) {
        this.echoServerSocket = echoServerSocket;
    }

    public void start() {
        Socket clientSocket = echoServerSocket.accept();
        String message = readClientMessage(clientSocket);
        while (!(message).equals("stop")) {
            sendMessageToClient(message, clientSocket);
            message = readClientMessage(clientSocket);
        }
    }

    public String readClientMessage(Socket socket) {
        try {
            BufferedReader clientReader= createClientReader(socket);
            return clientReader.readLine();
        } catch (IOException e) {
            System.out.println("Couldn't get input stream");
        }
        return "";
    }

    public void sendMessageToClient(String message, Socket socket) {
        try {
            PrintWriter sender = createClientSender(socket);
            sender.println(message);
        } catch (IOException e) {
            System.out.println("Couldn't get output stream");
        }
    }

    private BufferedReader createClientReader(Socket socket) throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    private PrintWriter createClientSender(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        return new PrintWriter(outputStream, true);
    }
}
