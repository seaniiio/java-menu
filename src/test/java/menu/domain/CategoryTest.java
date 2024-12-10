package menu.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CategoryTest {

    @Test
    void 랜덤_카테고리_탐색_테스트() {
        Assertions.assertThat(Category.getRandomCategory())
                .isInstanceOf(Category.class);
    }
}
