package sk.ivankohut.tictactoe;

import static org.mockito.Mockito.mock;

import java.util.Optional;

public class AnyWinner implements Game {

	@Override
	public Optional<Player> winner() {
		return Optional.of(mock(Player.class));
	}
}
