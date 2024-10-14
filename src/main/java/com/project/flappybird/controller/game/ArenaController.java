package com.project.flappybird.controller.game;

import com.project.flappybird.Game;
import com.project.flappybird.gui.GUI;
import com.project.flappybird.model.game.arena.Arena;
import com.project.flappybird.model.game.arena.ArenaBuilder;
import com.project.flappybird.model.menu.MenuInitial;
import com.project.flappybird.states.GameState;
import com.project.flappybird.states.MenuState;

public class ArenaController extends GameController {
    private final BirdController birdController;
    private final PipeController pipeController;
    private final GroundController groundController;

    public ArenaController(Arena arena) {
        super(arena);

        this.birdController = new BirdController(arena);
        this.pipeController = new PipeController(arena);
        this.groundController = new GroundController(arena);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action != GUI.ACTION.QUIT) {
            birdController.step(game, action, time);
            pipeController.step(game, action, time);
            groundController.step(game, action, time);

            if (getModel().getBird().getHit()) {
                int best = getModel().getBest();

                if (getModel().getScore() > getModel().getBest()) {
                    best = getModel().getScore();
                }

                game.setState(new GameState(new ArenaBuilder(getModel().getLevel()).createArena(best)));
            }
        }
        else {
            game.setState(new MenuState(new MenuInitial()));
        }
    }

}
