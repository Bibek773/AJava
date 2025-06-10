package JavaNetworking;
import java.io.IOException;
import java.net.*;

public class UdpClient {
    public static void main(String [] args) throws IOException {
        DatagramSocket socket=new DatagramSocket();
        String msg ="Hello from client";
        byte[]  bmsg = msg.getBytes();
        InetAddress address = InetAddress.getByName("localhost");
        DatagramPacket packet = new DatagramPacket(bmsg, bmsg.length, address, 9099);
        socket.send(packet);
        byte[] smsg = new byte[1024];
        DatagramPacket spacket = new DatagramPacket(smsg, smsg.length);
        socket.receive(spacket);
        String  smessage = new String(spacket.getData(), 0, spacket.getLength());
        System.out.println("Server message:" + smessage);
        socket.close();


    }
}
