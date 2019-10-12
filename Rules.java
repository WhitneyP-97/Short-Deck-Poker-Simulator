package shortDeck;

public class Rules {
	
	int[] rules; //best to worst
	
	//1 = high card, 2 = one pair, 3 = two pair, 4 = three of a kind, 5 = straight, 6 = flush, 7 = full house, 8 = four of a kind, 9 = straight flush
	
	public Rules() {
		int[] r = {9,8,7,6,5,4,3,2,1};
		rules = r;
	}
	
	public Rules(int min) {
		if(min==2) {
			int[] r = {9,8,7,6,5,4,3,2,1};
			rules = r;
		}
		else if(min<9) {
			int[] r = {9,8,6,7,5,4,3,2,1};
			rules = r;
		}
		else {
			int[] r = {9,6,8,5,7,4,3,2,1};
			rules = r;
		}
	}
	
	public int[] getRules() {
		return rules;
	}

}
