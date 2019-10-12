package shortDeck;

public class Straight {
	
	public Straight() {
		
	}
	
	public static int getHighestCard(Hand h) {
		if(h.isStraight()) {
			for(int i=12;i>=4;i--) {
				for (int j=i;j>i-5;j--) {
					if(h.getValueCounts()[j]==0) {
						break;
					}
					if(j==i-4) {
						int highestCard = i+2;
						return highestCard;
					}
				}
			}
		
		
			if(h.aceLowStraights==true) {
				if(h.getValueCounts()[12]>0) {
					int highestCard = h.getMin()+3;
					return highestCard;
				}
			}
		}
		else {
			int highestCard = 0;
			return highestCard;
		}
		
		return 0;
	}
}
