package com.project.flappybird.gui;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.project.flappybird.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);

        gui = new LanternaGUI(screen);
    }


    @Test
    void drawBird() {
        gui.drawBird(new Position(5, 5));

        Mockito.verify(screen, Mockito.times(1)).newTextGraphics();
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 215, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(5, 6, "B");
    }
    @Test
    void drawPipe() {
        gui.drawPipe(new Position(5, 5));

        Mockito.verify(screen, Mockito.times(1)).newTextGraphics();
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(50, 205, 50));
        Mockito.verify(tg, Mockito.times(1)).putString(5, 6, "#");
    }
    @Test
    void drawGround() {
        gui.drawGround(new Position(5, 5),0);

        Mockito.verify(screen, Mockito.times(1)).newTextGraphics();
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(0, 255, 127));
        Mockito.verify(tg, Mockito.times(1)).putString(5, 6, "^");

        gui.drawGround(new Position(5, 5),1);

        Mockito.verify(screen, Mockito.times(2)).newTextGraphics();
        Mockito.verify(tg, Mockito.times(2)).setForegroundColor(new TextColor.RGB(0, 255, 127));
        Mockito.verify(tg, Mockito.times(1)).putString(5, 6, "/");
    }

    @Test
    void drawText() {
        gui.drawText(new Position(5, 5), "String", "#FF0000");

        Mockito.verify(screen, Mockito.times(1)).newTextGraphics();
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 0, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(5, 5, "String");
    }

    @Test
    void drawBackground(){
        gui.drawBackground("#FF0000", 5, 5);

        Mockito.verify(screen, Mockito.times(1)).newTextGraphics();
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(255, 0, 0));
        Mockito.verify(tg,Mockito.times(1)).fillRectangle(new TerminalPosition(0,0), new TerminalSize(5,5), ' ');
    }

    @Test
    void clear() {
        gui.clear();

        Mockito.verify(screen, Mockito.times(1)).clear();
    }

    @Test
    void refresh() throws IOException {
        gui.refresh();

        Mockito.verify(screen, Mockito.times(1)).refresh();
    }

    @Test
    void close() throws IOException {
        gui.close();

        Mockito.verify(screen, Mockito.times(1)).close();
    }

    @Test
    void getNextAction() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(null);
        GUI.ACTION action = gui.getNextAction();

        Mockito.verify(screen, Mockito.times(1)).pollInput();
        Assertions.assertEquals(GUI.ACTION.NONE, action);



        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowUp));
        action = gui.getNextAction();

        Mockito.verify(screen, Mockito.times(2)).pollInput();
        Assertions.assertEquals(GUI.ACTION.UP, action);



        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowDown));
        action = gui.getNextAction();

        Mockito.verify(screen, Mockito.times(3)).pollInput();
        Assertions.assertEquals(GUI.ACTION.DOWN, action);



        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.Enter));
        action = gui.getNextAction();

        Mockito.verify(screen, Mockito.times(4)).pollInput();
        Assertions.assertEquals(GUI.ACTION.SELECT, action);



        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowLeft));
        action = gui.getNextAction();

        Mockito.verify(screen, Mockito.times(5)).pollInput();
        Assertions.assertEquals(GUI.ACTION.NONE, action);



        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke('q', false, false));
        action = gui.getNextAction();

        Mockito.verify(screen, Mockito.times(6)).pollInput();
        Assertions.assertEquals(GUI.ACTION.QUIT, action);
    }

}
