package com.project.flappybird.controller.Game;

import com.project.flappybird.Game;
import com.project.flappybird.controller.game.GroundController;
import com.project.flappybird.gui.GUI;
import com.project.flappybird.model.Position;
import com.project.flappybird.model.Setting;
import com.project.flappybird.model.game.arena.Arena;
import com.project.flappybird.model.game.elements.Bird;
import com.project.flappybird.model.game.elements.Ground;
import com.project.flappybird.model.game.elements.Pipe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class GroundControllerTest {
    GroundController controller;
    private Arena arena;
    private Setting setting;
    private Game game;
    GUI.ACTION action;
    private long time;

    @BeforeEach
    void setUp() {
        setting = new Setting("Easy");
        game = Mockito.mock(Game.class);
        action = GUI.ACTION.UP;
        time = System.currentTimeMillis();
        arena = new Arena(setting);

        arena.setBird(new Bird(8, 8));
        arena.setPipes(Arrays.asList(new Pipe(5, 5, setting.getArenaHeight(), setting.getPipeSpace())));
        arena.setGrounds(Arrays.asList(new Ground(2, 2, 0), new Ground(3,2,1)));

        controller = new GroundController(arena);
    }

    @Test
    void moving() {
        controller.step(game, action, time);

        Assertions.assertEquals(arena.getGrounds().get(0).getPosition().getX(), 1);
        Assertions.assertEquals(arena.getGrounds().get(0).getSymbolType(), 0);
        Assertions.assertEquals(arena.getGrounds().get(1).getPosition().getX(), 2);
        Assertions.assertEquals(arena.getGrounds().get(1).getSymbolType(), 1);

    }

    @Test
    void renew() {
        arena.setGrounds(Arrays.asList(new Ground(2,2,0)));

        int count = 0;
        while (count != arena.getWidth()) {
            count++;
            controller.step(game, action, time);
            time += 51;
        }

        Assertions.assertEquals(arena.getGrounds().size(), 2*setting.getArenaWidth());
    }
    @Test
    void notMoving() {
        time = 50;
        Position position1 = arena.getGrounds().get(0).getPosition();
        Position position2 = arena.getGrounds().get(1).getPosition();

        controller.step(game, action, time);

        Assertions.assertTrue(arena.getGrounds().get(0).getPosition().equals(position1));
        Assertions.assertTrue(arena.getGrounds().get(1).getPosition().equals(position2));
    }
}
