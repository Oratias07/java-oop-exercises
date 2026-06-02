package cards;

public class Deck {
    private Card[] cards;
    private int numCards;

    public Deck(int num) {
        this.numCards = num * 4;
        this.cards = new Card[this.numCards];
        for (int i = 0; i < num; i++) {
            this.cards[i * 4] = new Card(i, 0);
            this.cards[i * 4 + 1] = new Card(i, 1);
            this.cards[i * 4 + 2] = new Card(i, 2);
            this.cards[i * 4 + 3] = new Card(i, 3);
        }
    }

    public Deck(Deck from, int num) {
        int actual = Math.min(num, from.numCards);
        this.cards = new Card[actual];
        this.numCards = 0;
        for (int i = 0; i < actual; i++) {
            this.cards[i] = from.takeOne();
            this.numCards++;
        }
    }

    public Deck(Deck first, Deck second) {
        this.numCards = first.numCards + second.numCards;
        this.cards = new Card[this.numCards];
        int idx = 0;
        while (first.numCards > 0 || second.numCards > 0) {
            if (first.numCards > 0)
                this.cards[idx++] = first.takeOne();
            if (second.numCards > 0)
                this.cards[idx++] = second.takeOne();
        }
    }

    public int getNumCards() {
        return this.numCards;
    }

    public Card takeOne() {
        if (this.numCards == 0) {
            return null;
        } else {
            this.numCards--;
            return this.cards[this.numCards];
        }
    }

    public String toString() {
        String result = "[";
        for (int i = 0; i < this.numCards; i++) {
            result += this.cards[i].toString();
            if (i < this.numCards - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }

    public void sort() {
        for (int i = 0; i < this.numCards - 1; i++) {
            for (int j = 0; j < this.numCards - 1 - i; j++) {
                if (this.cards[j].compareTo(this.cards[j + 1]) > 0) {
                    Card temp = this.cards[j];
                    this.cards[j] = this.cards[j + 1];
                    this.cards[j + 1] = temp;
                }
            }
        }
    }

}
