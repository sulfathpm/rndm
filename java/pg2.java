import java.util.*;
class Student {
    int rno,marks;
    String name;
    Student(){
        rno=0;
        marks=0;
        name='None';
    }
       
}

public class pg2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of students?");
        int n=sc.nextInt();
        
        Student s[]=new Student[n];
        for(int i=0;i<n;i++){
            System.out.println("rno,name,mark of student"+(i+1)+"?");
            s[i].rno=sc.nextInt();
            s[i].name=sc.next();
            s[i].marks=sc.nextInt();
        }
        System.out.println("no. of students:"+n);
        sortRank(s, n);
        System.out.println("rank\troll no\tname\tmarks");
        for(int i=0;i<n;i++){
            System.out.println((i+1)+"\t"+s[i].rno+"\t"+s[i].name+"\t"+s[i].marks);
        }
        
    }        
    public static void sortRank(Student s[],int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(s[i].marks<s[j].marks){
                    Student st=s[i];
                    s[i]=s[j];
                    s[j]=st;
                }
            }
        }
    }
    
}
