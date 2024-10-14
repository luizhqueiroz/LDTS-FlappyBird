package com.project.flappybird.model.Menu;

import com.project.flappybird.model.menu.MenuLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenuLevelTest {
    private MenuLevel menu;

    @BeforeEach
    void setUp() {
        menu = new MenuLevel();
    }

    @Test
    void isSelectedEasy() {
        Assertions.assertTrue(menu.isSelectedEasy());

        menu.nextEntry();

        Assertions.assertFalse(menu.isSelectedEasy());
    }

    @Test
    void isSelectedMedium() {
        Assertions.assertFalse(menu.isSelectedMedium());

        menu.nextEntry();

        Assertions.assertTrue(menu.isSelectedMedium());
    }

    @Test
    void isSelectedHard() {
        Assertions.assertFalse(menu.isSelectedHard());

        menu.previousEntry();

        Assertions.assertTrue(menu.isSelectedHard());
    }

    @Test
    void menuLevel() {
        Assertions.assertEquals(menu.getNumberEntries(), 3);
        Assertions.assertEquals(menu.getEntry(0), "Easy");
        Assertions.assertEquals(menu.getEntry(1), "Medium");
        Assertions.assertEquals(menu.getEntry(2), "Hard");
    }
}
