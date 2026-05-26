import java.util.Scanner;

class negexc extends Exception{
    public negexc(String msg){
        super(msg);
    }
}
public class p6_negexc {
    static void checkneg(int n) throws negexc{
        if(n<0) throw new negexc("Neg number isn't allowed");
    }
    public static void main(String[] args) {
        int sum=0;
        double avg=0.0;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter limit ? ");
        int n=sc.nextInt();
        int count=0;
        int a[]=new int[n];
        System.out.println("elements?");
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
            try{
                checkneg(a[i]);
                sum=sum+a[i];
                count++;
            }catch(negexc e){
            System.out.println(e.getMessage());
        }
    }
        avg=(double)sum/count;
        System.out.println("avg="+avg);
    
    }
}
