import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class EchoServerSocketTest {

    @Test
    public void createsNewServerSocketOnSpecificPort() {
        EchoServerSocket echoServerSocket = new EchoServerSocket(1234);
        assertEquals(1234, echoServerSocket.getPortNumber());
    }

    @Test
    public void acceptsInput() {
        ServerSocketSpy socketSpy = null;
        try {
            socketSpy = new ServerSocketSpy();
        } catch (IOException e) {
            e.printStackTrace();
        }

        EchoServerSocket echoServerSocket = new EchoServerSocket(socketSpy);
        echoServerSocket.accept();
        assertTrue(socketSpy.acceptWasCalled);
    }
}