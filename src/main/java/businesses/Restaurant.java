package businesses;

import persons.Person;
import products.Cheese;
import products.Food;
import util.Pair;

import static util.Range.range;

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
    public void service(Person... people) {
        for(Integer i: range(people.length)){
            System.out.println("Кормим: " + people[i].getClass().getSimpleName());
            new Thread(() -> {
                people[i].eat(new Food() {
                    @Override
                    public void produce() {
                        satiety = (int) (100 * Math.random());
                        System.out.println("Приготовили интересную еду");
                    }
                });
            }).start();
        }
    }

    @Override
    public Food advertising() {
        return new Cheese(){
            @Override
            public void produce() {
                System.out.println("Приготовили уникальную сырную тарелку от ресторана " + ceo.getClass().getSimpleName());
            }
        };
    }

    @Override
    public void mainActivity() {
        advertising();
    }
}
