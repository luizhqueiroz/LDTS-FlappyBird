package com.project.flappybird.viewer.Menu;

import com.project.flappybird.gui.GUI;
import com.project.flappybird.model.Position;
import com.project.flappybird.model.menu.Menu;
import com.project.flappybird.model.menu.MenuInitial;
import com.project.flappybird.viewer.menu.MenuInitialViewer;
import com.project.flappybird.viewer.menu.MenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuInitialViewerTest {
    private GUI gui;
    private MenuViewer viewer;
    private Menu menuInitial;

    @BeforeEach
    void setUp() {
        menuInitial = new MenuInitial();
        gui = Mockito.mock(GUI.class);
        viewer = new MenuInitialViewer(menuInitial);
    }

    @Test
    void draw() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawBackground(Mockito.any(String.class),Mockito.any(int.class), Mockito.any(int.class));
        Mockito.verify(gui, Mockito.times(menuInitial.getNumberEntries() + 1)).drawText(Mockito.any(Position.class), Mockito.any(String.class), Mockito.any(String.class));
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}
