package system;

import managers.Console;
import network.Server;

import java.io.File;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws Exception {
        Console console = new Console();
        Server server= new Server(console, args);
        server.runServer();
    }
}

