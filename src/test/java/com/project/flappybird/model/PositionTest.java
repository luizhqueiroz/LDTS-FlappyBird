package com.project.flappybird.model;

import com.project.flappybird.model.game.elements.Bird;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PositionTest {

    private Position position;

    @BeforeEach
    void setUp() {
        position = new Position(2, 4);
    }

    @Test
    void up() {
        position = position.getUp();

        Assertions.assertEquals(2, position.getX());
        Assertions.assertEquals(3, position.getY());
    }

    @Test
    void down() {
        position = position.getDown();

        Assertions.assertEquals(2, position.getX());
        Assertions.assertEquals(5, position.getY());

    }

    @Test
    void left() {
        position = position.getLeft();

        Assertions.assertEquals(1, position.getX());
        Assertions.assertEquals(4, position.getY());

    }

    @Test
    void right() {
        position = position.getRight();

        Assertions.assertEquals(3, position.getX());
        Assertions.assertEquals(4, position.getY());
    }

    @Test
    void equals() {
        Position newPosition1 = new Position(position);
        Position newPosition2 = new Position(4, 2);
        Bird bird = new Bird(2,4);


        Assertions.assertTrue(position.equals(newPosition1));
        Assertions.assertTrue(position.equals(position));
        Assertions.assertFalse(position.equals(newPosition2));
        Assertions.assertFalse(position.equals(bird));
    }

    @Test
    void hash() {
        Position pos1 = new Position(2,4);
        Position pos2 = new Position(1,3);
        int hash1 = position.hashCode();
        int hash2 = pos1.hashCode();
        int hash3 = pos2.hashCode();

        Assertions.assertEquals(hash1, hash2);
        Assertions.assertNotEquals(hash1, hash3);
    }

}
