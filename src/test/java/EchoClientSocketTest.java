import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class EchoClientSocketTest {

    @Test
    public void returnsOutputStream() throws IOException {
        ClientSocketSpy socketSpy = new ClientSocketSpy();
        EchoClientSocket socket = new EchoClientSocket(socketSpy);

        socket.getOutputStream();

        assertTrue(socketSpy.wasOutputStreamReturned());
    }

}