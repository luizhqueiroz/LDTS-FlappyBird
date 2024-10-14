package com.project.flappybird.model.game.elements;

public class Bird extends Element {
    private boolean hit;
    public Bird(int x, int y) {
        super(x, y);
        this.hit = false;
    }

    public boolean getHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

}
