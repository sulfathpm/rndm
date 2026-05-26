import java.util.*;
public class p4arrylist {
    public static void main(String[] args) {
        ArrayList<String> names=new ArrayList<>();
        names.add("ab");
        names.add(0,"an");
        names.add("ag");
        System.out.println(names.get(1));
        for(String x:names) System.out.println(x);
    }
}
