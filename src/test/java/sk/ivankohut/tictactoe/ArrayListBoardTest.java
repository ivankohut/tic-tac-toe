package sk.ivankohut.tictactoe;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;
import org.mockito.InOrder;

public class ArrayListBoardTest {
	@Test
	public void playerIsWinnerIfCoversAnyWinningLine() throws Exception {
		ArrayListBoard sut = new ArrayListBoard(Arrays.asList(Arrays.asList(3, 5, 7)));
		Player player = mock(Player.class);
		// exercise
		setFields(sut, player, 3, 4, 5, 7);
		Optional<Player> winner = sut.winner();
		// verify
		assertThat(winner).contains(player);
	}
	
	@Test
	public void playerIsNotWinnerIfHeDoesNotCoversAnyWinningLine() throws Exception {
		ArrayListBoard sut = new ArrayListBoard(Arrays.asList(Arrays.asList(3, 5, 7)));
		Player player = mock(Player.class);
		Player otherPlayer = mock(Player.class);
		// exercise
		setFields(sut, player, 3, 7);
		setFields(sut, otherPlayer, 5);
		Optional<Player> winner = sut.winner();
		// verify
		assertThat(winner).isEmpty();
	}
	
	@Test
	public void moveIsPossibleIfEmptyFieldExists() throws Exception {
		assertMovePossibleForFieldsOccupied(true, 1, 2, 3, 4, 5, 6, 7, 8);
	}
	
	@Test
	public void moveIsNotPossibleIfAllFieldsAreOccupied() throws Exception {
		assertMovePossibleForFieldsOccupied(false, 1, 2, 3, 4, 5, 6, 7, 8, 9);
	}
	
	private static void assertMovePossibleForFieldsOccupied(Boolean expectedMovePossible, Integer ... fields) throws Exception {
		Player player = mock(Player.class);
		ArrayListBoard sut = new ArrayListBoard(Arrays.asList(Arrays.asList()));
		setFields(sut, player, fields);
		// exercise
		Boolean movePossible = sut.isMovePossible();
		// verify
		assertThat(movePossible).isEqualTo(expectedMovePossible);
	}
	
	private static void setFields(ArrayListBoard board, Player player, Integer ... fields) {
		for (Integer field : fields) {
			board.set(field, player);
		}
	}
	
	@Test
	public void printsTheBoardAsTextUsingPlayerNames() throws Exception {
		Player playerX = new ConstantPlayer('X');
		Player playerO = new ConstantPlayer('O');
		ArrayListBoard sut = new ArrayListBoard(Arrays.asList(Arrays.asList()));
		TextOutput output = mock(TextOutput.class);
		// exercise
		sut.set(2, playerX);
		sut.set(9, playerO);
		sut.print(output);
		// verify
		InOrder inOrder = inOrder(output);
		inOrder.verify(output).add(" |X| ");
		inOrder.verify(output).add("-+-+-");
		inOrder.verify(output).add(" | | ");
		inOrder.verify(output).add("-+-+-");
		inOrder.verify(output).add(" | |O");
		inOrder.verify(output).add("");
	}
}
