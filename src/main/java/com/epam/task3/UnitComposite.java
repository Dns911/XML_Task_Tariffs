package com.epam.task3;

import com.epam.task3.entity.GroupType;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class UnitComposite implements UnitComponent{
    private GroupType type;
    private List<UnitComponent> unitComponents = new ArrayList<>();

    public void add(UnitComponent unit){
        unitComponents.add(unit);
    }

    public boolean remove(UnitComponent o) {
        return unitComponents.remove(o);
    }

    public void setType(GroupType type) {
        this.type = type;
    }

    @Override
    public int count() {
        int counter = 0;
        for (UnitComponent unit:
             unitComponents) {
            counter += unit.count();
        }
        return counter;
    }

    @Override
    public int attack() {
        int fullPower = 0;
        for (UnitComponent unit:
                unitComponents) {
            fullPower += unit.attack();
        }
        return fullPower;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ",  "[", "]")
                .add(type + "=" + unitComponents)
                .toString();
    }
}
