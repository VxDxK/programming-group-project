package products;

import java.util.UUID;

/**
 * Сыр
 * @author artem
 */

public class Cheese extends Food{
    /**
     * Уникальный id сыры
     */
    protected UUID uuid;
    @Override
    public void produce() {
        uuid = new UUID(0, 0);
        System.out.println("Сыр долго стоял и квасился в подвале Истринской сыроварни");
        try {
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        isReady = true;
    }
}
