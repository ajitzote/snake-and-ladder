package com.ajit.snakeladder.model;

public class Player {
    private String name;
    private int position;

    private boolean win;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public Player(String name) {
        this.name = name;
        this.position = 0;
        this.win = false;
    }
}
