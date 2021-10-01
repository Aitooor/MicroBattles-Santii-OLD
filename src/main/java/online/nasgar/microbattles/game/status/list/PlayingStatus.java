package online.nasgar.microbattles.game.status.list;

import online.nasgar.microbattles.game.status.GameState;
import online.nasgar.microbattles.game.status.GameStatus;

public class PlayingStatus extends GameStatus {
    public PlayingStatus() {
        super(GameState.PLAYING);
    }

    @Override
    public void execute() {

    }

    @Override
    public GameStatus getNextStatus() {
        return new ResettingStatus();
    }
}
