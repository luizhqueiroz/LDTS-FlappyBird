package com.project.flappybird.controller.Menu;

import com.project.flappybird.Game;
import com.project.flappybird.controller.menu.MenuInitialController;
import com.project.flappybird.controller.menu.MenuLevelController;
import com.project.flappybird.gui.GUI;
import com.project.flappybird.model.menu.MenuInitial;
import com.project.flappybird.model.menu.MenuLevel;
import com.project.flappybird.states.GameState;
import com.project.flappybird.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MenuLevelControllerTest {
    private MenuLevelController controller;
    private MenuLevel menu;
    private Game game;
    private GUI.ACTION action;
    private long time;

    @BeforeEach
    void setUp() {
        menu = Mockito.mock(MenuLevel.class);
        controller = new MenuLevelController(menu);
        game = Mockito.mock(Game.class);
        time = System.currentTimeMillis();
    }

    @Test
    void up() {
        action = GUI.ACTION.UP;

        controller.step(game, action, time);

        Mockito.verify(menu,Mockito.times(1)).previousEntry();
    }

    @Test
    void down() {
        action = GUI.ACTION.DOWN;

        controller.step(game, action, time);

        Mockito.verify(menu,Mockito.times(1)).nextEntry();
    }

    @Test
    void selectEasy() {
        action = GUI.ACTION.SELECT;
        Mockito.when(menu.isSelectedEasy()).thenReturn(true);

        controller.step(game, action, time);

        Mockito.verify(game,Mockito.times(1)).setState(Mockito.any(MenuState.class));
    }

    @Test
    void selectMedium() {
        action = GUI.ACTION.SELECT;
        Mockito.when(menu.isSelectedMedium()).thenReturn(true);

        controller.step(game, action, time);

        Mockito.verify(game,Mockito.times(1)).setState(Mockito.any(MenuState.class));
    }

    @Test
    void selectHard() {
        action = GUI.ACTION.SELECT;
        Mockito.when(menu.isSelectedHard()).thenReturn(true);
        controller.step(game, action, time);

        Mockito.verify(game,Mockito.times(1)).setState(Mockito.any(MenuState.class));
    }
}
