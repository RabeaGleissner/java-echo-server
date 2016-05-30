import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class EchoServerTest {

    @Test
    public void returnsGivenInput() throws IOException {
        EchoServer echoServer = new EchoServer(new EchoServerSocket(new FakeServerSocket()));
        FakeClientSocket fakeClientSocket = new FakeClientSocket();
        fakeClientSocket.input("hello!");

        assertEquals("hello!", echoServer.readClientMessage(fakeClientSocket));
    }

    @Test
    public void writesGivenMessage() throws IOException {
        EchoServer echoServer = new EchoServer(new EchoServerSocket(new FakeServerSocket()));
        FakeClientSocket fakeClientSocket = new FakeClientSocket();
        echoServer.sendMessageToClient("hello!", fakeClientSocket);

        assertEquals("hello!\n", fakeClientSocket.printedMessage());
    }

    @Test
    public void acceptsInputFromServerSocketUntilStopIsSent() throws IOException {
        FakeClientSocket fakeClientSocket = new FakeClientSocket();
        fakeClientSocket.input("hello!!", "stop");
        FakeServerSocket fakeServerSocket = new FakeServerSocket(fakeClientSocket);
        EchoServer echoServer = new EchoServer(new EchoServerSocket(fakeServerSocket));

        echoServer.start();

        assertEquals("hello!!\n", fakeClientSocket.printedMessage());
    }
}