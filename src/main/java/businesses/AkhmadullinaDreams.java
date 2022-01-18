package businesses;

import com.sun.org.apache.xpath.internal.operations.Mod;
import persons.Person;
import products.*;
import util.Pair;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.*;
import static util.Range.range;

/**
 * Бренд Akhmadullina
 * @author vadim
 */
public final class AkhmadullinaDreams extends Business<Clothes>{
    private DreamsFactory factory;
    private int countOfVisitors;
    private int countOfModels;

    {
        types.add(new Pair<>(IndustryType.FASHION, 1));
    }

    public AkhmadullinaDreams(int countOfVisitors, int countOfModels){
        super();
        this.countOfModels = countOfModels;
        this.countOfVisitors = countOfVisitors;
        //Обзавелись своей мастерской
        factory = new DreamsFactory();
    }

    @Override
    public void service(Person... people) {
        Arrays.stream(people).forEach(person -> person.addExperience((int) (random() * 5)));
        System.out.println("Зрители пришли на экскурсию и получили новый опыт");
    }

    @Override
    public Clothes advertising() {
        capitalization += 20;
        return factory.generateRandom();
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
            Model modelNow = new Model();
            modelNow.join(this);
            Clothes clothe = factory.generateRandom();
            addProduct(clothe);
            modelNow.wear(clothe);
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
            System.out.println(getClass().getSimpleName() +  " взглянула на одежду, которую ей предстоит носить");
        }

        @Override
        public void watch(Person somebody) {
            System.out.println(getClass().getSimpleName() + " смотрит на зрителя");
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

    /**
     * Личная фабрика модельного агенства
     * @author vadim
     */
    public class DreamsFactory{
        /**
         * Количество сырья на фабрике
         */
        private int raw = 100;

        public Clothes generateRandom(){
            Clothes clothes = null;
            switch ((int) (4 * random())){
                case 0:
                    //Джинсы
                    clothes = getClothe(Jeans.class);
                    break;
                case 1:
                    //Косынка
                    clothes = getClothe(Scarf.class);
                    break;
                case 2:
                    //Фуфайка
                    clothes = getClothe(Sweatshirt.class);
                    break;
                case 3:
                    //Платье
                    clothes = getClothe(Dress.class);
                    break;
                case 4:
                    //Деним куртка
                    clothes = getClothe(DenimJacket.class);
                    break;
            }
            return clothes;
        }
        public Clothes getClothe(Class<? extends Clothes> cloth){
            Clothes clothes = null;
            Pair<Color, Pair<Integer, Pair<Clothes.Sex, Integer>>> pairs = generateParams();
            Color color = pairs.getFirst();
            int size = pairs.getSecond().getFirst();
            Clothes.Sex sex = pairs.getSecond().getSecond().getFirst();
            int textile = pairs.getSecond().getSecond().getSecond();

            if(cloth.equals(Jeans.class)){
                clothes = new Jeans(color, size, sex, textile, random() < 0.5, random() < 0.5 ? "lower with buttons" : "high rhinestones");
            }else if(cloth.equals(Scarf.class)){
                clothes = new Scarf(color, size, sex, textile, 45, 30, 20, 5);
            }else if(cloth.equals(Sweatshirt.class)){
                clothes = new Sweatshirt(color, size, sex, textile, (int) (100 * random()), (int) (10 * random()));
            }else if(cloth.equals(Dress.class)){
                clothes = new Dress(color, size, sex, textile, (int) (40 * random()), random() < 0.5);
            }else{
                clothes = new DenimJacket(color, size, sex, textile, random() < 0.5, random() < 0.5){
                    @Override
                    public void produce() {
                        raw -= textile;
                    }
                };
            }
            if(raw <= 0){
                capitalization -= 20;
                raw += 100;
            }
            assert clothes != null;
            return clothes;
        }

        private Pair<Color, Pair<Integer, Pair<Clothes.Sex, Integer>>> generateParams(){
            Pair<Clothes.Sex, Integer> pair1 = new Pair<>(Clothes.Sex.values()[(int) (Clothes.Sex.values().length * random())], (int) (10 * random()));
            Pair<Integer, Pair<Clothes.Sex, Integer>> pair2 = new Pair<>((int) (random() * 70) + 10, pair1);
            return new Pair<>(new Color((int) (Integer.MAX_VALUE * random())), pair2);
        }
    }

}

