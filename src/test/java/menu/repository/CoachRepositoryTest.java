package menu.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import menu.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CoachRepositoryTest {

    @Test
    void 코치_수_예외_테스트_1() {
        CoachRepository coachRepository = CoachRepository.getInstance();
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> coachRepository.saveCoaches(List.of("1명")))
                .withMessageContaining(ErrorMessage.COACH_NUMBER_ERROR.getErrorMessage());
    }

    @Test
    void 코치_수_예외_테스트_2() {
        CoachRepository coachRepository = CoachRepository.getInstance();
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> coachRepository.saveCoaches(List.of("1명", "2명", "3명", "4명", "5명", "6명")))
                .withMessageContaining(ErrorMessage.COACH_NUMBER_ERROR.getErrorMessage());
    }
}
