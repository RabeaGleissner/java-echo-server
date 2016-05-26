import org.junit.Test;

import static org.junit.Assert.*;

public class EchoServerSocketTest {

    @Test
    public void createsNewServerSocketOnSpecificPort() {
        EchoServerSocket echoServerSocket = new EchoServerSocket(1234);
        assertEquals(1234, echoServerSocket.getPortNumber());
    }
}