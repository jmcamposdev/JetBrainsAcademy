package coffeemachine;

public class Machine {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;
    boolean isworking;

    public Machine(int water, int milk, int beans, int cups, int money) {
        if (water < 0)
            throw new IllegalArgumentException("The water can't be negative");
        if (milk < 0)
            throw new IllegalArgumentException("The milk can't be negative");
        if (beans < 0)
            throw new IllegalArgumentException("The beans can't be negative");
        if (cups < 0)
            throw new IllegalArgumentException("The cups can't be negative");
        if (money < 0)
            throw new IllegalArgumentException("The money can't be negative");

        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
        this.isworking = true;
    }

    public boolean isWorking () {
        return this.isworking;
    }

    public boolean getIsWorking() {
        return isworking;
    }

    public void setIsWorking(boolean isWorking) {
        this.isworking = isWorking;
    }

    public int getWater() {
        return water;
    }

    public void addWater(int water) {
        if (water > 0)
            this.water += water;
    }
    public void removeWater(int water) {
        if (water > 0) {
            this.water -= water;
        }
    }

    public int getMilk() {
        return milk;
    }

    public void addMilk(int milk) {
        if (milk > 0)
            this.milk += milk;
    }
    public void removeMilk(int milk) {
        if (milk > 0) {
            this.milk -= milk;
        }
    }

    public int getBeans() {
        return beans;
    }

    public void addBeans(int beans) {
        if (beans > 0)
            this.beans += beans;
    }
    public void removeBeans(int beans) {
        if (beans > 0)
            this.beans -= beans;
    }

    public int getCups() {
        return cups;
    }

    public void addCups(int cups) {
        if (cups > 0)
            this.cups += cups;
    }
    public void removeCups(int cups) {
        if (cups > 0)
            this.cups -= cups;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int money) {
        if (money > 0)
            this.money += money;
    }

    public int removeMoney() {
        int currentMoney = this.money;
        this.money = 0;
        return currentMoney;
    }

    @Override
    public String toString() {
        return "The coffee machine has:\n" +
                water + " ml of water\n" +
                milk + " ml of milk\n" +
                beans + " g of coffee beans\n" +
                cups + " disposable cups\n" +
                "$" + money + " of money";
    }
}

