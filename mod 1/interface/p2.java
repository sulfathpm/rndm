interface Measurable{
    public String getVal();
    String unit="sq cm";
}
class rec implements Measurable{
    double l,b;
    public rec(double len,double brd){
        l=len;
        b=brd;
    }
    public String getVal(){
        return l*b+unit;
    }
}
class sq implements Measurable{
    int x;
    public sq(int s){
        x=s;
    }
    public String getVal(){
        return x*x+unit;
    }
}
public class p2 {
    public static void main(String[] args) {
        Measurable m[]=new Measurable[2];
        m[0]=new rec(1, 1);
        m[1]=new sq(5);
        System.out.println(m[0].getVal());
        System.out.println(m[1].getVal());
    }
}
