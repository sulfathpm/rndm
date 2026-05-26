class Person {

    String name;

    Person(String name) {

        this.name = name;
    }
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

        System.out.println("Name : " + name);
        System.out.println("Roll No : " + roll);
        System.out.println("Marks : " + marks);
        System.out.println();
    }
}

class Shared {

    boolean studentTurn = true;

    synchronized void printStudent(Student s) {

        try {

            while (!studentTurn) {

                wait();
            }

            s.printDetails();

            studentTurn = false;

            notify();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    synchronized void printFactor(int factor) {

        try {

            while (studentTurn) {

                wait();
            }

            System.out.println("Factor : " + factor);
            System.out.println();

            studentTurn = true;

            notify();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}

class StudentThread extends Thread {

    Student students[];
    Shared sh;

    StudentThread(Student students[], Shared sh) {

        this.students = students;
        this.sh = sh;
    }

    public void run() {

        for (Student s : students) {

            sh.printStudent(s);
        }
    }
}

class FactorThread extends Thread {

    Shared sh;
    int num;

    FactorThread(Shared sh, int num) {

        this.sh = sh;
        this.num = num;
    }

    public void run() {

        for (int i = 1; i <= num; i++) {

            if (num % i == 0) {

                sh.printFactor(i);
            }
        }
    }
}

public class q2{ 

    public static void main(String[] args) {

        Student students[] = {

            new Student("Anu", 101, 90),

            new Student("Rahul", 102, 85),

            new Student("Arun", 103, 88)
        };

        Shared sh = new Shared();

        StudentThread t1 =
                new StudentThread(students, sh);

        FactorThread t2 =
                new FactorThread(sh, 12);

        t1.start();

        t2.start();
    }
}