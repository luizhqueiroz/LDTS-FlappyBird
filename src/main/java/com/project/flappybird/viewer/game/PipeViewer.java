package com.project.flappybird.viewer.game;

import com.project.flappybird.gui.GUI;
import com.project.flappybird.model.Position;
import com.project.flappybird.model.game.elements.Pipe;

public class PipeViewer implements ElementViewer<Pipe> {
    @Override
    public void draw(Pipe pipe, GUI gui) {
        for (Position position : pipe.getUp() ) {
            gui.drawPipe(position);
        }

        for (Position position : pipe.getDown()) {
            gui.drawPipe(position);
        }
    }
}
