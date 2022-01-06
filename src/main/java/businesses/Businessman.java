package businesses;

public interface Businessman {
    void found(Business<?> business) throws BusinessFoundFailException;
    Business<?> getBusiness();
}
