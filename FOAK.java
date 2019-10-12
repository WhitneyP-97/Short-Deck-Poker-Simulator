package shortDeck;

public class FOAK {
	
	public static int[] getHighestCard(Hand h) {
		int[] x = new int[2];
		
		for(int i=12;i>0;i--) {
			if(h.getValueCounts()[i]>=4) {
				x[0]=i+2;
				break;
			}
		}
		
		for(int i=12;i>0;i--) {
			if((h.getValueCounts()[i]>0) && ((i+2)!=x[0])) {
				x[1] = i+2;
				break;
			}
		}
		
		return x;
	}

}
