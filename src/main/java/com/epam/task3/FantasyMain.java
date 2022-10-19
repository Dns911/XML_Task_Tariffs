package com.epam.task3;

import com.epam.task3.entity.GroupType;

public class FantasyMain {
    public static void main(String[] args) {
        Elf elf1 = new Elf(10, 4);
        Elf elf2 = new Elf(12, 4);
        Elf elf3 = new Elf(13, 4);
        Elf elf4 = new Elf(14, 4);
        Elf elf5 = new Elf(15, 4);
        Elf elf6 = new Elf(16, 4);
        Elf elf7 = new Elf(17, 4);
        Dwarf dwarf1 = new Dwarf(20, 8);
        Dwarf dwarf2 = new Dwarf(21, 8);
        Dwarf dwarf3 = new Dwarf(22, 8);
        Dwarf dwarf4 = new Dwarf(23, 8);
        Dwarf dwarf5 = new Dwarf(24, 8);
        Dwarf dwarf6 = new Dwarf(25, 8);
        UnitComposite tribes = new UnitComposite();
        tribes.setType(GroupType.COMMON_UNIT);
        UnitComposite elfGroup = new UnitComposite();
        elfGroup.setType(GroupType.LIGHT_E);
        UnitComposite dwarfGroup = new UnitComposite();
        dwarfGroup.setType(GroupType.DUNGEON_D);
        tribes.add(elfGroup);
        tribes.add(dwarfGroup);
        elfGroup.add(elf1);
        elfGroup.add(elf2);
        elfGroup.add(elf3);
        dwarfGroup.add(dwarf1);
        dwarfGroup.add(dwarf2);
        dwarfGroup.add(dwarf3);
        dwarfGroup.add(dwarf4);

//        System.out.println(tribes.count());
        System.out.println(tribes);
//        System.out.println(elfGroup.attack());
//        System.out.println(dwarfGroup.attack());
        tribes.add(elf4);
        System.out.println(tribes);
//        System.out.println(elfGroup.attack());
//        System.out.println(dwarfGroup.attack());
    }
}
