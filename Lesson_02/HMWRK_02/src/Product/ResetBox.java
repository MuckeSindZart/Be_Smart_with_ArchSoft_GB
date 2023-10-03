package Product;


public class ResetBox extends ItemReward {
    public boolean isGameOver = true;

    public void open() {
        System.out.println("Вы открыли обнуляющую коробку!");
    }
}