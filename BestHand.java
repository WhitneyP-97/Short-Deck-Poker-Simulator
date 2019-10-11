package shortDeck;
import java.util.*;

public class BestHand extends Hand{
	
	Rules rule;
	ArrayList<Card> bestHand;
	
	public BestHand(Rules r, int m) {
		super(m);
		setRules(r);
		findBestHand();
	}
	
	public BestHand(ArrayList<Card> cards, Rules r, int m) {
		super(cards, m);
		setRules(r);
		findBestHand();
	}
	
	public BestHand(ArrayList<Card> cards, ArrayList<Card> cards2, Rules r, int m) {
		super(cards, cards2, m);
		setRules(r);
		findBestHand();
	}
	
	public BestHand(ArrayList<Card> cards, Card c, Rules r, int m) {
		super(cards, c, m);
		setRules(r);
		findBestHand();
	}
	
	public BestHand(Hand x, Rules r, int m) {
		super(m);
		hand = x.getHand();
		setRules(r);
		findBestHand();
	}
	
	public BestHand(Hand x, Hand y, Rules r, int m) {
		super(x,y,m);
		setRules(r);
		findBestHand();
	}
	
	public BestHand(Hand h, Card c, Rules r, int m) {
		super(h,c,m);
		setRules(r);
		findBestHand();
	}
	
	public BestHand(Hand h, ArrayList<Card> c, Rules r, int m) {
		super(h,c,m);
		setRules(r);
		findBestHand();
	}
	
	public void setRules(Rules r) {
		rule = r;
	}
	
	
	
	public void findBestHand() {
		if(hand.size()<=5) {
			bestHand = hand;
			return;
		}
		for(int i=0;i<rule.rules.length;i++) {
			switch (rule.rules[i]) {
			case 9:
				if(isSF()) {
					bestHand = getBestSF();
					return;
				}
				
			case 8:
				if(isFOAK()) {
					bestHand = getBestFOAK();
					return;
				}
				
			case 7:
				if(isFH()) {
					bestHand = getBestFH();
					return;
				}
			case 6:
				if(isFlush()) {
					bestHand = getBestFlush();
					return;
				}
			case 5:
				if(isStraight()) {
					bestHand = getBestStraight();
					return;
				}
			case 4:
				if(isTOAK()) {
					bestHand = getBestTOAK();
					return;
				}
				
			case 3:
				if(isTwoPair()) {
					bestHand = getBestTwoPair();
					return;
				}
			case 2:
				if(isPair()) {
					bestHand = getBestPair();
					return;
				}
				
			case 1:
				bestHand = getBestHighCard();
				return;
		
			}
		}
	}
	
	public Hand bestHandToHand() {
		return new Hand(bestHand,min);
	}

}
