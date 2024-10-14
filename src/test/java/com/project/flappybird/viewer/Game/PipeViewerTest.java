package com.project.flappybird.viewer.Game;

import com.project.flappybird.gui.GUI;
import com.project.flappybird.model.Position;
import com.project.flappybird.model.Setting;
import com.project.flappybird.model.game.elements.Pipe;
import com.project.flappybird.viewer.game.PipeViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class PipeViewerTest {
    private Pipe pipe;
    private PipeViewer viewer;
    private GUI gui;
    private Setting setting;

    @BeforeEach
    void setUp() {
        setting = new Setting("easy");
        pipe = new Pipe(6, 4, setting.getArenaHeight(), setting.getPipeSpace());
        viewer = new PipeViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        int n = pipe.getUp().size() + pipe.getDown().size();
        viewer.draw(pipe, gui);
        Mockito.verify(gui, Mockito.times(n)).drawPipe(Mockito.any(Position.class));
    }
}
