package sk.ivankohut.tictactoe;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ConstantPlayerTest {
	
	@Test
	public void providesGivenName() throws Exception {
		char name = 'C';
		ConstantPlayer sut = new ConstantPlayer(name);
		// exercise
		Character actualName = sut.name();
		// verify
		assertThat(actualName).isEqualTo(name);
	}
	
	@Test
	public void providesGivenMoves() throws Exception {
		ConstantPlayer sut = new ConstantPlayer(1, 3);
		// exercise
		// verify
		assertThat(sut.move()).isEqualTo(1);
		assertThat(sut.move()).isEqualTo(3);
		assertThat(sut.move()).isNull();
	}
}
