package businesses;

import persons.Person;
import products.Clothes;
import products.Food;
import products.Manufacturable;
import util.Pair;

import java.util.ArrayList;
import java.util.List;

import static util.Range.range;

/**
 * Бренд Akhmadullina
 * @author vadim
 */
public final class AkhmadullinaDreams extends Business<Clothes>{

    {
        types.add(new Pair<>(IndustryType.FASHION, 1));
    }

    /**
     * Главным занятием модельного агенства считаем показ мод
     */
    @Override
    public void mainActivity() {
        System.out.println("Начался показ мод");
        List<Person> visitors = new ArrayList<>();
        for (Integer n: range(5)) {
            Person visitor = new Person(20, 1.0) {
                @Override
                public void watch(Manufacturable item) {

                }

                @Override
                public void watch(Person somebody) {
                    System.out.print("Зритель видет обворожительную модель");

                }

                @Override
                public void join(Business<?> business) {

                }

                @Override
                public void eat(Food food) {

                }
            };
            visitors.add(visitor);
        }
    }

    /**
     * Метод, отвечающий за празднование годовщины бренда
     * @param business место, где будет проводиться праздник
     */
    public void celebrateAnn(Business<?> business){
        System.out.println(this.getClass().getSimpleName() + " празднует свою годовщину в " + business.getClass().getSimpleName());
        mainActivity();
    }

    public class Model extends Person{
        Clothes clothes;

        public Model(Clothes clothes) {
            super(40, 0.7);
            this.clothes = clothes;
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
    }

}

