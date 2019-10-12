package shortDeck;

import java.util.ArrayList;

public class HandSimulator{
	int min;
	Rules r;
	ArrayList<Hand> h;
	ArrayList<Card> commCards;
	ArrayList<Hand> finalHands;
	Card[] c1;
	Hand[] fh1;
	
	public HandSimulator(int x,ArrayList<Hand> h1, int trials) {
		min=x;
		r = new Rules(min);
		h=h1;
		commCards = new ArrayList<Card>();
		
		c1 = new Card[commCards.size()];
		
		for(int i=0;i<commCards.size();i++) {
			c1[i]=commCards.get(i);
		}
		
		displayWins(simulate(trials));
	}
	
	public HandSimulator(int x,ArrayList<Hand> h1, ArrayList<Card> c1, int trials) {
		min=x;
		r = new Rules(min);
		h=h1;
		commCards = c1;
		displayWins(simulate(trials));
	}
	
	public int[] simulate(int trials) {
		Deck d = new Deck(min);
		int[] wins = new int[h.size()];
		
		//removes duplicates of cards already in hands from deck
		
		for(int i=0;i<d.getDeck().size();i++) {
			for(int j=0;j<h.size();j++) {
				for(int k = 0;k<h.get(j).getHand().size();k++) {
					if((h.get(j).getHand().get(k).getValue()==(d.getDeck().get(i).getValue())) &&(h.get(j).getHand().get(k).getSuit()==(d.getDeck().get(i).getSuit()))) {
						d.remove(i);
					}
				}
				
			}
		}
		
		//removes duplicates of cards already in comm cards from deck
		
		for(int i=0;i<d.getDeck().size();i++) {
			for(int j=0;j<commCards.size();j++) {
				if((commCards.get(j).getValue()==(d.getDeck().get(i).getValue())) && (commCards.get(j).getSuit()==(d.getDeck().get(i).getSuit()))) {
					d.remove(i);
				}
			}
		}
		
		Card[] d1 = new Card[d.getDeck().size()];
		
		for(int i=0;i<d.getDeck().size();i++) {
			d1[i]=d.getDeck().get(i);
		}


		
		for(int i=0;i<trials;i++) {
			finalHands = new ArrayList<Hand>();
			
			for(int j=0;j<commCards.size();j++) {
				commCards.clear();
			}
			
			for(int j=0;j<c1.length;j++) {
				commCards.add(c1[j]);
			}
			
			for(int j=0;j<h.size();j++) {
				h.get(j).resetHand();
			}
			
			d.resetDeck(d1);
				
			d.shuffle();
			
			for(int j = commCards.size();j<5;j++) {
				commCards.add(d.dealOneCard());
			}
			

			
			for(int k = 0;k<h.size();k++) {
				Hand newH = new Hand(h.get(k),commCards,min);
				//finalHands should be in the same order as h
				finalHands.add(newH);
			}
			
			/*for(int j=0;j<finalHands.size();j++) {
				for(int k=0;k<finalHands.get(j).getHand().size();k++) {
					System.out.print(finalHands.get(j).getHand().get(k).display);
				}
				System.out.println();
			}*/
			
			CompareCards a = new CompareCards(finalHands);
			wins[a.compareCards()]++;
		}
		
		return wins;
		
	}
	
	public void displayWins(int[] a) {
		for(int i = 0;i<a.length;i++) {
			System.out.println(a[i]);
		}
	}

}
