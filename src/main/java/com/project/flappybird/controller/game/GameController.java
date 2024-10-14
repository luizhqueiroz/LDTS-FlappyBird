package com.project.flappybird.controller.game;

import com.project.flappybird.controller.Controller;
import com.project.flappybird.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {

    public GameController(Arena arena) {
        super(arena);
    }
}
