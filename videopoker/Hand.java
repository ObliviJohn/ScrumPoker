package scrum;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card>currentHand;
	private ArrayList<Card>trash;

	Deck d = new Deck();	
	
	public void fill(){
		for(;currentHand.size < 5;){
			currentHand.add(d.draw());
		}
	}
	public void add(){
		currentHand(d.draw());

	}	
	public void discard(int i){
		currentHand.remove(i - 1);
		trash.add(i - 1);
	}
	
}
