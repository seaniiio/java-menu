package menu.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomCategoryNumberUtil implements RandomUtil {

    @Override
    public int pickRandomNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
