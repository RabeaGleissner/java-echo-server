import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static junit.framework.TestCase.assertEquals;

public class EchoClientSocketTest {
    @Test
    public void returnsOutputStream() throws IOException {

        FakeSocket fakeSocket = new FakeSocket();
        EchoClientSocket socket = new EchoClientSocket(fakeSocket);
//        ByteArrayOutputStream fakeOutputStream = socket.getOutputStream();
//        assertEquals("hi", fakeOutputStream.sayHi());
    }

}