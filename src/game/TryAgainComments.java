package game;

public enum TryAgainComments {
	Sorry("I'm sorry, I didn't quite catch that. Try again."), 
	Sense("You're not making sense. Please try again."), 
	Stroke("Are you having a stroke, mate? Please try again."), 
	Assimilate("You will assimilate! Please try again.");
	
	String sentence;

	TryAgainComments(String sentence) {
		this.sentence = sentence;
	}

	public String getSentence() {
		return sentence;
	}
	
//	 @Override
//	  public String toString() {
//	       switch (this) {
//	         case Sorry:
//	              System.out.println("I'm sorry, I didn't quite catch that. Try again.");
//	              break;
//	         case Sense:
//	              System.out.println("You're not making sense. Please try again.");
//	              break;
//	         case Stroke:
//	              System.out.println("Are you having a stroke, mate? Please try again.");
//	              break;
//	         case Assimilate:
//	              System.out.println("You will assimilate! Please try again.");
//	        }
//	  return super.toString();
//	 }

}
