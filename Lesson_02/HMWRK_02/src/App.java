import Fabric.*;
import Interface.*;
import Product.ResetBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {

    // Метод для добавления генераторов в список
    private static void addGenerators(List<ItemGenerator> generators, ItemGenerator generator, int count) {
        for (int i = 0; i < count; i++) {
            generators.add(generator);
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int numItemsToOpen = 10; // Количество коробок в игре
        int openedBoxes = 0; // Количество открытых коробок

        List<ItemGenerator> generators = new ArrayList<>();

        // Добавление генераторов разных типов и количество их в списке
        addGenerators(generators, new GoldGenerator(), 5);
        addGenerators(generators, new GemGenerator(), 5);
        addGenerators(generators, new SilverGenerator(), 5);
        // newItem
        addGenerators(generators, new WoodBoxGenerator(), 15);
        addGenerators(generators, new IronChestGenerator(), 15);
        addGenerators(generators, new ResetBoxGenerator(), 15);
        //

        Scanner scanner = new Scanner(System.in);

        while (openedBoxes < numItemsToOpen) {

            System.out.println("Открыто коробок: " + openedBoxes + " из 10");

            System.out.println("Открыть следующую коробку? (y/n)");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("y")) {
                int randomIndex = random.nextInt(generators.size());
                // Случайный индекс из массива
                ItemGenerator generator = generators.get(randomIndex);
                iGameItem item = generator.createItem();

                // Проверка, является ли предмет ResetBox (костыли и велосипеды)
                if (item instanceof ResetBox) {
                    item.open();
                    if (((ResetBox) item).isGameOver) {
                        System.out.println("Вы проиграли!");
                    }
                    break;
                } else {
                    item.open();
                }
                openedBoxes++; // Счетчик отрытых коробок
            } else if (input.equals("n")) {// Выход из цикла while
                break;
            } else {//Ввод чего то кроме "n" или "y"
                System.out.println("\nПожалуйста, вводите 'y' или 'n'.\n");
            }
        }

        System.out.println("Игра завершена. Открыто коробок: " + openedBoxes + " из " + numItemsToOpen);
    }
}
