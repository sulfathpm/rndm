class Animal {
    void sound() {
        System.out.println("Animal Sound");
    }
}

class Dog extends Animal {
    void sound() {
        super.sound();
        System.out.println("Dog Barks");
    }
}

public class dynmic_methd_disptch {
    public static void main(String[] args) {

        Animal a;

        a = new Dog();

        a.sound();
    }
}

