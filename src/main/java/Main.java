import businesses.*;
import persons.AlenaAkhmadullina;
import persons.GeorgeTroyan;
import persons.OlegSirota;
import products.*;

import java.awt.*;

import static util.Range.range;

/**
 * Класс с main методом
 * @author vadim,
 */
public class Main {
    public static void main(String[] args) {
        Market market = new Market();

        Businessman georgeTroyan = new GeorgeTroyan(60, 1.2);
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

        Businessman alenaAkhmadullina = new AlenaAkhmadullina();
        AkhmadullinaDreams dreams = new AkhmadullinaDreams(5, 5);

        market.addBusiness(dreams);

        int sum = 0;
        for(Integer i: range(market.getIndustry(IndustryType.FASHION).size()))
            sum += market.getIndustry(IndustryType.FASHION).get(i).getSecond();
        System.out.println("Доля рынка фэшн-индустрии: " + (double)sum/(double)market.getAllMass());

        try {
            alenaAkhmadullina.found(dreams);
        }catch (BusinessFoundFailException e){
            e.printStackTrace();
            System.exit(-1);
        }
        dreams.addProduct(new DenimJacket(Color.BLACK, 39, Clothes.Sex.FEMALE, false, true));
        ClothesFactory clothesFactory = new ClothesFactory();
        for(Integer i : range(6)){
            dreams.addProduct(clothesFactory.generateClothes());
        }
        System.out.println("Упорство и профессионализм помогли " + alenaAkhmadullina.getClass().getSimpleName() + " добиться успеха");
        dreams.celebrateAnn(cheeseDairy);

    }
}
