import java.util.*;
import java.sql.*;

public class pg1 {
    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//localhost:1521/XE",
                    "system",
                    "123");

            Statement st = conn.createStatement();

            // Drop table if exists
            try {
                st.executeUpdate("DROP TABLE book");
            } catch (Exception e) {
                System.out.println("Table doesn't exist");
            }

            // Create table
            st.executeUpdate(
                    "CREATE TABLE book(" +
                    "id NUMBER PRIMARY KEY, " +
                    "title VARCHAR2(50), " +
                    "author VARCHAR2(50), " +
                    "price NUMBER)");

            System.out.println("Table created");

            Scanner sc = new Scanner(System.in);
            int choice;

            do {

                System.out.println("\n.....BOOK MENU.....");
                System.out.println("1. Insert");
                System.out.println("2. Display all books");
                System.out.println("3. Display book based on title");
                System.out.println("4. Display books of given author");
                System.out.println("5. Update price of a given book");
                System.out.println("6. Delete a given book");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    // INSERT
                    case 1:
                        System.out.print("Id: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Title: ");
                        String title = sc.nextLine();

                        System.out.print("Author: ");
                        String author = sc.nextLine();

                        System.out.print("Price: ");
                        double price = sc.nextDouble();

                        PreparedStatement ps1 =
                                conn.prepareStatement(
                                        "INSERT INTO book VALUES(?,?,?,?)");

                        ps1.setInt(1, id);
                        ps1.setString(2, title);
                        ps1.setString(3, author);
                        ps1.setDouble(4, price);

                        ps1.executeUpdate();

                        System.out.println("Book inserted successfully");
                        break;

                    // DISPLAY ALL
                    case 2:
                        PreparedStatement ps2 =
                                conn.prepareStatement("SELECT * FROM book");

                        ResultSet rs = ps2.executeQuery();

                        System.out.println("\n...BOOK LIST...\n");

                        while (rs.next()) {
                            System.out.println(
                                    rs.getInt(1) + " | " +
                                    rs.getString(2) + " | " +
                                    rs.getString(3) + " | " +
                                    rs.getDouble(4));
                        }
                        break;

                    // SEARCH BY TITLE
                    case 3:
                        System.out.print("Enter title: ");
                        title = sc.nextLine();

                        PreparedStatement ps3 =
                                conn.prepareStatement(
                                        "SELECT * FROM book WHERE title=?");

                        ps3.setString(1, title);

                        ResultSet rs1 = ps3.executeQuery();

                        while (rs1.next()) {
                            System.out.println(
                                    rs1.getInt(1) + " | " +
                                    rs1.getString(2) + " | " +
                                    rs1.getString(3) + " | " +
                                    rs1.getDouble(4));
                        }
                        break;

                    // SEARCH BY AUTHOR
                    case 4:
                        System.out.print("Enter author: ");
                        author = sc.nextLine();

                        PreparedStatement ps4 =
                                conn.prepareStatement(
                                        "SELECT * FROM book WHERE author=?");

                        ps4.setString(1, author);

                        ResultSet rs2 = ps4.executeQuery();

                        while (rs2.next()) {
                            System.out.println(
                                    rs2.getInt(1) + " | " +
                                    rs2.getString(2) + " | " +
                                    rs2.getString(3) + " | " +
                                    rs2.getDouble(4));
                        }
                        break;

                    // UPDATE PRICE
                    case 5:
                        System.out.print("Book Id: ");
                        id = sc.nextInt();

                        System.out.print("New Price: ");
                        price = sc.nextDouble();

                        PreparedStatement ps5 =
                                conn.prepareStatement(
                                        "UPDATE book SET price=? WHERE id=?");

                        ps5.setDouble(1, price);
                        ps5.setInt(2, id);

                        int rows = ps5.executeUpdate();

                        if (rows > 0)
                            System.out.println("Price updated");
                        else
                            System.out.println("Book not found");

                        break;

                    // DELETE
                    case 6:
                        System.out.print("Id to delete: ");
                        id = sc.nextInt();

                        PreparedStatement ps6 =
                                conn.prepareStatement(
                                        "DELETE FROM book WHERE id=?");

                        ps6.setInt(1, id);

                        int r = ps6.executeUpdate();

                        if (r > 0)
                            System.out.println("Book deleted successfully");
                        else
                            System.out.println("Book not found");

                        break;

                    case 0:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }

            } while (choice != 0);

            sc.close();
            st.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}