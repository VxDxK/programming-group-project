package products;

import java.awt.*;
import java.util.Objects;

/**
 * Класс косынки
 * @author artem
 */
public class Scarf extends Clothes {
    /**
     * процент содержания нейлона
     */
    protected int nylon;
    /**
     * процент содержания шерсти
     */
    protected int wool;
    /**
     * процент содержания вискозы
     */
    protected int viscose;
    /**
     * процент содержания ангоры
     */
    protected int angora;
    /**
     * Конструктор одежды
     * @param color - цвет
     * @param size  - размер
     * @param sex   - пол
     * @param angora - процент содержания ангоры
     * @param nylon - процент содержания нейлона
     * @param viscose - процент содержания вискозы
     * @param wool - процент содержания шерсти
     */
    public Scarf(Color color, int size, Sex sex, int nylon, int wool, int viscose, int angora) {
        super(color, size, sex);
        if(nylon + wool + viscose + angora != 100){
            throw new IllegalArgumentException("Процент материалов должен быть равен сотне");
        }
        this.nylon = nylon;
        this.wool = wool;
        this.viscose = viscose;
        this.angora = angora;

    }

    @Override
    public void produce() {
        System.out.println("Косынка произведена");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Scarf)) return false;
        if (!super.equals(o)) return false;
        Scarf scarf = (Scarf) o;
        return nylon == scarf.nylon && wool == scarf.wool && viscose == scarf.viscose && angora == scarf.angora;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nylon, wool, viscose, angora);
    }

    @Override
    public String toString() {
        return "Косынка " +
                "цвет=" + color +
                ", размер=" + size +
                ", пол=" + sex +
                ", доля нейлона=" + nylon +
                ", доля шерсти=" + wool +
                ", доля вискозы=" + viscose +
                ", доля ангоры=" + angora;
    }
}
