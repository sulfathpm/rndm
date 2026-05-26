import java.util.*;

class attendee {

    int regid;
    String name, email;

    public attendee(int r, String n, String e) {

        regid = r;
        name = n;
        email = e;
    }

    public String toString() {

        return "regid:" + regid +
               " | name: " + name +
               " | email: " + email;
    }
}

public class p1attendee {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashSet<attendee> at =
                new HashSet<>();

        System.out.println("n?");
        int n = sc.nextInt();

        while(at.size() < n) {

            System.out.println(
                    "regid,name,mail?");

            int r = sc.nextInt();
            String nm = sc.next();
            String em = sc.next();

            boolean duplicate = false;

            for(attendee a : at) {

                // same regid

                if(a.regid == r) {

                    System.out.println(
                        "Reg ID already exists");

                    duplicate = true;
                    break;
                }

                // same name + email

                if(a.name.equals(nm)
                   &&
                   a.email.equals(em)) {

                    System.out.println(
                        "Attendee already exists");

                    duplicate = true;
                    break;
                }
            }

            if(!duplicate) {

                at.add(
                    new attendee(r,nm,em)
                );
            }
        }

        System.out.println("\nAttendees:");

        for(attendee attend : at) {

            System.out.println(attend);
        }
    }
}