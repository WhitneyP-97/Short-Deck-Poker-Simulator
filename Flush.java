package shortDeck;

public class Flush {
	
	public static int[] getHighestCard(Hand h1) {
		Hand h = new Hand(h1.getBestFlush(),h1.getMin());
		
		return HighCard.getHighestCard(h);
	}

}
