import java.io.*;
public class bufferW1 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bf=null;
        try{
            FileWriter fr=new FileWriter("c.txt");
            bf=new BufferedWriter(fr);
            bf.write("hello ?");
            bf.flush();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(bf!=null){
                bf.close();

            }
        }
    }
}