package Ch4JavaNetworking;
import java.io.IOException;
import java.net.*;
public class UdpServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9099);
         byte[] data = new byte[1024];
         DatagramPacket packet = new DatagramPacket(data, data.length);
         socket.receive(packet);
         String msg = new String(packet.getData(), 0, packet.getLength());
         System.out.println("message :"+msg);
         String tomsg ="Hello from Server";
         byte[] todata = tomsg.getBytes();
         DatagramPacket topack = new DatagramPacket(todata, todata.length, packet.getAddress(), packet.getPort());
         socket.send(topack);
         socket.close();
    }
}
