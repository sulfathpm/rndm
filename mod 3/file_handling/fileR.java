import java.io.*;
public class fileR {
    public static void main(String[] args) {
        try{
            FileReader fr=new FileReader("a.txt");
            int data;
            while ((data=fr.read())!=-1) {
            
                System.out.print((char)data);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
