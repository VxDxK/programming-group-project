package businesses;

import products.Food;
import util.Pair;

/**
 * Ресторан Георгия Трояна
 * @author vadim
 */
public class Restaurant extends Business<Food>{

    {
        types.add(new Pair<>(IndustryType.FOOD, 2));
        types.add(new Pair<>(IndustryType.RESTAURANT, 5));
    }

    @Override
    public void mainActivity() {

    }
}
