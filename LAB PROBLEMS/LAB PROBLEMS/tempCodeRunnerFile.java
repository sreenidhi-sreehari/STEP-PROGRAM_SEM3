
abstract class AbstractFruit {
    protected String color;
    protected String taste;

    public AbstractFruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }

     abstract void showDetails();
}

interface Edible {
    void nutrientsInfo();
}

class Apple extends AbstractFruit implements Edible {
    private String variety;

    public Apple(String color, String taste, String variety) {
        super(color, taste);
        this.variety = variety;
    }

    @Override
    public void showDetails() {
        System.out.println("Apple Variety: " + variety + ", Color: " + color + ", Taste: " + taste);
    }

    @Override
    public void nutrientsInfo() {
        System.out.println("Apples are rich in Vitamin C and Fiber.");
    }
}

public class Fruit {
    public static void main(String[] args) {
        Apple apple = new Apple("Red", "Sweet", "Fuji");
        apple.showDetails();
        apple.nutrientsInfo();
    }
}
