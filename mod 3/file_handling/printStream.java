import java.io.*;
public class printStream {
    public static void main(String[] args) {
        try{
            PrintStream ps=new PrintStream(System.out);
            ps.println("printStream eg");
            ps.printf("Formatted output: %d, %s, %.2f\n", 10, "Hello", 3.14159);
            ps.println("More text.");
            ps.close();
            FileWriter fw = new FileWriter("ab.txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.println("PrintWriter Example:");
            pw.printf("Formatted output: %d, %s, %.2f\n", 20, "World", 2.71828);
            pw.println("Another line.");
            pw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
