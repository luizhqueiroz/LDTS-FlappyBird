package com.project.flappybird.model.game.arena;

import com.project.flappybird.model.Setting;
import com.project.flappybird.model.game.elements.Bird;
import com.project.flappybird.model.game.elements.Ground;
import com.project.flappybird.model.game.elements.Pipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArenaBuilder {
    private final Setting gameSetting;
    private final Random rng;

    public ArenaBuilder(String level) {
        this.gameSetting = new Setting(level);
        this.rng = new Random();
    }
    public Arena createArena(int best) {
        Arena arena = new Arena(gameSetting);

        arena.setBird(createBird());
        arena.setPipes(createPipes());
        arena.setGrounds(createGround());
        arena.setBest(best);

        return arena;
    }

    private List<Pipe> createPipes() {
        List<Pipe> pipes = new ArrayList<>();
        int distance = 15;

        for (int i = 0; i < 3; i++) {

            pipes.add(new Pipe(gameSetting.getArenaWidth() + distance, rng.nextInt(gameSetting.getArenaHeight()/3) + gameSetting.getPipeSpace()/2 +1, gameSetting.getArenaHeight(), gameSetting.getPipeSpace()));
            distance += 10;
        }
        return pipes;
    }

    public List<Pipe> createNewPipes(int x) {
        List<Pipe> pipes = new ArrayList<>();
        int distance = x;

        for (int i = 0; i < 3; i++) {

            pipes.add(new Pipe(distance, rng.nextInt(gameSetting.getArenaHeight()/3) + gameSetting.getPipeSpace()/2 +1, gameSetting.getArenaHeight(), gameSetting.getPipeSpace()));
            distance += 10;
        }
        return pipes;
    }

    public List<Ground> createGround() {
        List<Ground> grounds = new ArrayList<>();

        for (int x = 0; x < 2* gameSetting.getArenaWidth(); x++){
            if (x % 2 == 0){
            grounds.add(new Ground(x,8*(gameSetting.getArenaHeight()/10), 0));
            }
            else {
                grounds.add(new Ground(x,8*(gameSetting.getArenaHeight()/10), 1));
            }
        }

        return grounds;
    }

    private Bird createBird() {
        return new Bird(gameSetting.getArenaWidth()/3, gameSetting.getArenaHeight()/3);
    }
}
