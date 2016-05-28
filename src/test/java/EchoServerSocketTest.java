import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.ServerSocket;

import static org.junit.Assert.assertEquals;

public class EchoServerSocketTest {

    @Test
    public void createsNewServerSocketOnSpecificPort() throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        EchoServerSocket echoServerSocket = new EchoServerSocket(
                serverSocket);

        assertEquals(1234, echoServerSocket.getPortNumber());
        serverSocket.close();
    }

    @Test
    public void returnsClientSocketToAcceptInput() throws IOException {
        String message = "hello";
        FakeClientSocket fakeClientSocket = new FakeClientSocket();
        EchoServerSocket echoServerSocket = new EchoServerSocket(
                new FakeServerSocket(fakeClientSocket, message));

        fakeClientSocket = (FakeClientSocket) echoServerSocket.accept();
        ByteArrayOutputStream outputStream = fakeClientSocket.getOutputStream();
        outputStream.write(message.getBytes());

        assertEquals(message, outputStream.toString());
    }
}