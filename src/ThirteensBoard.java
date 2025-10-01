package elevens;

import java.util.ArrayList;

public class ThirteensBoard extends Board{
	
	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 10;

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
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new ThirteensBoard instance.
	 */
	public ThirteensBoard() {
		/* *** TO BE IMPLEMENTED IN Activity 4 *** */
		super(BOARD_SIZE, RANKS, SUITS,POINT_VALUES);
	}

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Thirteens, the legal groups are (1) a pair of cards
	 * whose values add to 13, and (2) a king.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(ArrayList<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN Activity 4 *** */
		if (selectedCards.size() == 1) {
			return containsK(selectedCards);
		} else if (selectedCards.size() == 2) {
			return containsPairSum13(selectedCards);
		} else {
			return false;
		}
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Thirteens, the legal groups are (1) a pair of cards
	 * whose values add to 13, and (2) a king.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		/* *** TO BE IMPLEMENTED IN Activity 4 *** */
		ArrayList<Integer> cardIndex = cardIndexes();
		ArrayList<Integer> sum13pair = findPairSum13(cardIndex);
		ArrayList<Integer> cardK = findK(cardIndex);
		return sum13pair.size() == 2 || cardK.size() == 1;
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	protected boolean containsPairSum13(ArrayList<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
		int sum = 0;
		for (int i = 0; i < selectedCards.size(); i++) {
			int k = selectedCards.get(i).intValue();
			sum += cardAt(k).getPointValue();
		}
		
		if (sum == 13) {
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
	protected boolean containsK(ArrayList<Integer> selectedCards) {	
		boolean isFound = false;
		for (Integer obj : selectedCards) {
			int i = obj.intValue();
			if (cardAt(i).getRank().equals("king")) {
				isFound = true;
			}
		}
		return isFound;
	}
	
		/**
	 * Attempts to play either a pair that sums to 13 or a K
	 * @return true if there was a legal move to play; otherwise false
	 */
	protected boolean playIfPossible() {

		return false;

	}
	
	/**
	 * Check for a pair that sums to 13 in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 13-pair.
	 * @return an ArrayList containint the pair of cards that sum to 13; otherwise an empty ArrayList.
	 */
	protected ArrayList<Integer> findPairSum13(ArrayList<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 5 *** */
		ArrayList<Integer> pairIndex = new ArrayList<Integer>();
		
		for (int i = 0; i < selectedCards.size(); i++) {
			int k = selectedCards.get(i).intValue();
			for (int j = i+1; j < selectedCards.size(); j++) {
				int h = selectedCards.get(j).intValue();
				if(cardAt(k).getPointValue() + cardAt(h).getPointValue() == 13) {
					pairIndex.add(selectedCards.get(i));
					pairIndex.add(selectedCards.get(j));
					return pairIndex;
				}
			}
		}
		return pairIndex;
	}

	/**
	 * find a K in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a K group.
	 * @return an ArrayList containint the single of face cards; otherwise an empty ArrayList.
	 */
	protected ArrayList<Integer> findK(ArrayList<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 5 *** */
		ArrayList<Integer> indexOfK = new ArrayList<Integer>();
		boolean isFoundK = false;
		
		if(containsK(selectedCards)) {
			for (Integer obj : selectedCards) {
				int i = obj.intValue();
				
				if(isFoundK == false && cardAt(i).getRank().equals("king")) {
					indexOfK.add(obj);
					isFoundK = true;
				}
			}
		}
		return indexOfK;
	}
}
