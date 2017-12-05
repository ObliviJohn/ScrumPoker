package videopoker;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card>currentHand = new ArrayList<Card>();
	private int hValue, drawVal;
	private String hDesc, dDesc;
	Deck d = new Deck();	
	Evaluator e = new Evaluator();
<<<<<<< HEAD
	
//	public Hand(){
//		fill();
//		eval();
//	}
	
	public void fill(){					
		while(currentHand.size() < 5){
			currentHand.add(d.draw());
		}
	}
	
	public void discard(int arr[]){
		
		for(int i = 4; i >= 0; i--){
			
			if (arr[i] == 1){
				currentHand.remove(currentHand.get(i));
				currentHand.add(i, d.draw());
			}
=======
	
	public Hand(){
		fill();
		eval();
	}
	
	public void fill(){					
		while(currentHand.size() < 5){
			currentHand.add(d.draw());
>>>>>>> e55865049a98be84581d47a795c08d903cf636cb
		}
		eval();
	}
	
<<<<<<< HEAD
	public ArrayList<Card> getHand(){//Ret. ArrayList av Card
		return currentHand;
	}
	
	public int getVal(){//Ret. 0-9 fÃ¶r handstyrka. Ex 5 fÃ¶r flush
		return hValue;
	}
	
	public int getDrawVal(){//Ret. siffra frÃ¥n 1 till 5. Ex 1 fÃ¶r hÃ¥lstegdrag
=======
	public void discard(int arr[]){
		
		for(int i = 4; i >= 0; i--){
			
			if (arr[i] == 1){
				currentHand.remove(currentHand.get(i));
				currentHand.add(i, d.draw());
			}
		}
		eval();
	}
	
	public ArrayList<Card> getHand(){//Ret. ArrayList av Card
		return currentHand;
	}
	
	public int getVal(){//Ret. 0-9 för handstyrka. Ex 5 för flush
		return hValue;
	}
	
	public int getDrawVal(){//Ret. siffra från 1 till 5. Ex 1 för hålstegdrag
>>>>>>> e55865049a98be84581d47a795c08d903cf636cb
		return drawVal;
	}
	
	public String getDesc(){//Ret. ex "Pair: 9"
		hDesc = hDesc.replace("11", "J");
		hDesc = hDesc.replace("12", "Q");
		hDesc = hDesc.replace("13", "K");
		hDesc = hDesc.replace(" 1 ", " A ");

		return hDesc;
	}
	
	public String getDrawDesc(){//Ret. beskr. av drag. Ex "Flush draw"
		return dDesc;
	}
	
<<<<<<< HEAD
	public void eval(){//UtvÃ¤rderar hand och sÃ¤tter hValue mm.
=======
	public void eval(){//Utvärderar hand och sätter hValue mm.
>>>>>>> e55865049a98be84581d47a795c08d903cf636cb
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
		eval();
	}
	
}