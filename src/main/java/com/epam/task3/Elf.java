package com.epam.task3;

import java.util.StringJoiner;

public class Elf implements UnitComponent{
private long id;
private int power;

    public Elf(long id, int power) {
        this.id = id;
        this.power = power;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }


    @Override
    public int count() {
        return 1;
    }

    @Override
    public int attack() {
        return power;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "Elf[", "]")
                .add("id=" + id)
                .add("power=" + power)
                .toString();
    }
}
