package com.project.flappybird.viewer.Game;

import com.project.flappybird.gui.GUI;
import com.project.flappybird.model.game.elements.Bird;
import com.project.flappybird.viewer.game.BirdViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BirdViewerTest {
    private Bird bird;
    private BirdViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        bird = new Bird(6, 4);
        viewer = new BirdViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(bird, gui);
        Mockito.verify(gui, Mockito.times(1)).drawBird(bird.getPosition());
    }
}
