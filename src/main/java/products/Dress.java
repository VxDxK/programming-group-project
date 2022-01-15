package products;

import java.awt.*;
import java.util.Objects;

/**
 * Класс платья
 * @author artem
 */
public final class Dress extends Clothes{
    /**
     * длинна платья
     */
    protected int length;
    /**
     * есть ли рукава
     */
    protected boolean sleeves;

    /**
     * Конструктор платья
     * @param color - цвет
     * @param size  - размер
     * @param sex   - пол
     * @param length - длина платья
     * @param sleeves - рукава
     */
    public Dress(Color color, int size, Sex sex, int length, boolean sleeves) {
        super(color, size, sex);
        this.length = length;
        this.sleeves = sleeves;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dress dress = (Dress) o;
        return length == dress.length && sleeves == dress.sleeves;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), length, sleeves);
    }

    @Override
    public String toString() {
        return "Dress{" +
                "color=" + color +
                ", size=" + size +
                ", sex=" + sex +
                ", length=" + length +
                ", sleeves=" + sleeves +
                '}';
    }

    @Override
    public void produce() {

    }

}
