class myThread extends Thread{
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

public class p11{
    public static void main(String[] args) throws InterruptedException{
        myThread t1=new myThread();
        t1.start();
        System.out.println("main thread");
        for (int i = 0; i < 5; i++) {
            System.out.println("main :"+i);
            // try{
             Thread.sleep(600);
            // }catch(InterruptedException e){
            //     e.printStackTrace();
            // }
        }
    }
}