package sk.ivankohut.tictactoe;

public class ThinkingPlayer implements Player {

	private final Integer secondsToThink;
	private final Player underlyingPlayer;

	public ThinkingPlayer(Integer secondsToThink, Player underlyingPlayer) {
		this.secondsToThink = secondsToThink;
		this.underlyingPlayer = underlyingPlayer;
	}

	@Override
	public Character name() {
		return underlyingPlayer.name();
	}

	@Override
	public Integer move() {
		try {
			Thread.sleep(secondsToThink * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return underlyingPlayer.move();
	}

}
