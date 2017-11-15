package sk.ivankohut.tictactoe;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TextWinnerGratulationTest {
	
	@Test
	public void winnerNameDisplayedAtTheEndOfTheGame() throws Exception {
		assertWinnerMessage(Optional.of('X'), "PLAYER X WON!");
	}

	@Test
	public void drawMessageDisplayedAtTheEndOfTheGameWhenThereIsNoWinner() throws Exception {
		assertWinnerMessage(Optional.empty(), "GAME ENDS WITH A DRAW!");
	}

	private void assertWinnerMessage(Optional<Character> winnerName, String expectedMessage) {
		List<String> lines = new ArrayList<>();
		Optional<Player> winner = winnerName.map(name -> when(mock(Player.class).name()).thenReturn(name).getMock());
		Game game = when(mock(Game.class).winner()).thenReturn(winner).getMock();
		TextWinnerGratulation ticTacToe = new TextWinnerGratulation(new CollectionTextOutput(lines), game);
		// exercise
		ticTacToe.say();
		// verify
		Assertions.assertThat(lines).endsWith(expectedMessage);
	}
	
}
