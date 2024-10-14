package com.project.flappybird.model;

public class Setting {

    private String level;
    private final int arenaWidth, arenaHeight;
    private int pipeSpeed, pipeSpace, gravityLimit;

    public Setting(String level) {
        this.arenaWidth = 20;
        this.arenaHeight = 21;
        chooseLevel(level);
    }

    private void chooseLevel(String level) {
        this.level = level;

        if (level.equals("Easy")) easy();
        if (level.equals("Medium")) medium();
        if (level.equals( "Hard")) hard();
    }

    private void easy() {
        pipeSpeed = 150;
        pipeSpace = arenaHeight/3 + 1;
        gravityLimit = 1;

    }

    private void medium() {
        pipeSpeed = 120;
        pipeSpace = arenaHeight/3;
        gravityLimit = 2;
    }

    private void hard() {
        pipeSpeed = 80;
        pipeSpace = arenaHeight/3;
        gravityLimit = 3;
    }

    public int getPipeSpeed() {
        return pipeSpeed;
    }

    public int getPipeSpace() {
        return pipeSpace;
    }

    public int getGravityLimit() {
        return gravityLimit;
    }

    public int getArenaWidth() {
        return arenaWidth;
    }

    public int getArenaHeight() {
        return arenaHeight;
    }

    public String getLevel() {
        return level;
    }
}
