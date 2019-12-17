package game;

public enum Emotes {

	smile("Your mouth widens in a smile."), 
	wink("You blink excessively."), 
	cry("You cry to get sympathy from the human."), 
	grin("You grin to the human"), 
	pout("You try to elicit a positive response by pouting."), 
	frown("You frown to emulate a human emotion.");

	String sentence;

	Emotes(String sentence) {
		this.sentence = sentence;
	}

	public String getSentence() {
		return sentence;
	}

//	@Override
//	public String toString() {
//		switch (this) {
//		case Smile:
//			System.out.println("Your mouth widens in a smile.");
//			break;
//		case Blink:
//			System.out.println("You blink excessively.");
//			break;
//		case Drink:
//			System.out.println("You take a sip of water.");
//			break;
//		case Grin:
//			System.out.println("You grin to the human");
//			break;
//		case Frown:
//			System.out.println("You frown.");
//			break;
//		case Pout:
//			System.out.println("You try to elicit a positive response by pouting.");
//			break;
//		}
//		return super.toString();
//	}

}
