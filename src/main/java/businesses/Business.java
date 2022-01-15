package businesses;

import persons.Person;
import products.Manufacturable;
import sun.security.krb5.internal.crypto.Aes128CtsHmacSha1EType;
import util.Pair;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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

    public List<T> getAllProducts(){
        return products;
    }
    public void addProduct(T item){
        products.add(item);
    }

     public abstract void mainActivity();

}
