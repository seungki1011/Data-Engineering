package de.java.conditional;

public class con3 {
    public static void main(String[] args) {
        int asset = 40000;
        String status = (asset >= 30000) ? " You can buy it!" : " You can't buy it!";
        System.out.println("With your asset " + asset + "$" + status);
    }
}
