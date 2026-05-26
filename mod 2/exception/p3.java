import java.util.Scanner;

public class p3 {
    static void division(int n,int d){
        if(d==0) throw new ArithmeticException("div by 0 is not possible");
        else{
            System.out.println("div : "+n/d);
        }
    }
    public static void main(String[] args) {
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("numertr?");
            int n=sc.nextInt();
            System.out.println("denomintr?");
            int d=sc.nextInt();
            division(n, d);
        }catch(ArithmeticException e){
            System.out.println(e);
        }
    }
}
