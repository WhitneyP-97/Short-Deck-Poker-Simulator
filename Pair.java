package shortDeck;

public class Pair {
	public static int[] getHighestCard(Hand h) {
		int[] x = new int[4];
		int y = 1;
		
		for(int i=12;i>0;i--) {
			if(h.getValueCounts()[i]>=2) {
				x[0]=i+2;
			}
		}
		
		for(int i=12;i>0;i--) {
			if((h.getValueCounts()[i]!=0) && (y!=4)) {
				x[y] = i+2;
				y++;
				if(y==4) {
					break;
				}
			}
		}
		
		return x;
	}
}
