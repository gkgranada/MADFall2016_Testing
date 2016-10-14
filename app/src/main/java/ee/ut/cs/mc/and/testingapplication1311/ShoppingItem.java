package ee.ut.cs.mc.and.testingapplication1311;

import java.util.Random;

public class ShoppingItem {

    String name;
    int price;
    int amount;

    public ShoppingItem(String name, int amount) {
        this.name = name;
        this.price = 5;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("%s price:%s amount%s", name, price, amount);
    }
}
