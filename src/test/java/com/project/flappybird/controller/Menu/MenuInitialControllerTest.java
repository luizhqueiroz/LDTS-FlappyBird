package com.project.flappybird.controller.Menu;

import com.project.flappybird.Game;
import com.project.flappybird.controller.menu.MenuInitialController;
import com.project.flappybird.gui.GUI;
import com.project.flappybird.model.menu.MenuInitial;
import com.project.flappybird.states.GameState;
import com.project.flappybird.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MenuInitialControllerTest {
    private MenuInitialController controller;
    private MenuInitial menu;
    private Game game;
    private GUI.ACTION action;
    private long time;

    @BeforeEach
    void setUp() {
        menu = Mockito.mock(MenuInitial.class);
        controller = new MenuInitialController(menu);
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
    void selectExit() {
        action = GUI.ACTION.SELECT;
        Mockito.when(menu.isSelectedExit()).thenReturn(true);

        controller.step(game, action, time);

        Mockito.verify(game,Mockito.times(1)).setState(null);
    }

    @Test
    void selectStart() {
        action = GUI.ACTION.SELECT;
        Mockito.when(menu.isSelectedStart()).thenReturn(true);
        Mockito.when(menu.getGameLevel()).thenReturn("Easy");

        controller.step(game, action, time);

        Mockito.verify(game,Mockito.times(1)).setState(Mockito.any(GameState.class));
    }

    @Test
    void selectLevel() {
        action = GUI.ACTION.SELECT;
        Mockito.when(menu.isSelectedLevel()).thenReturn(true);
        controller.step(game, action, time);

        Mockito.verify(game,Mockito.times(1)).setState(Mockito.any(MenuState.class));
    }

}
