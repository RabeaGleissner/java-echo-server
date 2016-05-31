import java.io.IOException;
import java.net.ServerSocket;

public class FakeServerSocket extends ServerSocket {

    private FakeClientSocket fakeClientSocket;

    public FakeServerSocket(FakeClientSocket fakeClientSocket) throws IOException {
        super();
        this.fakeClientSocket = fakeClientSocket;
    }

    public FakeClientSocket accept() {
        return fakeClientSocket;
    }
}
