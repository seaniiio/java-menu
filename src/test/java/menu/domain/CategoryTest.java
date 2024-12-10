package menu.domain;

import static org.junit.jupiter.api.Assertions.*;

import menu.util.RandomTestNumberUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CategoryTest {

    @ParameterizedTest
    @CsvSource({
            "1, 일식",
            "2, 한식",
            "3, 중식",
            "4, 아시안",
            "5, 양식"
    })
    void 카테고리_탐색_테스트(int sequence, String name) {
        RandomTestNumberUtil randomTestNumberUtil = new RandomTestNumberUtil(sequence);

        Assertions.assertThat(Category.getRandomCategory(randomTestNumberUtil).getName())
                .isEqualTo(name);
    }
}
