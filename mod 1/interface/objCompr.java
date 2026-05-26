 interface Comparable {
    public double volume();
    public int compareByVol(Comparable o);
    
}
class rec implements Comparable{
    double l,b,h;
    public rec(double le,double br,double he){
        l=le;
        h=he;
        b=br;
    }
    public double volume(){
        return l*b*h;
    }
    public int compareByVol(Comparable o){
        if(volume()<o.volume()) return -1;
        else if(volume()>o.volume()) return 1;
        else return 0;
    }
}
public class objCompr {
        public static void main(String[] args) {

    rec r1 = new rec(2, 3, 4);

        rec r2 = new rec(3, 3, 3);

        System.out.println("Volume of r1 = " + r1.volume());

        System.out.println("Volume of r2 = " + r2.volume());

        int result = r1.compareByVol(r2);

        if (result == 0)
            System.out.println("Both volumes are equal");

        else if (result < 0)
            System.out.println("r1 volume is smaller");

        else
            System.out.println("r1 volume is greater");
    }
}
