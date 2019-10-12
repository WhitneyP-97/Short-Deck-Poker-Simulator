package shortDeck;

public class TOAK {
	
	public static int[] getHighestCard(Hand h) {
		int[] x = new int[3];
		int y = 1;
		
		if(h.isTOAK()) {
		for(int i=12;i>0;i--) {
			if(h.getValueCounts()[i]>=3) {
				x[0]=i+2;
				break;
			}
		}
		
		for(int i=12;i>0;i--) {
			if((h.getValueCounts()[i]>=2)&&((i+2)!=x[0])&&((i+2)!=x[1])&&(y<3)) {
				x[y]=i+2;
				y++;
				if(y==3) {
					break;
				}
			}
		}
		
		return x;
	}
		return x;
	}


}
