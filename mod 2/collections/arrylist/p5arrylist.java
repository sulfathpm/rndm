import java.util.*;

public class p5arrylist {
    public static void main(String[] args) {
        ArrayList<String> names=new ArrayList<>();
        names.add("ab");
        names.add(0,"an");
        names.add("ag");
        //System.out.println(names.get(1));
        names.remove(1);
        names.remove("an");
        System.out.println(names);
        ArrayList <String> s2mca=new ArrayList<>();
        s2mca.addAll(names);
        s2mca.add(1,"d");
        //s2mca.clear();
        s2mca.removeAll(s2mca);
        for(String x:s2mca) System.out.println(x);
        
    }
}


