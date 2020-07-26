public class Player{
    private Card[] _hand;
    private String _name;
    private String _password;
    private Card[] _cardsPlayed;

    public Player(String name, String password) {
        _hand = new Card[1];
        _name = name;
        _password = password;
        _cardsPlayed = new Card[1];
    }

    public void playCard(Card play) {
        addCard(play, _cardsPlayed);
    }

    public void addCard(Card in) {
        addCard(in, _hand);
    }

    public void addCard(Card in, Card[] source) {
        Card[] temp = new Card[source.length + 1];
        for(int i = 0; i < source.length; i++)
            temp[i] = source[i];
        temp[temp.length - 1] = in;
        source = temp;
    }

    public String getName() {
        return _name;
    }

    public String getHand(String pass) {
        String s = "";
        if(pass.equals(_password))
            for(int i = 0; i < _hand.length; i++)
                s += _hand[i] + " ";
        else
            s = "Incorrect password";
        return s;
    }

    public Card removeCard(String suit, String rank) {
        Card out = null;
        for(int i = 0; i < _hand.length; i++) {
            if(suit.equals(_hand[i].getSuit()) && rank.equals(_hand[i].getRank()))
                 out = _hand[i];
        }
        return out;
    }

    public boolean isEmpty() {
        return (_hand.length == 0);
    }

    public String cardsPlayed() {
        String s = "";
        for(int i = 0; i < _cardsPlayed.length; i++)
            s += _cardsPlayed[i] + "\n";
        return s;
    }
}
