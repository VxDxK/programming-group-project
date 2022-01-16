package products;

import java.awt.*;
import java.util.Objects;

/**
 * Класс джинсов
 * @author artem
 */
public final class Jeans extends Clothes{
    /**
     * зауженные ли джинсы
     */
    protected boolean skinny;
    /**
     * посадка джинс
     */
    protected String fit;

    /**
     * Конструктор джинс
     * @param color - цвет
     * @param size - размер
     * @param sex - пол
     * @param skinny - зауженные
     * @param fit - посадка
     */
    public Jeans(Color color, int size, Sex sex, boolean skinny, String fit) {
        super(color, size, sex);
        this.skinny = skinny;
        this.fit = fit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Jeans jeans = (Jeans) o;
        return skinny == jeans.skinny && Objects.equals(fit, jeans.fit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), skinny, fit);
    }

    @Override
    public String toString() {
        return "Джинсы " +
                "цвет=" + color.toString() +
                ", цвет=" + size +
                ", пол=" + sex +
                ", зауженность=" + skinny +
                ", форма=" + fit;
    }

    @Override
    public void produce() {
        System.out.println("Джинсы произведены");
    }
}
