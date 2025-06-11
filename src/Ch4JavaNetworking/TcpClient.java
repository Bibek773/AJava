package Ch4JavaNetworking;

import java.net.*;
import java.io.*;

public class TcpClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("172.16.10.138", 9097); // Replace with server IP
        System.out.println("Connected to server.");

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        // Thread to read from server
        new Thread(() -> {
            String msgFromServer;
            try {
                while ((msgFromServer = br.readLine()) != null) {
                    System.out.println("Server: " + msgFromServer);
                }
            } catch (IOException e) {
                System.err.println("Server disconnected.");
            }
        }).start();

        // Main thread to send to server
        String msgToServer;
        while ((msgToServer = keyboard.readLine()) != null) {
            out.println(msgToServer);
        }

        socket.close();
    }
}
