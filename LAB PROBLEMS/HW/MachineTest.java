interface Printer {
    void connect();
}

interface Scanner {
    void connect();
}

class AllInOneMachine implements Printer, Scanner {
    public void connect() {
        System.out.println("Connected to All-in-One Machine.");
    }
}

public class MachineTest {
    public static void main(String[] args) {
        Printer p = new AllInOneMachine();
        p.connect();
        Scanner s = new AllInOneMachine();
        s.connect();
    }
}
