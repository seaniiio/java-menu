package menu.util;

import java.util.List;

public interface RandomUtil {
    int pickRandomNumber(int min, int max);
    <T> List<T> shuffle(List<T> list);
}
