package businesses;

import persons.Person;
import products.Clothes;
import products.Manufacturable;
import util.Pair;

/**
 * Бренд Akhmadullina
 * @author vadim
 */
public class AkhmadullinaDreams extends Business<Clothes>{

    {
        types.add(new Pair<>(IndustryType.FASHION, 1));
    }

    /**
     * Главным занятием модельного агенства считаем показ мод
     */
    @Override
    public void mainActivity() {
        System.out.println("Начался показ мод");
    }

    /**
     * Метод, отвечающий за празднование годовщины бренда
     * @param business место, где будет проводиться праздник
     */
    public void celebrateAnn(Business<?> business){
        System.out.println(this.getClass().getSimpleName() + " празднует свою годовщину в " + business.getClass().getSimpleName());
        mainActivity();
    }

}
