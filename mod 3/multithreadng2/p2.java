class myRunnable implements Runnable{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
public class p2 {
    public static void main(String[] args) {
        myRunnable runnable=new myRunnable();
        Thread t1=new Thread(runnable);
        t1.start();
        System.out.println("main thread");
        for (int i = 0; i < 5; i++) {
            System.out.println("main :"+i);
            try{
                Thread.sleep(600);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
