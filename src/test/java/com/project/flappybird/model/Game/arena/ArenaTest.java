package com.project.flappybird.model.Game.arena;

import com.project.flappybird.model.Position;
import com.project.flappybird.model.Setting;
import com.project.flappybird.model.game.arena.Arena;
import com.project.flappybird.model.game.elements.Bird;
import com.project.flappybird.model.game.elements.Ground;
import com.project.flappybird.model.game.elements.Pipe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ArenaTest {
    private Arena arena;
    private Setting setting;

    @BeforeEach
    void setUp() {
        setting = new Setting("Easy");
        arena = new Arena(setting);
        arena.setBird(new Bird(2,3));
        arena.setGrounds(Arrays.asList(new Ground(9,20,0)));
        arena.setPipes(Arrays.asList(new Pipe(-5, 4, setting.getArenaHeight(),
                setting.getPipeSpace()), new Pipe(0, 4, setting.getArenaHeight(), setting.getPipeSpace()),
                new Pipe(5,4, setting.getArenaHeight(), setting.getPipeSpace())));
    }

    @Test
    void increaseScore() {
        arena.increaseScore();

        Assertions.assertTrue(arena.getScore() == 1);
    }

    @Test
    void setBest() {
        arena.setBest(10);

        Assertions.assertTrue(arena.getBest() == 10);
    }

    @Test
    void getLevel() {
        Assertions.assertTrue(arena.getLevel() == "Easy");
    }

    @Test
    void getPipeSpeed() {
        Assertions.assertTrue(arena.getPipeSpeed() == setting.getPipeSpeed());
    }

    @Test
    void getGravityLimity() {
        Assertions.assertTrue(arena.getGravityLimit() == setting.getGravityLimit());
    }

    @Test
    void gravity() {
        arena.setGravity(10);

        Assertions.assertTrue(arena.getGravity() == 10);
    }

    @Test
    void verifyPipes() {
        Assertions.assertTrue(arena.needPipes());
        List<Pipe> pipes = arena.getPipes();

        arena.newPipes();

        List<Pipe> newpipes = arena.getPipes();

        Assertions.assertTrue(pipes.get(2) == newpipes.get(0));
        Assertions.assertFalse(arena.needPipes());
    }

    @Test
    void passedPipe() {
        Assertions.assertTrue(arena.passedPipe(arena.getBird().getPosition()));
        Assertions.assertFalse(arena.passedPipe(new Position(-6,4)));
    }

    @Test
    void isEmptyToGround() {
        Assertions.assertFalse(arena.isEmpty(new Position(9,19)));
        Assertions.assertFalse(arena.isEmpty(new Position(9,20)));
        Assertions.assertFalse(arena.isEmpty(new Position(9,21)));
        Assertions.assertTrue(arena.isEmpty(new Position(9,18)));
        Assertions.assertTrue(arena.isEmpty(new Position(8,20)));
        Assertions.assertTrue(arena.isEmpty(new Position(10,20)));
        Assertions.assertTrue(arena.isEmpty(new Position(8,21)));
        Assertions.assertTrue(arena.isEmpty(new Position(10,21)));
        Assertions.assertTrue(arena.isEmpty(new Position(8,19)));
        Assertions.assertTrue(arena.isEmpty(new Position(10,19)));
        Assertions.assertTrue(arena.isEmpty(new Position(8,18)));
        Assertions.assertTrue(arena.isEmpty(new Position(10,18)));
    }

    @Test
    void isEmptyToPipe() {
        Assertions.assertFalse(arena.isEmpty(new Position(5, 4 + setting.getPipeSpace())));
        Assertions.assertFalse(arena.isEmpty(new Position(5, 4 - setting.getPipeSpace())));
        Assertions.assertFalse(arena.isEmpty(new Position(4, 4 + setting.getPipeSpace())));
        Assertions.assertFalse(arena.isEmpty(new Position(4, 4 - setting.getPipeSpace())));
        Assertions.assertTrue(arena.isEmpty(new Position(5, 4)));
        Assertions.assertTrue(arena.isEmpty(new Position(4, 4)));
    }
}
