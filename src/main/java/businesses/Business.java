package businesses;

import persons.Person;
import products.Manufacturable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Business<T extends Manufacturable> {
    protected Person ceo;
    protected Integer businessLife;
    protected IndustryType type;
    protected List<T> products = new ArrayList<>();

    public IndustryType getType() {
        return type;
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
