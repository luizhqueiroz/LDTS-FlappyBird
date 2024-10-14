package com.project.flappybird.controller.game;

import com.project.flappybird.Game;
import com.project.flappybird.gui.GUI;
import com.project.flappybird.model.Position;
import com.project.flappybird.model.game.arena.Arena;

public class BirdController extends GameController {

    public BirdController(Arena arena) {
        super(arena);
    }

    private void moveBirdUp() {
        if (getModel().getGravityLimit() > 0) getModel().setGravity(0);

        for (int i = 0; i < 3; i++)
            moveBird(getModel().getBird().getPosition().getUp());

    }

    private void moveBirdDown() {
        if ( getModel().getGravity() < getModel().getGravityLimit()) getModel().setGravity(getModel().getGravity()+1);

        for (int i= 0; i < getModel().getGravity(); i++)
            moveBird(getModel().getBird().getPosition().getDown());
    }

    private void moveBird(Position position) {
        if (getModel().isEmpty(position)) {
            if (position.getY() > -10) {
                getModel().getBird().setPosition(position);
                if (getModel().passedPipe(position)) getModel().increaseScore();
            }
        }
        else {
            getModel().getBird().setHit(true);
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {

        if (game.hasStarted()) {
            if (action == GUI.ACTION.UP) {
                game.notStarted();
                moveBirdUp();
            }
        }
        else {
            if (action == GUI.ACTION.UP) moveBirdUp();
            else moveBirdDown();
        }
    }

}
