class Bird {
    void fly() {
        System.out.println("Bird is flying (general behavior)");
    }
}

class Penguin extends Bird {
    @Override
    void fly() {
        System.out.println("Penguin cannot fly");
    }
}

class Eagle extends Bird {
    @Override
    void fly() {
        System.out.println("Eagle soars high in the sky");
    }
}

public class Main1 {
    public static void main(String[] args) {
        Bird[] birds = {
            new Bird(),
            new Penguin(),
            new Eagle()
        };

        for (Bird b : birds) {
            b.fly(); // Shows polymorphism: calls the correct fly() based on object type
        }
    }
}
