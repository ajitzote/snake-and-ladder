package com.ajit.snakeladder.model;

public class Board {
    private int size;
    private int start;
    private int end;

    public int getSize() {
        return size;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public Board(int size) {
        this.size = size;
        this.start = 1;
        this.end = this.start+size-1;
    }
}
