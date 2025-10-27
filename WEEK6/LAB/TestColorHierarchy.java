class Color {
    String name;
    Color(String name) {
        this.name = name;
    }
}

class PrimaryColor extends Color {
    int intensity;
    PrimaryColor(String name, int intensity) {
        super(name);
        this.intensity = intensity;
    }
}

class RedColor extends PrimaryColor {
    String shade;
    RedColor(String name, int intensity, String shade) {
        super(name, intensity);
        this.shade = shade;
    }

    void showDetails() {
        System.out.println("Color: " + name + ", Intensity: " + intensity + ", Shade: " + shade);
    }
}

public class TestColorHierarchy {
    public static void main(String[] args) {
        RedColor red = new RedColor("Red", 85, "Dark");
        red.showDetails();
    }
}
