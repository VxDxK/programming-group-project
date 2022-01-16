package persons;

import businesses.Business;
import businesses.BusinessFoundFailException;
import businesses.Businessman;
import products.Cheese;
import products.Food;
import products.Manufacturable;

/**
 * Класс персонажа
 * Олег Сирота
 * Владелец сыроварни
 */
public final class OlegSirota extends Person implements Businessman {
    /**
     * Инициализация бизнеса
     */
    public Business<?> business;

    /**
     * Конструктор суперкласса
     */
    public OlegSirota() {
        super(50, 0.8);
    }

    @Override
    public void watch(Manufacturable item) {

    }

    @Override
    public void watch(Person somebody) {

    }

    @Override
    public void join(Business<?> business) {

    }

    @Override
    public void eat(Food food) {

    }

    @Override
    public void found(Business business) throws BusinessFoundFailException {

    }

    @Override
    public Business<?> getBusiness() {
        return null;
    }
}
