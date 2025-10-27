import java.util.UUID;

final class PetSpecies {
    private final String name;
    private final String[] stages;
    public PetSpecies(String name, String[] stages) { this.name = name; this.stages = stages.clone(); }
    public String getName() { return name; }
    public String[] getStages() { return stages.clone(); }
}

public class VirtualPet {
    private final String id;
    private final PetSpecies species;
    private String name;
    private int happiness;
    public static final String VERSION = "2.0";

    public VirtualPet(String name, PetSpecies species) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.species = species;
        this.happiness = 50;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getHappiness() { return happiness; }
    public void feed() { happiness = Math.min(100, happiness + 10); }
    public void play() { happiness = Math.min(100, happiness + 5); }

    public static void main(String[] args) {
        PetSpecies cat = new PetSpecies("Cat", new String[]{"Kitten", "Adult"});
        VirtualPet pet = new VirtualPet("Fluffy", cat);
        pet.feed();
        pet.play();
        System.out.println(pet.getName() + " (" + cat.getName() + ") Happiness: " + pet.getHappiness());
    }
}
