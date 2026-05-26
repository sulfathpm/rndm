import java.util.HashSet;
import java.util.Scanner;

public class p0 {
    public static void main(String[] args) {
        HashSet<String> a=new HashSet<>();
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("continue?(y/n)");
            char c=sc.next().charAt(0);
            sc.nextLine();
            if(Character.toLowerCase(c)=='n') break;
            System.out.println("elemnt?");
            a.add(sc.nextLine());

        }
        for(String x:a){
            System.out.println(x);

        }
        System.out.println("eemnt to search?");
        String s=sc.nextLine();
        System.out.println(a.contains(s)?"found ":"not found");
        System.out.println("elemnt to remove :");
        String r=sc.nextLine();
        System.out.println(a.remove(r)?"removed":"not removed");

    }
    
}
