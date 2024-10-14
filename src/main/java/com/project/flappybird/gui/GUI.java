package com.project.flappybird.gui;

import com.project.flappybird.model.Position;

import java.io.IOException;

public interface GUI {

    ACTION getNextAction() throws IOException;

    void drawBird(Position position);

    void drawPipe(Position position);

    void drawGround(Position position, int symbolType);

    void drawText(Position position, String text, String color);

    void drawBackground(String color, int width, int height);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION { UP, DOWN, NONE, QUIT, SELECT}
}
