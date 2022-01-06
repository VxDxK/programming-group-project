package products;

public abstract class Food implements Manufacturable{
    protected int satiety;
    protected boolean isReady = false;

    public boolean isReady() {
        return isReady;
    }
}
