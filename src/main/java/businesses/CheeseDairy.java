package businesses;

import products.Cheese;
import products.Manufacturable;
import util.Pair;

import java.util.List;

/**
 * Сыроварня на Истре
 * @author vadim
 */
public class CheeseDairy extends Business<Cheese> {

    {
        types.add(new Pair<>(IndustryType.FOOD, 3));
    }

    @Override
    public void mainActivity() {

    }

    @Override
    public void addProduct(Cheese item) {
        super.addProduct(item);
    }

    @Override
    public List<Cheese> getAllProducts() {
        return super.getAllProducts();
    }
}
