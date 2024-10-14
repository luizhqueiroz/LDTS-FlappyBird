package com.project.flappybird.model.Game.elements;

import com.project.flappybird.model.game.elements.Bird;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BirdTest {
    private Bird bird;

    @BeforeEach
    void setUp() {
        bird = new Bird(2,3);
    }

    @Test
    void hit() {
        bird.setHit(true);

        Assertions.assertTrue(bird.getHit());
    }
}
