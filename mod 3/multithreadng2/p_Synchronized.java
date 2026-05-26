import java.security.spec.ECFieldF2m;

class Reader implements Runnable{
    static final Object lock=p_Synchronized.lock;
    static boolean workdone=false;
    public void run(){
        synchronized(lock){
        try{
            System.out.println("Read A");
            Thread.sleep(500);
            System.out.println("Read B");
            Thread.sleep(500);
            System.out.println("Read C");
            Thread.sleep(500);
              while(!workdone){
                lock.wait();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
      }
    }
}

class Writer implements Runnable{
    static final Object lock=p_Synchronized.lock;
    public void run(){
        synchronized(lock){
        try{
          
            System.out.println("Write A");
            Thread.sleep(500);
            System.out.println("Write B");
            Thread.sleep(500);
            System.out.println("Write C");
            Thread.sleep(500);
            Reader.workdone=true;
            lock.notifyAll();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    }
}

public class p_Synchronized {
    static final Object lock=new Object();
    public static void main(String[] args) throws InterruptedException{
        Reader r=new Reader();
        Writer w=new Writer();
        Thread t1=new Thread(r);
        Thread t2=new Thread(w);
        t2.start();        
        t1.start();

    }
}

