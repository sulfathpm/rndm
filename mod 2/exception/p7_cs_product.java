// create a class Product (productName, stockQuantity).
// Implement a method purchase(int quantity):
// If the requested quantity is less than or equal to zero, 
// throw a built-in IllegalArgumentException with the message: "Quantity must be positive".
// If the requested quantity is greater than stockQuantity, throw a custom OutOfStockException.

import java.util.Scanner;

class OutOfStockException extends Exception{
    public OutOfStockException(String msg){
        super(msg);
    }
}

public class p7_cs_product {
    String productName;
    static double stockQuantity;
    public p7_cs_product(){
        Scanner sc=new Scanner(System.in);
        System.out.println("prod name?");
        productName=sc.next();
        System.out.println("stock quantity?");
        stockQuantity=sc.nextDouble();

    }
    public static void purchase(int quantity) throws OutOfStockException{
        if(quantity<=0) throw new IllegalArgumentException("Quantity must be positive");
        if(quantity>stockQuantity){
            throw new OutOfStockException("quantity is greater than stock");
        }
        else{
            System.out.println("purchased "+quantity);
            stockQuantity-=quantity;
            System.out.println("remiang "+stockQuantity);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
                p7_cs_product p = new p7_cs_product();

        try{
            System.out.println("quantity to purchase?");
            int q=sc.nextInt();
            purchase(q);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
