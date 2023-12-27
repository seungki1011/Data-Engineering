package de.java.referencetype;

public class rf1 {
    public static void main(String[] args) {
        Unit unit1 = createUnit("Marine", 30, 150);
        Unit unit2 = createUnit("Firebat", 50, 250);

        printUnit(unit1);
        printUnit(unit2);
    }

    static Unit createUnit(String name, int attack, int defense) { // return 타입이 Unit
        Unit unit = new Unit();
        unit.name = name;
        unit.attack = attack;
        unit.defense = defense;
        return unit; // 만들어진 인스턴스의 참조값 반환
    }
    static void printUnit(Unit unit){
        System.out.println("Unit name: "+unit.name+"| Attack: "+unit.attack+"| Defense: "+unit.defense);
    }
}
