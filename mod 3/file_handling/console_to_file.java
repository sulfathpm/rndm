import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class console_to_file{ 

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try (
            FileWriter fw = new FileWriter("output.txt");
            BufferedWriter bw = new BufferedWriter(fw)
        ) {

            System.out.println("Enter text lines:");
            System.out.println("Type 'stop' to finish.");

            String line;

            while (true) {

                line = sc.nextLine();

                if (line.equalsIgnoreCase("stop")) {
                    break;
                }

                bw.write(line);

                bw.newLine();
            }

            System.out.println("Data written to file.");

        } catch (IOException e) {

            e.printStackTrace();
        }

        sc.close();
    }
}