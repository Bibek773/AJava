package JavaNetworking;
import java.net.*;
import java.io.*;


public class TcpServer {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(9097);
        Socket socket =ss.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out =new PrintWriter(socket.getOutputStream(), true);
        String cmsg = br.readLine();
        System.out.println("Client :"+cmsg);
        System.out.println("Hi from Server");
        out.flush();
        socket.close();
        ss.close();
    }
}
