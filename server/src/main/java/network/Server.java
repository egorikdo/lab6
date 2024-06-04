package network;

import managers.CollectionManager;
import managers.Console;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    private DatagramSocket socket= new DatagramSocket(8080);
    private InetAddress address= InetAddress.getByName("localhost");
    private Console console;
    private static final Logger logger = Logger.getLogger("logger");
    private byte[] buffer = new byte[4096];


    public String path;
    private DatagramPacket packet= new DatagramPacket(buffer, buffer.length);
    private CollectionManager collectionManager;


    public Server() throws SocketException, UnknownHostException, SocketException, UnknownHostException {
    }

    public Server(managers.Console console, String[] args) throws SocketException, UnknownHostException {
        this.console = console;
        this.collectionManager=console.start(args);

    }

    public void runServer() throws Exception {
        while (true){
            logger.log(Level.INFO, "Получение информации");
            socket.receive(packet);
            byte[] data= packet.getData();
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data));
            Task task= (Task) objectInputStream.readObject();
            processTask(task, packet.getAddress(), packet.getPort(), collectionManager);
        }
    }

    public void processTask(Task task, InetAddress address, Integer port, CollectionManager collectionManager) throws Exception {
        logger.log(Level.INFO, "Выполнение команды");
        sendAnswer(console.processTask(task, collectionManager), address, port);

    }

    public void sendAnswer(Task answer, InetAddress address, Integer port) throws IOException {
        logger.log(Level.INFO, "Отправка ответа");
        ByteArrayOutputStream byteArrayOutputStream= new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(answer);
        byte[] buffer= byteArrayOutputStream.toByteArray();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
        socket.send(packet);
    }

}


