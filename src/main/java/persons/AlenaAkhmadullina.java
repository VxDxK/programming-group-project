package persons;

import businesses.Business;
import businesses.BusinessFoundFailException;
import businesses.Businessman;
import products.Food;
import products.Manufacturable;

import java.time.LocalDate;

/**
 * Класс персонажа
 * Алёна Ахмадуллина
 * Владелица бренда
 * @author maxim
 **/

public final class AlenaAkhmadullina extends Person implements Businessman {
    /**
     * Инициализация бизнеса
     */
    public Business<?> business;
    
    /**
     * Конструктор суперкласса
     */
    public AlenaAkhmadullina() {
        super(30, 1.2);
    }

    @Override
    public void found(Business<?> business) throws BusinessFoundFailException {
        business.setCeo(this);
        business.setBusinessLife(0);
        System.out.println("Бренд основан");
        String[] mistakes = {"двигается на ощупь, ", "совершает ошибки, ", "формирует индустрию, ", "рискует"};
        int counter = 0;
        System.out.print("Алена Ахмадулина: ");
        try {
            for(String now : mistakes){
                System.out.print(now);
                Thread.sleep(200);
                if (Math.random() < 0.3) {
                    counter++;
                }
                if(counter >= 3){
                    System.out.println();
                    throw new BusinessFoundFailException("Бизнес прогорел из-за большого количества ошибок");
                }
                business.setBusinessLife(business.getBusinessLife() + 5);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.printf("\nПрошло %d лет\n", business.getBusinessLife());
    }

    @Override
    public Business<?> getBusiness() {
        return null;
    }


    @Override
    public void watch(Manufacturable item) {

    }

    @Override
    public void watch(Person somebody) {

    }

    @Override
    public void eat(Food food) {

    }

    @Override
    public void join(Business business) {

    }
}
