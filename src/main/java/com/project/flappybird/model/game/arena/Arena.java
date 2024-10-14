package com.project.flappybird.model.game.arena;

import com.project.flappybird.model.Position;
import com.project.flappybird.model.Setting;
import com.project.flappybird.model.game.elements.Bird;
import com.project.flappybird.model.game.elements.Ground;
import com.project.flappybird.model.game.elements.Pipe;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;
    private final Setting gameSetting;
    private int gravity;
    private int score;
    private int best;
    private Bird bird;
    private List<Pipe> pipes;
    private List<Ground> grounds;

    public Arena(Setting gameSetting) {
        this.gameSetting = gameSetting;
        this.width = gameSetting.getArenaWidth();
        this.height = gameSetting.getArenaHeight();
        this.gravity = 0;
        this.score = 0;
        this.best = 0;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Bird getBird() {
        return bird;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }

    public List<Pipe> getPipes() {
        return pipes;
    }

    public void setPipes(List<Pipe> pipes) {
        this.pipes = pipes;
    }

    public List<Ground> getGrounds() {
        return grounds;
    }

    public void setGrounds(List<Ground> grounds) {
        this.grounds = grounds;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        this.score++;
    }

    public int getBest() {
        return best;
    }

    public void setBest(int best) { this.best = best; }

    public String getLevel() {
        return gameSetting.getLevel();
    }

    public int getPipeSpeed() {
        return gameSetting.getPipeSpeed();
    }

    public int getGravityLimit() {
        return gameSetting.getGravityLimit();
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public boolean isEmpty(Position position) {
        Position pos = new Position(position);

        for (Pipe pipe : pipes)
            if (pipe.canHit(pos)) {

                if (pipe.getPosition().getX() == pos.getX()) {
                    if (pipe.getPosition().getY() > pos.getY()) {
                        pos = new Position(pipe.getPosition().getX(),pipe.getPosition().getY() - gameSetting.getPipeSpace()/2);
                        setBirdEndPosition(pos);
                    }

                    if (pipe.getPosition().getY() < pos.getY()) {
                        pos = new Position(pipe.getPosition().getX(),pipe.getPosition().getY() + gameSetting.getPipeSpace()/2);
                        setBirdEndPosition(pos);
                    }

                }
                else setBirdEndPosition(pos);

                return false;
            }

        pos = pos.getDown();
        for (Ground ground : grounds) {
            if (ground.getPosition().getY() <= pos.getY() && ground.getPosition().getX() == pos.getX()) {
                setBirdEndPosition(ground.getPosition().getUp());

                return false;
            }
        }
        return true;
    }

    private void setBirdEndPosition(Position position){
        bird.setPosition(position);
    }

    public boolean passedPipe(Position position) {
        for (Pipe pipe : pipes) {
            if (pipe.getPosition().getX() <= position.getX()) {
                if(!pipe.getPass()) {
                    pipe.setPass(true);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean needPipes() {
        return pipes.get(1).getPosition().getX() <= 0;
    }

    public void newPipes() {
        Pipe pipe = pipes.get(2);
        pipes = new ArenaBuilder(this.getLevel()).createNewPipes(pipe.getPosition().getX());
        pipes.set(0,pipe);
    }
}
