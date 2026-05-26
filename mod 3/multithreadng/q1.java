class Person {

    String name;

    Person(String name) {

        this.name = name;
    }
}

class Employee extends Person {

    String designation;
    double salary;

    Employee(String name, String designation, double salary) {

        super(name);

        this.designation = designation;
        this.salary = salary;
    }

    void printDetails() {

        System.out.println("Name : " + name);
        System.out.println("Designation : " + designation);
        System.out.println("Salary : " + salary);
        System.out.println();
    }
}

class Shared {

    boolean employeeTurn = true;

    synchronized void printEmployee(Employee e) {

        try {

            while (!employeeTurn) {

                wait();
            }

            e.printDetails();

            employeeTurn = false;

            notify();

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    synchronized void factorial(int num) {

        try {

            while (employeeTurn) {

                wait();
            }

            int fact = 1;

            System.out.print("Factorial Terms : ");

            for (int i = 1; i <= num; i++) {

                fact = fact * i;

                System.out.print(fact + " ");
            }

            System.out.println("\n");

            employeeTurn = true;

            notify();

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }
}

class EmployeeThread extends Thread {

    Employee emp[];
    Shared s;

    EmployeeThread(Employee emp[], Shared s) {

        this.emp = emp;
        this.s = s;
    }

    public void run() {

        for (Employee e : emp) {

            s.printEmployee(e);
        }
    }
}

class FactorialThread extends Thread {

    Shared s;

    FactorialThread(Shared s) {

        this.s = s;
    }

    public void run() {

        s.factorial(5);
    }
}

public class q1{ 

    public static void main(String[] args) {

        Employee emp[] = {

            new Employee("Arun", "Manager", 50000),

            new Employee("Anu", "Developer", 40000),

            new Employee("Rahul", "Tester", 35000)
        };

        Shared s = new Shared();

        EmployeeThread t1 = new EmployeeThread(emp, s);

        FactorialThread t2 = new FactorialThread(s);

        t1.start();

        t2.start();
    }
}