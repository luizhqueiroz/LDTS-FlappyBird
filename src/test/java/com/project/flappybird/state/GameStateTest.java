package com.project.flappybird.state;

import com.project.flappybird.Game;
import com.project.flappybird.gui.GUI;
import com.project.flappybird.model.game.arena.Arena;
import com.project.flappybird.model.game.arena.ArenaBuilder;
import com.project.flappybird.states.GameState;
import com.project.flappybird.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class GameStateTest {
    private GameState arenaState;
    private Game game;
    private GUI gui;
    private long time;


    @BeforeEach
    void setUp() {
        game = Mockito.mock(Game.class);
        gui = Mockito.mock(GUI.class);
        time = System.currentTimeMillis();
        Arena arena = new ArenaBuilder("Easy").createArena(0);
        arenaState = new GameState(arena);
    }

    @Test
    void step() throws IOException {
        Mockito.when(gui.getNextAction()).thenReturn(GUI.ACTION.QUIT);

        arenaState.step(game, gui, time);

        Mockito.verify(gui,Mockito.times(1)).clear();
        Mockito.verify(gui,Mockito.times(1)).refresh();
        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(MenuState.class));
    }
}
