package shortDeck;
import java.util.*;

public class Hand {
	ArrayList<Card> hand;
	int[] valueCounts = new int[13];
	int[] suitCounts = new int[4];
	boolean aceLowStraights = true;
	Card[] a;
	int min;

	public Hand(int m) {
		hand = new ArrayList<Card>();
		valCounts();
		suitCounts();
		a = new Card[0];
		min = m;
	}
	
	public Hand(ArrayList<Card> x, int m) {
		hand = x;
		a = new Card[hand.size()];
		for(int i=0;i<hand.size();i++) {
			a[i]=hand.get(i);
		}
		valCounts();
		suitCounts();
		min = m;
	}
	
	public Hand(ArrayList<Card> x, ArrayList<Card> y, int m) {
		x.addAll(y);
		hand = x;
		a = new Card[hand.size()];
		for(int i=0;i<hand.size();i++) {
			a[i]=hand.get(i);
		}
		valCounts();
		suitCounts();
		min = m;
	}
	
	public Hand(ArrayList<Card> x, Card y, int m) {
		x.add(y);
		hand = x;
		a = new Card[hand.size()];
		for(int i=0;i<hand.size();i++) {
			a[i]=hand.get(i);
		}
		valCounts();
		suitCounts();
		min = m;
	}
	
	public Hand(Hand h, Card y, int m) {
		ArrayList<Card> h1 = h.getHand();
		h1.add(y);
		hand = h1;
		a = new Card[hand.size()];
		for(int i=0;i<hand.size();i++) {
			a[i]=hand.get(i);
		}
		valCounts();
		suitCounts();
		min = m;
	}
	
	public Hand(Hand h, ArrayList<Card> c, int m) {
		ArrayList<Card> h1 = h.getHand();
		h1.addAll(c);
		hand = h1;
		a = new Card[hand.size()];
		for(int i=0;i<hand.size();i++) {
			a[i]=hand.get(i);
		}
		valCounts();
		suitCounts();
		min = m;
	}
	
	public Hand(Hand h1, Hand h2, int m) {
		ArrayList<Card> h = h1.getHand();
		h.addAll(h2.getHand());
		hand = h;
		a = new Card[hand.size()];
		for(int i=0;i<hand.size();i++) {
			a[i]=hand.get(i);
		}
		min = m;
		valCounts();
		suitCounts();
	}
	
	public ArrayList<Card> getHand(){
		return hand;
	}
	
	public void valCounts() {
		for(int i = 2;i<=14;i++) {
			int x = 0;
			for(int j=0;j<hand.size();j++) {
				if(hand.get(j).value==i) {
					x ++;
				}
			}
			valueCounts[i-2]=x;
		}
	}
	
	public void suitCounts() {
		for(int i=0;i<4;i++) {
			int x = 0;
			for(int j=0;j<hand.size();j++) {
				if(hand.get(j).suit==i) {
					x++;
				}
			}
			suitCounts[i]=x;
		}
	}
	
	public void resetHand(Card[] c) {
		hand.clear();
		for(int i=0;i<c.length;i++) {
			hand.add(c[i]);
		}
	}
	
	public void resetHand() {
		hand.clear();
		for(int i=0;i<a.length;i++) {
			hand.add(a[i]);
		}
	}
	
