package elevens;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Activity1Test {
	private Deck deck;
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};
	@BeforeEach
	public void init(){
		deck = new Deck(new String[] { "Bob", "Joel", "Emma" }, new String[] { "A", "B", "C" },
				new int[] { 1, 2, 3 });
	}
	
	/* CARD Tests */
	@Test
	public void testCardConstructor() {
		Card card = new Card("5", "A", 5);
		
		assertAll("Card Constructor",
				() -> assertEquals("5", card.getRank()),
				() -> assertEquals("A", card.getSuit()),
				() -> assertEquals(5, card.getPointValue())
		);
	}

	@Test
	public void testCardGetSuit() {
		Card card = new Card("Ace", "Hearts", 23);
		assertEquals("Hearts", card.getSuit());
	}

	@Test
	public void testCardGetRank() {
		Card card = new Card("3", "C", 34);
		assertEquals("3", card.getRank());
	}

	@Test
	public void testCardGetPointValue() {
		Card card = new Card("Ace", "D", 11);
		assertEquals(11, card.getPointValue());
	}

	@Test
	public void testCardEquals1of2() {
		Card card1 = new Card("Ace", "Hearts", 1);
		Card card2 = new Card("Ace", "Hearts", 1);
		assertTrue(card1.equals(card2));
	}
	@Test
	public void testCardEquals2of2() {
		Card card3 = new Card("Queen", "Diamonds", 12);
		Card card4 = new Card("Jack", "Spades", 11);
		
	    assertFalse(card3.equals(card4));
	}

	@Test
	public void testCardToString1() {
		Card card = new Card("55", "H", 2);
		assertEquals("55 of H (point value = 2)", card.toString());
	}
	@Test
	public void testCardToString2() {
		Card card = new Card("4", "clubs", 4);
		assertEquals(card.toString(), "4 of clubs (point value = 4)");

	}
	
	/* Deck Tests */
	@Test
	public void testDeck() {
		assertAll("Deck Constructor",
				() -> assertFalse(deck.isEmpty()),
				() -> assertNotEquals(0, deck.getSize())
		);
	}

	@Test
	public void testDeckIsEmpty1of2() {
		assertFalse(deck.isEmpty());
	}
	@Test
	public void testDeckIsEmpty2of2() {
		Deck d1 = new Deck(RANKS,SUITS, POINT_VALUES );
		for (int i = 0 ; i < RANKS.length * SUITS.length; i++) {
			d1.deal();
		}
		assertTrue(d1.isEmpty());
	}

	@Test
	public void testDeckGetSize1of2() {
		assertNotEquals(0, deck.getSize());
	}
	@Test
	public void testDeckGetSize2of2() {
		Deck d1 = new Deck(RANKS,SUITS, POINT_VALUES );
		assertEquals(52, d1.getSize());
	}

	@Test
	public void testDeckDeal1of4() {
		Deck d1 = new Deck(RANKS,SUITS, POINT_VALUES );
		assertEquals(52,d1.getSize());
	}
	@Test
	public void testDeckDeal2of4(	) {
		Deck d1 = new Deck(RANKS,SUITS, POINT_VALUES );
		Card c = d1.cards.get(51);
		assertEquals(c,d1.deal());
	}
	@Test
	public void testDeckDeal3of4(	) {
		Deck d1 = new Deck(RANKS,SUITS, POINT_VALUES );
		d1.deal();
		d1.deal();
		assertEquals(50,d1.getSize());
	}

	@Test
	public void testDeckDeal4of4() {
		Deck d1 = new Deck(RANKS,SUITS, POINT_VALUES );
		Card c = d1.deal();
		assertNotEquals(d1.deal(),c);
	}

	
	@Test
	public void testDeckToString1() {
		assertNotEquals(null, deck.toString());
	}
}
