package online.nasgar.microbattles.game.status;

public abstract class GameStatus {

    private GameState gameState;

    public GameStatus(final GameState gameState) {
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public abstract void execute();
    public abstract GameStatus getNextStatus();
}