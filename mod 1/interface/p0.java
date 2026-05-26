interface Animal {
    void sound();
}

class Dog implements Animal {

    public void sound() {
        System.out.println("Dog barks");
    }
}

public class p0 {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.sound();
    }
}