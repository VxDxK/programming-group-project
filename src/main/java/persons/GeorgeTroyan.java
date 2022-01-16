package persons;

import businesses.Business;
import businesses.BusinessFoundFailException;
import businesses.Businessman;
import products.Food;
import products.Manufacturable;


/**
 * Класс персонажа
 * Георгий Троян
 * Владелец ресторана
 * @author maxim
 */
=======
public final class GeorgeTroyan extends Person implements Businessman {
     /**
     * Инициализация бизнеса
     */
    public Business<?> business;

    public GeorgeTroyan(int saturation, double saturationCoefficient) {
        super(saturation, saturationCoefficient);
    }

    @Override
    public void found(Business<?> business) throws BusinessFoundFailException {
        this.business = business;
    }

    @Override
    public Business<?> getBusiness() {
        return business;
    }

    @Override
    public void watch(Manufacturable item) {
        System.out.println("Георгий Троян смотрит на " + item);
    }

    @Override
    public void watch(Person somebody) {
        System.out.println("Георгий Троян смотрит на " + somebody);
    }

    @Override
    public void join(Business<?> business) {
        System.out.println("Георгий Троян пришёл на " + business);
    }

    @Override
    public void eat(Food food) {
        System.out.println("Георгий Троян ест " + food);
    }
}
