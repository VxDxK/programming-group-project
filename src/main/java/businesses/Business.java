package businesses;

import persons.Person;
import products.Manufacturable;
import util.Pair;
import java.util.ArrayList;
import java.util.List;

/**
 * Базовый класс для написания предприятий
 * @param <T> тип производимого сырья
 */
public abstract class Business<T extends Manufacturable> {
    protected Person ceo;
    protected List<Pair<IndustryType, Integer>> types= new ArrayList<>();
    protected Integer businessLife;
    protected List<T> products = new ArrayList<>();
    protected int capitalization;

    public List<Pair<IndustryType, Integer>> getTypes() {
        return types;
    }

    public Person getCeo() {
        return ceo;
    }
    public void setCeo(Person ceo) {
        this.ceo = ceo;
    }

    public Integer getBusinessLife() {
        return businessLife;
    }
    public void setBusinessLife(Integer businessLife) {
        this.businessLife = businessLife;
    }

    public int getCapitalization() {
        return capitalization;
    }

    public void addCapitalization(int capitalization) throws BusinessFoundFailException {
        this.capitalization += capitalization;
        if(capitalization < -50){
            throw new BusinessFoundFailException("Бизнес прогорел после " + businessLife + " существования");
        }
    }

    public List<T> getAllProducts(){
        return products;
    }
    public void addProduct(T item){
        products.add(item);
    }
    public abstract void service(Person ... people);
    public abstract T advertising();

    public abstract void mainActivity();

}
