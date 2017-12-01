package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Hand {
	private ArrayList<Card>currentHand = new ArrayList<Card>();
	private ArrayList<Card>trash = new ArrayList<Card>();
	private int hValue;

	Deck d = new Deck();	
	
	public void fill(){					
		while(currentHand.size() < 5){
			currentHand.add(d.draw());
		}
	}
	
	public void newHand(){
		currentHand.clear();
		d.createCards();
		while(currentHand.size() < 5){
			currentHand.add(d.draw());
		}
	}

	public void plusOne(int i){
		currentHand.add(i - 1, d.draw());
	}	
	
	public void discard(int i){
		trash.add(currentHand.get(i - 1));
		currentHand.remove(currentHand.get(i - 1));
	}
	
	public ArrayList<Card> getHand(){
		return currentHand;
	}
	
	public ArrayList<Card> getTrash(){
		return trash;
	}
	
	public String eval(){
		ArrayList<Integer>av   = new ArrayList<Integer>();	//h?申r l?申ggs alla v?申rden
		ArrayList<Integer>uv   = new ArrayList<Integer>();	//h?申r l?申ggs unika v?申rden
		ArrayList<Integer>nuv1 = new ArrayList<Integer>();	//h?申r l?申ggs v?申rden som redan finns i uv
		ArrayList<Integer>nuv2 = new ArrayList<Integer>();	//h?申r l?申ggs v?申rden som finns i listan ovan
		ArrayList<Integer>nuv3 = new ArrayList<Integer>();	//h?申r l?申ggs v?申rden som finns i listan ovan
		Set<String>suits	   = new HashSet<String>();
		
		for (int i = 0; i < 5; i++){
			Card c = currentHand.get(i);
			int j = c.getValue();
			String s = c.getSuit().toString();
			av.add(j);
			suits.add(s);
			
			if (uv.contains(j) == false)
				uv.add(j);
			
			else if (uv.contains(j) == true && nuv1.contains(j) == false)
				nuv1.add(j);
		
			else if (nuv1.contains(j) == true && nuv2.contains(j) == false)
				nuv2.add(j);
			
			else if (nuv2.contains(j) == true)
				nuv3.add(j);
			
			else
				System.out.println("");
		}
		Collections.sort(uv);
		String s = "Inga kombinationer";
		hValue = 0;
		
		if (nuv1.size() == 1){
			s = "Par i " + nuv1.get(0);
			hValue = 1;
		}
		if (nuv1.size() == 2){
			s = "Tv?申par i " + nuv1.get(0) + " och " + nuv1.get(1);
			hValue = 2;
		}
		if (nuv2.size() == 1){
			s = "Triss i " + nuv2.get(0);
			hValue = 3;
		}
		if (uv.size() == 5 && (uv.get(0) + 4) == uv.get(4)){
			s = "Stege " + uv.get(4) + " h?申g";
			hValue = 4;
		}
		if (suits.size() == 1){
			s = "F?申rg";
			hValue = 5;
		}
		if (nuv1.size() == 2 && nuv2.size() == 1){
			s = "K?申k " + nuv2.get(0) + " ?申ver";
			hValue = 6;
		}
		if (nuv3.size() == 1){
			s = "Fyrtal i " + nuv3.get(0);
			hValue = 7;
		}	
		if (uv.size() == 5 && (uv.get(0) + 4) == uv.get(4) && suits.size() == 1){
			s = "Straight flush " + uv.get(4).toString() + " h?申g";
			hValue = 8;
		}
		if (suits.size() == 1 && uv.get(0) == 1 && ((uv.get(1)) + 3) == uv.get(4) && uv.get(4) == 13){
			s = "Royal flush ";
			System.out.println(uv);
			hValue = 9;
		}
		return s;
	}	
	public int getVal(){
		return hValue;
	
	}
}