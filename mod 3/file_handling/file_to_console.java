import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class file_to_console{ 

    public static void main(String[] args) {

        try (
            FileReader fr = new FileReader("a.txt");
            BufferedReader br = new BufferedReader(fr)
        ) {

            String line;

            while ((line = br.readLine()) != null) {

                System.out.println(line);
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}