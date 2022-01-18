package businesses;

import persons.Person;
import products.Cheese;
import products.Manufacturable;
import util.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static java.lang.Math.random;

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
        //Варят сыр
        addProduct(new Cheese(){
            @Override
            public void produce() {
                uuid = UUID.randomUUID();
                System.out.println("Сварили супер годный, непонятно какого сорта сыр, id номер: " + uuid.toString());
            }
        });
    }

    /**
     * Зрители поели сыра и посмотрели экскурсию на сыроварню
     * @param people люди
     */
    @Override
    public void service(Person... people) {
        Arrays.stream(people).peek(x -> x.eat(getAllProducts().get((int) (random() * getAllProducts().size())))).forEach(x -> x.addExperience(1));
    }

    @Override
    public Cheese advertising() {
        Cheese cheese = getAllProducts().get((int) (getAllProducts().size() * random()));
        System.out.println("Рекламим сыр: " + cheese.toString());
        return cheese;
    }

}
