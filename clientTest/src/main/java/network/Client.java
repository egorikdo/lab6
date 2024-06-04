package network;

import network.Task;


import java.io.*;
import java.net.*;

public class Client {
    private DatagramSocket socket= new DatagramSocket();
    private InetAddress address= InetAddress.getByName("localhost");
    private byte[] buffer = new byte[4096];
    private DatagramPacket packet= new DatagramPacket(buffer, buffer.length);

    public Client() throws SocketException, UnknownHostException {
    }

    public void sendTask(Task task) throws IOException, ClassNotFoundException {
        try {
            ByteArrayOutputStream byteArrayOutputStream= new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream= new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(task);
            byte[] buffer = byteArrayOutputStream.toByteArray();
            DatagramPacket packet= new DatagramPacket(buffer, buffer.length, address, 8080);
            socket.send(packet);
            getAnswer();

        } catch (Exception e) {
            System.out.println("Плохое соединение");
        }

    }

    public void getAnswer() throws IOException, ClassNotFoundException {
        socket.receive(packet);
        byte[] data = packet.getData();
        ObjectInputStream objectInputStream= new ObjectInputStream(new ByteArrayInputStream(data));
        Task answer= (Task) objectInputStream.readObject();
        System.out.println(answer.describe[0]);
    }
}
