package util;

import java.util.Iterator;

/**
 * Вспомогатальный класс для написания циклов в Python стиле
 * @author vadim
 */
public class Range {
    public static Iterable<Integer> range(int count){
        return range(0, count);
    }

    public static Iterable<Integer> range(int from, int to) throws IllegalArgumentException{
        int increment = to >= from ? 1 : -1;
        return range(from, to, increment);
    }

    public static Iterable<Integer> range(int from, int to, int increment) throws IllegalArgumentException {
        int condIncrement = increment - 1;
        if(increment == 0){
            throw new IllegalArgumentException("Increment cannot be 0");
        }else if(increment < 0){
            condIncrement = increment + 1;
        }
        int finalCondIncrement = condIncrement;
        return () -> new Iterator<Integer>() {

            int point = from;
            @Override
            public boolean hasNext() {
                return  increment > 0 ? point + finalCondIncrement < to : point + finalCondIncrement > to;
            }

            @Override
            public Integer next() {
                int temp = point;
                point += increment;
                return temp;
            }
        };
    }
}
