package scrum;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	List<String>handO = new ArrayList<>();
	List<String>trash = new ArrayList<>();

	Deck d = new Deck();	
	
	public void fill(){
		for(;handO.size < 5;){
			handO.add(d.draw());
		}
	}
	public void add(){
		handO.add(d.draw());

	}	
	public void discard(int i){
		handO.remove(i - 1);
		trash.add(i - 1);
	}
	
}
