package com.project.flappybird.controller.Game;

import com.project.flappybird.Game;
import com.project.flappybird.controller.game.BirdController;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BirdControllerTest {
    private BirdController controller;
    private Bird bird;
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
        bird = new Bird(8, 8);

        arena.setBird(bird);
        arena.setPipes(Arrays.asList(new Pipe(5, 5, setting.getArenaHeight(), setting.getPipeSpace())));
        arena.setGrounds(Arrays.asList(new Ground(2, 2, 0)));

        controller = new BirdController(arena);

    }

    /*@Test
    void moveBirdUp() {
        controller.moveBirdUp();
        assertEquals(new Position(8, 6), bird.getPosition());
    }

    @Test
    void moveBirdDown() {
        controller.moveBirdDown();
        assertEquals(new Position(8, 9), bird.getPosition());
    }*/

    @Test
    void stepUpStarting() {
        Mockito.when(game.hasStarted()).thenReturn(true);
        arena.setGravity(1);

        controller.step(game,action,time);

        Mockito.verify(game, Mockito.times(1)).notStarted();

        Assertions.assertTrue(arena.getBird().getPosition().equals(new Position(8,5)));
        Assertions.assertEquals(arena.getGravity(),0);
    }

    @Test
    void stepUp() {
        Mockito.when(game.hasStarted()).thenReturn(false);

        controller.step(game,action,time);

        Mockito.verify(game, Mockito.times(0)).notStarted();

        Assertions.assertTrue(arena.getBird().getPosition().equals(new Position(8,5)));
        Assertions.assertEquals(arena.getGravity(),0);
        Assertions.assertEquals(arena.getScore(), 1);
    }

    @Test
    void stepDown() {
        Mockito.when(game.hasStarted()).thenReturn(false);
        action = GUI.ACTION.NONE;

        controller.step(game,action,time);

        Assertions.assertTrue(arena.getBird().getPosition().equals(new Position(8,9)));
        Assertions.assertEquals(arena.getGravity(),1);

        controller.step(game,action,time);

        Assertions.assertEquals(arena.getGravity(),1);
    }

    @Test
    void birdHitPipe() {
        Mockito.when(game.hasStarted()).thenReturn(true);
        bird = new Bird(5,5 - setting.getPipeSpace()/2 + 3);
        arena.setBird(bird);

        controller.step(game,action,time);

        Assertions.assertTrue(bird.getHit());
    }

    @Test
    void birdHitGround() {
        Mockito.when(game.hasStarted()).thenReturn(true);
        bird = new Bird(2,2 + 3);
        arena.setBird(bird);

        controller.step(game,action,time);

        Assertions.assertTrue(bird.getHit());
    }

}
