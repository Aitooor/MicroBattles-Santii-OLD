package online.nasgar.microbattles.game.status.list;

import online.nasgar.microbattles.game.status.GameState;
import online.nasgar.microbattles.game.status.GameStatus;

public class WaitingStatus extends GameStatus {
    public WaitingStatus() {
        super(GameState.PLAYING);
    }

    @Override
    public void execute() {

    }

    @Override
    public GameStatus getNextStatus() {
        return new PlayingStatus();
    }
}
