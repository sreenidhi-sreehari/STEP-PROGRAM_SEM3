class Instrument {
    String name, material;
    Instrument(String name, String material) {
        this.name = name;
        this.material = material;
    }
}

class Piano extends Instrument {
    int keys;
    Piano(String n, String m, int k) {
        super(n, m);
        keys = k;
    }
    void show() {
        System.out.println(name + " Piano, Material: " + material + ", Keys: " + keys);
    }
}

class Guitar extends Instrument {
    int strings;
    Guitar(String n, String m, int s) {
        super(n, m);
        strings = s;
    }
    void show() {
        System.out.println(name + " Guitar, Material: " + material + ", Strings: " + strings);
    }
}

class Drum extends Instrument {
    String type;
    Drum(String n, String m, String t) {
        super(n, m);
        type = t;
    }
    void show() {
        System.out.println(name + " Drum, Material: " + material + ", Type: " + type);
    }
}

public class TestInstruments {
    public static void main(String[] args) {
        Instrument[] arr = {
            new Piano("Yamaha", "Wood", 88),
            new Guitar("Fender", "Wood", 6),
            new Drum("Pearl", "Metal", "Snare")
        };
        for (Instrument i : arr) {
            if (i instanceof Piano) ((Piano)i).show();
            else if (i instanceof Guitar) ((Guitar)i).show();
            else if (i instanceof Drum) ((Drum)i).show();
        }
    }
}
