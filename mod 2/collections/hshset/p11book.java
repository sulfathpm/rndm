import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
class Book {
    String title;
    String author;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;                              
    }
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null||getClass()!=o.getClass()) return false;
        Book b=(Book)o;
        return Objects.equals(author, b.author)&& Objects.equals(title,b.title);

    }
    public int hashCode(){
        return Objects.hash(title,author);
    }
    public String toString(){
        return "titile : "+title+" | autho: "+author;
    }
}
public class p11book {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashSet <Book> b=new HashSet<>();

    Book b1=new Book("a","aa");
    Book b3=new Book("b","bb");

    Book b2=new Book("c","cc");
    Book b4=new Book("d","dd");

    b.add(b1);
    b.add(b2);
    b.add(b3);
    b.add(b4);
    System.out.println("Number of books in the set: " + b.size()); 
        System.out.println("\nBooks in the set:");
        for (Book book : b) {
            System.out.println(book);
        }
        System.out.println("\nChecking if a book exists:");
        Book book5 = new Book("The Lord of the Rings", "J.R.R. Tolkien"); 
        System.out.println(b.contains(book5)); 
        System.out.println("\nRemoving a book:");
        b.remove(b1);
        System.out.println("Number of books after removal: " + b.size()); 
        for (Book book : b) {
            System.out.println(book);
        }   }   }