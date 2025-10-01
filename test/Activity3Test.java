package elevens;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Activity3Test {


	// Elevens Board Tests
	@Test
	public void test11sConstructor() {
		ElevensBoard board = new ElevensBoard();
		// ensure the following:
		// -board size is 9
		// - After 9 cards have been dealt in the constructor,
		// 		43 cards are left undealt
		// - The board is NOT empty. Should contain 9 cards
		// - The number non-Null cards on the deck should by 9 at this point.
		assertAll("ElevensBoard Constructor",
				() -> assertEquals(9, board.size()),
				() -> assertEquals(43, board.deckSize()),
				() -> assertFalse(board.isEmpty()),
				() -> assertEquals(9, board.cardIndexes().size())
				);


	}

	@Test
	public void test11sConstructor2() {
		ElevensBoard board = new ElevensBoard();
		assertEquals(9, board.size());
	}

	@Test
	public void test11sConstructorDeal() {
		ElevensBoard board = new ElevensBoard();
		int initSize = board.deckSize();
		// Deal 9 cards
		for (int i = 0; i < 9; i++) {
			board.deal(i);
		}
		assertEquals(initSize - 9,board.deckSize());
	}

	@Test
	public void test11sConstructorDeckSize() {
		ElevensBoard board = new ElevensBoard();
		assertEquals(43, board.deckSize());

	}

	@Test
	public void test11sAnotherPlayIsPossible() {
		
		boolean isWorking = true;

		for (int run = 0; run < 100; run++) {
			ElevensBoard board = new ElevensBoard();
			boolean hasPairSum11 = false;
			boolean hasJack = false;
			boolean hasQueen = false;
			boolean hasKing = false;

			// Get indexes of cards on board
			ArrayList<Integer> indexes = (ArrayList<Integer>)(board.cardIndexes());
			// traverse indexes for sums
			for (int i = 0; i < indexes.size(); i++) {
				if (board.cardAt(i) != null) {
					int points = board.cardAt(i).getPointValue();
					for (int j = i + 1; j < indexes.size(); j++) {
						if (board.cardAt(j).getPointValue() + points == 11) {
							hasPairSum11 = true;
						}
						
					}
					if (board.cardAt(i).getRank().equals("jack")) {
						hasJack =true;
					}
					else if (board.cardAt(i).getRank().equals("queen")) {
						hasQueen =true;
					}
					else if (board.cardAt(i).getRank().equals("king")) {
						hasKing = true;
					}

				}
			}
			boolean retval = board.anotherPlayIsPossible();

			if (((hasJack && hasQueen && hasKing) || hasPairSum11)!= retval)
				isWorking = false;

		}
		assertTrue(isWorking);
	
	}
	@Test
	public void test11sContainsPairSum11_1_of5() {
		Card tenHearts = new Card("10","hearts",10);
		Card aceHearts = new Card("ace","hearts",1);
		ElevensBoard board = new ElevensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(tenHearts);
		int i2 = ((Board)board).deck.cards.indexOf(aceHearts);
		((Board)board).boardCards[0] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[1] = ((Board)board).deck.cards.get(i2);
		indexes.add(0);
		indexes.add(1);
		
		assertTrue(board.containsPairSum11(indexes));
	}
	
	@Test
	public void test11sContainsPairSum11_2_of_5() {
		Card tenHearts = new Card("10","hearts",10);
		Card aceHearts = new Card("ace","hearts",1);
		Card aceSpades = new Card("ace","spades",1);
		ElevensBoard board = new ElevensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(tenHearts);
		int i2 = ((Board)board).deck.cards.indexOf(aceHearts);
		int i3 = ((Board)board).deck.cards.indexOf(aceSpades);
		((Board)board).boardCards[0] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[1] = ((Board)board).deck.cards.get(i2);
		((Board)board).boardCards[2] = ((Board)board).deck.cards.get(i3);
		indexes.add(0);
		indexes.add(1);
		indexes.add(2);
		
		assertFalse(board.containsPairSum11(indexes));
	}
	@Test
	public void test11sContainsPairSum11_3_of5() {
		Card sevenHearts = new Card("7","hearts",7);
		Card fourHearts = new Card("4","hearts",4);
		ElevensBoard board = new ElevensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(sevenHearts);
		int i2 = ((Board)board).deck.cards.indexOf(fourHearts);
		((Board)board).boardCards[0] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[1] = ((Board)board).deck.cards.get(i2);
		indexes.add(0);
		indexes.add(1);
		
		assertTrue(board.containsPairSum11(indexes));
	}
	@Test
	public void test11sContainsPairSum11_4_of5() {
		Card sixHearts = new Card("6","hearts",6);
		Card fourHearts = new Card("4","hearts",4);
		ElevensBoard board = new ElevensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(sixHearts);
		int i2 = ((Board)board).deck.cards.indexOf(fourHearts);
		((Board)board).boardCards[0] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[1] = ((Board)board).deck.cards.get(i2);
		indexes.add(0);
		indexes.add(1);
		
		assertFalse(board.containsPairSum11(indexes));
	}
	
	@Test
	public void test11sContainsPairSum11_5_of5() {
		Card jackHearts = new Card("jack","hearts",0);
		Card queenHearts = new Card("queen","hearts",0);
		
		ElevensBoard board = new ElevensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(jackHearts);
		int i2 = ((Board)board).deck.cards.indexOf(queenHearts);
		((Board)board).boardCards[0] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[1] = ((Board)board).deck.cards.get(i2);
		indexes.add(0);
		indexes.add(1);
		
		assertFalse(board.containsPairSum11(indexes));
	}

	@Test
	public void test11sContainsJQK_1_of_4() {
		Card jackHearts = new Card("jack","hearts",0);
		Card queenHearts = new Card("queen","hearts",0);
		Card kingHearts = new Card("king", "hearts", 0);
		ElevensBoard board = new ElevensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(jackHearts);
		int i2 = ((Board)board).deck.cards.indexOf(queenHearts);
		int i3 = ((Board)board).deck.cards.indexOf(kingHearts);
		((Board)board).boardCards[0] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[1] = ((Board)board).deck.cards.get(i2);
		((Board)board).boardCards[2] = ((Board)board).deck.cards.get(i3);
		indexes.add(0);
		indexes.add(1);
		indexes.add(2);
		assertTrue(board.containsJQK(indexes));

	}
	@Test
	public void test11sContainsJQK_2_of_4() {
		Card jackHearts = new Card("jack","hearts",0);
		Card queenHearts = new Card("queen","hearts",0);
		Card kingHearts = new Card("king", "hearts", 0);
		ElevensBoard board = new ElevensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(jackHearts);
		int i2 = ((Board)board).deck.cards.indexOf(queenHearts);
		int i3 = ((Board)board).deck.cards.indexOf(kingHearts);
		((Board)board).boardCards[0] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[1] = ((Board)board).deck.cards.get(i2);
		((Board)board).boardCards[8] = ((Board)board).deck.cards.get(i3);
		indexes.add(0);
		indexes.add(1);
		indexes.add(8);
		assertTrue(board.containsJQK(indexes));
	}

	@Test
	public void test11sContainsJQK_3_of_4() {
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
		indexes.add(0);
		indexes.add(1);
		indexes.add(8);
		assertFalse(board.containsJQK(indexes));
	}

	@Test
	public void test11sContainsJQK_4_of_4() {
		Card jackHearts = new Card("jack","hearts",0);
		Card queenHearts = new Card("queen","hearts",0);
		Card kingHearts = new Card("king", "hearts", 0);
		ElevensBoard board = new ElevensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(jackHearts);
		int i2 = ((Board)board).deck.cards.indexOf(queenHearts);
		int i3 = ((Board)board).deck.cards.indexOf(kingHearts);
		((Board)board).boardCards[4] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[6] = ((Board)board).deck.cards.get(i2);
		((Board)board).boardCards[8] = ((Board)board).deck.cards.get(i3);
		indexes.add(4);
		indexes.add(6);
		indexes.add(8);
		assertTrue(board.containsJQK(indexes));
	}
	// Tests whether pairs adding up to or not to 11 are correctly evaluated.
	// This test does not do an exhaustive test whether a pair that sums to 11 exists.
	@Test
	public void test11sIsLegal_PairSum11_1of5() {
		Card tenHearts = new Card("10","hearts",10);
		Card aceHearts = new Card("ace","hearts",1);
		ElevensBoard board = new ElevensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(tenHearts);
		int i2 = ((Board)board).deck.cards.indexOf(aceHearts);
		((Board)board).boardCards[0] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[1] = ((Board)board).deck.cards.get(i2);
		indexes.add(0);
		indexes.add(1);
		
		assertTrue(board.isLegal(indexes));

		}
	@Test
	public void test11sIsLegal_PairSum11_2of5() {
		Card tenHearts = new Card("10","hearts",10);
		Card aceHearts = new Card("ace","hearts",1);
		Card aceSpades = new Card("ace","spades",1);
		ElevensBoard board = new ElevensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(tenHearts);
		int i2 = ((Board)board).deck.cards.indexOf(aceHearts);
		int i3 = ((Board)board).deck.cards.indexOf(aceSpades);
		((Board)board).boardCards[0] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[1] = ((Board)board).deck.cards.get(i2);
		((Board)board).boardCards[2] = ((Board)board).deck.cards.get(i3);
		indexes.add(0);
		indexes.add(1);
		indexes.add(2);
		
		assertFalse(board.isLegal(indexes));
	}
	@Test
	public void test11sIsLegal_PairSum11_3of5() {
		Card sevenHearts = new Card("7","hearts",7);
		Card fourHearts = new Card("4","hearts",4);
		ElevensBoard board = new ElevensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(sevenHearts);
		int i2 = ((Board)board).deck.cards.indexOf(fourHearts);
		((Board)board).boardCards[0] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[1] = ((Board)board).deck.cards.get(i2);
		indexes.add(0);
		indexes.add(1);
		
		assertTrue(board.isLegal(indexes));
	}
	@Test
	public void test11sIsLegal_PairSum11_4of5() {
		Card sixHearts = new Card("6","hearts",6);
		Card fourHearts = new Card("4","hearts",4);
		ElevensBoard board = new ElevensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(sixHearts);
		int i2 = ((Board)board).deck.cards.indexOf(fourHearts);
		((Board)board).boardCards[0] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[1] = ((Board)board).deck.cards.get(i2);
		indexes.add(0);
		indexes.add(1);
	
		assertFalse(board.isLegal(indexes));
	}
	@Test
	public void test11sIsLegal_PairSum11_5of5() {
		Card jackHearts = new Card("jack","hearts",0);
		Card queenHearts = new Card("queen","hearts",0);
		
		ElevensBoard board = new ElevensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(jackHearts);
		int i2 = ((Board)board).deck.cards.indexOf(queenHearts);
		((Board)board).boardCards[0] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[1] = ((Board)board).deck.cards.get(i2);
		indexes.add(0);
		indexes.add(1);
		
		assertFalse(board.isLegal(indexes));
	}

	// Tests whether isLegal works when there is and is not a JQK triplet
	@Test
	public void test11sIsLegal_JQK_1_of4() {
		Card jackHearts = new Card("jack","hearts",0);
		Card queenHearts = new Card("queen","hearts",0);
		Card kingHearts = new Card("king", "hearts", 0);
		ElevensBoard board = new ElevensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(jackHearts);
		int i2 = ((Board)board).deck.cards.indexOf(queenHearts);
		int i3 = ((Board)board).deck.cards.indexOf(kingHearts);
		((Board)board).boardCards[0] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[1] = ((Board)board).deck.cards.get(i2);
		((Board)board).boardCards[2] = ((Board)board).deck.cards.get(i3);
		indexes.add(0);
		indexes.add(1);
		indexes.add(2);
		assertTrue(board.isLegal(indexes));

	}
	
	@Test
	public void test11sIsLegal_JQK_2_of4() {
		Card jackHearts = new Card("jack","hearts",0);
		Card queenHearts = new Card("queen","hearts",0);

		ElevensBoard board = new ElevensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(jackHearts);
		int i2 = ((Board)board).deck.cards.indexOf(queenHearts);

		((Board)board).boardCards[0] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[1] = ((Board)board).deck.cards.get(i2);

		indexes.add(0);
		indexes.add(1);

		assertFalse(board.isLegal(indexes));

	}

	@Test
	public void test11sIsLegal_JQK_3_of4() {
		Card jackHearts = new Card("jack","hearts",0);
		Card queenHearts = new Card("queen","hearts",0);
		Card kingHearts = new Card("king", "hearts", 0);
		ElevensBoard board = new ElevensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(jackHearts);
		int i2 = ((Board)board).deck.cards.indexOf(queenHearts);
		int i3 = ((Board)board).deck.cards.indexOf(kingHearts);
		((Board)board).boardCards[4] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[6] = ((Board)board).deck.cards.get(i2);
		((Board)board).boardCards[8] = ((Board)board).deck.cards.get(i3);
		indexes.add(4);
		indexes.add(6);
		indexes.add(8);
		assertTrue(board.isLegal(indexes));

	}
	@Test
	public void test11sIsLegal_JQK_4_of4() {
		Card kingHearts = new Card("king","hearts",0);
		Card kingHearts2 = new Card("king","hearts",0);
		Card kingHearts3 = new Card("king", "hearts", 0);
		ElevensBoard board = new ElevensBoard();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		int i1 = ((Board)board).deck.cards.indexOf(kingHearts);
		int i2 = ((Board)board).deck.cards.indexOf(kingHearts2);
		int i3 = ((Board)board).deck.cards.indexOf(kingHearts3);
		((Board)board).boardCards[4] = ((Board)board).deck.cards.get(i1);
		((Board)board).boardCards[6] = ((Board)board).deck.cards.get(i2);
		((Board)board).boardCards[8] = ((Board)board).deck.cards.get(i3);
		indexes.add(4);
		indexes.add(6);
		indexes.add(8);
		assertFalse(board.isLegal(indexes));

	}



}
