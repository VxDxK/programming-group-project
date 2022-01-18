package products;

import java.awt.*;
import java.util.Objects;

/**
 * Класс одежды
 * @author artem
 */
public abstract class Clothes implements Manufacturable{
    /**
     * Цвет одежды
     */
    protected Color color;
    /**
     * Размер одежды
     */
    protected int size;
    /**
     * Пол
     */
    protected Sex sex;
    /**
     * Количество сырья, необходимого для производства одежды.
     */
    protected int textile;
    /**
     * Конструктор одежды
     * @param color - цвет
     * @param size - размер
     * @param sex - пол
     */
    public Clothes(Color color, int size, Sex sex, int textile) {
        this.color = color;
        this.size = size;
        this.sex = sex;
        this.textile = textile;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clothes clothes = (Clothes) o;
        return size == clothes.size && Objects.equals(color, clothes.color) && sex == clothes.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, size, sex);
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "colorRGB=" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + " " +
                ", size=" + size +
                ", sex=" + sex +
                '}';
    }

    /**
     * Енам пола
     */
    public enum Sex{
        MALE,
        FEMALE,
        UNISEX
    }
}
