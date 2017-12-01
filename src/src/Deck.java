package src;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;

    public Card draw(){
        Card temp = cards.get(0);
        cards.remove(0);
        return temp;
    }
    //Constructor
    public Deck(){
        newDeck();
    }
    public void shuffle(){
        ArrayList<Card> temp = new ArrayList<>();
        while(!cards.isEmpty()) {
            int loc=(int)(Math.random()* cards.size());
            temp.add(cards.get(loc));
            cards.remove(loc);
        }
        cards =temp;
    }
    //newDeck method can be used if multiple decks are used.
    private void newDeck() {
        cards = new ArrayList<>();
        for (int i = 0; i < 4;i++){//Generate Suit
            for (int j = 1;j<= 13;j++){//Generate Values
                this.cards.add(new Card(j,Suit.values()[i]));
            }
        }
    }
}
