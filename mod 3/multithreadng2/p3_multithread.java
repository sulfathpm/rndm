class multi implements Runnable{
    public void run(){
        System.out.println("multiicatn table of 5: ");
        for (int i = 0; i < 10; i++) {
            System.out.println((i+1)+"*"+"5 = "+((i+1)*5));
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class factor implements Runnable{
    public void run(){
        int n=36;
        System.out.println("factor of 36");
        for (int i = 1; i < n; i++) {
            if(n%i==0){
                System.out.println("f(36) = "+i);
                try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            }
        }
    }
}

public class p3_multithread {
    public static void main(String[] args) throws InterruptedException {
        multi r1=new multi();
        Thread t1=new Thread(r1);
        factor r2=new factor();
        Thread t2=new Thread(r2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
