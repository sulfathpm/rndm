import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

class Book {
    String title,author;
    public Book(String t,String a){
        title=t;
        author=a;
    }
    public String toString(){
        return "title : "+title+"| author :"+author;
    }
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        Book b=(Book)o;
        return Objects.equals(title,b.title)&& Objects.equals(author, b.author);
    }
    public int hashCode(){
        return Objects.hash(title,author);
    }
    
}
public class p1book {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashSet <Book> bk=new HashSet<>();
        for(int i=0;i<3;i++){
            System.out.println("title?");
            String t=sc.nextLine();
            System.out.println("author?");
            String a=sc.nextLine();
            bk.add(new Book(t, a));
    }
    System.out.println("books:");
    for(Book x:bk){
        System.out.println(x);
    }
    // System.out.println("enter title for the elemnt to search?");
    // String s=sc.nextLine();
    // String a=sc.nextLine();
    // System.out.println(bk.contains(new Book(s, a))?"found":"not found");

    // System.out.println("enter title of book to remoove?");
    // String rm=sc.nextLine();
    // System.out.println(bk.remove(rm)?"removed":"not removed");
System.out.print("\nElement to search (by title)? : ");
        String s = sc.nextLine();
        boolean found = false;
        for (Book x : bk) {
            if (x.title.equalsIgnoreCase(s)) {
                found = true;
                break;
            }
        }
        System.out.println(found ? "found" : "not found");


 System.out.println("Title to remove?");
        String rm = sc.nextLine();

        Book removeBook = null;

        for(Book x : bk) {

            if(x.title.equals(rm)) {

                removeBook = x;
                break;
            }
        }

        if(removeBook != null) {

            bk.remove(removeBook);

            System.out.println("Removed");
        }

        else {

            System.out.println("Not removed");
        }

    System.out.print("\nRemove (by title)? : ");
        String rm1 = sc.nextLine();
        boolean removed = false;
        
        Iterator<Book> itr = bk.iterator();
        while (itr.hasNext()) {
            Book x = itr.next();
            if (x.title.equalsIgnoreCase(rm1)) {
                itr.remove(); // Safely deletes the object from the HashSet
                removed = true;
                break; 
            }
        }
        System.out.println(removed ? "removed" : "not removed");

           System.out.println("Number of books after removal: " + bk.size()); 

    }
}
