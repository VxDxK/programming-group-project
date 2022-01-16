package products;

public abstract class Food implements Manufacturable{
    protected int satiety;
    protected boolean isReady = false;

    public int getSatiety() {
        return satiety;
    }

    public boolean isReady() {
        return isReady;
    }
}
