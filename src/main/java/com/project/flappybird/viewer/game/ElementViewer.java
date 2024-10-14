package com.project.flappybird.viewer.game;

import com.project.flappybird.gui.GUI;
import com.project.flappybird.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
