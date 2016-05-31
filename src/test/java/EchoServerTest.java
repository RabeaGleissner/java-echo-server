import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class EchoServerTest {

    @Test
    public void acceptsInputFromServerSocketUntilStopIsSent() throws IOException {
        FakeClientSocket fakeClientSocket = new FakeClientSocket();
        fakeClientSocket.input("hello!!", "stop");
        EchoServer echoServer = new EchoServer(new EchoServerSocket(new FakeServerSocket(fakeClientSocket)));

        echoServer.start();

        assertEquals("hello!!\n", fakeClientSocket.printedMessage());
    }

    @Test
    public void notifiesUserOfReverseModeActivation() throws IOException {
        FakeClientSocket fakeClientSocket = new FakeClientSocket();
        EchoServer echoServer = new EchoServer(new EchoServerSocket(new FakeServerSocket(fakeClientSocket)));

        fakeClientSocket.input("#reverse", "stop");
        echoServer.start();
        assertEquals("reverse mode activated\n", fakeClientSocket.printedMessage());
    }

    @Test
    public void notifiesUserOfNormalModeActivation() throws IOException {
        FakeClientSocket fakeClientSocket = new FakeClientSocket();
        EchoServer echoServer = new EchoServer(new EchoServerSocket(new FakeServerSocket(fakeClientSocket)));

        fakeClientSocket.input("#normal", "stop");
        echoServer.start();
        assertEquals("normal mode activated\n", fakeClientSocket.printedMessage());
    }

    @Test
    public void printsInputInReverseWhenInReverseMode() throws IOException {
        FakeClientSocket fakeClientSocket = new FakeClientSocket();
        EchoServer echoServer = new EchoServer(new EchoServerSocket(new FakeServerSocket(fakeClientSocket)));
        fakeClientSocket.input("#reverse", "hello!!", "stop");

        echoServer.start();

        assertEquals("!!olleh\n", fakeClientSocket.printedMessage());
    }

    @Test
    public void printsInReverseAndSwitchesBackToNormal() throws IOException {
        FakeClientSocket fakeClientSocket = new FakeClientSocket();
        EchoServer echoServer = new EchoServer(new EchoServerSocket(new FakeServerSocket(fakeClientSocket)));
        fakeClientSocket.input("#reverse", "#normal", "hello!", "stop");

        echoServer.start();

        assertEquals("hello!\n", fakeClientSocket.printedMessage());
    }
}