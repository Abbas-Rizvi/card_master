package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BlackJackTest.class, CardTest.class, DeckTest.class, PlayerTest.class })
public class AllTests {

}
