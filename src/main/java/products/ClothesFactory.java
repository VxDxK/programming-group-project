package products;

import java.awt.*;

import static java.lang.Math.random;

/**
 * Упрощенный паттерн фабрика, генерирует случайный вид одежды
 * @author vadim
 */
public final class ClothesFactory {
    public Clothes generateClothes() {
        Clothes clothes = null;

        Color color = new Color((int) (Integer.MAX_VALUE * random()));
        int size = (int) (random() * 70) + 10;
        Clothes.Sex sex = Clothes.Sex.values()[(int) (Clothes.Sex.values().length * random())];

        switch ((int) (4 * random())){
            case 0:
                //Джинсы
                clothes = new Jeans(color, size, sex, random() < 0.5, random() < 0.5 ? "lower with buttons" : "high rhinestones");
                break;
            case 1:
                //Косынка
                clothes = new Scarf(color, size, sex, 45, 30, 20, 5);
                break;
            case 2:
                //Фуфайка
                clothes = new Sweatshirt(color, size, sex, (int) (100 * random()), (int) (10 * random()));
                break;
            case 3:
                //Платье
                clothes = new Dress(color, size, sex, (int) (40 * random()), random() < 0.5);
                break;
            case 4:
                //Деним куртка
                clothes = new DenimJacket(color, size, sex, random() < 0.5, random() < 0.5);
                break;
        }
        assert clothes != null;
        clothes.produce();
        return clothes;
    }
}
