package com.project.flappybird.controller.Game;

import com.project.flappybird.Game;
import com.project.flappybird.controller.game.ArenaController;
import com.project.flappybird.gui.GUI;
import com.project.flappybird.model.Position;
import com.project.flappybird.model.Setting;
import com.project.flappybird.model.game.arena.Arena;
import com.project.flappybird.model.game.elements.Bird;
import com.project.flappybird.model.game.elements.Ground;
import com.project.flappybird.model.game.elements.Pipe;
import com.project.flappybird.states.GameState;
import com.project.flappybird.states.MenuState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ArenaControllerTest {
    ArenaController controller;
    private Arena arena;
    private Game game;
    private GUI.ACTION action;
    private long time;

    @BeforeEach
    void setUp() {
        Setting setting = new Setting("Easy");
        game = Mockito.mock(Game.class);
        action = GUI.ACTION.UP;
        time = System.currentTimeMillis();
        arena = new Arena(setting);

        arena.setBird(new Bird(8, 8));
        arena.setPipes(Arrays.asList(new Pipe(5, 5, setting.getArenaHeight(), setting.getPipeSpace()),
                new Pipe(10, 5, setting.getArenaHeight(), setting.getPipeSpace()),
                new Pipe(15, 5, setting.getArenaHeight(), setting.getPipeSpace())));
        arena.setGrounds(Arrays.asList(new Ground(2, 2, 0)));

        controller = new ArenaController(arena);
    }

    @Test
    void quit() {
        action = GUI.ACTION.QUIT;

        controller.step(game, action, time);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(MenuState.class));
    }

    @Test
    void step() {
        arena.getBird().setHit(true);
        Position position = arena.getGrounds().get(0).getPosition();

        controller.step(game, action, time);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(GameState.class));
        Mockito.verify(game, Mockito.times(2)).hasStarted();
        Assertions.assertFalse(position.equals(arena.getGrounds().get(0).getPosition()));
    }

}
