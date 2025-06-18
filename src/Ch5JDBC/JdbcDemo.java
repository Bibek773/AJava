package Ch5JDBC;

import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "your_password");
        String q = "INSERT INTO user (id, name, email, password) VALUES (?, ?, ?, ?)";
        PreparedStatement pre = con.prepareStatement(q);
        pre.setString(1, "101");
        pre.setString(2, "ABC");
        pre.setString(3, "abc@gmail.com");
        pre.setString(4, "ABC");
        pre.executeUpdate();
        pre.close();
        con.close();
        System.out.println("Data Added Successfully");
    }
}
