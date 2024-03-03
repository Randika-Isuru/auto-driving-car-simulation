package org.example.model;

public class Car {
    private String name;
    private int x;
    private int y;
    private char orientation;
    private String commands;
    private int index;

    public Car(String name, int x, int y, char orientation, String commands) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.commands = commands;
        this.index = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getOrientation() {
        return orientation;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
