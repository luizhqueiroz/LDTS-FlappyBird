package com.project.flappybird.viewer.Game;

import com.project.flappybird.gui.GUI;
import com.project.flappybird.model.Position;
import com.project.flappybird.model.Setting;
import com.project.flappybird.model.game.arena.Arena;
import com.project.flappybird.model.game.elements.Bird;
import com.project.flappybird.model.game.elements.Ground;
import com.project.flappybird.model.game.elements.Pipe;
import com.project.flappybird.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ArenaViewerTest {
    private GUI gui;
    private GameViewer viewer;
    private Arena arena;
    private Setting setting;

    @BeforeEach
    void setUp() {
        setting = new Setting("easy");
        arena = new Arena(setting);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(arena);

        arena.setBird(new Bird(2, 4));
        arena.setGrounds(Arrays.asList(new Ground(5, 5,0), new Ground(3, 6,0)));
        arena.setPipes(Arrays.asList(new Pipe(2, 4, setting.getArenaHeight(), setting.getPipeSpace()), new Pipe(3, 4, setting.getArenaHeight(), setting.getPipeSpace()), new Pipe(4, 4, setting.getArenaHeight(), setting.getPipeSpace())));
    }

    @Test
    void drawBird() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawBird(new Position(2, 4));
        Mockito.verify(gui, Mockito.times(1)).drawBird(Mockito.any(Position.class));
    }

    @Test
    void drawGrounds() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawGround(new Position(5, 5),0);
        Mockito.verify(gui, Mockito.times(1)).drawGround(new Position(3, 6),0);

        Mockito.verify(gui, Mockito.times(2)).drawGround(Mockito.any(Position.class),Mockito.any(int.class));
    }

    @Test
    void drawPipes() throws IOException {
        List<Pipe> pipes =  arena.getPipes();

        int n1 = pipes.get(0).getUp().size() + pipes.get(0).getDown().size();
        int n2 = pipes.get(1).getUp().size() + pipes.get(1).getDown().size();
        int n3 = pipes.get(2).getUp().size() + pipes.get(2).getDown().size();

        viewer.draw(gui);
        for (Position pos : pipes.get(0).getUp())
            Mockito.verify(gui, Mockito.times(1)).drawPipe(new Position(pos));
        for (Position pos : pipes.get(0).getDown())
            Mockito.verify(gui, Mockito.times(1)).drawPipe(new Position(pos));

        for (Position pos : pipes.get(1).getUp())
            Mockito.verify(gui, Mockito.times(1)).drawPipe(new Position(pos));
        for (Position pos : pipes.get(1).getDown())
            Mockito.verify(gui, Mockito.times(1)).drawPipe(new Position(pos));

        for (Position pos : pipes.get(2).getUp())
            Mockito.verify(gui, Mockito.times(1)).drawPipe(new Position(pos));
        for (Position pos : pipes.get(2).getDown())
            Mockito.verify(gui, Mockito.times(1)).drawPipe(new Position(pos));

        Mockito.verify(gui, Mockito.times(n1+n2+n3)).drawPipe(Mockito.any(Position.class));
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }

    @Test
    void drawElements() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawBackground("#FFE4B5", arena.getWidth(), arena.getHeight());
        Mockito.verify(gui, Mockito.times(1)).drawBackground("#87CEEB", arena.getWidth(), 9*(arena.getHeight()/10));
        Mockito.verify(gui, Mockito.times(1)).drawBackground("#FFFFFF", arena.getWidth(), (2*arena.getHeight()/10));
        Mockito.verify(gui, Mockito.times(1)).drawBackground("#000000", arena.getWidth(), 1);
        Mockito.verify(gui, Mockito.times(4)).drawBackground(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt());

        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(0, 0),
                "Score: " + arena.getScore() + " " + " Best: " + arena.getBest(),
                "#E0FFFF");
    }

}
