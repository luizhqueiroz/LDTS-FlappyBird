package com.project.flappybird.model.game.elements;

public class Ground extends Element {
    int symbolType;
    public Ground(int x, int y, int symbolType){
        super(x,y);
        this.symbolType = symbolType;
    }

    public int getSymbolType() {
        return symbolType;
    }
}
