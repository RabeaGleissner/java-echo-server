import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.ServerSocket;

import static org.junit.Assert.*;

public class EchoServerTest {

    @Test
    public void acceptsInputFromASocket() throws IOException {
        EchoServerSocket echoServerSocket = new EchoServerSocket(
                new EchoClientSocket(new FakeClientSocket()),
                new ServerSocket());
        EchoServer echoServer = new EchoServer(echoServerSocket);
        String message = "hello";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(message.getBytes());

        BufferedReader input = echoServer.getInput(byteArrayInputStream);

        assertEquals(message, input.readLine());
    }
}