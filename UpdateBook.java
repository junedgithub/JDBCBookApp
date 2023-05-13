package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        Statement stmt = null;
        System.out.println("Enter Book id");
        int id = sc.nextInt();
        System.out.println("Enter Choice");
        System.out.println("1.Update Book name");
        System.out.println("2.Update Book price");
        int ch = sc.nextInt();
        String query = "";
        if (ch == 1) {
            System.out.println("Enter Book Name");
            String name = sc.next();
            query = "update book_info set book_name = '" + name + "' where book_id = " + id;

        }
        if (ch == 2) {
            System.out.println("Enter Book Price");
            double price = sc.nextDouble();
            query = "update book_info set book_price =" + price + " where book_id = " + id;
        }
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "sql123");
                stmt = con.createStatement();
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }
    }

