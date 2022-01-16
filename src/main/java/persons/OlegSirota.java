package persons;

import businesses.Business;
import businesses.BusinessFoundFailException;
import businesses.Businessman;
import products.Food;
import products.Manufacturable;

public final class OlegSirota extends Person implements Businessman {
    public Business<?> business;
    public OlegSirota() {
        super(50, 0.8);
    }

    @Override
    public void watch(Manufacturable item) {
        System.out.println("Олег сирота посмотрел на " + item);
    }

    @Override
    public void watch(Person somebody) {
        System.out.println("Олег сирота залюбовался " + somebody);
    }

    @Override
    public void join(Business<?> business) {
        System.out.println("Пришел в " + business);
    }

    @Override
    public void eat(Food food) {
        System.out.println("Олег сирота съел" + food);
    }

    @Override
    public void found(Business<?> business) throws BusinessFoundFailException {
        this.business = business;
    }

    @Override
    public Business<?> getBusiness() {
        return business;
    }
}
