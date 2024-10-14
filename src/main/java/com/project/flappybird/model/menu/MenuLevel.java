package com.project.flappybird.model.menu;

import java.util.Arrays;

public class MenuLevel extends Menu {

    public MenuLevel() {
        super(Arrays.asList("Easy", "Medium", "Hard"));
    }

    public boolean isSelectedEasy() {
        return super.isSelected(0);
    }

    public boolean isSelectedMedium() {
        return super.isSelected(1);
    }

    public boolean isSelectedHard() {
        return super.isSelected(2);
    }

}
