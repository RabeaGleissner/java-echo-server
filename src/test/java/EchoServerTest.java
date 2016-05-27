import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class EchoServerTest {

    @Test
    public void returnsGivenInput() {
        EchoServer echoServer = new EchoServer();
        FakeClientSocket fakeClientSocket = new FakeClientSocket();
        fakeClientSocket.setInput("hello!");


        assertEquals("hello!", echoServer.readInput(fakeClientSocket));
    }

    @Test
    public void writesGivenMessage() {
        EchoServer echoServer = new EchoServer();
        FakeClientSocket fakeClientSocket = new FakeClientSocket();
        echoServer.write("hello!", fakeClientSocket);

        assertEquals("hello!\n", fakeClientSocket.printedMessage());
    }
}