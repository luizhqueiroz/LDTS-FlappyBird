package com.project.flappybird.model.game.elements;

import com.project.flappybird.model.Position;

import java.util.ArrayList;
import java.util.List;

public class Pipe extends Element {
    private final List<Position> up = new ArrayList<>();
    private final List<Position> down = new ArrayList<>();
    private final int height;
    private final int space;
    private boolean passed;

    public Pipe(int x, int y, int height, int space) {
        super(x, y);
        this.height = height;
        this.space = space;
        this.passed = false;
        createPipeParts();
    }

    public List<Position> getUp() {
        return up;
    }

    public List<Position> getDown() {
        return down;
    }

    private void createPipeParts() {
        for (int y = 0; y < 8 * (height / 10); y++) {

            if (y < super.getPosition().getY() - space/2){
                up.add(new Position(super.getPosition().getX(), y));
            }

            if (y > super.getPosition().getY() + space/2){
                down.add(new Position(super.getPosition().getX(),y));
            }
        }
    }

    public boolean getPass() {
        return this.passed;
    }

    public void setPass(boolean passed) {
        this.passed = passed;
    }

    public void move(Position position) {
        super.setPosition(position);
        up.clear();
        down.clear();
        createPipeParts();
    }

    public boolean canHit(Position position) {

        if (position.getRight().getX() == super.getPosition().getX()) {
            if (position.getY() <= super.getPosition().getY() - space/2) return true;
            if (position.getY() >= super.getPosition().getY() + space/2) return true;
        }

        if (position.getX() == super.getPosition().getX()) {
            if (position.getUp().getY() < super.getPosition().getY() - space/2) return true;
            if (position.getDown().getY() > super.getPosition().getY() + space/2) return true;
        }
        return false;
    }

}
