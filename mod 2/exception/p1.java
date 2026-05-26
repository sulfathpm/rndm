public class p1 {
    public static void main(String[] args) {
        int a[]={1,2};
        int c=2;
        
        try{
            System.out.println(a[3]);
            int b=c/0;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }catch(ArithmeticException e){
            System.out.println(e);
        }finally{
            System.out.println("finally block executed");
        }

    }
}
