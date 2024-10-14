package com.project.flappybird.controller.menu;

import com.project.flappybird.Game;
import com.project.flappybird.gui.GUI;
import com.project.flappybird.model.menu.Menu;
import com.project.flappybird.model.menu.MenuInitial;
import com.project.flappybird.model.menu.MenuLevel;
import com.project.flappybird.states.MenuState;

public class MenuLevelController extends MenuController {

    public MenuLevelController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        switch (action) {
            case UP -> getModel().previousEntry();
            case DOWN -> getModel().nextEntry();
            case SELECT -> {
                MenuLevel m = (MenuLevel) getModel();

                if (m.isSelectedEasy()) {
                    game.setState(new MenuState(new MenuInitial("Easy")));
                }

                if (m.isSelectedMedium()) {
                    game.setState(new MenuState(new MenuInitial("Medium")));
                }

                if (m.isSelectedHard()) {
                    game.setState(new MenuState(new MenuInitial("Hard")));
                }
            }
        }
    }
}
