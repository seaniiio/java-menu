package menu.util;

public class RandomTestNumberUtil implements RandomUtil {

    private final int fixedNumber;

    public RandomTestNumberUtil(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public int pickRandomNumber(int min, int max) {
        return fixedNumber;
    }
}
