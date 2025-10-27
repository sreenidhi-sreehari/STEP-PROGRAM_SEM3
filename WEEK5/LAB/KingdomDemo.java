import java.util.*;

final class KingdomConfig {
    private final String kingdomName;
    private final int foundingYear;
    private final List<String> structures;

    public KingdomConfig(String name, int year, List<String> structs) {
        this.kingdomName = name;
        this.foundingYear = year;
        this.structures = new ArrayList<>(structs);
    }

    public String getKingdomName() { return kingdomName; }
    public int getFoundingYear() { return foundingYear; }
    public List<String> getStructures() { return new ArrayList<>(structures); }
}

class MagicalStructure {
    private final String name;
    private int magicPower;

    public MagicalStructure(String name, int power) {
        this.name = name;
        this.magicPower = power;
    }

    public String getName() { return name; }
    public int getMagicPower() { return magicPower; }
    public void boostPower(int delta) { magicPower += delta; }
}

public class KingdomDemo {
    public static void main(String[] args) {
        KingdomConfig config = new KingdomConfig("Avalon", 1024, Arrays.asList("Castle", "Library"));
        MagicalStructure tower = new MagicalStructure("WizardTower", 500);
        tower.boostPower(50);

        System.out.println(config.getKingdomName() + " founded in " + config.getFoundingYear());
        System.out.println("Structures: " + config.getStructures());
        System.out.println(tower.getName() + " power: " + tower.getMagicPower());
    }
}
