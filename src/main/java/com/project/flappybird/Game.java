package com.project.flappybird;

import com.project.flappybird.gui.LanternaGUI;
import com.project.flappybird.model.menu.MenuInitial;
import com.project.flappybird.states.MenuState;
import com.project.flappybird.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {

    private final LanternaGUI gui;
    private State state;
    private boolean start;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(20, 20);
        this.state = new MenuState(new MenuInitial());
        this.start = true;
    }

    public void setState(State state) {
        this.state = state;
        this.start = true;
    }

    public boolean hasStarted() {
        return this.start;
    }

    public void notStarted() {
        this.start = false;
    }

    private void start() throws IOException, InterruptedException {
        int FPS = 10;
        int frameTime = 1200 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;


            if (sleepTime > 0) Thread.sleep(sleepTime);
        }

        gui.close();
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException, InterruptedException {
        new Game().start();
    }
}
