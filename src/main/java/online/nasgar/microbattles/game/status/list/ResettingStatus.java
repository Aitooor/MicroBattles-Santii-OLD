package online.nasgar.microbattles.game.status.list;

import online.nasgar.microbattles.game.status.GameState;
import online.nasgar.microbattles.game.status.GameStatus;

public class ResettingStatus extends GameStatus {
    public ResettingStatus() {
        super(GameState.RESETTING);
    }

    @Override
    public void execute() {

    }

    @Override
    public GameStatus getNextStatus() {
        return new WaitingStatus();
    }
}
