package com.project.flappybird.controller.game;

import com.project.flappybird.Game;
import com.project.flappybird.gui.GUI;
import com.project.flappybird.model.Position;
import com.project.flappybird.model.game.arena.Arena;
import com.project.flappybird.model.game.elements.Pipe;

public class PipeController extends GameController {

    private long lastMovement;

    public PipeController(Arena arena) {
        super(arena);

        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {

        if (!game.hasStarted()) {
            if (time - lastMovement > getModel().getPipeSpeed()) {
                for (Pipe pipe : getModel().getPipes())
                    movePipe(pipe, pipe.getPosition().getLeft());
                this.lastMovement = time;
            }
        }
    }

    private void movePipe(Pipe pipe, Position position) {
        if (getModel().isEmpty(getModel().getBird().getPosition())) {
            pipe.move(position);
        }
        else {
            pipe.move(position);
            getModel().getBird().setHit(true);
        }

        if (getModel().needPipes()) {
            getModel().newPipes();
        }
    }
}
