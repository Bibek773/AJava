package JavaNetworking;
import java.net.*;
import java.io.*;


public class TcpClient {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 9097);





//        ServerSocket ss = new ServerSocket(9097);
//        Socket socket =ss.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out =new PrintWriter(socket.getOutputStream(), true);

        out.println("Hello from client");
        out.flush();

        String msg = br.readLine();
        System.out.println("Server:"+msg);

        out.close();
        br.close();
        socket.close();
    }
}
