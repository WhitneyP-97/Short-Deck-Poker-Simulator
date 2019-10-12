package shortDeck;

public class TwoPair {
	public static int[] getHighestCard(Hand h) {
		int[] x = new int[3];
		int y = 0;
		
		for(int i=12;i>0;i--) {
			if((h.getValueCounts()[i]>=2) && (y!=2)){
				x[y]=i+2;
				y++;
				if(y==2) {
					break;
				}
			}
		}
		
		for(int i=12;i>0;i--) {
			if((h.getValueCounts()[i]!=0) && (y!=3)) {
				x[y] = i+2;
				y++;
				if(y==3) {
					break;
				}
			}
		}
		
		return x;
	}
}
