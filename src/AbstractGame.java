import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public abstract class AbstractGame implements Game {
    Integer sizeWord;
    Integer maxTry;
    int currentTry;
    String computerWord;
    GameStatus gameStatus = GameStatus.INIT;
    List<String> gameHistory = new ArrayList<>();

    @Override
    public void start(Integer sizeWord, Integer maxTry) {
        this.sizeWord = sizeWord;
        this.maxTry = maxTry;
        computerWord = generateWord();
        System.out.println("comp: " + computerWord);
        this.gameStatus = GameStatus.START;
        this.currentTry = 0;
        this.gameHistory.clear();
    }

    @Override
    public Answer inputValue(String value) {
        if (currentTry >= maxTry) {
            gameStatus = GameStatus.FINISH;
            System.out.println("Вы проиграли по количеству попыток");
            gameHistory.add("[Попытка " + (currentTry + 1) + "] Введенное слово: " + value + ", Результат: Проигрыш");
            return null;
        }
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == computerWord.charAt(i)) {
                bull++;
                cow++;
            } else if (computerWord.contains(String.valueOf(value.charAt(i)))) {
                cow++;
            }
        }
        currentTry++;
        if (sizeWord.equals(bull)) {
            gameStatus = GameStatus.FINISH;
            System.out.println("Вы победили!!");
            gameHistory.add("[Попытка " + (currentTry) + "] Введенное слово: " + value + ", Результат: Победа");
            return null;
        }
        Answer answer = new Answer(bull, cow, currentTry);
        gameHistory.add("[Попытка " + (currentTry) + "] Введенное слово: " + value + ", Результат: Быки - " + bull + ", Коровы - " + cow);
        return answer;
    }

    @Override
    public GameStatus getGameStatus() {
        return gameStatus;
    }

    @Override
    public List<String> getGameHistory() {
        return gameHistory;
    }

    abstract List<String> generateCharList();

    private String generateWord() {
        List<String> charList = generateCharList();
        String result = "";
        Random random = new Random();
        for (int i = 0; i < sizeWord; i++) {
            int randomIndex = random.nextInt(charList.size());
            result += charList.get(randomIndex);
            charList.remove(randomIndex);
        }
        return result;
    }
}
