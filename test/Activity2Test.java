package elevens;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Activity2Test {

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
	@DisplayName("Deck.shuffle")
	void testDeckShuffle() {
		Deck deck = new Deck(new String[] {"seven", "ten", "ace" }, new String[] { "green", "red", "white" },
				new int[] { 7, 10, 1 });
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

}
