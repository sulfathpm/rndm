import java.util.*;
class student{
    int rno;
    String name;
    public student(int rno,String name){
        this.rno=rno;
        this.name=name;
    }
    public String toString(){
        return "rollno : "+rno+"| name : "+name;
    }
}
public class p0arrlist {
    public static void main(String[] args) {
        ArrayList<student> st=new ArrayList<>();
        st.add(new student(0,"anna"));
        st.add(new student(2, "abc"));
        st.add(new student(1, "bc"));
        Collections.sort(st,Comparator.comparing((student s)->s.name).reversed());
        System.out.println(st);
    }
}
