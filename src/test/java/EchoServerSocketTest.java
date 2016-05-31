import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.ServerSocket;

import static org.junit.Assert.assertEquals;

public class EchoServerSocketTest {

    @Test
    public void returnsClientSocketToAcceptInput() throws IOException {
        String message = "hello";
        FakeClientSocket fakeClientSocket = new FakeClientSocket();
        fakeClientSocket.input(message);
        EchoServerSocket echoServerSocket = new EchoServerSocket(
                new FakeServerSocket(fakeClientSocket));

        fakeClientSocket = (FakeClientSocket) echoServerSocket.accept();
        ByteArrayOutputStream outputStream = fakeClientSocket.getOutputStream();
        outputStream.write(message.getBytes());

        assertEquals(message, outputStream.toString());
    }

    @Test(expected=IOException.class)
    public void throwExceptionWhenItCannotCreateSocket() throws IOException {
        EchoServerSocket echoServerSocket = new EchoServerSocket(new ServerSocket(222));
        echoServerSocket.accept();
    }
}