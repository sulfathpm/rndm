class Person {
    String name;
    Person(String name) { this.name = name; }
}

class Student extends Person {
    int roll;
    int marks;

    Student(String name, int roll, int marks) {
        super(name);
        this.roll = roll;
        this.marks = marks;
    }

    void printDetails() {
        System.out.println("Name    : " + name);
        System.out.println("Roll No : " + roll);
        System.out.println("Marks   : " + marks);
        System.out.println();
    }
}

class Shared {
    // Standard synchronized methods acting as our execution blocks
    synchronized void printStudent(Student s) {
        s.printDetails();
    }

    synchronized void printFactor(int factor) {
        System.out.println("Factor  : " + factor);
        System.out.println();
    }
}

class StudentThread extends Thread {
    Student[] students;

    final static Object lock=q11.lock;

    StudentThread(Student[] students, Shared sh) {
        this.students = students;
    }

    public void run() {
        for (Student s : students) {
            sh.printStudent(s);
            try { 
                // Yield control to give the factor thread time to print
                Thread.sleep(200); 
            } catch (InterruptedException e) { }
        }
    }
}

class FactorThread extends Thread {
final static Object lock=q11.lock;
    int num;

    FactorThread(Shared sh, int num) {
        this.sh = sh;
        this.num = num;
    }

    public void run() {
        // Give the student thread a tiny head start to match your lab's goal
        try { Thread.sleep(50); } catch (InterruptedException e) { }

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                sh.printFactor(i);
                try { 
                    // Yield control to let the student thread print next
                    Thread.sleep(200); 
                } catch (InterruptedException e) { }
            }
        }
    }
}

public class q11 { 
    final static Object lock = new Object();

    public static void main(String[] args) {
        Student[] students = {
            new Student("Anu", 101, 90),
            new Student("Rahul", 102, 85),
            new Student("Arun", 103, 88)
        };


        StudentThread t1 = new StudentThread(students, sh);
        FactorThread t2 = new FactorThread(sh, 12);

        t1.start();
        t2.start();
    }
}