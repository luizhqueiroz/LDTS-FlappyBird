package com.project.flappybird.viewer.menu;

import com.project.flappybird.gui.GUI;
import com.project.flappybird.model.Position;
import com.project.flappybird.model.menu.Menu;
import com.project.flappybird.viewer.Viewer;

public abstract class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

}
