package shortDeck;

public class FullHouse {
	
	public static int[] getHighestCard(Hand h) {
		int[] x = new int[2];
		
		if(h.isFH()) {
		for(int i=12;i>0;i--) {
			if(h.getValueCounts()[i]>=3) {
				x[0]=i+2;
				break;
			}
		}
		
		for(int i=12;i>0;i--) {
			if((h.getValueCounts()[i]>=2)&&((i+2)!=x[0])) {
				x[1]=i+2;
				break;
			}
		}
		
		return x;
	}
		return x;
	}

}
