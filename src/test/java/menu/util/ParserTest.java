package menu.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    void 코치_이름_파싱_테스트() {
        String coachesInput = "김시,원입,니다";

        Assertions.assertThat(Parser.parseCoaches(coachesInput))
                .containsAll(List.of("김시", "원입", "니다"));
    }

    @Test
    void 메뉴_이름_파싱_테스트() {
        String coachesInput = "짜장면,짬뽕";

        Assertions.assertThat(Parser.parseCoaches(coachesInput))
                .containsAll(List.of("짜장면", "짬뽕"));
    }
}
