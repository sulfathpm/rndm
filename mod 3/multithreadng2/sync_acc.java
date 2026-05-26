import java.util.Scanner;

class Acc {

    int blnc = 1000;

    Scanner sc = new Scanner(System.in);

    synchronized void deposit() throws InterruptedException{

        System.out.println("Amount to deposit:");

        int amt = sc.nextInt();

        blnc += amt;

        System.out.println("Balance = " + blnc);
    }

    synchronized void withdraw() throws InterruptedException{

        System.out.println("Amount to withdraw:");

        int amt = sc.nextInt();

        if(amt > blnc) {

            System.out.println("Insufficient balance");
        }
        else {

            blnc -= amt;

            System.out.println("Balance = " + blnc);
        }
    }
}

public class sync_acc {

    public static void main(String[] args) {

        Acc a = new Acc();

        try {

            for(int i = 0; i < 2; i++) {

                a.deposit();

                Thread.sleep(500);

               
            }

        } catch(Exception e) {

            e.printStackTrace();
        }
 try {

            for(int i = 0; i < 2; i++) {
                a.withdraw();

                Thread.sleep(500);
                    
            }

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}