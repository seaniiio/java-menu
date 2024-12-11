package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberUtil implements RandomUtil {

    @Override
    public int pickRandomNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }

    @Override
    public <T> List<T> shuffle(List<T> list) {
        return Randoms.shuffle(list);
    }
}
