package test;

import static org.junit.Assert.*;

import org.junit.Before;

import game.Card;

import org.junit.Test;

public class CardTest {

	//create two cards to be used for testing
	Card card1;
	Card card2;

	// predefined methods before tests
	@Before
	public void createTestCards() {
		card1 = new Card(Card.Suit.DIAMONDS,Card.Value.QUEEN);
		card2 = new Card(Card.Suit.SPADES,Card.Value.FIVE);
	}
	
	@Test
	//constructor
	public void testCard() {
		Card test = new Card(Card.Suit.CLUBS,Card.Value.EIGHT);
		assertEquals(test.getCard_suit(), Card.Suit.CLUBS);
		assertEquals(test.getCard_value(), Card.Value.EIGHT);
	}

	@Test
	//test calculate rank function
	public void testCalculateRank() {
		assertEquals(10,card1.calculateRank());
		assertEquals(5,card2.calculateRank());
	}

	@Test
	//test get suit function
	public void testGetCard_suit() {
		assertEquals(Card.Suit.DIAMONDS,card1.getCard_suit());
		assertEquals(Card.Suit.SPADES,card2.getCard_suit());
	}

	@Test
	//test get value
	public void testGetCard_value() {
		assertEquals(Card.Value.QUEEN,card1.getCard_value());
		assertEquals(Card.Value.FIVE,card2.getCard_value());
	}

	@Test
	// test setting card suit
	public void testSetCard_suit() {
		card1.setCard_suit(Card.Suit.HEARTS);
		assertEquals(Card.Suit.HEARTS,card1.getCard_suit());
	
	
		card2.setCard_suit(Card.Suit.CLUBS);
		assertEquals(Card.Suit.CLUBS,card2.getCard_suit());
	}

	@Test
	// test setting all values
	public void testSetAll() {
		card1.setAll(Card.Suit.HEARTS, Card.Value.ACE);
		assertEquals(card1.getCard_suit(), Card.Suit.HEARTS);
		assertEquals(card1.getCard_value(), Card.Value.ACE);
		
		card2.setAll(Card.Suit.DIAMONDS, Card.Value.TWO);
		assertEquals(card2.getCard_suit(), Card.Suit.DIAMONDS);
		assertEquals(card2.getCard_value(), Card.Value.TWO);
		
	}

	@Test
	public void testSetCard_value() {
		card1.setCard_value(Card.Value.KING);
		assertEquals(Card.Value.KING, card1.getCard_value());

		card2.setCard_value(Card.Value.THREE);
		assertEquals(Card.Value.THREE, card2.getCard_value());
	}

	@Test
	public void testToString() {
		assertEquals("QUEEN OF DIAMONDS", card1.toString());
		assertEquals("FIVE OF SPADES", card2.toString());
	}

}
