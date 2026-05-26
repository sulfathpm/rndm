import java.util.*;
public class p6arrlist {
    public static void main(String[] args) {
    ArrayList <String> names=new ArrayList<>();
    names.add("ab");
    names.add(0,"an");
    names.add("ag");
    Collections.sort(names);
    System.out.println(names);
    System.out.println(names.contains("an"));
    System.out.println(names.indexOf("an"));
   Collections.sort(names,Collections.reverseOrder());
   System.out.println(names);
}

}
