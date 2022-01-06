package businesses;

import persons.Person;
import products.Clothes;
import products.Manufacturable;


public class AkhmadullinaDreams extends Business<Clothes>{

    {
        type = IndustryType.FASHION;
    }


    @Override
    public void mainActivity() {
        System.out.println("Начался показ мод");
    }

    public void celebrateAnn(Business<?> business){
        System.out.println(this.getClass().getSimpleName() + " празднует свою годовщину в " + business.getClass().getSimpleName());
        mainActivity();
    }

}
