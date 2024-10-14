package com.project.flappybird.model.Game.elements;

import com.project.flappybird.model.Position;
import com.project.flappybird.model.game.elements.Pipe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PipeTest {
    private Pipe pipe;

    @BeforeEach
    void setUp() {
        pipe = new Pipe(2,5,20,5);
    }

    @Test
    void move() {
        Position pos = new Position(5,6);
        pipe.move(pos);

        Assertions.assertTrue(pipe.getPosition() == pos);

        for (Position up : pipe.getUp()) {
            Assertions.assertTrue(5 == up.getX() && up.getY() < 6);
        }
        for (Position down : pipe.getDown()) {
            Assertions.assertTrue(5 == down.getX() && down.getY() > 6);
        }
    }


}
