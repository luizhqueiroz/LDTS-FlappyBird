package com.project.flappybird.viewer.menu;

import com.project.flappybird.gui.GUI;
import com.project.flappybird.model.Position;
import com.project.flappybird.model.menu.Menu;

public class MenuLevelViewer extends MenuViewer {

    public MenuLevelViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawBackground("#87CEEB", 20, 21);
        gui.drawText(new Position(7, 5), "LEVEL", "#FFFF00");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(7, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#DC143C" : "#FFFF00");
    }
}
