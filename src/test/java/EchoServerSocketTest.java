import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.Assert.*;

public class EchoServerSocketTest {

    @Test
    public void createsNewServerSocketOnSpecificPort() throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        EchoServerSocket echoServerSocket = new EchoServerSocket(new EchoClientSocket(new Socket()),
                serverSocket);

        assertEquals(1234, echoServerSocket.getPortNumber());
        serverSocket.close();
    }

    @Test
    public void returnsClientSocketToAcceptInput() throws IOException {
        FakeClientSocket fakeClientSocket = new FakeClientSocket();
        EchoServerSocket echoServerSocket = new EchoServerSocket(
                new EchoClientSocket(fakeClientSocket), new ServerSocketDummy());

        EchoClientSocket clientSocket = echoServerSocket.accept();
        ByteArrayOutputStream outputStream = (ByteArrayOutputStream)
                clientSocket.getOutputStream();
        String message = "hello";
        outputStream.write(message.getBytes());

        assertEquals(message, outputStream.toString());
    }
}