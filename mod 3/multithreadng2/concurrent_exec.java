import java.security.spec.ECFieldF2m;

class Reader implements Runnable{
    public void run(){
        try{
            System.out.println("Read A");
            Thread.sleep(500);
            System.out.println("Read B");
            Thread.sleep(500);
            System.out.println("Read C");
            Thread.sleep(500);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Writer implements Runnable{
    public void run(){
        try{
            System.out.println("Write A");
            Thread.sleep(500);
            System.out.println("Write B");
            Thread.sleep(500);
            System.out.println("Write C");
            Thread.sleep(500);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class concurrent_exec {
    public static void main(String[] args) {
        Reader r=new Reader();
        Writer w=new Writer();
        Thread t1=new Thread(r);
        Thread t2=new Thread(w);
        t1.start();
        t2.start();
    }
}
