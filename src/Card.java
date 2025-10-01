package elevens;
/**
 * Card.java
 *
 * Card represents a playing card.
 */
public class Card {

	/**
	 * String value that holds the suit of the card
	 */
	private String suit;

	/**
	 * String value that holds the rank of the card
	 */
	private String rank;

	/**
	 * int value that holds the point value.
	 */
	private int pointValue;


   /**
	 * Creates a new Card instance.
	 *
	 * @param cardRank  a String value
	 *                  containing the rank of the card
	 * @param cardSuit  a String value
	 *                  containing the suit of the card
	 * @param cardPointValue an int value
	 *                  containing the point value of the card
	 */
	public Card(String cardRank, String cardSuit, int cardPointValue) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		rank = cardRank;
		suit = cardSuit;
		pointValue = cardPointValue;
	}


	/**
	 * Accesses this Card's suit.
	 * @return this Card's suit.
	 */
	public String getSuit() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		return suit;
   }

	/**
	 * Accesses this Card's rank.
	 * @return this Card's rank.
	 */
	public String getRank() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		return rank;
	}

   /**
	 * Accesses this Card's point value.
	 * @return this Card's point value.
	 */
	public int getPointValue() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		return pointValue;
	}

	/** Compare this card with the argument.
	 * @param other the other card to compare to this
	 * @return true if the rank, suit, and point value of this card
	 *              are equal to those of the argument;
	 *         false otherwise.
	 */
	@Override
	public boolean equals(Object other) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		Card c1 = (Card) other;
		if(suit.equals(c1.getSuit()) && pointValue == c1.getPointValue() && rank.equals(c1.getRank())) {
			return true;			
		}
		
		return false;
	}

	/**
	 * Converts the rank, suit, and point value into a string in the format
	 *     "[Rank] of [Suit] (point value = [PointValue])".
	 * This provides a useful way of printing the contents
	 * of a Deck in an easily readable format or performing
	 * other similar functions.
	 *
	 * @return a String containing the rank, suit,
	 *         and point value of the card.
	 */
	@Override
	public String toString() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		return rank + " of " + suit + " (point value = " + pointValue + ")";
	}
}
