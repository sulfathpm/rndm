interface Dim {
 public double area(double x);
    
}
public class p1 {
    public static void main(String[] args) {
        Dim sq=(x)->x*x;
        Dim cube=(x)->x*x*x;
        Dim circle=(x)->3.14*x*x;
        Dim sphere=(x)->(4.0/3.0)*3.14*x*x*x;
        System.out.println("sq  : "+sq.area(5)+"| cube : "+cube.area(5)+" | circle: "+circle.area(1)+" | sphere : "+sphere.area(1));
    }
}
