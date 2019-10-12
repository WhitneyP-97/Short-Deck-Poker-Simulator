package shortDeck;

public class StraightFlush{
	
	public StraightFlush() {
	}
	
	public static int getHighestCard(Hand h1) {
		Hand h = new Hand(h1.getBestSF(),h1.getMin());
		return Straight.getHighestCard(h);
	}
	
	
}
