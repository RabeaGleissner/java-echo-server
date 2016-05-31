import java.io.*;
import java.net.Socket;

public class EchoServer {

    private final EchoServerSocket echoServerSocket;
    private boolean reverse = false;
    private final String reverseCommand = "#reverse";
    private final String normalCommand = "#normal";

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
        if (message.equals(reverseCommand)) {
            reverse = true;
        }
        if (message.equals(normalCommand)) {
            reverse = false;
        }
    }

    private boolean isCommand(String message) {
        return (message.equals(reverseCommand) || message.equals(normalCommand));
    }

    public String readClientMessage(Socket socket) {
        try {
            BufferedReader clientReader = createClientReader(socket);
            if (clientReader != null) {
                return clientReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Couldn't get input stream");
        }
        return "";
    }

    public void sendMessageToClient(String message, Socket socket, Boolean reverse) {
        String messageToSend = prepareMessage(message, reverse);
        PrintWriter sender = createClientSender(socket);
        if (sender != null) {
            sender.println(messageToSend);
        }
    }

    private String prepareMessage(String message, Boolean reverse) {
        if (reverse && !isCommand(message)) {
            message = new StringBuilder(message).reverse().toString();
        }

        if (isCommand(message)) {
            message = message.replace("#", "") + " mode activated";
        }
        return message;
    }

    private BufferedReader createClientReader(Socket socket) {
        try {
            return new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private PrintWriter createClientSender(Socket socket) {
        try {
            return new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
