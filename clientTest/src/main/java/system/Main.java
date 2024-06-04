package system;

import managers.Console;

import java.io.File;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws Exception {
        Console console = new Console();
        console.start();
    }
}

