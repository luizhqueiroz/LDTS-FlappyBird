package com.project.flappybird.controller.Game;

import com.project.flappybird.Game;
import com.project.flappybird.controller.game.PipeController;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PipeControllerTest {
    private PipeController controller;
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
        arena.setPipes(Arrays.asList(new Pipe(5, 5, setting.getArenaHeight(), setting.getPipeSpace()),
                new Pipe(10, 5, setting.getArenaHeight(), setting.getPipeSpace()),
                new Pipe(15, 5, setting.getArenaHeight(), setting.getPipeSpace())));
        arena.setGrounds(Arrays.asList(new Ground(2, 2, 0)));

        controller = new PipeController(arena);
    }

    @Test
    void stopped() {
        Mockito.when(game.hasStarted()).thenReturn(true);

        List<Pipe> pipes = arena.getPipes();
        List<Position> pos1 = new ArrayList<>();
        for (Pipe p : pipes) {
            pos1.add(p.getPosition());
        }

        controller.step(game, action, time);

        pipes = arena.getPipes();
        List<Position> pos2 = new ArrayList<>();
        for (Pipe p : pipes) {
            pos2.add(p.getPosition());
        }

        Assertions.assertEquals(pos1, pos2);
    }

    @Test
    void moving() {
        Mockito.when(game.hasStarted()).thenReturn(false);

        List<Position> pos = new ArrayList<>();
        for (Pipe p : arena.getPipes()) {
            pos.add(p.getPosition());
        }

        controller.step(game, action, time);

        Assertions.assertFalse(arena.getBird().getHit());

        for (int i = 0; i < arena.getPipes().size(); i++) {
            Position position = arena.getPipes().get(i).getPosition();
            Assertions.assertTrue(position.equals(new Position(pos.get(i).getX() - 1, pos.get(i).getY())));
        }
    }

    @Test
    void notMoving() {
        Mockito.when(game.hasStarted()).thenReturn(false);
        time = arena.getPipeSpeed();

        List<Position> pos = new ArrayList<>();
        for (Pipe p : arena.getPipes()) {
            pos.add(p.getPosition());
        }

        controller.step(game, action, time);

        for (int i = 0; i < arena.getPipes().size(); i++) {
            Position position = arena.getPipes().get(i).getPosition();
            Assertions.assertTrue(position.equals(pos.get(i)));
        }
    }

    @Test
    void hit() {
        arena.setBird(new Bird(3,5 + setting.getPipeSpace()/2));

        List<Position> pos = new ArrayList<>();
        for (Pipe p : arena.getPipes()) {
            pos.add(p.getPosition());
        }

        controller.step(game, action, time);

        Assertions.assertTrue(arena.getBird().getHit());

        for (int i = 0; i < arena.getPipes().size(); i++) {
            Position position = arena.getPipes().get(i).getPosition();
            Assertions.assertTrue(position.equals(new Position(pos.get(i).getX() - 1, pos.get(i).getY())));
        }
    }

    @Test
    void needPipes() {
        arena.setPipes(Arrays.asList(new Pipe(-5, 5, setting.getArenaHeight(), setting.getPipeSpace()),
                new Pipe(0, 5, setting.getArenaHeight(), setting.getPipeSpace()),
                new Pipe(5, 5, setting.getArenaHeight(), setting.getPipeSpace())));

        Pipe pipe = arena.getPipes().get(2);

        controller.step(game, action, time);

        Assertions.assertEquals(arena.getPipes().get(0), pipe);
    }
}
