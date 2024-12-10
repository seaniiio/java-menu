package menu.domain;

import static org.junit.jupiter.api.Assertions.*;

import menu.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachTest {

    @ParameterizedTest
    @ValueSource(strings = {"짧, 너무길어어어"})
    void 코치_이름_길이_테스트(String name) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Coach(name))
                .withMessageContaining(ErrorMessage.COACH_NAME_LENGTH_ERROR.getErrorMessage());
    }
}
