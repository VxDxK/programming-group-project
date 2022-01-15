package businesses;

/**
 * Интерфейс Бизнесмен
 */
public interface Businessman {
    /**
     * Метод, где должнен быть описан путь создания предприятия
     * @param business предприятие, которое мы хоти основать
     * @throws BusinessFoundFailException посмотри {@link BusinessFoundFailException}
     */
    void found(Business<?> business) throws BusinessFoundFailException;

    /**
     * @return геттер созданного бизнеса
     */
    Business<?> getBusiness();
}
