import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public interface Game {
    void start(Integer sizeWord, Integer maxTry);

    Answer inputValue(String value);

    GameStatus getGameStatus();

    List<String> getGameHistory();
}
