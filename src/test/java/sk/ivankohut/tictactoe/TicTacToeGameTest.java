package sk.ivankohut.tictactoe;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.Test;
import org.mockito.InOrder;

public class TicTacToeGameTest {
	
	@Test
	public void noWinnerIfNoMoreMovesPossible() throws Exception {
		Board board = when(mock(Board.class).isMovePossible()).thenReturn(false).getMock();
		TicTacToeGame sut = new TicTacToeGame(board, new ConstantPlayer(), null, mock(TextOutput.class));
		// exercise
		Optional<Player> name = sut.winner();
		// verify
		assertThat(name).isEmpty();
	}
	
	@Test
	public void playersAlternateInMoves() throws Exception {
		ConstantPlayer player1 = new ConstantPlayer('X', 1, 2); 
		ConstantPlayer player2 = new ConstantPlayer('O', 9, 8);
		Board board = when(mock(Board.class).isMovePossible()).thenReturn(true, true, true, true, false).getMock();
		when(board.winner()).thenReturn(Optional.empty());
		TextOutput output = mock(TextOutput.class);
		TicTacToeGame sut = new TicTacToeGame(board, player1, player2, output);
		// exercise
		Optional<Player> player = sut.winner();
		// verify
		InOrder inOrder = inOrder(board, output);
		inOrder.verify(board).set(1, player1);
		inOrder.verify(output).add("Player X");
		inOrder.verify(board).set(9, player2);
		inOrder.verify(output).add("Player O");
		inOrder.verify(board).set(2, player1);
		inOrder.verify(output).add("Player X");
		inOrder.verify(board).set(8, player2);
		inOrder.verify(output).add("Player O");
		assertThat(player).isEmpty();
	}
	
	@Test
	public void boardIsPrintedAfterEachMove() throws Exception {
		Board board = when(mock(Board.class).isMovePossible()).thenReturn(true, true, false).getMock();
		when(board.winner()).thenReturn(Optional.empty());
		TextOutput output = mock(TextOutput.class);
		TicTacToeGame sut = new TicTacToeGame(board, new ConstantPlayer(1), new ConstantPlayer(2), output);
		// exercise
		sut.winner();
		// verify
		verify(board, times(1 + 2)).print(output);
	}
	
	@Test
	public void noMoreMovesIfAnyPlayerIsWinner() throws Exception {
		Player anyPlayer = mock(Player.class);
		Board board = when(mock(Board.class).isMovePossible()).thenReturn(true).getMock();
		when(board.winner()).thenReturn(Optional.of(anyPlayer));
		TicTacToeGame sut = new TicTacToeGame(board, new ConstantPlayer(), null, mock(TextOutput.class));
		// exercise
		Optional<Player> player = sut.winner();
		// verify
		assertThat(player).contains(anyPlayer);
	}
	
	@Test
	public void outputsBoardCreationMessages() throws Exception {
		Board board = when(mock(Board.class).isMovePossible()).thenReturn(false).getMock();
		TextOutput output = mock(TextOutput.class);
		TicTacToeGame sut = new TicTacToeGame(board, new ConstantPlayer('P'), null, output);
		// exercise
		sut.winner();
		// verify
		InOrder inOrder = inOrder(output, board);
		inOrder.verify(output).add("Game Board Creation...");
		inOrder.verify(board).print(output);
		inOrder.verify(output).add("Board Created.");
		inOrder.verify(output).add("The game will start with player P");
	}
}
