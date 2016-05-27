import java.io.*;

public class EchoServer {
    private final EchoServerSocket echoServerSocket;

    public EchoServer(EchoServerSocket echoServerSocket) {
        this.echoServerSocket = echoServerSocket;
    }

    public void start() {
        try (
                EchoClientSocket clientSocket = echoServerSocket.accept();
                OutputStream outputStream = clientSocket.getOutputStream();
                InputStream inputStream = clientSocket.getInputStream();

                )
                {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public BufferedReader getInput(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        return new BufferedReader(inputStreamReader);
    }

    public void writeToStream(OutputStream outputStream, String message) {
        PrintWriter out = new PrintWriter(outputStream, true);
        out.println(message);
    }
}
