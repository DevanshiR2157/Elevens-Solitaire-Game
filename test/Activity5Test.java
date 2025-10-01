package elevens;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class Activity5Test {

	@Test
	public void test11sFindPairSum11_1_of4() {
		Card tenHearts = new Card("10","hearts",10);
		Card aceHearts = new Card("ace","hearts",1);
		Card twoDiamonds = new Card("2", "diamonds", 2);
		
		ElevensBoard board = new ElevensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(tenHearts);
		int i2 = ((Board)board).deck.cards.indexOf(aceHearts);
		int i3 = ((Board)board).deck.cards.indexOf(twoDiamonds);
		Card twoDiamondsRef = ((Board)board).deck.cards.get(i3);
		((Board)board).boardCards[0] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[1] = ((Board)board).deck.cards.get(i2);
		((Board)board).boardCards[2] = twoDiamondsRef;
		((Board)board).boardCards[3] = twoDiamondsRef;
		((Board)board).boardCards[4] = twoDiamondsRef;
		((Board)board).boardCards[5] = twoDiamondsRef;
		((Board)board).boardCards[6] = twoDiamondsRef;
		((Board)board).boardCards[7] = twoDiamondsRef;
		((Board)board).boardCards[8] = twoDiamondsRef;

		indexes.add(0);
		indexes.add(1);
		ArrayList<Integer> foundIndexes = board.findPairSum11(indexes);
		boolean isWorking = true;
		for (int i = 0; i < indexes.size(); i++) {
			if (!foundIndexes.contains(indexes.get(i))) {
				isWorking = false;
			}
		}
		assertTrue(isWorking);
	}

	@Test
	public void test11sFindPairSum11_2_of4() {
		Card sixHearts = new Card("6","hearts",6);
		Card fiveSpades = new Card("5","spades",5);
		Card twoDiamonds = new Card("2", "diamonds", 2);
		
		ElevensBoard board = new ElevensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(sixHearts);
		int i2 = ((Board)board).deck.cards.indexOf(fiveSpades);
		int i3 = ((Board)board).deck.cards.indexOf(twoDiamonds);
		Card twoDiamondsRef = ((Board)board).deck.cards.get(i3);
		((Board)board).boardCards[1] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[8] = ((Board)board).deck.cards.get(i2);
		((Board)board).boardCards[0] = twoDiamondsRef;
		((Board)board).boardCards[2] = twoDiamondsRef;
		((Board)board).boardCards[3] = twoDiamondsRef;
		((Board)board).boardCards[4] = twoDiamondsRef;
		((Board)board).boardCards[5] = twoDiamondsRef;
		((Board)board).boardCards[6] = twoDiamondsRef;
		((Board)board).boardCards[7] = twoDiamondsRef;

		indexes.add(1);
		indexes.add(8);
		ArrayList<Integer> foundIndexes = board.findPairSum11(indexes);
		boolean isWorking = true;
		for (int i = 0; i < indexes.size(); i++) {
			if (!foundIndexes.contains(indexes.get(i))) {
				isWorking = false;
			}
		}
		assertTrue(isWorking);
	}
	@Test
	public void test11sFindPairSum11_3_of4() {
		Card sixHearts = new Card("6","hearts",6);
		Card fiveSpades = new Card("5","spades",5);
		Card nineDiamonds = new Card("9","diamonds",9);
		Card twoDiamonds = new Card("2", "diamonds", 2);
		
		ElevensBoard board = new ElevensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(sixHearts);
		int i2 = ((Board)board).deck.cards.indexOf(fiveSpades);
		int i3 = ((Board)board).deck.cards.indexOf(twoDiamonds);
		int i4 = ((Board)board).deck.cards.indexOf(nineDiamonds);
		Card twoDiamondsRef = ((Board)board).deck.cards.get(i3);
		Card nineDiamondsref = ((Board)board).deck.cards.get(i4);
		((Board)board).boardCards[1] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[8] = ((Board)board).deck.cards.get(i2);
		((Board)board).boardCards[0] = twoDiamondsRef;
		((Board)board).boardCards[2] = nineDiamondsref;
		((Board)board).boardCards[3] = twoDiamondsRef;
		((Board)board).boardCards[4] = nineDiamondsref;
		((Board)board).boardCards[5] = twoDiamondsRef;
		((Board)board).boardCards[6] = nineDiamondsref;
		((Board)board).boardCards[7] = twoDiamondsRef;

		indexes.add(1);
		indexes.add(8);
		ArrayList<Integer> foundIndexes = board.findPairSum11(indexes);
		assertEquals(2, foundIndexes.size());
	}
	@Test
	public void test11sFindPairSum11_4_of4() {
		Card sixHearts = new Card("6","hearts",6);
		Card twoDiamonds = new Card("2", "diamonds", 2);
		
		ElevensBoard board = new ElevensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(sixHearts);
		int i3 = ((Board)board).deck.cards.indexOf(twoDiamonds);
		Card twoDiamondsRef = ((Board)board).deck.cards.get(i3);
		((Board)board).boardCards[1] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[8] = twoDiamondsRef;
		((Board)board).boardCards[0] = twoDiamondsRef;
		((Board)board).boardCards[2] = twoDiamondsRef;
		((Board)board).boardCards[3] = twoDiamondsRef;
		((Board)board).boardCards[4] = twoDiamondsRef;
		((Board)board).boardCards[5] = twoDiamondsRef;
		((Board)board).boardCards[6] = twoDiamondsRef;
		((Board)board).boardCards[7] = twoDiamondsRef;

		indexes.add(1);
		indexes.add(8);
		ArrayList<Integer> foundIndexes = board.findPairSum11(indexes);
		assertEquals(0, foundIndexes.size());
	}

	@Test
	public void test11sFindJQK_1_of_4() {
		Card jackHearts = new Card("jack","hearts",0);
		Card queenHearts = new Card("queen","hearts",0);
		Card kingHearts = new Card("king", "hearts", 0);
		Card twoDiamonds = new Card("2", "diamonds", 2);
		ElevensBoard board = new ElevensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(jackHearts);
		int i2 = ((Board)board).deck.cards.indexOf(queenHearts);
		int i3 = ((Board)board).deck.cards.indexOf(kingHearts);
		int i4 = ((Board)board).deck.cards.indexOf(twoDiamonds);
		Card twoDiamondsRef = ((Board)board).deck.cards.get(i4);
		((Board)board).boardCards[0] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[1] = ((Board)board).deck.cards.get(i2);
		((Board)board).boardCards[2] = ((Board)board).deck.cards.get(i3);
		((Board)board).boardCards[3] = twoDiamondsRef;
		((Board)board).boardCards[4] = twoDiamondsRef;
		((Board)board).boardCards[5] = twoDiamondsRef;
		((Board)board).boardCards[6] = twoDiamondsRef;
		((Board)board).boardCards[7] = twoDiamondsRef;
		((Board)board).boardCards[8] = twoDiamondsRef;
		indexes.add(0);
		indexes.add(1);
		indexes.add(2);
		ArrayList<Integer> foundIndexes = board.findJQK(indexes);
		boolean isWorking = true;
		for (int i = 0; i < indexes.size(); i++) {
			if (!foundIndexes.contains(indexes.get(i))) {
				isWorking = false;
			}
		}
		assertTrue(isWorking);

	}
	@Test
	public void test11sFindJQK_2_of_4() {
		Card jackHearts = new Card("jack","hearts",0);
		Card queenHearts = new Card("queen","hearts",0);
		Card kingHearts = new Card("king", "hearts", 0);
		Card twoDiamonds = new Card("2", "diamonds", 2);
		ElevensBoard board = new ElevensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(jackHearts);
		int i2 = ((Board)board).deck.cards.indexOf(queenHearts);
		int i3 = ((Board)board).deck.cards.indexOf(kingHearts);
		int i4 = ((Board)board).deck.cards.indexOf(twoDiamonds);
		Card twoDiamondsRef = ((Board)board).deck.cards.get(i4);
		((Board)board).boardCards[0] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[1] = ((Board)board).deck.cards.get(i2);
		((Board)board).boardCards[8] = ((Board)board).deck.cards.get(i3);
		((Board)board).boardCards[2] = twoDiamondsRef;
		((Board)board).boardCards[3] = twoDiamondsRef;
		((Board)board).boardCards[4] = twoDiamondsRef;
		((Board)board).boardCards[5] = twoDiamondsRef;
		((Board)board).boardCards[6] = twoDiamondsRef;
		((Board)board).boardCards[7] = twoDiamondsRef;
		indexes.add(0);
		indexes.add(1);
		indexes.add(8);
		ArrayList<Integer> foundIndexes = board.findJQK(indexes);
		boolean isWorking = true;
		for (int i = 0; i < indexes.size(); i++) {
			if (!foundIndexes.contains(indexes.get(i))) {
				isWorking = false;
			}
		}
		assertTrue(isWorking);
	}

	@Test
	public void test11sFindJQK_3_of_4() {
		Card jackHearts = new Card("jack","hearts",0);
		Card queenHearts = new Card("queen","hearts",0);
		Card jackHearts2 = new Card("jack", "hearts", 0);
		ElevensBoard board = new ElevensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(jackHearts);
		int i2 = ((Board)board).deck.cards.indexOf(queenHearts);
		int i3 = ((Board)board).deck.cards.indexOf(jackHearts2);
		((Board)board).boardCards[0] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[1] = ((Board)board).deck.cards.get(i2);
		((Board)board).boardCards[8] = ((Board)board).deck.cards.get(i3);
		((Board)board).boardCards[2] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[3] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[4] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[5] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[6] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[7] = ((Board)board).deck.cards.get(i1);
		indexes.add(0);
		indexes.add(1);
		indexes.add(8);
		ArrayList<Integer> foundIndexes = board.findJQK(indexes);

		assertEquals(0,foundIndexes.size());
	}

	@Test
	public void test11sFindJQK_4_of_4() {
		Card jackHearts = new Card("jack","hearts",0);
		Card queenHearts = new Card("queen","hearts",0);
		Card kingHearts = new Card("king", "hearts", 0);
		Card twoDiamonds = new Card("2", "diamonds", 2);
		ElevensBoard board = new ElevensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(jackHearts);
		int i2 = ((Board)board).deck.cards.indexOf(queenHearts);
		int i3 = ((Board)board).deck.cards.indexOf(kingHearts);
		int i4 = ((Board)board).deck.cards.indexOf(twoDiamonds);
		Card twoDiamondsRef = ((Board)board).deck.cards.get(i4);
		Card kingHeartsRef = ((Board)board).deck.cards.get(i3);
		Card jackHeartsRef = ((Board)board).deck.cards.get(i1);
		Card queenHeartsRef = ((Board)board).deck.cards.get(i2);
		((Board)board).boardCards[0] = jackHeartsRef;
		((Board)board).boardCards[1] = queenHeartsRef;
		((Board)board).boardCards[8] = kingHeartsRef;
		((Board)board).boardCards[2] = kingHeartsRef;
		((Board)board).boardCards[3] = jackHeartsRef;
		((Board)board).boardCards[4] = jackHeartsRef;
		((Board)board).boardCards[5] = queenHeartsRef;
		((Board)board).boardCards[6] = twoDiamondsRef;
		((Board)board).boardCards[7] = twoDiamondsRef;
		indexes.add(0);
		indexes.add(1);
		indexes.add(8);
		ArrayList<Integer> foundIndexes = board.findJQK(indexes);
		assertEquals(3,foundIndexes.size());
	}
	@Test
	public void testPlaySum11IfPossible() {
		ElevensBoard board = new ElevensBoard();
		boolean hasSum11 = false;
		for (int card1 = 0; card1 < board.size()-1;card1++) {
			for (int card2 = card1 + 1; card2 < board.size(); card2++) {
				// See if the cards sum up to 11.
				hasSum11 = hasSum11 ? hasSum11 : board.cardAt(card1).getPointValue() + board.cardAt(card2).getPointValue() == 11;
			}
		}


		int sizeOfDeckPriorToPlay = board.deckSize();
		boolean isPlaySum11Possible = board.playPairSum11IfPossible();
		boolean testAndCodeInSync = isPlaySum11Possible == hasSum11;

		// This tests that both the code and test come to the same 
		// determination that a sum 11 play is possible and that the deck
		// it is adjusted accordingly.

		// Had to add an if, because lambda expressions required the
		// variable that I have the "2" and "0" to be final, which I
		// did not want. Also, that is the same reason that I created
		// the testAndCodeInSync variable. 

		if (isPlaySum11Possible)
			assertAll("ElevensBoard Simulation: playSum11IfPossible",
					() -> assertTrue(testAndCodeInSync),
					() -> assertEquals(2, sizeOfDeckPriorToPlay - board.deckSize())
					);
		else
			assertAll("ElevensBoard Simulation: playSum11IfPossible",
					() -> assertTrue(testAndCodeInSync),
					() -> assertEquals(0, sizeOfDeckPriorToPlay - board.deckSize())
					);

	}


	@Test
	public void testPlayJQKIfPossible() {
		ElevensBoard board = new ElevensBoard();
		boolean hasJQK = false;

		for (int card1 = 0; card1 < board.size();card1++) {

			for (int card2 = 0; card2 < board.size(); card2++) {

				for (int card3 = 0; card3 < board.size(); card3++) {
					boolean containsJ = false;
					boolean containsQ = false; 
					boolean containsK = false;
					int[] cards = new int[3];
					cards[0] = card1;
					cards[1] = card2;
					cards[2] = card3;
					for (int i : cards) {
						// determine if we have J or Q or K
						if (board.cardAt(i).getRank().equals("jack"))
							containsJ = true;
						else if (board.cardAt(i).getRank().equals("queen"))
							containsQ = true;
						else if (board.cardAt(i).getRank().equals("king"))
							containsK = true;
					}
					// See if we have a valid JQK.
					hasJQK = hasJQK ? hasJQK : containsJ && containsQ && containsK;
				}
			}

		}

		int sizeOfDeckPriorToPlay = board.deckSize();
		boolean isPlayJQKIfPossible = board.playJQKIfPossible();
		boolean testAndCodeInSync = isPlayJQKIfPossible == hasJQK;

		// This tests that both the code and test come to the same 
		// determination that a JQK play is possible and that the deck
		// it is adjusted accordingly.

		// Had to add an if, because lambda expressions required the
		// variable that I have the "3" and "0" to be final, which I
		// did not want. Also, that is the same reason that I created
		// the testAndCodeInSync variable. 

		if (isPlayJQKIfPossible)
			assertAll("ElevensBoard Simulation: playJQKIfPossible",
					() -> assertTrue(testAndCodeInSync),
					() -> assertEquals(3, sizeOfDeckPriorToPlay - board.deckSize())
					);
		else
			assertAll("ElevensBoard Simulation: playJQKIfPossible",
					() -> assertTrue(testAndCodeInSync),
					() -> assertEquals(0, sizeOfDeckPriorToPlay - board.deckSize())
					);

	}
	@Test
	public void testPlayIfPossible() {
		// Use simulation code provided
		final int GAMES_TO_PLAY = 1000;
		final boolean I_AM_DEBUGGING = false;

		// Track whether a JQK is ever played
		int JQKBeenPlayedCount = 0;
		// Track whether a pair Sum 11 is ever played
		int pairSum11BeenPlayedCount = 0;

		ElevensBoard board = new ElevensBoard();
		int wins = 0;

		for (int k = 0; k < GAMES_TO_PLAY; k++) {
			int prevBoardSize = board.deckSize();
			while (board.playIfPossible()) {
				// Check whether a JQK or pairSum11 was played correctly.
				int deckSizeDelta = prevBoardSize - board.deckSize();
				if (deckSizeDelta == 2 ) {
					pairSum11BeenPlayedCount++;
				}
				else if (deckSizeDelta == 3) {
					JQKBeenPlayedCount++;
				}
				prevBoardSize = board.deckSize();
			}
			if (board.gameIsWon()) {
				wins++;
			}
			board.newGame();
		}

		double percentWon = (int)(1000.0 * wins / GAMES_TO_PLAY + 0.5) / 10.0;
		if (I_AM_DEBUGGING) {
			System.out.println("Percent Won: " + percentWon);
			System.out.println("Pair sum 11 played: " + pairSum11BeenPlayedCount);
			System.out.println("JQK played: " + JQKBeenPlayedCount);
		}

		boolean winPercentageInRange = percentWon > 7 && percentWon < 14;
		// These were added to workaround Lambda expression error
		// <variableName> defined in an enclosing scope must be final
		// or effectively final.
		boolean pairSumInRange = pairSum11BeenPlayedCount > 0;
		boolean JQKSumInRange = JQKBeenPlayedCount > 0;
		assertAll("ElevensBoard Simulation: playifPossible",
				() -> assertTrue(pairSumInRange),
				() -> assertTrue(JQKSumInRange),
				() -> assertTrue(winPercentageInRange)

				);
	}


}
