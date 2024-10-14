package com.project.flappybird.states;

import com.project.flappybird.controller.Controller;
import com.project.flappybird.controller.game.ArenaController;
import com.project.flappybird.model.game.arena.Arena;
import com.project.flappybird.viewer.Viewer;
import com.project.flappybird.viewer.game.GameViewer;

public class GameState extends State<Arena>{
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }

}
