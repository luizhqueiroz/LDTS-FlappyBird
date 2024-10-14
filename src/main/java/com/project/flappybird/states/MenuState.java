package com.project.flappybird.states;

import com.project.flappybird.controller.Controller;
import com.project.flappybird.controller.menu.MenuInitialController;
import com.project.flappybird.controller.menu.MenuLevelController;
import com.project.flappybird.model.menu.Menu;
import com.project.flappybird.model.menu.MenuInitial;
import com.project.flappybird.viewer.Viewer;
import com.project.flappybird.viewer.menu.MenuInitialViewer;
import com.project.flappybird.viewer.menu.MenuLevelViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        if (getModel().getClass() == MenuInitial.class )  return new MenuInitialViewer(getModel());
        else return new MenuLevelViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        if (getModel().getClass() == MenuInitial.class )  return new MenuInitialController(getModel());
        else return new MenuLevelController(getModel());
    }

}
