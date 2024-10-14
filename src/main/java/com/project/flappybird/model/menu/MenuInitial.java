package com.project.flappybird.model.menu;

import java.util.Arrays;

public class MenuInitial extends Menu {
    private final String gameLevel;
    public MenuInitial() {
        super(Arrays.asList("Start", "Level", "Exit"));
        this.gameLevel = "Easy";
    }

    public MenuInitial(String level) {
        super(Arrays.asList("Start", "Level", "Exit"));
        this.gameLevel = level;
    }

    public boolean isSelectedExit() {
        return super.isSelected(2);
    }

    public boolean isSelectedLevel() {
        return super.isSelected(1);
    }

    public boolean isSelectedStart() {
        return super.isSelected(0);
    }

    public String getGameLevel() {
        return gameLevel;
    }

}
