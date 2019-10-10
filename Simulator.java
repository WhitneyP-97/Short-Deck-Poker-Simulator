//this simulator doesn't make value judgments on hands. If your seven card hand has a pair and a straight flush, it will appear as both a pair and a straight flush.
//this is because many short deck games have house rules which make regular poker rules unusable.

package shortDeck;
import java.util.*;

public class Simulator{
	int min;
	
	int pairs;
	int twoPairs;
	int TOAKs;
	int FHs;
	int straights;
	int flushes;
	int FOAKs;
	int SFs;
	double pairPCT;
	double TPPCT;
	double TOAKPCT;
	double FHPCT;
	double straightPCT;
	double flushPCT;
	double FOAKPCT;
	double SFPCT;
	
	public Simulator(int x, int numtrials) {
		min = x;
		
		pairs = 0;
		twoPairs = 0;
		TOAKs = 0;
		FHs = 0;
		straights = 0;
		flushes = 0;
		FOAKs = 0;
		SFs = 0;
		
		pairPCT = 0;
		TOAKPCT = 0;
		FHPCT = 0;
		straightPCT = 0;
		FOAKPCT = 0;
		SFPCT = 0;
		flushPCT = 0;
		TPPCT = 0;
		
		simulate(numtrials);
		
		display();
	}
	
	public void simulate(int numtrials) {
		for(int i=0;i<numtrials;i++) {
			Deck d = new Deck(min);
			d.shuffle();
			ArrayList<Card> cards = d.dealXCards(7);
			Hand h = new Hand(cards);
			
			if(h.isPair()) {
				pairs++;
			}
			if(h.isTOAK()) {
				TOAKs++;
			}
			if(h.isTwoPair()) {
				twoPairs++;
			}
			if(h.isFlush()) {
				flushes++;
			}
			if(h.isStraight()) {
				straights++;
			}
			if(h.isFOAK()) {
				FOAKs++;
			}
			if(h.isSF()) {
				SFs++;
			}
			if(h.isFH()) {
				FHs++;
			}
		}
		
		pairPCT = (double)pairs/numtrials;
		TOAKPCT = (double)TOAKs/numtrials;
		FHPCT = (double)FHs/numtrials;
		straightPCT = (double)straights/numtrials;
		FOAKPCT = (double)FOAKs/numtrials;
		SFPCT = (double)SFs/numtrials;
		flushPCT = (double)flushes/numtrials;
		TPPCT = (double)twoPairs/numtrials;
	}
	
	public void display() {
		System.out.println("pairs: "+ pairs);
		System.out.println("Two pairs: "+twoPairs);
		System.out.println("three of a kinds: "+TOAKs);
		System.out.println("full houses: "+FHs);
		System.out.println("flushes: "+flushes);
		System.out.println("straights: "+straights);
		System.out.println("straight flushes: "+SFs);
		System.out.println("four of a kinds: "+FOAKs);
	}
	
	public void reset() {
		
		pairPCT = 0;
		TOAKPCT = 0;
		FHPCT = 0;
		straightPCT = 0;
		FOAKPCT = 0;
		SFPCT = 0;
		flushPCT = 0;
		TPPCT = 0;
		
		pairs = 0;
		twoPairs = 0;
		TOAKs = 0;
		FHs = 0;
		straights = 0;
		flushes = 0;
		FOAKs = 0;
		SFs = 0;
	}

}
