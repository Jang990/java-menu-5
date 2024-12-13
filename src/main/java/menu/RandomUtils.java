package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomUtils {
    public int pickNumberInRange(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }

    public String pickRandom(List<String> strings) {
        List<String> clone = List.copyOf(strings);
        return Randoms.shuffle(clone).getFirst();
    }
}
