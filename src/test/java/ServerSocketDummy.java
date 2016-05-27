import java.io.IOException;
import java.net.ServerSocket;

public class ServerSocketDummy extends ServerSocket {

    public ServerSocketDummy() throws IOException {
    }

    public int getLocalPort() {
        return 0;
    }
}
