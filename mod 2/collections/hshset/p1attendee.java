import java.util.*;
class attendee{
    int regid;
    String name,email;
    public attendee(int r,String n,String e){
        regid=r;
        name=n;
        email=e;
    }
    public boolean equals(Object o){
        if(this ==o) return true;
        if(o==null|| getClass()!=o.getClass()) return false;
        attendee a=(attendee) o;
        return regid == a.regid && Objects.equals(name,a.name)&& Objects.equals(email,a.email);
    }
    public int hashCode(){
        return Objects.hash(regid, name, email);    }
    public String toString(){
        return "regid:"+regid+" | name: "+name+" | email: "+email;
    }
}
public class p1attendee {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
    HashSet <attendee> at=new HashSet<>();
        System.out.println("n?");
        int n=sc.nextInt();
        while (at.size()<n) {
            System.out.println("regid,name,mail?");
            int r=sc.nextInt();
            String nm=
            sc.next();
            String em=
            sc.next();
            attendee temp = new attendee(r, nm, em);

if(at.contains(temp)) {

    System.out.println(
        "Attendee already exists. Please use different details.");
}

else {

    at.add(temp);
}
        }
        for(attendee attend:at){
            System.out.println(attend);
        }
    }
    
}