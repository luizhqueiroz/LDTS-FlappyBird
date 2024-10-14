package com.project.flappybird.viewer.game;

import com.project.flappybird.gui.GUI;
import com.project.flappybird.model.game.elements.Ground;

public class GroundViewer implements ElementViewer<Ground> {
    @Override
    public void draw(Ground ground, GUI gui){
        gui.drawGround(ground.getPosition(), ground.getSymbolType());
    }
}
