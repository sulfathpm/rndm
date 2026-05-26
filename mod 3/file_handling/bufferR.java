import java.io.*;
public class bufferR {
    public static void main(String[] args) {
        try{
            BufferedReader br=new BufferedReader(new FileReader("c.txt"));
            int data;
            while ((data=br.read())!=-1) {
                System.out.println((byte)data);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
