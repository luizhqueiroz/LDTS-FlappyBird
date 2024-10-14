package com.project.flappybird.controller.game;

import com.project.flappybird.Game;
import com.project.flappybird.gui.GUI;
import com.project.flappybird.model.Position;
import com.project.flappybird.model.game.arena.Arena;
import com.project.flappybird.model.game.arena.ArenaBuilder;
import com.project.flappybird.model.game.elements.Ground;

public class GroundController extends GameController{
    private long lastMovement;
    private int renew;

    public GroundController(Arena arena) {
        super(arena);

        this.lastMovement = 0;
        this.renew = 0;
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) {


        if (time - lastMovement > 50) {
            for (Ground ground : getModel().getGrounds()) {
                moveGround(ground, ground.getPosition().getLeft());
            }

            this.renew++;
            this.lastMovement = time;

        }

        if (renew == getModel().getWidth()) {
            getModel().setGrounds(new ArenaBuilder(getModel().getLevel()).createGround());
            this.renew = 0;
        }

    }

    private void moveGround(Ground ground, Position position) {
        ground.setPosition(position);
    }
}
