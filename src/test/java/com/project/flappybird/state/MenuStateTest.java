package com.project.flappybird.state;

import com.project.flappybird.Game;
import com.project.flappybird.gui.GUI;
import com.project.flappybird.model.Position;
import com.project.flappybird.model.menu.Menu;
import com.project.flappybird.model.menu.MenuInitial;
import com.project.flappybird.model.menu.MenuLevel;
import com.project.flappybird.states.GameState;
import com.project.flappybird.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuStateTest {
    private Game game;
    private GUI gui;
    private long time;


    @BeforeEach
    void setUp() {
        game = Mockito.mock(Game.class);
        gui = Mockito.mock(GUI.class);
        time = System.currentTimeMillis();
    }

    @Test
    void menuLevelStep() throws IOException {
        MenuLevel menu = Mockito.mock(MenuLevel.class);
        MenuState menuState = new MenuState(menu);

        Mockito.when(gui.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        Mockito.when(menu.isSelectedEasy()).thenReturn(true);

        menuState.step(game, gui, time);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
        Mockito.verify(menu, Mockito.times(1)).isSelectedEasy();
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(MenuState.class));
    }

    @Test
    void menuInitialStep() throws IOException {
        Menu menu = new MenuInitial();
        MenuState menuState = new MenuState(menu);
        Mockito.when(gui.getNextAction()).thenReturn(GUI.ACTION.SELECT);

        menuState.step(game, gui, time);

        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(4, 5), "Flappy Bird", "#32CD32");
        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(GameState.class));
    }
}
