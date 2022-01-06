import businesses.AkhmadullinaDreams;
import businesses.Business;
import businesses.BusinessFoundFailException;
import businesses.Businessman;
import persons.AlenaAkhmadullina;
import persons.OlegSirota;
import persons.Person;
import products.Clothes;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Businessman olegSirota = new OlegSirota();

        //Главная история
        Businessman alenaAkhmadullina = new AlenaAkhmadullina();
        Business<Clothes> dreams = new AkhmadullinaDreams();
        try {
            alenaAkhmadullina.found(dreams);
        }catch (BusinessFoundFailException e){
            e.printStackTrace();
            System.exit(-1);
        }
        System.out.println("Упорство и профессионализм помогли " + alenaAkhmadullina.getClass().getSimpleName() + " добиться успеха");

    }
}
