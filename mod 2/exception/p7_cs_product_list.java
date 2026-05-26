import java.util.Scanner;

class OutOfStockException extends Exception{
    public OutOfStockException(String msg){
        super(msg);
    }
}
public class p7_cs_product_list {
    static String productName[];
    static double stockQuantity[];
    static int n;
    public p7_cs_product_list(){
        Scanner sc=new Scanner(System.in);
        
        System.out.println("items rqd?");
        n=sc.nextInt();
        productName=new String[n];
        stockQuantity=new double[n];
        for (int i = 0; i < n; i++) {
            System.out.println("prod name?");
            productName[i]=sc.next();
            System.out.println("stock quantity?");
            stockQuantity[i]=sc.nextDouble();  
        }

    }
    public static void purchase(String item,double quantity) throws OutOfStockException{
        int found=0;
        for (int i = 0; i <n; i++) {
            if(item.equals(productName[i])){
                found=1;
           
        if(quantity<=0) throw new IllegalArgumentException("qnty cnt be -ve");
        if(quantity>stockQuantity[i]) throw new OutOfStockException("out of stock.choose less quantity");
        else{
            stockQuantity[i]-=quantity;
            System.out.println("purchased "+quantity+" rmeaing "+stockQuantity[i]);
            }
        }
        }
    if(found==0) {
        System.out.println("item not found");
    }
    }
    public static void main(String[] args) {
        p7_cs_product_list p=new p7_cs_product_list();
        Scanner sc=new Scanner(System.in);
        
        try{
            System.out.println("item to purchase ?");
            String item=sc.next();
            System.out.println("quantity t puchase?");
            double q=sc.nextDouble();
            purchase(item,q);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
