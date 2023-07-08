import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите язык игры (1 - Русский, 2 - Английский):");
        int languageChoice = scanner.nextInt();
        scanner.nextLine();

        Game game;
        if (languageChoice == 1) {
            game = new RuGame();
        } else if (languageChoice == 2) {
            game = new EngGame();
        } else {
            System.out.println("Некорректный выбор языка.");
            return;
        }

        System.out.println("Введите длину слова:");
        int wordLength = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите максимальное количество попыток:");
        int maxTries = scanner.nextInt();
        scanner.nextLine();

        game.start(wordLength, maxTries);

        while (!game.getGameStatus().equals(GameStatus.FINISH)) {
            System.out.println("Введите слово:");
            String inputWord = scanner.nextLine();
            Answer answer = game.inputValue(inputWord);
            if (answer != null) {
                System.out.println("Ответ: быки - " + answer.getBull() + ", коровы - " + answer.getCow());
            }
        }

        System.out.println("Хотите посмотреть историю игры? (да/нет)");
        String viewHistory = scanner.nextLine();
        if (viewHistory.equalsIgnoreCase("да")) {
            List<String> gameHistory = game.getGameHistory();
            System.out.println("История игры:");
            for (String entry : gameHistory) {
                System.out.println(entry);
            }
        }
    }
}