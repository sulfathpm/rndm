import java.util.*;
class product{
    int price;
    String name;
    public product(String name,int price){
        this.name=name;
        this.price=price;
    }
    public String toString(){
        return "name : "+name+"| price : "+price;
    }
}
public class zprod {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice;
        ArrayList <product> p=new ArrayList<>();
        do{
            System.out.println("1.add\n2.sort\n3.display\n0.exit.\nchoice?");
            choice=sc.nextInt();
            switch (choice) {
                case 1: System.out.println("prod name?");
                        String prod=sc.next();
                        System.out.println("price?");
                        int price=sc.nextInt();
                        p.add(new product(prod, price));

                    
                    break;
                case 2: System.out.println("sorted : ");
                        ArrayList<product> pr=new ArrayList<>();
                        pr.addAll(p);
                        Collections.sort(pr,Comparator.comparing((product pro)->pro.name));
                        System.out.println(pr);

                    
                    break;
                 case 3: System.out.println("list : ");
                        System.out.println(p);

                    
                    break;
                case 0:System.exit(0);
            
                default:System.out.println("invaid choice");
                    break;
            }
        }while(choice!=0);
    }
}
