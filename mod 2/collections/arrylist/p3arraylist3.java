import java.util.*;

public class p3arraylist3 {
    public static void main(String[] args) {
        ArrayList <String> students=new ArrayList<>(5);
        students.add("abel");
        students.add(0,"anna");
        //System.out.println(students);
        ArrayList <String> s2mca=new ArrayList<>();
        s2mca.addAll(students);
        System.out.println(s2mca);
    }
    
}

