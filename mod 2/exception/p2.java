import java.util.Scanner;

public class p2 {
    static void validateAge(int age){
        if(age<18) throw new IllegalArgumentException("Age must be 18 or older");
    }
    public static void main(String[] args) {
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("age?");
            int age=sc.nextInt();
            validateAge(age);
        }catch(IllegalArgumentException e){
            System.out.println(e);
        }
    }
}

