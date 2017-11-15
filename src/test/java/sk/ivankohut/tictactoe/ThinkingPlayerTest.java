package sk.ivankohut.tictactoe;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.Test;

public class ThinkingPlayerTest {
	@Test
	public void responsesAfterGivenNumberOfSeconds() throws Exception {
		LocalDateTime before = LocalDateTime.now();
		int secondsToThink = 1;
		Integer move = 1;
		Player underlyingPlayer = when(mock(Player.class).move()).thenReturn(move).getMock();
		ThinkingPlayer sut = new ThinkingPlayer(secondsToThink, underlyingPlayer);
		// exercise
		Integer actualMove = sut.move();
		// verify
		assertThat(actualMove).isEqualTo(move);
		assertThat(LocalDateTime.now()).isAfterOrEqualTo(before.plusSeconds(secondsToThink));
	}
	
	@Test
	public void delegatesNameToUnderlyingPlayer() throws Exception {
		char name = 'P';
		Player underlyingPlayer = new ConstantPlayer(name);
		ThinkingPlayer sut = new ThinkingPlayer(0, underlyingPlayer);
		// exercise
		Character actualName = sut.name();
		// verify
		assertThat(actualName).isEqualTo(name);
	}
	
}
