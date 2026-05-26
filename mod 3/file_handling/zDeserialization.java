import java.io.*;
class Student implements Serializable {//Deserialization
    int roll;
    String name;
    double percent;
    Student() {
        roll = 1;
        name = "Abhijith";
        percent = 92.78;
    }
}
public class zDeserialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Student s1 = new Student();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Student.ser"));
        s1 = (Student) in.readObject();
        System.out.println("Student Name: " + s1.name);    
}}