package test;

import game.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BlackJackTest {

	BlackJack bj = new BlackJack();

	Deck deck = new Deck(false);
	Player host = new Player();
	Player p1 = new Player();

	@Before
	public void setUp() throws Exception {
		
	}

	//test game over function
	@Test
	public void testGameOver() {

		bj.gameOver(true);

	}
	
	@Test
	public void testHit() {
		fail("Not imp");
	}
	
	@Test
	public void testReturnCards() {

		// remove 10 cards from deck
		bj.dealCard(host, deck, 5);
		bj.dealCard(p1, deck, 5);

		// verify removal
		assertEquals(42, deck.num_cards());
		
		// return cards
		bj.returnCards(p1, host, deck);
		
		//verify retrieval
		assertEquals(0,host.deck.num_cards());
		assertEquals(52, deck.num_cards());
	}

	// test dealer option if hand score is less than player and less than 17
	@Test
	public void testDealerOption1() {
		Player host = new Player();
		Player p1 = new Player();
		
		Card card1 = new Card(Card.Suit.DIAMONDS,Card.Value.QUEEN);
		
		// host hand is 10
		host.deck.newCard(card1);
		
		// player hand is 20
		p1.deck.newCard(card1);
		p1.deck.newCard(card1);
		
		// Should return true
		assertTrue(bj.dealerOption(p1, host));
	}
	
	// test dealer option if hand score is less than player and greater than 17
	@Test
	public void testDealerOption2() {
		Player host = new Player();
		Player p1 = new Player();
		
		Card card1 = new Card(Card.Suit.DIAMONDS,Card.Value.QUEEN);
		Card card2 = new Card(Card.Suit.CLUBS, Card.Value.NINE);

		// host hand is 19
		host.deck.newCard(card1);
		host.deck.newCard(card2);
		
		// player hand is 20
		p1.deck.newCard(card1);
		p1.deck.newCard(card1);
		
		// should return false
		assertFalse(bj.dealerOption(p1, host));
	}
	
	// test dealer option if dealer hand greater than player
	@Test
	public void testDealerOption3() {
		Player host = new Player();
		Player p1 = new Player();
		
		Card card1 = new Card(Card.Suit.DIAMONDS,Card.Value.QUEEN);
		Card card2 = new Card(Card.Suit.CLUBS, Card.Value.SIX);
		
		// player hand is 10
		p1.deck.newCard(card1);
		
		// host hand is 16
		host.deck.newCard(card1);
		host.deck.newCard(card2);
		
		// should return false
		assertFalse(bj.dealerOption(p1, host));
	}

	// test dealing cards to player
	@Test
	public void testDealCard() {
	
		bj.dealCard(p1, deck, 5);
		
		assertEquals(p1.deck.num_cards(),5);
		
	}


}
