package products;

import products.Clothes;

import java.awt.*;
import java.util.Objects;

/**
 * Класс джинсовой куртки
 * @author artem
 */
public final class DenimJacket extends Clothes {
    /**
     * длинные ли рукава
     */
    protected boolean longSleeves;
    /**
     * есть ли капюшон
     */
    protected boolean hood;

    /**
     * Конструктор джинсовой куртки
     * @param color - цвет
     * @param size  - размер
     * @param sex   - пол
     * @param longSleeves - длинные рукава
     * @param hood - капюшон
     */
    public DenimJacket(Color color, int size, Sex sex, boolean longSleeves, boolean hood) {
        super(color, size, sex);
        this.longSleeves = longSleeves;
        this.hood = hood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DenimJacket that = (DenimJacket) o;
        return longSleeves == that.longSleeves && hood == that.hood;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), longSleeves, hood);
    }

    @Override
    public String toString() {
        return "Куртка из денима " +
                "цвет=" + color +
                ", размер=" + size +
                ", пол=" + sex +
                ", есть ли рукава=" + longSleeves +
                ", капюшон=" + hood;
    }

    @Override
    public void produce() {

    }
}
