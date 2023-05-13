package Demo;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    public static void main(String[] args) {
        try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            System.out.println("Connection Successful!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
