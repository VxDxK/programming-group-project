import businesses.*;
import persons.AlenaAkhmadullina;
import persons.OlegSirota;
import products.Clothes;

/**
 * Класс с main методом
 * @author vadim
 */
public class Main {
    public static void main(String[] args) {
        Market market = new Market();
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
