package de.java.oop;

public class oop1 {
    public static void main(String[] args) {
        ControllerData controllerData = new ControllerData();
        System.out.println("Current value = "+controllerData.value);
        controllerData.increase();
        controllerData.increase();
        controllerData.increase();
        System.out.println("Current value = "+controllerData.value);
    }
}
