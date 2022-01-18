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
    private int experience;
    public abstract void watch(Manufacturable item);
    public abstract void watch(Person somebody);
    public abstract void join(Business<?> business);
    public void eat(Food food){
        System.out.println(getClass().getSimpleName() + " отведал вкуснейший " + food.getClass().getSimpleName());
    }

    public Person(int saturation, double saturationCoefficient){
        this.saturation = saturation;
        this.saturationCoefficient = saturationCoefficient;
    }

    public int getExperience() {
        return experience;
    }

    public void addExperience(int experience) {
        this.experience += experience;
        if(this.experience < 0){
            this.experience = 0;
        }
    }
}
