package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteBook {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the book id to be Deleted!!");
        int id = sc.nextInt();
        String query = "delete from book_info where book_id = "+id;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            stmt = con.createStatement();
            int count = stmt.executeUpdate(query);
            System.out.println(count+" Book deleted Successfully!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (con!=null)
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
