package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DisplaySpecificBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        System.out.println("Enter Book ID to display the book details!!");
        int id = sc.nextInt();
        String query = "select * from book_info where book_id = "+id;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            System.out.println("ID\t\tNAME\t\tPRICE");
            while (rs.next())
            {
                int id1 = rs.getInt(1);
                if (id==id1)
                {
                    String name = rs.getString(2);
                    double price = rs.getDouble(3);
                    System.out.println(id1+"\t\t"+name+"\t\t"+price);
                }
                else
                    System.out.println("Book Id not Found!!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (con!=null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (stmt!=null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

}
