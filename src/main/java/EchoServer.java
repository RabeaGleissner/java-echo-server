import java.io.*;
import java.net.Socket;

public class EchoServer {

    private final EchoServerSocket echoServerSocket;

    public EchoServer(EchoServerSocket echoServerSocket) {
        this.echoServerSocket = echoServerSocket;
    }

    public void start() {
        Socket clientSocket = echoServerSocket.accept();
        String message = readInput(clientSocket);
        write(message, clientSocket);
    }

    public String readInput(Socket socket) {
        try {
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader input = new BufferedReader(inputStreamReader);
            return input.readLine();
        } catch (IOException e) {
            System.out.println("Couldn't get input stream");
            System.out.println(e.getMessage());
        }
        return "";
    }

    public void write(String message, Socket socket) {
        try {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream, true);
            out.println(message);
        } catch (IOException e) {
            System.out.println("Couldn't get output stream");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
