import java.util.ArrayList;
import java.util.List;

public class EngGame extends AbstractGame {
    @Override
    List<String> generateCharList() {
        List<String> result = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            result.add(String.valueOf(c));
        }
        return result;
    }
}
