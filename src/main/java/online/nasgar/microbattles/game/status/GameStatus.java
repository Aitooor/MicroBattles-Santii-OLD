package online.nasgar.microbattles.game.status;

public abstract class GameStatus {

    private final GameState gameState;

    public GameStatus(final GameState gameState) {
        this.gameState = gameState;
    }

    public abstract void execute();
    public abstract GameStatus getNextStatus();
}