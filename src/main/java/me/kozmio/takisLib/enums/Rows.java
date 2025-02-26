package me.kozmio.takisLib.enums;

public enum Rows {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private final int size;
    Rows(int rows){
        this.size = rows * 9;
    }
    public int getSize() {
        return size;
    }
}