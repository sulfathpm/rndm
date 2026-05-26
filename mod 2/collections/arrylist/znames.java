import java.util.*;

public class znames {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice;
        ArrayList <String> names=new ArrayList<>();
        do{
            System.out.println("\n1.add name\n2.remove name\n3.sarch \n4.sort\n5.display\n0.exit\nEnter ur choice:");
         choice=sc.nextInt();
            switch (choice) {
                case 1: System.out.println("enter name?");
                        String name=sc.next();
                        names.add(name);
                        System.out.println(name+" added.");
                    
                    break;
                case 2: System.out.println("enter name to remove?");
                        String name1=sc.next();
                        System.out.println(names.remove(name1)?"removed":"not found");
                    
                    break;
                case 3: System.out.println("enter name to search?");
                        String name3=sc.next();
                        if(names.contains(name3)){
                            System.out.println(name3+" found at "+names.indexOf(name3));
                        }else{
                            System.out.println(name3+" not found.");
                        }
                    
                    break;
                case 4: ArrayList<String> temp=new ArrayList<>(names);
                        System.out.println("sorting names:");
                        Collections.sort(temp);
                        System.out.println(temp);
                    
                    break;
                case 5: System.out.println("names:");
                        for(String x:names) System.out.println(x);
                    
                    break;
            
                default:System.out.println("inaid cjoice");
                    break;
            }
        }while (choice!=0);       
    }
}
