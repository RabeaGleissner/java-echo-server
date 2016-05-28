import java.io.IOException;
import java.net.ServerSocket;

public class FakeServerSocket extends ServerSocket {

    private String input;
    private FakeClientSocket fakeClientSocket;

    public FakeServerSocket() throws IOException {
    }

    public FakeServerSocket(FakeClientSocket fakeClientSocket, String input) throws IOException {
        super();
        this.fakeClientSocket = fakeClientSocket;
        this.input = input;
    }

    public FakeClientSocket accept() {
        if (input != null) {
            fakeClientSocket.input(input, "quit");
        }
        return fakeClientSocket;
    }
}
