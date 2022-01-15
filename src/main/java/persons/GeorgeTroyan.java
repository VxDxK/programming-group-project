package persons;

import businesses.Business;
import businesses.BusinessFoundFailException;
import businesses.Businessman;
import products.Food;

public final class GeorgeTroyan implements Businessman {
    public Business<?> business;

    @Override
    public void found(Business<?> business) throws BusinessFoundFailException {
        this.business = business;
    }

    @Override
    public Business<?> getBusiness() {
        return business;
    }
}
