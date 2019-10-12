package shortDeck;

public class Card {
	int value;
	int suit;
	String display;
	
	public Card(int i, int j) {
		
		value = i;
		suit = j;
		
		
		if (suit==0) {
			if(value<11) {
				display = value+"s";
			}
			else if(value==11) {
				display = "Js";
			}
			else if(value==12) {
				display = "Qs";
			}
			else if(value==13) {
				display = "Ks";
			}
			else if(value==14) {
				display = "As";
			}
		}
		
		else if (suit==1) {
			if(value<11) {
				display = value+"c";
			}
			else if(value==11) {
				display = "Jc";
			}
			else if(value==12) {
				display = "Qc";
			}
			else if(value==13) {
				display = "Kc";
			}
			else if(value==14) {
				display = "Ac";
			}
		}
		
		else if (suit==2) {
			if(value<11) {
				display = value+"h";
			}
			else if(value==11) {
				display = "Jh";
			}
			else if(value==12) {
				display = "Qh";
			}
			else if(value==13) {
				display = "Kh";
			}
			else if(value==14) {
				display = "Ah";
			}
		}
		
		else if (suit==3) {
			if(value<11) {
				display = value+"d";
			}
			else if(value==11) {
				display = "Jd";
			}
			else if(value==12) {
				display = "Qd";
			}
			else if(value==13) {
				display = "Kd";
			}
			else if(value==14) {
				display = "Ad";
			}
		}
	}
	
	public int getValue() {
		return value;
	}
	
	public int getSuit() {
		return suit;
	}
}
