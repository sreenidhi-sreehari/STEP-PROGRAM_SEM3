class Fruit {
    protected String color;
    protected String taste;
}

class Apple extends Fruit {
    protected String variety;
}

public class TestFruit {
    public static void main(String[] args) {
        Apple myApple = new Apple();
        myApple.color = "Red";
        myApple.taste = "Sweet";
        myApple.variety = "Honeycrisp";

        System.out.println("Apple Color: " + myApple.color);
        System.out.println("Apple Taste: " + myApple.taste);
        System.out.println("Apple Variety: " + myApple.variety);
    }
}

