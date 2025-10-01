package elevens;
import java.util.ArrayList;


/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board{

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new ElevensBoard instance.
	 */
	public ElevensBoard() {
		/* *** TO BE IMPLEMENTED IN Activity 3 *** */
		super(BOARD_SIZE, RANKS, SUITS,POINT_VALUES);
	}

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	public boolean isLegal(ArrayList<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN Activity 3 *** */
		if (selectedCards.size() == 2) {
			return containsPairSum11(selectedCards);
		} else if (selectedCards.size() == 3) {
			return containsJQK(selectedCards);
		} else {
			return false;
		}
	}


	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
		ArrayList<Integer> cardIndex = cardIndexes();
		ArrayList<Integer> sum11pair = findPairSum11(cardIndex);
		ArrayList<Integer> cardsJQK = findJQK(cardIndex);
		return sum11pair.size() == 2 || cardsJQK.size() == 3;
	}
	



	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	protected boolean containsPairSum11(ArrayList<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
		int sum = 0;
		for (int i = 0; i < selectedCards.size(); i++) {
			int k = selectedCards.get(i).intValue();
			sum += cardAt(k).getPointValue();
		}
		if(sum == 11) {
			return true;
		}
		return false;
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	protected boolean containsJQK(ArrayList<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
		boolean isFoundJ = false;
		boolean isFoundQ = false;
		boolean isFoundK = false;
		
		for (Integer obj : selectedCards) {
			int i = obj.intValue();
			if(cardAt(i).getRank().equals("jack")) {
				isFoundJ = true;
			} 
			
			if(cardAt(i).getRank().equals("queen")) {
				isFoundQ = true;
			}
			
			if(cardAt(i).getRank().equals("king")) {
				isFoundK = true;
			}
		}
		
		return isFoundJ && isFoundQ && isFoundK;
		
	}
	
	
	/**
	 * Attempts to play either a pair that sums to 11 or a JQK triplet
	 * @return true if there was a legal move to play; otherwise false
	 */
	protected boolean playIfPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 5 *** */
		return playPairSum11IfPossible() || playJQKIfPossible();
	}
	
	/**
	 * Attempts to play a pair that sums to 11
	 * @return true if there was a legal move to play; otherwise false
	 */
	protected boolean playPairSum11IfPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 5 *** */
		ArrayList<Integer> cardIndex = cardIndexes();
		ArrayList<Integer> sumPair = findPairSum11(cardIndex);
		if(sumPair.size() == 2) {
			replaceSelectedCards(sumPair);
			return true;
		}
		return false;
	}
	
	/**
	 * Attempts to play a JQK triplet
	 * @return true if there was a legal move to play; otherwise false
	 */

	protected boolean playJQKIfPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 5 *** */
		ArrayList<Integer> cardIndex = cardIndexes();
		ArrayList<Integer> indexesOfJQK = findJQK(cardIndex);
		if(indexesOfJQK.size() == 3) {
			replaceSelectedCards(indexesOfJQK);
			return true;
		}
		return false;
	}
	
	/**
	 * Check for a pair that sums to 11 in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return an ArrayList containint the pair of cards that sum to 11; otherwise an empty ArrayList.
	 */
	protected ArrayList<Integer> findPairSum11(ArrayList<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 5 *** */
		ArrayList<Integer> pairIndex = new ArrayList<Integer>();
		
		for (int i = 0; i < selectedCards.size(); i++) {
			int k = selectedCards.get(i).intValue();
			for (int j = i+1; j < selectedCards.size(); j++) {
				int h = selectedCards.get(j).intValue();
				if(cardAt(k).getPointValue() + cardAt(h).getPointValue() == 11) {
					pairIndex.add(selectedCards.get(i));
					pairIndex.add(selectedCards.get(j));
					return pairIndex;
				}
			}
		}
		return pairIndex;
	}

	/**
	 * find a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return an ArrayList containint the triplet of face cards; otherwise an empty ArrayList.
	 */
	protected ArrayList<Integer> findJQK(ArrayList<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 5 *** */
		ArrayList<Integer> indexOfJQK = new ArrayList<Integer>();
		boolean isFoundJ = false;
		boolean isFoundQ = false;
		boolean isFoundK = false;
		
		if(containsJQK(selectedCards)) {
			for (Integer obj : selectedCards) {
				int i = obj.intValue();
				
				if(isFoundJ == false && cardAt(i).getRank().equals("jack")) {
					indexOfJQK.add(obj);
					isFoundJ = true;
				} 
				
				if(isFoundQ == false && cardAt(i).getRank().equals("queen")) {
					indexOfJQK.add(obj);
					isFoundQ = true;
				}
				
				if(isFoundK == false && cardAt(i).getRank().equals("king")) {
					indexOfJQK.add(obj);
					isFoundK = true;
				}
			}
		}
		return indexOfJQK;
	}
}
