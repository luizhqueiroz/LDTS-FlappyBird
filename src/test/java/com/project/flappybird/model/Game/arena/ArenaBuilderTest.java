package com.project.flappybird.model.Game.arena;

import com.project.flappybird.model.game.arena.Arena;
import com.project.flappybird.model.game.arena.ArenaBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArenaBuilderTest {
    private ArenaBuilder arenaBuilder;

    @BeforeEach
    void setUp() {
        arenaBuilder = new ArenaBuilder("Easy");
    }

    @Test
    void createArena() {
        Arena arena = arenaBuilder.createArena(10);

        Assertions.assertTrue(arena.getBest() == 10);
        Assertions.assertTrue(arena.getLevel() == "Easy");
        Assertions.assertTrue(arena.getScore() == 0);
        Assertions.assertTrue(arena.getBird() != null);
        Assertions.assertTrue(!arena.getPipes().isEmpty());
        Assertions.assertTrue(!arena.getGrounds().isEmpty());
    }

}
