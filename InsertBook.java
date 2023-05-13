package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertBook {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        String query = "insert into book_info values(1,'SQl',2433.55)";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            stmt = con.createStatement();
            int count = stmt.executeUpdate(query);
            System.out.println(count+" Book Inserted Successfully!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(con!=null)
            {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (stmt!=null)
            {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
