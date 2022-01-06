package persons;

import businesses.Business;
import products.Food;
import products.Manufacturable;

/**
 * Базовый класс человека, от которого наследуются другие люди и персонажи.
 * @author vadim
 */

public abstract class Person {
    protected int saturation;
    protected double saturationCoefficient = 1;
    public int salary;
    public abstract void watch(Manufacturable item);
    public abstract void watch(Person somebody);
    public abstract void join(Business<?> business);
    public abstract void eat(Food food);

    Person(int saturation, double saturationCoefficient){
        this.saturation = saturation;
        this.saturationCoefficient = saturationCoefficient;
    }
}
