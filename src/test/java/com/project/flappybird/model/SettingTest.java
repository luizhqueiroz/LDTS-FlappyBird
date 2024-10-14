package com.project.flappybird.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SettingTest {
    private Setting setting;

    @Test
    void easy() {
        setting = new Setting("Easy");

        Assertions.assertEquals(setting.getLevel(), "Easy");
        Assertions.assertEquals(setting.getPipeSpeed(), 150);
        Assertions.assertEquals(setting.getPipeSpace(), setting.getArenaHeight()/3 + 1);
        Assertions.assertEquals(setting.getGravityLimit(), 1);
    }

    @Test
    void medium() {
        setting = new Setting("Medium");

        Assertions.assertEquals(setting.getLevel(), "Medium");
        Assertions.assertEquals(setting.getPipeSpeed(), 120);
        Assertions.assertEquals(setting.getPipeSpace(), setting.getArenaHeight()/3);
        Assertions.assertEquals(setting.getGravityLimit(), 2);
    }

    @Test
    void Hard() {
        setting = new Setting("Hard");

        Assertions.assertEquals(setting.getLevel(), "Hard");
        Assertions.assertEquals(setting.getPipeSpeed(), 80);
        Assertions.assertEquals(setting.getPipeSpace(), setting.getArenaHeight()/3);
        Assertions.assertEquals(setting.getGravityLimit(), 3);
    }
}
