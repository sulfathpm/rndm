import java.io.FileOutputStream;
import java.util.*;
public class fileop {
    public static void main(String[] args) {
        try(FileOutputStream out=new FileOutputStream("output.txt")){
        // try(FileOutputStream out=new FileOutputStream("output.bin")){

            // byte[] data={65,66,67};
            // out.write(data);
            String s = "ABC";
            out.write(s.getBytes());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
