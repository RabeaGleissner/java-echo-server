import java.io.*;
import java.net.Socket;

public class EchoServer {

    private final EchoServerSocket echoServerSocket;
    private boolean reverse = false;

    public EchoServer(EchoServerSocket echoServerSocket) {
        this.echoServerSocket = echoServerSocket;
    }

    public void start() {
        Socket clientSocket = echoServerSocket.accept();
        String message = readClientMessage(clientSocket);
        while (!(message).equals("stop")) {
            switchModes(message);
            sendMessageToClient(message, clientSocket, reverse);
            message = readClientMessage(clientSocket);
        }
    }

    private void switchModes(String message) {
        if (message.equals("#reverse")) {
            reverse = true;
        }
        if (message.equals("#normal")) {
            reverse = false;
        }
    }

    public boolean isCommand(String message) {
        return (message.equals("#reverse") || message.equals("#normal"));
    }

    public String readClientMessage(Socket socket) {
        try {
            BufferedReader clientReader = createClientReader(socket);
            return clientReader.readLine();
        } catch (IOException e) {
            System.out.println("Couldn't get input stream");
        }
        return "";
    }

    public void sendMessageToClient(String message, Socket socket, Boolean reverse) {
        if (reverse && !isCommand(message)) {
            message = new StringBuilder(message).reverse().toString();
        }

        if (isCommand(message)) {
            message = message.replace("#", "") + " mode activated";
        }

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
        return new PrintWriter(socket.getOutputStream(), true);
    }
}
