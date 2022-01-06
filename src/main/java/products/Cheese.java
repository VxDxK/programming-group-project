package products;

public class Cheese extends Food{
    @Override
    public void produce() {
        System.out.println("Сыр долго стоял и квасился в подвале Истринской сыроварни");
        try {
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        isReady = true;
    }
}
