package elevens;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class Activity4Test {

	// ThirteensBoard tests
	@Test
	public void test13sConstructor_Size() {
		ThirteensBoard board = new ThirteensBoard();
		assertEquals(10, board.size());
	}

	@Test
	public void test13sConstructor_Deal() {
		ThirteensBoard board = new ThirteensBoard();
		int initSize = board.deckSize();
		// Deal 9 cards
		for (int i = 0; i < 9; i++) {
			board.deal(i);
		}
		assertEquals(initSize - 9,board.deckSize());
	}

	@Test
	public void test13sConstructor_Deck_Size() {
		ThirteensBoard board = new ThirteensBoard();
		assertEquals(42, board.deckSize());

	}

	
	// Tests whether card contain exactly 1 K.
	@Test
	public void test13sIsLegal_K_1_of_2() {
		Card kingHearts = new Card("king","hearts",0);
		ThirteensBoard board = new ThirteensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(kingHearts);
		((Board)board).boardCards[8] = ((Board)board).deck.cards.get(i1);
		indexes.add(8);
		assertTrue(board.isLegal(indexes));

	}
	@Test
	public void test13sIsLegal_K_2_of_2() {
		Card kingHearts = new Card("king","hearts",0);
		Card jackHearts = new Card("jack","hearts",11);
		Card queenHearts = new Card("queen","hearts",12);

		ThirteensBoard board = new ThirteensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(kingHearts);
		int i2 = ((Board)board).deck.cards.indexOf(jackHearts);
		int i3 = ((Board)board).deck.cards.indexOf(queenHearts);
		((Board)board).boardCards[0] = ((Board)board).deck.cards.get(i2);
		((Board)board).boardCards[1] = ((Board)board).deck.cards.get(i3);
		((Board)board).boardCards[8] = ((Board)board).deck.cards.get(i1);
		indexes.add(0);
		indexes.add(1);
		indexes.add(8);
		assertFalse(board.isLegal(indexes));

	}

	// Tests whether pairs adding up to or not to 13 are correctly evaluated.
	// This test does not do an exhaustive test whether a pair that sums to 13 exists.
	@Test
	public void test13sIsLegal_PairSum13_1_of_3() {
		Card jackHearts = new Card("jack","hearts",11);
		Card twoHearts = new Card("2","hearts",2);
		ThirteensBoard board = new ThirteensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(twoHearts);
		int i2 = ((Board)board).deck.cards.indexOf(jackHearts);
		((Board)board).boardCards[0] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[8] = ((Board)board).deck.cards.get(i2);
		indexes.add(0);
		indexes.add(8);
		
		assertTrue(board.isLegal(indexes));
	}
	@Test
	public void test13sIsLegal_PairSum13_2_of_3() {
		Card nineHearts = new Card("9","hearts",9);
		Card twoHearts = new Card("2","hearts",2);
		ThirteensBoard board = new ThirteensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(nineHearts);
		int i2 = ((Board)board).deck.cards.indexOf(twoHearts);
		((Board)board).boardCards[0] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[8] = ((Board)board).deck.cards.get(i2);
		indexes.add(0);
		indexes.add(8);
		
		assertFalse(board.isLegal(indexes));
	}
	@Test
	public void test13sIsLegal_PairSum13_3_of_3() {
		Card nineHearts = new Card("9","hearts",9);
		Card twoHearts = new Card("2","hearts",2);
		Card kingHearts = new Card("king", "hearts", 0);

		ThirteensBoard board = new ThirteensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(nineHearts);
		int i2 = ((Board)board).deck.cards.indexOf(twoHearts);
		int i3 = ((Board)board).deck.cards.indexOf(kingHearts);

		((Board)board).boardCards[0] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[8] = ((Board)board).deck.cards.get(i2);
		((Board)board).boardCards[2] = ((Board)board).deck.cards.get(i3);

		indexes.add(0);
		indexes.add(8);
		indexes.add(2);
		assertFalse(board.isLegal(indexes));
	}


	@Test
	public void test13sContainsPairSum13_1_of_2() {
		Card tenHearts = new Card("10","hearts",10);
		Card threeHearts = new Card("3","hearts",3);
		ThirteensBoard board = new ThirteensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(tenHearts);
		int i2 = ((Board)board).deck.cards.indexOf(threeHearts);
		((Board)board).boardCards[0] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[8] = ((Board)board).deck.cards.get(i2);
		indexes.add(0);
		indexes.add(8);
		
		assertTrue(board.containsPairSum13(indexes));
	}
	@Test
	public void test13sContainsPairSum13_2_of_2() {
		Card tenHearts = new Card("10","hearts",10);
		Card aceHearts = new Card("ace","hearts",1);
		ThirteensBoard board = new ThirteensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(tenHearts);
		int i2 = ((Board)board).deck.cards.indexOf(aceHearts);
		((Board)board).boardCards[0] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[1] = ((Board)board).deck.cards.get(i2);
		indexes.add(0);
		indexes.add(1);
		
		assertFalse(board.containsPairSum13(indexes));
	}

	@Test
	public void test13sContainsK_2_of_2() {
		Card jackHearts = new Card("jack","hearts",11);
		ThirteensBoard board = new ThirteensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(jackHearts);
		((Board)board).boardCards[0] = ((Board)board).deck.cards.get(i1);
		indexes.add(0);
		assertFalse(board.containsK(indexes));
	}
	@Test
	public void test13sContainsK_1_of_2() {
		Card kingHearts = new Card("king","hearts",0);
		ThirteensBoard board = new ThirteensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(kingHearts);
		((Board)board).boardCards[8] = ((Board)board).deck.cards.get(i1);
		indexes.add(8);
		
		assertTrue(board.containsK(indexes));
	}

	@Test
	public void test13sAnotherPlayIsPossible() {
		
		boolean isWorking = true;

		for (int run = 0; run < 100; run++) {
			ThirteensBoard board = new ThirteensBoard();
			boolean hasPairSum13 = false;
			boolean hasKing = false;

			// Get indexes of cards on board
			ArrayList<Integer> indexes = (ArrayList<Integer>)(board.cardIndexes());
			// traverse indexes for sums
			for (int i = 0; i < indexes.size(); i++) {
				if (board.cardAt(i) != null) {
					int points = board.cardAt(i).getPointValue();
					for (int j = i + 1; j < indexes.size(); j++) {
						if (board.cardAt(j).getPointValue() + points == 13) {
							hasPairSum13 = true;
						}
						
					}
					if (board.cardAt(i).getRank().equals("king")) {
						hasKing = true;
					}

				}
			}
			boolean retval = board.anotherPlayIsPossible();

			if (((hasKing) || hasPairSum13)!= retval)
				isWorking = false;

		}
		assertTrue(isWorking);
	
	}
}
