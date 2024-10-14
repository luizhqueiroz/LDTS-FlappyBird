package com.project.flappybird.viewer.game;

import com.project.flappybird.gui.GUI;
import com.project.flappybird.model.game.elements.Bird;

public class BirdViewer implements ElementViewer<Bird> {
    @Override
    public void draw(Bird bird, GUI gui) {
        gui.drawBird(bird.getPosition());
    }
}
