import java.io.*;
public class bufferW {

    public static void main(String[] args) {
        try{
            FileWriter fr=new FileWriter("b.txt");
            BufferedWriter bf=new BufferedWriter(fr);
            bf.write("hello, how r u?");
            bf.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}