public class Card{
    private String _suit;
    private int _index;
    private String _rank;

    public Card(int suitIndex, int cardIndex) {
        _suit = getSuit(suitIndex);
        _index = cardIndex;
        _rank = getRank(_index);
    }

    public int getIndex() {
        return _index;
    }

    public String getRank(int i) {
        String rank = "" + (i + 1);
        switch (i){
            case 0:
                rank = "Ace";
                break;
            case 10:
                rank = "Jack";
                break;
            case 11:
                rank = "Queen";
                break;
            case 12:
                rank = "King";
                break;
        }
        return rank;
    }

    public String getSuit(int i){
        String s = "Clubs";
        switch(i) {
            case 1:
                s = "Diamonds";
                break;
            case 2:
                s = "Hearts";
                break;
            case 3:
                s = "Spades";
                break;
        }
        return s;
    }

    public String getRank(){
        return _rank;
    }

    public String getSuit(){
        return _suit;
    }

    public int compareTo(Card other) {
        if(_suit.compareTo(other.getSuit()) == 0)
            return getIndex() - other.getIndex();
        else return -1;
    }

    public String toString() {
        return getRank() + " of " + getSuit();
    }
}