package util;

import java.util.Objects;

/**
 * Класс "пара", аналогичен std::pair
 * @param <K> первый параметр
 * @param <V> второй параметр
 * @author vadim
 */
public class Pair <K, V>{
    private K first;
    private V second;

    /**
     * Пустой конструктор, не рекомендуется к использованию
     */
    public Pair() {
    }

    /**
     * Ну типа конструктор
     * @param first первый параметр
     * @param second второй параметр
     */
    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public void setFirst(K first) {
        this.first = first;
    }

    public V getSecond() {
        return second;
    }

    public void setSecond(V second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
