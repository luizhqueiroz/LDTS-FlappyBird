package com.project.flappybird.model.Menu;

import com.project.flappybird.model.menu.MenuInitial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenuInitialTest {
    private MenuInitial menu;

    @BeforeEach
    void setUp() {
        menu = new MenuInitial("Easy");
    }

    @Test
    void nextEntry() {
        menu.nextEntry();

        Assertions.assertTrue(menu.isSelected(1));
        Assertions.assertFalse(menu.isSelected(0));
        Assertions.assertFalse(menu.isSelected(2));

        menu.nextEntry();
        menu.nextEntry();

        Assertions.assertTrue(menu.isSelected(0));
        Assertions.assertFalse(menu.isSelected(1));
        Assertions.assertFalse(menu.isSelected(2));
    }

    @Test
    void previousEntry() {
        menu.previousEntry();

        Assertions.assertTrue(menu.isSelected(2));
        Assertions.assertFalse(menu.isSelected(0));
        Assertions.assertFalse(menu.isSelected(1));

        menu.previousEntry();
        menu.previousEntry();

        Assertions.assertTrue(menu.isSelected(0));
        Assertions.assertFalse(menu.isSelected(1));
        Assertions.assertFalse(menu.isSelected(2));
    }

    @Test
    void isSelectedExit() {
        Assertions.assertFalse(menu.isSelectedExit());

        menu.previousEntry();

        Assertions.assertTrue(menu.isSelectedExit());
    }

    @Test
    void isSelectedLevel() {
        Assertions.assertFalse(menu.isSelectedLevel());

        menu.nextEntry();

        Assertions.assertTrue(menu.isSelectedLevel());
    }

    @Test
    void isSelectedStart() {
        Assertions.assertTrue(menu.isSelectedStart());

        menu.nextEntry();

        Assertions.assertFalse(menu.isSelectedStart());
    }

    @Test
    void getGameLevel() {
        Assertions.assertTrue(menu.getGameLevel() == "Easy");
    }

    @Test
    void menuInitial() {
        Assertions.assertEquals(menu.getGameLevel(), "Easy");
        Assertions.assertEquals(menu.getNumberEntries(), 3);
    }
}