	public boolean isPair() {
		for(int i=0;i<13;i++) {
			if(valueCounts[i]>=2) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isTwoPair() {
		int x = -1;
		for(int i=0;i<13;i++) {
			if(valueCounts[i]>=2) {
				x = i;
				for(int j=0;j<13;j++) {
					if((valueCounts[j]>=2)&&(j!=x)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean isTOAK() {
		for(int i=0;i<13;i++) {
			if(valueCounts[i]>=3) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isFH() {
		int x = -1;
		for(int i=0;i<13;i++) {
			if(valueCounts[i]>=3) {
				x=i;
				for(int j=0;j<13;j++) {
					if((valueCounts[j]>=2)&&(j!=x)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean isFOAK() {
		for(int i=0;i<13;i++) {
			if(valueCounts[i]>=4) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isStraight() {
		for(int i=0;i<8;i++) {
			for(int j=i;j<(i+5);j++) {
				if(valueCounts[j]==0) {
					break;
				}
				if(j==i+4) {
					return true;
				}
			}
		}
		
		if (aceLowStraights==true) {
			if(valueCounts[12]>0) {
				for(int i=min-2;i<min+2;i++) {
					if(valueCounts[i]==0) {
						break;
					}
					if(i==min+1) {
						return true;
					}
				}
			}
		}
		return false;
		
	}
	
	public boolean isFlush() {
		for(int i=0;i<4;i++) {
			if(suitCounts[i]>=5) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isSF() {
		ArrayList<Card> newCards = new ArrayList<Card>();
		int x = 0;
		if(isFlush()) {
			for(int i=0;i<4;i++) {
				if(suitCounts[i]>=5) {
					x = i;
				}
			}
			for(int i=0;i<hand.size();i++) {
				if(hand.get(i).suit==x) {
					newCards.add(hand.get(i));
				}
			}
			
			Hand newHand = new Hand(newCards, min);
			
			if(newHand.isStraight()) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public ArrayList<Card> getBestSF(){
		ArrayList<Card> cards = new ArrayList<Card>();
		if(isSF()) {
			ArrayList<Card> newCards = new ArrayList<Card>();
			int x = 0;
			for(int i=0;i<4;i++) {
				if(suitCounts[i]>=5) {
					x = i;
				}
			}
			for(int i=0;i<hand.size();i++) {
				if(hand.get(i).getSuit()==x) {
					newCards.add(hand.get(i));
				}
			}
			
			if(newCards.size()==5) {
				return newCards;
			}
			
			else {
				Hand h = new Hand(newCards, min);
				ArrayList<Card> c = new ArrayList<Card>();
				
				for(int i=12;i>=4;i--) {
					for (int j=i;j>i-5;j--) {
						if(h.valueCounts[j]==0) {
							break;
						}
						if(j==i-4) {
							for(int k = i;k>i-5;k--) {
								Card c1 = new Card(k+2,newCards.get(1).getSuit());
								c.add(c1);
							}
							return c;
						}
					}
				}
				
				if(aceLowStraights==true) {
					if(h.valueCounts[12]>0) {
						cards.add(new Card(14,newCards.get(1).getSuit()));
						for(int i = min;i<min+4;i++) {
							cards.add(new Card(i,newCards.get(1).getSuit()));
						}
					}
					return cards;
				}
				
			}
			
		}
		
		return cards;
	}
	
	public ArrayList<Card> getBestFOAK(){
		ArrayList<Card> cards = new ArrayList<Card>();
		if(isFOAK()) {
			int x = 0;
			for(int i=0;i<13;i++) {
				if(valueCounts[i]>=4) {
					x = i;
					for(int j=0;j<4;j++) {
						cards.add(new Card(i+2,j));
					}
					break;
				}
			}
			
			for(int i = 12;i>=0;i--) {
				if ((i!=x)&&(valueCounts[i]>0)) {
					for(int j = 0;j<hand.size();j++) {
						if (hand.get(j).getValue()==(i+2)) {
							cards.add(hand.get(j));
							return cards;
						}
					}
					
				}
			}
			
		}
		return cards;
	}
	
	public ArrayList<Card> getBestFH(){
		int x=0;
		ArrayList<Card> c = new ArrayList<Card>();
		
		if(isFH()) {
		for(int i=12;i>0;i--) {
			if(valueCounts[i]>=3) {
				x = i;
				break;
			}
		}
		
		int y=0;
		for(int i=0;i<hand.size();i++) {
			if((hand.get(i).getValue()==(x+2))&&(y<3)) {
				c.add(hand.get(i));
				y++;
			}
		}
		
		for(int i=12;i>0;i--) {
			if((valueCounts[i]>=2)&&(i!=x)) {
				x=i;
				break;
			}
		}
		
		y=0;
		for(int i=0;i<hand.size();i++) {
			if((hand.get(i).getValue()==(x+2))&&(y<2)) {
				c.add(hand.get(i));
				y++;
			}
		}
		return c;
		}
		
		return c;
	}
	
	public ArrayList<Card> getBestStraight(){
		ArrayList<Card> c = new ArrayList<Card>();
		if(isStraight()) {
		for(int i=12;i>=4;i--) {
			for (int j=i;j>i-5;j--) {
				if(valueCounts[j]==0) {
					break;
				}
				if(j==i-4) {
					for(int k = i;k>i-5;k--) {
						Card c1 = new Card(k+2,hand.get(1).getSuit());
						c.add(c1);
					}
					return c;
				}
			}
		}
		
		if(aceLowStraights==true) {
			if(valueCounts[12]>0) {
				c.add(new Card(14,hand.get(1).getSuit()));
				for(int i = min;i<min+4;i++) {
					c.add(new Card(i,hand.get(1).getSuit()));
				}
			}
			return c;
		}
		}
		
		return c;
	
	}
	
	public ArrayList<Card> getBestFlush(){
		
		ArrayList<Card> cards = new ArrayList<Card>();
		if(isFlush()) {
			ArrayList<Card> newCards = new ArrayList<Card>();
			int x = 0;
			for(int i=0;i<4;i++) {
				if(suitCounts[i]>=5) {
					x = i;
				}
			}
			for(int i=0;i<hand.size();i++) {
				if(hand.get(i).getSuit()==x) {
					newCards.add(hand.get(i));
				}
			}
			
			if(newCards.size()==5) {
				return newCards;
			}
			else {
				int y = 0;
				for(int i=12;i>0;i--) {
					if((valueCounts[i]>=1)&&(y<5)) {
						cards.add(new Card(i+2,x));
						y++;
					}
				}
				return cards;
			}
		}
		return cards;
	}
	
	public ArrayList<Card> getBestTOAK(){
		ArrayList<Card> c = new ArrayList<Card>();
		int x = 0;
		int y = 0;
		if(isTOAK()) {
		for(int i=12;i>0;i--) {
			if(valueCounts[i]>=3) {
				x = i;
				for(int j=0;j<hand.size();j++) {
					if((hand.get(j).getValue()==(i+2)) &&(y<5)) {
						c.add(hand.get(j));
						y++;
					}
				}
				break;
			}
		}
		
		for(int i=12;i>0;i--) {
			if((valueCounts[i]!=0)&&(i!=x)) {
				for(int j=0;j<hand.size();j++) {
					if((hand.get(j).getValue()==(i+2)) && (y<5)) {
						c.add(hand.get(j));
						y++;
					}
				}
			}
		}
		return c;
		
		}
		return c;
	}
	
	public ArrayList<Card> getBestTwoPair(){
		ArrayList<Card> c = new ArrayList<Card>();
		
		if(isTwoPair()) {
			int x = 0;
			int y = 0;
			int a = 0;
			int b = 0;
			for(int i=12;i>0;i--) {
				if((valueCounts[i]>=2)&&(x<2)) {
					x++;
					
					if(x==0) {
						a=i;
					}
					else {
						b=i;
					}
					
					for(int j=0;j<hand.size();j++){
						if((hand.get(j).getValue()==(i+2)) && (y<2)) {
							c.add(hand.get(j));
							y++;
						}
					}
					y=0;
				}
			}
			
			for(int i = 12;i>0;i--) {
				if((valueCounts[i]>=1)&&(i!=a)&&(i!=b)) {
					for(int j=0;j<hand.size();j++) {
						if(hand.get(j).getValue()==(i+2)) {
							c.add(hand.get(j));
							return c;
						}
					}
				}
			}
			
		}
		return c;
	}
	
	public ArrayList<Card> getBestPair(){
		ArrayList<Card> c = new ArrayList<Card>();
		if(isPair()) {
			int x = 0;
			int y = 0;
			for(int i=12;i>0;i--) {
				if(valueCounts[i]>=2) {
					x = i;
					for(int j=0;j<hand.size();j++) {
						if((hand.get(j).getValue()==(i+2))&&(y<2)) {
							c.add(hand.get(j));
							y++;
						}
					}
				}
			}
			
			for(int i=12;i>0;i--) {
				if((valueCounts[i]!=0) && (i!=x)){
					for(int j=0;j<hand.size();j++) {
						if((hand.get(j).getValue()==(i+2))&&(y<5)) {
							c.add(hand.get(j));
							y++;
						}
					}
				}
			}
			return c;
			
		}
		else {
			return c;
		}
	}
	
	public ArrayList<Card> getBestHighCard(){
		ArrayList<Card> c = new ArrayList<Card>();
		
		int y = 0;
		for(int i = 12;i>0;i--) {
			if(valueCounts[i]>0) {
				for(int j=0;j<hand.size();j++) {
					if((hand.get(j).getValue()==(i+2))&&(y<5)) {
						c.add(hand.get(j));
						y++;
					}
				}
			}
		}
		
		return c;
	}
	
	public boolean isHighCard() {
		return true;
	}
	
	public int getMin() {
		return min;
	}
	
	public int[] getValueCounts() {
		return valueCounts;
	}
	
	public int[] getSuitCounts() {
		return suitCounts;
	}
}
