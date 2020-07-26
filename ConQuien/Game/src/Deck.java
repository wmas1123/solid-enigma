/*
This object is used to simulate a deck of playing cards
Methods used -
createDeck used to create the deck of 52 Card objects
topCard returns the String of teh top card, used for games that implement a discard pile
toString displays the entire deck
shuffle and swap are both used to shuffle the deck for games that require that method
deal is used to remove the card at the bottom of the deck in this case we treat the bottom of the deck as the top
insert inserts a card into the deck, mainly used for a discard pile
isEmpty checks if the deck is empty with a boolean
 */

import java.util.*;
public class Deck {
    private Card[] _deck;
    private final int SWAP_COUNT = 1000; //Arbitrary number, felt it used a proper amount of swaps
    private final int CARD_COUNT = 10; //Accounts for 52 cards in a deck, 4 suits (Clubs, Spades, Diamonds, and Hearts),
                                       //and 13 ranks (Ace, 2-10, Jack, Queen, King)

    //Initializes the Deck object as an array of 52 cards.
    public Deck(){
        _deck = new Card[CARD_COUNT];
    }

    //Creates the deck object, consists of 52 cards (4 suits, 13 ranks)
    public void createDeck() {
        Card temp;
        for(int i=0; i < 4; i++)
            for(int j = 0; j < 13; j++)
                insert(new Card(i, j));
}

    //Displays the top card
    public String topCard(){
        return "" + _deck[_deck.length - 1];
    }

    //Displays the entire deck, used for testing purposes only
    public String toString(){
        String s = "";
        for(int i = 0; i < _deck.length; i++)
            if(_deck[i] != null)
                s += _deck[i] + "\n";
        return s;
    }

    //shuffles the Deck object, implements the swap method and Random to accomplish
    public void shuffle() {
        int rand;
        int rand2;
        Random rgen = new Random();
        for(int i = 0; i < SWAP_COUNT; i++) {
            rand = rgen.nextInt(52);
            rand2 = rgen.nextInt(52);
            if(rand != rand2)
                swap(rand, rand2);
        }
    }

    //used to aid the shuffle method, swaps the position of 2 indexes of Card objects by swapping
    //@param int, int - 2 indexes that will switch places.
    public void swap(int i1, int i2) {
        Card temp = _deck[i1];
        _deck[i1] = _deck[i2];
        _deck[i2] = temp;
    }

    //Can also be referenced as a remove card method, used to remove the card at index _deck.length
    //also creates a new array, shortening the length of the array.
    public Card deal(){
        Card dealt = null;
        for(int i = 0;i < _deck.length; i++)
            if(_deck[i] != null) {
                dealt = _deck[i];
                _deck[i] = null;
                return dealt;
            }
        return null;
    }

    //returns a boolean based on if the deck length is 0
    public boolean isEmpty() {
        return(_deck.length == 0);
    }

    public boolean isFull() {
        for(int i = 0; i < _deck.length; i++)
            if(_deck[i] == null)
                return false;
        return true;
    }
    //Inserts a card object into the array by resizing the array and putting the new object into the _deck object
    //@param Card object to insert
    //This method is meant to be used for an empty deck i.e. a discard pile
    public void insert(Card in) {
        Card[] temp;
        if(isFull())
            temp = new Card[_deck.length + 1];
        else
            temp = _deck;
        for(int i = 0; i < _deck.length; i++) {
            temp[i] = _deck[i];
            if (_deck[i] == null) {
                temp[i] = in;
                return;
            }
        }
        temp[temp.length - 1] = in;
        _deck = temp;
    }
}