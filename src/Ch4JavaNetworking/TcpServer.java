package Ch4JavaNetworking;

import java.net.*;
import java.io.*;

public class TcpServer {
    public static void main(String[] args) throws Exception {
        InetAddress bindAddr = InetAddress.getByName("172.16.10.138");
        ServerSocket ss = new ServerSocket(9097, 50, bindAddr);
        System.out.println("Server started. Waiting for client...");

        Socket socket = ss.accept();
        System.out.println("Client connected: " + socket.getInetAddress());

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        // Thread to read from client
        new Thread(() -> {
            String msgFromClient;
            try {
                while ((msgFromClient = br.readLine()) != null) {
                    System.out.println("Client: " + msgFromClient);
                }
            } catch (IOException e) {
                System.err.println("Client disconnected.");
            }
        }).start();

        // Main thread to send to client
        String msgToClient;
        while ((msgToClient = keyboard.readLine()) != null) {
            out.println(msgToClient);
        }

        socket.close();
        ss.close();
    }
}
