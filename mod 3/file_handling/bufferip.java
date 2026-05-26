import java.io.*;
public class bufferip {
    public static void main(String[] args) {
        try(FileInputStream in=new FileInputStream("output.bin");
        BufferedInputStream bin=new BufferedInputStream(in)){
            int data;
            while ((data=in.read())!=-1) {
                System.out.println((byte)data);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
