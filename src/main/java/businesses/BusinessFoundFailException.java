package businesses;

/**
 * На пути создания бизнеса бывают взлеты и падания, так всегда остается шанс, что бизнес прогорит
 */
public class BusinessFoundFailException extends Exception{
    public BusinessFoundFailException(String s) {
        super(s);
    }
}
