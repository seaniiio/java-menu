package menu.util;

import java.util.List;

public class RandomNumberTestUtil implements RandomUtil {

    private final int fixedNumber;

    public RandomNumberTestUtil(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public int pickRandomNumber(int min, int max) {
        return fixedNumber;
    }

    @Override
    public <T> List<T> shuffle(List<T> list) {
        return list;
    }
}
