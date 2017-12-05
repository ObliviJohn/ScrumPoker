package Model;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card>currentHand = new ArrayList<Card>();
	private int hValue, drawVal;
	private String hDesc, dDesc;
	Deck d = new Deck();	
	Evaluator e = new Evaluator();
	
	public Hand(){
		fill();
		eval();
	}
	
	public void fill(){					
		while(currentHand.size() < 5){
			currentHand.add(d.draw());
		}
	}
	
	public void discard(int arr[]){
		
		for(int i = 4; i >= 0; i--){
			
			if (arr[i] == 1){
				currentHand.remove(currentHand.get(i));
			}
		}
		fill();
		e.handEv(currentHand);
		hValue = e.getScore();
		hDesc = e.getDesc();
		
	}
	
	public ArrayList<Card> getHand(){
		return currentHand;
	}
	
	public int getVal(){
		return hValue;
	}
	
	public int getDrawVal(){
		return drawVal;
	}
	
	public String getDesc(){
		return hDesc;
	}
	
	public String getDrawDesc(){
		return dDesc;
	}
	
	public void eval(){
		e.handEv(currentHand);
		hValue = e.getScore();
		hDesc = e.getDesc();
		drawVal = e.getDrawVal();
		dDesc = e.getDrawDesc();
	}
	

	public void newHand(){
		currentHand.clear();
		d.createCards();
		fill();
		e.handEv(currentHand);
		hValue = e.getScore();
		hDesc = e.getDesc();
		drawVal = e.getDrawVal();
		dDesc = e.getDrawDesc();
	}
	
}