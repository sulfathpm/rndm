import java.io.*;
public class fileW {
    public static void main(String[] args) {
        try{
            FileWriter f=new FileWriter("a.txt");
            f.write("hi");
            f.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
