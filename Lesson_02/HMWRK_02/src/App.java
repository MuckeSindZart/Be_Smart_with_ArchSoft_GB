import Fabric.*;
import Interface.*;
import Product.ResetBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Модель (Model)
class GameModel {
    private List<ItemGenerator> generators;
    private List<iGameItem> openedBoxes;
    private int score;
    private boolean isGameOver;

    public GameModel() {
        generators = new ArrayList<>();
        openedBoxes = new ArrayList<>();
        score = 0;
        isGameOver = false;
        // Добавление генераторов разных типов и количество их в списке
        addGenerators(new GoldGenerator(), 5);
        addGenerators(new GemGenerator(), 5);
        addGenerators(new SilverGenerator(), 5);
        // newItem
        addGenerators(new WoodBoxGenerator(), 15);
        addGenerators(new IronChestGenerator(), 15);
        addGenerators(new ResetBoxGenerator(), 15);
    }

    private void addGenerators(ItemGenerator generator, int count) {
        for (int i = 0; i < count; i++) {
            generators.add(generator);
        }
    }

    public List<ItemGenerator> getGenerators() {
        return generators;
    }

    public List<iGameItem> getOpenedBoxes() {
        return openedBoxes;
    }

    public int getScore() {
        return score;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }
    
}

// Представление (View)
class GameView {
    public void displayGameState(GameModel model) {
        System.out.println("Открыто коробок: " + model.getOpenedBoxes().size() + " из 10");
    }

    public String getUserInput() {
        System.out.println("Открыть следующую коробку? (y/n)");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    }
}

// Контроллер (Controller)
class GameController {
    private GameModel model;
    private GameView view;
    private Random random;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        this.random = new Random();
    }

    public void startGame() {
        while (model.getOpenedBoxes().size() < 10 && !model.isGameOver()) {
            view.displayGameState(model);
            String input = view.getUserInput();

            if (input.equals("y")) {
                int randomIndex = random.nextInt(model.getGenerators().size());
                ItemGenerator generator = model.getGenerators().get(randomIndex);
                iGameItem item = generator.createItem();

                if (item instanceof ResetBox) {
                    item.open();
                    if (((ResetBox) item).isGameOver) {
                        model.setGameOver(true);
                        System.out.println("Вы проиграли!");
                    }
                    break;
                } else {
                    item.open();
                }

                model.getOpenedBoxes().add(item);
            } else if (input.equals("n")) {
                break;
            } else {
                System.out.println("\nПожалуйста, вводите 'y' или 'n'.\n");
            }
        }

        System.out.println("Игра завершена. Открыто коробок: " + model.getOpenedBoxes().size() + " из 10");
    }
}

public class App {
    public static void main(String[] args) {
        GameModel model = new GameModel();
        GameView view = new GameView();
        GameController controller = new GameController(model, view);
        controller.startGame();
    }
}
