package de.generic.test2;

import java.util.ArrayList;

public class Shuttle <T extends BioUnit>{

    ArrayList<T> shuttleUnits = new ArrayList<>();

    public void in(T unit) {
        shuttleUnits.add(unit);
    }

    public void drop() {
        shuttleUnits.clear();
    }

    public void showInfo() {
        for (T shuttleUnit : shuttleUnits) {
            System.out.println("이름: " + shuttleUnit.getName()
                    + ", HP: " + shuttleUnit.getHp());
        }
    }

}
