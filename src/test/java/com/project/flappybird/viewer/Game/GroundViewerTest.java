package com.project.flappybird.viewer.Game;

import com.project.flappybird.gui.GUI;
import com.project.flappybird.model.game.elements.Ground;
import com.project.flappybird.viewer.game.GroundViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GroundViewerTest {
    private Ground ground;
    private GroundViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        ground = new Ground(6, 4,0);
        viewer = new GroundViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(ground, gui);
        Mockito.verify(gui, Mockito.times(1)).drawGround(ground.getPosition(), ground.getSymbolType());
    }
}
