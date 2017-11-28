package videopoker;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	List<Card>handO = new ArrayList<>();
	List<Card>trash = new ArrayList<>();

	Deck d = new Deck();	
	
	public void fill(){
		for(;handO.size() < 5;){
			handO.add(d.draw());
		}
	}
	public void add(){
		handO.add(d.draw());

	}	
	public void discard(int i){
		trash.add(handO.get(i - 1));
		handO.remove(i - 1);
	}
	
}
