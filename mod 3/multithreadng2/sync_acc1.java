import java.util.Scanner;

class Acc {

    int blnc = 1000;

    Scanner sc = new Scanner(System.in);

    synchronized void deposit() {

        System.out.println("Amount to deposit:");

        int amt = sc.nextInt();

        blnc += amt;

        System.out.println("Balance = " + blnc);
    }

    synchronized void withdraw() {

        System.out.println("Amount to withdraw:");

        int amt = sc.nextInt();

        if (amt > blnc) {

            System.out.println("Insufficient balance");
        }
        else {

            blnc -= amt;

            System.out.println("Balance = " + blnc);
        }
    }
}

class Deposit implements Runnable {

    Acc a;

    Deposit(Acc a) {

        this.a = a;
    }

    public void run() {

        try {

            for (int i = 0; i < 2; i++) {

                a.deposit();

                Thread.sleep(500);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}

class Withdraw implements Runnable {

    Acc a;

    Withdraw(Acc a) {

        this.a = a;
    }

    public void run() {

        try {

            for (int i = 0; i < 2; i++) {

                a.withdraw();

                Thread.sleep(500);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}

public class sync_acc1 {

    public static void main(String[] args) {

        Acc a = new Acc();

        Deposit d = new Deposit(a);

        Withdraw w = new Withdraw(a);

        Thread t1 = new Thread(d);

        Thread t2 = new Thread(w);

        t1.start();

        t2.start();
    }
}