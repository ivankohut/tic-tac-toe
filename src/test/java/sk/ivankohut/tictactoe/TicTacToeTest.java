package sk.ivankohut.tictactoe;


import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TicTacToeTest {
	@Test
	public void emptyBoardAndInitialPlayerShown() throws Exception {
		List<String> lines = new ArrayList<>();
		TicTacToe ticTacToe = new TicTacToe(new CollectionTextOutput(lines));
		// exercise
		ticTacToe.play();
		// verify
		Assertions.assertThat(lines).containsExactly(
				"Game Board Creation...",
				" | | ",
				"-+-+-",
				" | | ",
				"-+-+-",
				" | | ",
				"",
				"Board Created.",
				"The game will start with player X"
				);
	}
}
