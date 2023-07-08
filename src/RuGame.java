import java.util.ArrayList;
import java.util.List;

public class RuGame extends AbstractGame {
    @Override
    List<String> generateCharList() {
        List<String> result = new ArrayList<>();
        for (char c = 'а'; c <= 'я'; c++) {
            result.add(String.valueOf(c));
        }
        return result;
    }
}
