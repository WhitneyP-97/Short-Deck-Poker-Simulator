package shortDeck;

import java.util.*;

public class Deck {
	
	ArrayList<Card> deck;
	
	public Deck(int min) {
		
		deck = new ArrayList<Card>();
		
		for(int i=min;i<=14;i++) {
			for(int j=0;j<4;j++) {
				Card x = new Card(i,j);
				deck.add(x);
			}
		}
		
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public void resetDeck(int min) {
		deck.clear();
		for(int i=min;i<=14;i++) {
			for(int j=0;j<4;j++) {
				Card x = new Card(i,j);
				deck.add(x);
			}
		}	
	}
	
	public void resetDeck(ArrayList<Card> c) {
		deck = c;
	}
	
	public void resetDeck(Card[] c) {
		deck.clear();
		for(int i=0;i<c.length;i++) {
			deck.add(c[i]);
		}
	}
	
	public Card dealOneCard() {
		Card x = deck.get(0);
		deck.remove(0);
		return x;
	}
	
	public ArrayList<Card> dealXCards(int x) {
		ArrayList<Card> cards = new ArrayList<Card>();
		for(int i=0;i<x;i++) {
			cards.add(deck.get(0));
			deck.remove(0);
		}
		
		return cards;
	}

	public ArrayList<Card> getDeck(){
		return deck;
	}
	
	public void remove(int i) {
		deck.remove(i);
	}
}
