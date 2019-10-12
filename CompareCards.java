package shortDeck;
import java.util.*;

public class CompareCards {
	
	ArrayList<Hand> finalHands;
	Rules rules = new Rules(2);
	
	public CompareCards(ArrayList<Hand> h) {
		finalHands = h;
		rules = new Rules(h.get(0).getMin());
	}
	
	public int compareCards() {
		
		for(int i=0;i<rules.getRules().length;i++) {

			ArrayList<Hand> winningHands = new ArrayList<Hand>();
			int count = 0;
			
			
			switch (rules.getRules()[i]) {
			case 9:
				count = 0;
				winningHands = new ArrayList<Hand>();
				
				for(int j=0;j<finalHands.size();j++) {
					if(finalHands.get(j).isSF()) {
						count++;
						winningHands.add((finalHands.get(j)));
					}
				}
				
				if(count==1) {
					return finalHands.indexOf(winningHands.get(0));
				}
				else if(count>=2) {
					Hand winner = winningHands.get(0);
					for(int j=0;j<winningHands.size();j++) {
						if(StraightFlush.getHighestCard(winningHands.get(j))>StraightFlush.getHighestCard(winner)){
							winner = winningHands.get(j);
						}
					}
					
					return finalHands.indexOf(winner);
				}
				
			case 8:
				count = 0;
				winningHands = new ArrayList<Hand>();
				
				for(int j=0;j<finalHands.size();j++) {
					if(finalHands.get(j).isFOAK()) {
						count++;
						winningHands.add((finalHands.get(j)));
					}
				}
				
				
				if(count==1) {
					return finalHands.indexOf(winningHands.get(0));
				}
				else if(count>=2) {
					Hand winner = winningHands.get(0);
					for(int j=0;j<winningHands.size();j++) {
						for(int k=0;k<FOAK.getHighestCard(winningHands.get(0)).length;k++) {
							if(FOAK.getHighestCard(winner)[k]<FOAK.getHighestCard(winningHands.get(j))[k]) {
								winner = winningHands.get(j);
								break;
							}
							else if(FOAK.getHighestCard(winner)[k]>FOAK.getHighestCard(winningHands.get(j))[k]) {
								break;
							}
						}
					}
					
					return finalHands.indexOf(winner);
				}
				
			case 7:
				count = 0;
				winningHands = new ArrayList<Hand>();
				
				for(int j=0;j<finalHands.size();j++) {
					if(finalHands.get(j).isFH()) {
						count++;
						winningHands.add((finalHands.get(j)));
					}
				}
				
				
				if(count==1) {
					return finalHands.indexOf(winningHands.get(0));
				}
				else if(count>=2) {
					Hand winner = winningHands.get(0);
					for(int j=0;j<winningHands.size();j++) {
						for(int k=0;k<FullHouse.getHighestCard(winningHands.get(0)).length;k++) {
							if(FullHouse.getHighestCard(winner)[k]<FullHouse.getHighestCard(winningHands.get(j))[k]) {
								winner = winningHands.get(j);
								break;
							}
							else if(FullHouse.getHighestCard(winner)[k]>FullHouse.getHighestCard(winningHands.get(j))[k]) {
								break;
							}
						}
					}
					
					return finalHands.indexOf(winner);
				}
			
				
			case 6:
				count = 0;
				winningHands = new ArrayList<Hand>();
				
				for(int j=0;j<finalHands.size();j++) {
					if(finalHands.get(j).isFlush()) {
						count++;
						winningHands.add((finalHands.get(j)));
					}
				}
				
				if(count==1) {
					return finalHands.indexOf(winningHands.get(0));
				}
				else if(count>=2) {
					Hand winner = winningHands.get(0);
					for(int j=0;j<winningHands.size();j++) {
						for(int k=0;k<Flush.getHighestCard(winningHands.get(0)).length;k++) {
							if(Flush.getHighestCard(winner)[k]<Flush.getHighestCard(winningHands.get(j))[k]) {
								winner = winningHands.get(j);
								break;
							}
							else if(Flush.getHighestCard(winner)[k]>Flush.getHighestCard(winningHands.get(j))[k]) {
								break;
							}
						}
					}
					
					return finalHands.indexOf(winner);
				}
				
			case 5:
				count = 0;
				winningHands = new ArrayList<Hand>();
				
				for(int j=0;j<finalHands.size();j++) {
					if(finalHands.get(j).isStraight()) {
						count++;
						winningHands.add((finalHands.get(j)));
					}
				}
				
				if(count==1) {
					return finalHands.indexOf(winningHands.get(0));
				}
				else if(count>=2) {
					Hand winner = winningHands.get(0);
					for(int j=0;j<winningHands.size();j++) {
						if(Straight.getHighestCard(winningHands.get(j))>Straight.getHighestCard(winner)){
							winner = winningHands.get(j);
						}
					}
					
					return finalHands.indexOf(winner);
				}
				
			case 4:
				count = 0;
				winningHands = new ArrayList<Hand>();
				
				for(int j=0;j<finalHands.size();j++) {
					if(finalHands.get(j).isTOAK()) {
						count++;
						winningHands.add((finalHands.get(j)));
					}
				}
				
				if(count==1) {
					return finalHands.indexOf(winningHands.get(0));
				}
				else if(count>=2) {
					Hand winner = winningHands.get(0);
					for(int j=0;j<winningHands.size();j++) {
						for(int k=0;k<TOAK.getHighestCard(winningHands.get(0)).length;k++) {
							if(TOAK.getHighestCard(winner)[k]<TOAK.getHighestCard(winningHands.get(j))[k]) {
								winner = winningHands.get(j);
								break;
							}
							else if(TOAK.getHighestCard(winner)[k]>TOAK.getHighestCard(winningHands.get(j))[k]) {
								break;
							}
						}
					}
					
					return finalHands.indexOf(winner);
				}
			case 3:
				count = 0;
				winningHands = new ArrayList<Hand>();
				
				for(int j=0;j<finalHands.size();j++) {
					if(finalHands.get(j).isTwoPair()) {
						count++;
						winningHands.add((finalHands.get(j)));
					}
				}
				
				if(count==1) {
					return finalHands.indexOf(winningHands.get(0));
				}
				else if(count>=2) {
					Hand winner = winningHands.get(0);
					for(int j=0;j<winningHands.size();j++) {
						for(int k=0;k<TwoPair.getHighestCard(winningHands.get(0)).length;k++) {
							if(TwoPair.getHighestCard(winner)[k]<TwoPair.getHighestCard(winningHands.get(j))[k]) {
								winner = winningHands.get(j);
								break;
							}
							else if(TwoPair.getHighestCard(winner)[k]>TwoPair.getHighestCard(winningHands.get(j))[k]) {
								break;
							}
						}
					}
					
					return finalHands.indexOf(winner);
				}
				
			case 2:
				count = 0;
				winningHands = new ArrayList<Hand>();
				
				for(int j=0;j<finalHands.size();j++) {
					if(finalHands.get(j).isPair()) {
						count++;
						winningHands.add((finalHands.get(j)));
					}
				}
				
				if(count==1) {
					return finalHands.indexOf(winningHands.get(0));
				}
				else if(count>=2) {
					Hand winner = winningHands.get(0);
					for(int j=0;j<winningHands.size();j++) {
						for(int k=0;k<Pair.getHighestCard(winningHands.get(0)).length;k++) {
							if(Pair.getHighestCard(winner)[k]<Pair.getHighestCard(winningHands.get(j))[k]) {
					
								winner = winningHands.get(j);
								break;
							}
							else if(Pair.getHighestCard(winner)[k]>Pair.getHighestCard(winningHands.get(j))[k]) {
								break;
							}
						}
					}
					
					return finalHands.indexOf(winner);
				}
				
			case 1:
				count = 0;
				winningHands = new ArrayList<Hand>();
				
				for(int j=0;j<finalHands.size();j++) {
					if(finalHands.get(j).isHighCard()) {
						count++;
						winningHands.add((finalHands.get(j)));
					}
				}
				
				if(count==1) {
					return finalHands.indexOf(winningHands.get(0));
				}
				else if(count>=2) {
					Hand winner = winningHands.get(0);
					for(int j=0;j<winningHands.size();j++) {
						for(int k=0;k<HighCard.getHighestCard(winningHands.get(0)).length;k++) {
							if(HighCard.getHighestCard(winner)[k]>HighCard.getHighestCard(winningHands.get(j))[k]) {
								winner = winningHands.get(j);
								break;
							}
							else if(HighCard.getHighestCard(winner)[k]<HighCard.getHighestCard(winningHands.get(j))[k]) {
								break;
							}
						}
					}
					
					return finalHands.indexOf(winner);
				}
				
			}
				
		}
		
		return 0;
	}

}
