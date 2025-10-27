// Parent class
abstract class Character {
    String name;
    int health;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    // Abstract method to be overridden by subclasses
    public abstract void attack();
}

// Child class for Warrior
class Warrior extends Character {
    public Warrior(String name, int health) {
        super(name, health);
    }

    @Override
    public void attack() {
        System.out.println(name + " swings their sword for high damage! Defense is strong.");
    }
}

// Child class for Mage
class Mage extends Character {
    int mana;

    public Mage(String name, int health, int mana) {
        super(name, health);
        this.mana = mana;
    }

    @Override
    public void attack() {
        if (mana >= 10) {
            System.out.println(name + " casts a powerful fire spell! Mana is now " + (mana - 10) + ".");
            mana -= 10;
        } else {
            System.out.println(name + " doesn't have enough mana to cast a spell.");
        }
    }
}

// Child class for Archer
class Archer extends Character {
    public Archer(String name, int health) {
        super(name, health);
    }

    @Override
    public void attack() {
        System.out.println(name + " fires a long-range arrow, striking from a distance.");
    }
}

class BattleSystem {
    public static void main(String[] args) {
        Character[] army = new Character[3];
        army[0] = new Warrior("Aragorn", 150);
        army[1] = new Mage("Gandalf", 100, 200);
        army[2] = new Archer("Legolas", 120);

        System.out.println("--- Battle Commences! ---");
        for (Character character : army) {
            character.attack();
        }
    }
}