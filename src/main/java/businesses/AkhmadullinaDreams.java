package businesses;

import persons.Person;
import products.Clothes;
import products.Food;
import products.Manufacturable;
import util.Pair;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;
import static util.Range.range;

/**
 * Бренд Akhmadullina
 * @author vadim
 */
public final class AkhmadullinaDreams extends Business<Clothes>{
    private int countOfVisitors;
    private int countOfModels;
    {
        types.add(new Pair<>(IndustryType.FASHION, 1));
    }

    public AkhmadullinaDreams(int countOfVisitors, int countOfModels){
        super();
        this.countOfModels = countOfModels;
        this.countOfVisitors = countOfVisitors;
    }

    /**
     * Главным занятием модельного агенства считаем показ мод
     */
    @Override
    public void mainActivity() {
        System.out.println("Начался показ мод");
        List<Person> visitors = new ArrayList<>();

        for (Integer n: range(countOfVisitors)) {
            Person visitor = new Person(20, 1.0) {
                @Override
                public void watch(Manufacturable item) {
                    System.out.println("На ней надето: " + item.toString());
                }

                @Override
                public void watch(Person somebody) {
                    if(somebody instanceof Model){
                        System.out.print("Зритель видит обворожительную модель ");
                        watch(((Model) somebody).getClothes());
                    }
                }

                @Override
                public void join(Business<?> business) {
                    System.out.println("Зритель пришел в " + business.getClass().getSimpleName());
                }

                @Override
                public void eat(Food food) {
                    System.out.println("Зрителей не должны кормить на показе мод");
                }
            };
            visitors.add(visitor);
            visitor.join(this);
        }

        for (Integer now : range(countOfModels)) {
            Person modelNow = new Model();
            modelNow.join(this);
            visitors.get((int)(visitors.size() * random())).watch(modelNow);
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

        public Model() {
            super(40, 0.7);
        }

        @Override
        public void watch(Manufacturable item) {

        }

        @Override
        public void watch(Person somebody) {

        }

        @Override
        public void join(Business<?> business) {
            wear(getAllProducts().get((int) (getAllProducts().size() * random())));
        }

        @Override
        public void eat(Food food) {
            this.saturation += (food.getSatiety() * this.saturationCoefficient);
        }

        public Clothes getClothes() {
            return clothes;
        }

        public void wear(Clothes clothes) {
            this.clothes = clothes;
        }
    }

}

