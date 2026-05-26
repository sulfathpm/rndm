//Serialization
import java.io.*;
class Student implements Serializable {
    int roll;
    String name;
    double percent;
    Student() {
        roll = 1;
        name = "Abhijith";
        percent = 92.78;
    }
}
public class zSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Student s1 = new Student();
        FileOutputStream fout = new FileOutputStream("Student.ser");
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(s1);
    }}