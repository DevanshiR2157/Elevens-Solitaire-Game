package elevens;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Activity2TestV2 {
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	@Test
	@DisplayName("Shuffler.perfectShuffle")
	void testShufflerPerfectShuffle1of2() {
		int[] one = {2,1,5,7,8};
		int[] two = one.clone();
		
		Shuffler.perfectShuffle(two);
		
		Boolean permutation = true;
		for(int i=0;i<one.length;i++) {
			Boolean contains = false;
			for(int j=0;j<two.length;j++) {
				if(two[j]==one[i]) {
					contains = true;
				}
			}
			if(contains!=true) {
				permutation = false;
			}
		}
		assertTrue(permutation);
	}
	@Test
	@DisplayName("Shuffler.perfectShuffle")
	void testShufflerPerfectShuffle2of2() {
		int[] one = {2,1,5,7,8};
		int[] two = one.clone();
		
		Shuffler.perfectShuffle(two);
		boolean isDifferent = false;
		for(int i=0;i<one.length;i++) {
			if(two[i]!=one[i]) {
				isDifferent = true;
				}
		}
		assertTrue(isDifferent);
	}

	@Test
	@DisplayName("Shuffler.selectionShuffle")
	void testShufflerSelectionShuffle1of2() {
		int[] one = {2,1,5,7,8};
		int[] two = one.clone();
		
		Shuffler.selectionShuffle(two);
		
		Boolean permutation = true;
		for(int i=0;i<one.length;i++) {
			Boolean contains = false;
			for(int j=0;j<two.length;j++) {
				if(two[j]==one[i]) {
					contains = true;
				}
			}
			if(contains!=true) {
				permutation = false;
			}
		}
		assertTrue(permutation);	
	}
	@Test
	@DisplayName("Shuffler.selectionShuffle2")
	void testShufflerSelectionShuffle2of2() {
		int[] one = {2,1,5,7,8};
		int[] two = one.clone();
		
		Shuffler.selectionShuffle(two);
		
		// Make sure that perfectShuffle does something
		boolean isChanged = false;
		for (int i = 0; i < two.length; i++) {
			if (one[i] != two[i])
				isChanged = true;
		}
		assertTrue(isChanged);
	}
	@Test
	void testDeckShuffle1of3() {
		Deck deck = new Deck(RANKS,SUITS, POINT_VALUES );
		//deal 3 cards
		Card card1 = deck.deal();
		Card card2 = deck.deal();
		Card card3 = deck.deal();
		// shuffle
		deck.shuffle();
		// deal 3 cards again
		Card cardOne = deck.deal();
		Card cardTwo = deck.deal();
		Card cardThree = deck.deal();
		// Cards should not be the same.
		boolean isEqual = card1.equals(cardOne) && card2.equals(cardTwo) && card3.equals(cardThree);
		assertFalse(isEqual);
	}
	@Test
	void testDeckShuffle2of3() {
		Deck d1 = new Deck(RANKS,SUITS, POINT_VALUES );
		boolean allSameSuit = true;
		int totalCardCount = RANKS.length * SUITS.length;
		Card prev = d1.cards.get(totalCardCount -1);
		for (int rank = totalCardCount -2 ; rank > totalCardCount - RANKS.length -1; rank--) {
			if (!prev.getSuit().equals(d1.cards.get(rank))) {
				allSameSuit = false;
			}
		}
		assertFalse(allSameSuit);
	}
	@Test
	void testDeckShuffle3of3() {
		Deck d1 = new Deck(RANKS,new String[] {"Spades"}, POINT_VALUES );
		
		int incRankCount = 0;
		String prevRank = d1.cards.get(0).getRank();
		for (int rank = 0; rank <RANKS.length; rank++) {
			if (d1.cards.get(rank).getRank().equals(RANKS[rank])) {
				incRankCount++;
			}
		}
		assertNotEquals(13,incRankCount);
	}

}
