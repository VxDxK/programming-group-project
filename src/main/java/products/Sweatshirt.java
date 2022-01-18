package products;

import java.awt.*;
import java.util.Objects;

/**
 * Фуфайка
 * @author artem
 */
public class Sweatshirt extends Clothes{
    /**
     * коэффициент согреваемости
     */
    protected int warmingFactor;
    /**
     * количество пуговиц
     */
    protected int numberOfButtons;

    /**
     * Конструктор одежды
     * @param color цвет
     * @param size размер
     * @param sex пол
     * @param warmingFactor коэффициент согреваемости
     * @param numberOfButtons количество пуговиц
     */
    public Sweatshirt(Color color, int size, Sex sex, int textile, int warmingFactor, int numberOfButtons) {
        super(color, size, sex, textile);
        this.warmingFactor = warmingFactor;
        this.numberOfButtons = numberOfButtons;
    }

    @Override
    public void produce() {
        System.out.println("Фуфайка произведена");
    }

    @Override
    public String toString() {
        return "Фуфайка " +
                "цвет RGB=" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + " " +
                ", размер=" + size +
                ", пол=" + sex +
                ", коэффициент согреваемости=" + warmingFactor +
                ", количество пуговиц=" + numberOfButtons +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sweatshirt)) return false;
        if (!super.equals(o)) return false;
        Sweatshirt that = (Sweatshirt) o;
        return warmingFactor == that.warmingFactor && numberOfButtons == that.numberOfButtons;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), warmingFactor, numberOfButtons);
    }
}
