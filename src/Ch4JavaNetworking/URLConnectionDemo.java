package Ch4JavaNetworking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

class URLConnectionDemo {
    public static void main(String[] args) throws Exception {
        URL u = new URL("http://www.ghimire-bibek.com.np");
        URLConnection con = u.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        while(true){
            String line = br.readLine();
            if(null==line){
                break;
            }
            System.out.println(line);
        }
    }
}