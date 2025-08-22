import java.util.*;

public class DeckOfCards {
    static String[] suits = {"Hearts","Diamonds","Clubs","Spades"};
    static String[] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};

    public static String[] initDeck() {
        String[] deck = new String[suits.length * ranks.length];
        int idx = 0;
        for (String r : ranks) for (String s : suits) deck[idx++] = r + " of " + s;
        return deck;
    }

    public static void shuffle(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int r = i + (int)(Math.random() * (n - i));
            String temp = deck[i]; deck[i] = deck[r]; deck[r] = temp;
        }
    }

    public static String[][] distribute(String[] deck, int n, int players) {
        if (n % players != 0) return null;
        String[][] distributed = new String[players][n/players];
        int idx = 0;
        for (int i=0;i<players;i++) {
            for (int j=0;j<n/players;j++) {
                distributed[i][j] = deck[idx++];
            }
        }
        return distributed;
    }

    public static void printPlayers(String[][] hands) {
        for (int i=0;i<hands.length;i++) {
            System.out.println("Player " + (i+1) + ": " + Arrays.toString(hands[i]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] deck = initDeck();
        shuffle(deck);
        System.out.print("Enter number of cards to distribute: ");
        int n = sc.nextInt();
        System.out.print("Enter number of players: ");
        int players = sc.nextInt();
        String[][] hands = distribute(deck,n,players);
        if (hands==null) System.out.println("Cannot distribute evenly.");
        else printPlayers(hands);
        sc.close();
    }
}
