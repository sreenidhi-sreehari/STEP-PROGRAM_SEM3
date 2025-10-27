// File: GameBattle.java
public class GameBattle {
    public void attack(int damage) {
        System.out.println("Basic attack for " + damage + " points!");
    }

    public void attack(int damage, String weapon) {
        System.out.println("Attacking with " + weapon + " for " + damage + " points!");
    }

    public void attack(int damage, String weapon, boolean isCritical) {
        if (isCritical) {
            System.out.println("CRITICAL HIT! " + weapon + " deals " + (damage * 2) + " points!");
        } else {
            attack(damage, weapon); // Reuse overloaded method
        }
    }

    public void attack(int damage, String[] teammates) {
        String teamNames = String.join(", ", teammates);
        System.out.println("Team attack with " + teamNames + " for " + (damage * teammates.length) + " total damage!");
    }

    public static void main(String[] args) {
        GameBattle gb = new GameBattle();
        gb.attack(50); // Basic
        gb.attack(75, "Sword"); // With weapon
        gb.attack(60, "Bow", true); // Critical
        gb.attack(40, new String[]{"Alice", "Bob"}); // Team attack
    }
}
