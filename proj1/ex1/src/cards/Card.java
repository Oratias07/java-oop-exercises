package cards;

public class Card {
    private int num;
    private int suit;

    public Card(int num, int suit) {
        this.suit = suit;
        this.num = num;
    }

    public int getNum() {
        return this.num;
    }

    public int getSuit() {
        return this.suit;
    }

    public String toString() {
        if (this.suit == 0) {
            return this.num + "C";
        } else if (this.suit == 1) {
            return this.num + "D";
        } else if (this.suit == 2) {
            return this.num + "H";
        } else { // This.suit == 3
            return this.num + "S";
        }
    }

    public int compareTo(Card other) {
        if (this.num < other.num) {
            return -1;
        } else if (this.num > other.num) {
            return 1;
        } else { // This.num == other.num
            if (this.suit < other.suit) {
                return -1;
            } else if (this.suit > other.suit) {
                return 1;
            } else { // This.suit == other.suit
                return 0;
            }
        }
    }

}