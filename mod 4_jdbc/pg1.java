//error
import java.util.*;
import java.sql.*;
public class pg1 {
    public static void main(String[] args) {
        try{
            Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","123");
            Statement st=conn.createStatement();
            try{
                st.executeUpdate("DROP TABLE book");

            }catch(Exception e){
                System.out.println("Table don't exist");
            }
            st.executeUpdate("CREATE TABLE book(id number primary key,title varchar(50),author varchar(50),price number");
            System.out.println("table created");
            Scanner sc=new Scanner(System.in);
            int choice;
            do{
                System.out.println("\n.....book menu.....\n
                1. insert\n
                2. display all books\n3. display book based on title\n
                4. display books of gven author\n
                5. update price of a given book\n
                6. delete a given book
                \nEnter your choice :");
                choice=sc.nextInt();
                sc.next();
                switch(choice){
                    case 1: System.out.println("id?");int id=sc.nextInt();
                            System.out.println("title?");String title=sc.nextLine();
                            System.out.println("author?");String author=sc.nextLine();
                            System.out.println("price?"); double price=sc.nextDouble();
                            PreparedStatement ps1=conn.prepareStatement(INSERT INTO book VALUES(?,?,?,?));
                            ps1.setInt(1,id);ps1.setString(2,title);
                            ps1.setString(3,author);ps1.setString(4,title);
                            ps1.executeUpdate();
                            System.out.println("book inserted successfully");
                            break;
                    case 2: PreparedStatement ps2=conn.prepareStatement("select * from book");
                            ResultSet rs=ps2.executeQuery();
                            System.out.println("\n...Book list...\n");
                            while (rs.nextInt()) {
                                System.out.println("id: "+rs.getInt(1)+"title : "+rs.getString(2)+"auhtor : "+rs.getString(3)+"price :"+rs.getDouble(4));

                            }
                            break;
                    case 3: System.out.println("title?");
                            String title=sc.nextLine();
                            PreparedStatement ps3=conn.prepareStatement("select * from book where title=?");
                            ps3.setString(1, title);
                            ResultSet rs1=ps3.executeQuery();
                            while(rs1.next()){
                                System.out.println(rs1.getInt(1)+"|"+rs1.getString(2)+"|"+rs1.getString(3)+"|"+rs1.getDouble(4));

                            }
                            break;
                    case 4: System.out.println("author?");
                            String author=sc.nextLine();
                            PreparedStatement ps4=conn.prepareStatement("select * from book where author=?");
                            ps4.setString(1, author);
                            ResultSet rs2=ps4.executeQuery();
                            while(rs2.next()){
                                System.out.println(rs2.getInt(1)+"|"+rs2.getString(2)+"|"+rs2.getString(3)+"|"+rs2.getDouble(4));

                            }
                            break;
                    case 5: System.out.println("Book id?");
                            int id=sc.nextInt();
                            System.out.println("New price?");
                            double price=sc.nextDouble();
                            PreparedStatement ps5=conn.prepareStatement("UPDATE book SET price=? where id=?");
                            ps5.setDouble(1, price);
                            ps5.setInt(2, id);
                            ResultSet rs3=ps5.executeQuery();
                            while (rs3.next()) {
                                System.out.println(rs3.getInt(1)+"|"+rs3.getString(2)+"|"+rs3.getString(3)+"|"+rs3.getDouble(4));
                            }
                            break;
                    case 6: System.out.println("id to delete ?");
                            int id=sc.nextInt();
                            PreparedStatement ps6=conn.prepareStatement("DELETE from book where id=?");
                            ps6.setInt(1, id);
                            ps6.executeQuery();
                            System.out.println("book deleted successfully");
                            break;
                            
                            
                }while(choice!=0);
                sc.close();
                st.close();
                conn.close();

            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
