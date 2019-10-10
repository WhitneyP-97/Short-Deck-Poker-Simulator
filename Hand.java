package shortDeck;
import java.util.*;

public class Hand {
	ArrayList<Card> hand;
	int[] valueCounts = new int[13];
	int[] suitCounts = new int[4];
	boolean aceLowStraights = true; //ie in a 6+ short deck game, A 6 7 8 9 is a straight. If your house rules doesn't accept this, set to false.

	public Hand() {
		hand = new ArrayList<Card>();
		valCounts();
		suitCounts();
	}
	
	public Hand(ArrayList<Card> x) {
		hand = x;
		valCounts();
		suitCounts();
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
		for(int i=0;i<9;i++) {
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
				for(int i=0;i<4;i++) {
					if(valueCounts[i]==0) {
						break;
					}
					if(i==3) {
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
			
			Hand newHand = new Hand(newCards);
			
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
	
}
