package shortDeck;

public class HighCard {
	
	public HighCard() {
		
	}
	
	public static int[] getHighestCard(Hand h) {
		int[] x = new int[5];
		int y = 0;
		int a = 0;
		
		for(int i=12;i>0;i--) {
			if((h.getValueCounts()[i]>0)&&(y<5)) {
				x[a] = h.getValueCounts()[i]+2;
				y++;
				a++;
			}
		}
		
		return x;
	}

}
