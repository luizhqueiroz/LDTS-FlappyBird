package com.project.flappybird.controller.menu;

import com.project.flappybird.Game;
import com.project.flappybird.gui.GUI;
import com.project.flappybird.model.game.arena.ArenaBuilder;
import com.project.flappybird.model.menu.Menu;
import com.project.flappybird.model.menu.MenuInitial;
import com.project.flappybird.model.menu.MenuLevel;
import com.project.flappybird.states.GameState;
import com.project.flappybird.states.MenuState;

public class MenuInitialController extends MenuController {

    public MenuInitialController(Menu menu) {
        super(menu);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        switch (action) {
            case UP -> getModel().previousEntry();
            case DOWN -> getModel().nextEntry();
            case SELECT -> {
                MenuInitial menu = (MenuInitial) getModel();

                if (menu.isSelectedExit()) game.setState(null);

                if (menu.isSelectedStart()) {
                    game.setState(new GameState(new ArenaBuilder(menu.getGameLevel()).createArena(0)));
                }

                if (menu.isSelectedLevel()) game.setState(new MenuState(new MenuLevel()));
            }
        }
    }
}
