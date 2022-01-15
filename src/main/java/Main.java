import businesses.*;
import persons.AlenaAkhmadullina;
import persons.GeorgeTroyan;
import persons.OlegSirota;
import products.Cheese;
import products.Clothes;
import products.Food;
import products.Manufacturable;

/**
 * Класс с main методом
 * @author vadim
 */
public class Main {
    public static void main(String[] args) {
        Market market = new Market();

        Businessman georgeTroyan = new GeorgeTroyan();
        Business<Food> restaurant = new Restaurant();


        Businessman olegSirota = new OlegSirota();
        Business<Cheese> cheeseDairy = new CheeseDairy();

        market.addBusiness(restaurant);
        market.addBusiness(cheeseDairy);
        try {
            georgeTroyan.found(restaurant);
            olegSirota.found(cheeseDairy);
        } catch (BusinessFoundFailException e) {
            e.printStackTrace();
        }
        //Главная история> (a.getSecond() + b.getSecond()));


        Businessman alenaAkhmadullina = new AlenaAkhmadullina();
        AkhmadullinaDreams dreams = new AkhmadullinaDreams();
        market.addBusiness(dreams);

        int sum = 0;
        for(int i = 0; i < market.getIndustry(IndustryType.FASHION).size(); i++){
            sum += market.getIndustry(IndustryType.FASHION).get(i).getSecond();
        }
        System.out.println("Доля рынка фэшн-индустрии: " + (double)sum/(double)market.getAllMass());

        try {
            alenaAkhmadullina.found(dreams);
        }catch (BusinessFoundFailException e){
            e.printStackTrace();
            System.exit(-1);
        }
        System.out.println("Упорство и профессионализм помогли " + alenaAkhmadullina.getClass().getSimpleName() + " добиться успеха");

        dreams.celebrateAnn(cheeseDairy);

    }
}
