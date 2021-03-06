package Model;

import java.util.*;

public class Evaluator {
	
	private ArrayList<Integer>av    = new ArrayList<Integer>();	//h�r l�ggs alla val�rer
	private ArrayList<Integer>uv    = new ArrayList<Integer>();	//h�r l�ggs unika val�rer
	private ArrayList<Integer>nuv1  = new ArrayList<Integer>();	//h�r l�ggs v�rden som redan finns i ArrayList ovan
	private ArrayList<Integer>nuv2  = new ArrayList<Integer>();	// -:-
	private ArrayList<Integer>nuv3  = new ArrayList<Integer>();	// -:-
	
	private ArrayList<String>uSuits	= new ArrayList<String>(); //max en(1) av varje suit
	private ArrayList<String>aSuits = new ArrayList<String>(); //endast av samma suit som get(0) fr�n listan ovan. Identifierar f�rgdrag
	
	private int hScore, drawVal; //f�r handv�rde 1 - 9
	private String hDesc, dDesc; //f�r beskrivande String. B�de f�rdig hand och potentiella drag
	
	public int getScore(){
		return hScore;
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
	public void valReset(){
		hScore = 0;
		drawVal = 0;
		hDesc = "";
		dDesc = "";
	}
	
	public void handEv(List<Card>cHand){
		clearAll();
		valReset();

		for (int i = 0; i < 5; i++){
			Card c = cHand.get(i);
			int j = c.getValue();
			String s = c.getSuit().toString();
			av.add(j);
			
			if (uSuits.contains(s) == false)
				uSuits.add(s);
			
			if (s == uSuits.get(0))
				aSuits.add(s);
			
			if (uv.contains(j) == false)
				uv.add(j);
			
			else if (uv.contains(j) == true && nuv1.contains(j) == false)
				nuv1.add(j);
		
			else if (nuv1.contains(j) == true && nuv2.contains(j) == false)
				nuv2.add(j);
			
			else if (nuv2.contains(j) == true)
				nuv3.add(j);
			
		}
		Collections.sort(av);
		Collections.sort(uv);
		
		//h�r identifieras f�rdiga h�nder
		
		if (nuv1.size() == 1){
			hDesc = "Pair: " + nuv1.get(0) + " ";
			hScore = 1;
		}
		if (nuv1.size() == 2){
			hDesc = "Twopair: " + nuv1.get(0) + " and " + nuv1.get(1) + " ";
			hScore = 2;
		}
		if (nuv2.size() == 1){
			hDesc = "Three of a kind: " + nuv2.get(0) + " ";
			hScore = 3;
		}
		if (uv.size() == 5 && (uv.get(0) + 4) == uv.get(4)){
			hDesc = "Straight: " + uv.get(4) + " high";
			hScore = 4;
		}
		if (uv.size() == 5 && uv.get(0) == 1 && ((uv.get(1) + 3) == uv.get(4) && uv.get(4) == 13)){
			hDesc = "Straight A high";
			hScore = 4;
		}
		if (uSuits.size() == 1){
			hDesc = "Flush: " + uv.get(4).toString() + " high";
			hScore = 5;
			if (uv.get(0) == 1)
				hDesc = "Flush: A high";
		}
		if (nuv1.size() == 2 && nuv2.size() == 1){
			hDesc = "Full house: " + nuv2.get(0) + " over";
			hScore = 6;
		}
		if (nuv3.size() == 1){
			hDesc = "Four of a kind: " + nuv3.get(0) + " ";
			hScore = 7;
		}	
		if (uv.size() == 5 && (uv.get(0) + 4) == uv.get(4) && uSuits.size() == 1){
			hDesc = "Straight flush " + uv.get(4).toString() + " high";
			hScore = 8;
		}
		if (uSuits.size() == 1 && uv.get(0) == 1 && ((uv.get(1)) + 3) == uv.get(4) && uv.get(4) == 13){
			hDesc = "Royal flush ";
			hScore = 9;
		}
		if (hScore == 0)
			hDesc = "No combinations";
		
		//h�r identifieras stegdrag
		
		if (uv.size() == 5 && (hScore <= 1)){
			int median = av.get(2);
			if (av.get(0) == (av.get(4) - 4)){
				drawVal = 1;
				dDesc = "Gutshot draw";
			}
			else if (av.get(4) <= (median + 3)){
				if ((av.get(1) + 3) == av.get(4)){
					drawVal = 2;
					dDesc = "Open ended draw";
				}
				else if (av.get(1) + 4 == av.get(4)){
					drawVal = 1;
					dDesc = "Gutshot draw";
				}
			}	
		}
		if ((uv.size() == 4 && hScore <= 1) && (uv.get(0) + 3) == uv.get(3)){
			drawVal = 2;
			dDesc = "Open ended draw";
		}
		else if ((uv.size() == 4 && hScore <= 1) && (uv.get(0) + 4) == uv.get(3)){	
			drawVal = 1;
			dDesc = "Gutshot draw";
		}
		if (drawVal == 0 && hScore <= 1){
			if (uv.size() == 5 && (av.get(0) + 3) == av.get(3) && av.get(0) != 1){
				drawVal = 2;
				dDesc = "Open ended draw";
			}
			else if (uv.size() == 5 && av.get(0) + 4 == av.get(3)){
				drawVal = 1;
				dDesc = "Gutshot draw";
			}
		}
		//f�rgdrag samt kombinerade drag
		
		if (uSuits.size() == 2 && (aSuits.size() == 1 || aSuits.size() == 4)){
			if (drawVal == 1){
				drawVal = 4;
				dDesc = "Flush draw and gutshot draw";
			}
			else if (drawVal == 2){
				drawVal = 5;
				dDesc = "Flush draw and open ended draw";
			}
			else {
				drawVal = 3;
				dDesc = "Flush draw";
			}
		}
		if (drawVal == 0){
			dDesc = "No draw";
		}
	}

	public void clearAll(){
		av.clear();
		uv.clear();
		nuv1.clear();
		nuv2.clear();
		nuv3.clear();
		aSuits.clear();
		uSuits.clear();
	}
}
