package videopoker;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card>currentHand = new ArrayList<Card>();
	private ArrayList<Card>trash = new ArrayList<Card>();

	Deck d = new Deck();	
	
	public void fill(){
		while(currentHand.size() < 5){
			currentHand.add(d.draw());
		}
	}
	public void plusOne(){
		currentHand.add(d.draw());

	}	
	public void discard(int i){
		currentHand.remove(currentHand.get(i - 1));
		trash.add(currentHand.get(i - 1));
	}
	public ArrayList<Card> showHand(){
		return currentHand;
	}

}
