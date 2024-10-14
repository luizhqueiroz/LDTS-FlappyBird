package com.project.flappybird.viewer.game;

import com.project.flappybird.gui.GUI;
import com.project.flappybird.model.Position;
import com.project.flappybird.model.game.arena.Arena;
import com.project.flappybird.model.game.elements.Element;
import com.project.flappybird.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawBackground("#FFE4B5", getModel().getWidth(), getModel().getHeight());
        gui.drawBackground("#87CEEB", getModel().getWidth(), 9*(getModel().getHeight()/10));
        gui.drawBackground("#FFFFFF", getModel().getWidth(), (2*getModel().getHeight()/10));
        gui.drawBackground("#000000", getModel().getWidth(), 1);
        gui.drawText(
                new Position(0, 0),
                "Score: " + getModel().getScore() + " " + " Best: " + getModel().getBest(),
                "#E0FFFF");

        drawElement(gui, getModel().getBird(), new BirdViewer());
        drawElements(gui, getModel().getPipes(), new PipeViewer());
        drawElements(gui, getModel().getGrounds(), new GroundViewer());
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
