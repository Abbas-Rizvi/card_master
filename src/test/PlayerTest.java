package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import game.Player;

public class PlayerTest {


	Player player = new Player();

	@Before
	public void setUp() throws Exception {
		//always give player 1000 before tests and reset bets
		player.setMoney(1000);
		player.draw();
		player.setName("Timothy");
	}

	@Test
	//test setting bets
	public void testSetBet() {
		
		//verify function went through success
		assertTrue(player.setBet(100));
		
		//verify money removed from account 
		assertEquals(player.getMoney(),900,0);
		
		//verify money is placed in bet
		assertEquals(player.getBet(),100,0);
		
		//test invalid bet
		player.setMoney(0);
		
		assertFalse(player.setBet(100));

	}

	@Test
	public void testDeposit() {
		player.deposit(100);
		assertEquals(player.getMoney(), 1100, 0);
	}

	@Test
	public void testGetBet() {
		player.setBet(100);
		assertEquals(player.getBet(), 100,0);
	}

	@Test
	public void testDraw() {
		player.setBet(100);
		assertEquals(player.getMoney(), 900, 0);
		player.draw();
		assertEquals(player.getMoney(), 1000, 0);
	}

	@Test
	public void testWin() {
		player.setBet(100);
		player.win();
		assertEquals(player.getMoney(), 1100, 0);
		assertEquals(player.getBet(),0,0);
	}

	@Test
	public void testLose() {
		player.setBet(100);
		player.lose();
		assertEquals(player.getMoney(), 900, 0);
		assertEquals(player.getBet(),0,0);
	}

	@Test
	public void testGetMoney() {
		assertEquals(player.getMoney(),1000,0);
	}

	@Test
	public void testSetMoney() {
		player.setMoney(100);
		assertEquals(player.getMoney(), 100, 0);
	}

	@Test
	public void testGetName() {
		assertEquals("Timothy",player.getName());
	}

	@Test
	public void testSetName() {

		player.setName("Jim");
		assertEquals("Jim",player.getName());
	}

}
