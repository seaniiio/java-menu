package menu.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import menu.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuServiceTest {

    MenuService menuService = new MenuService();

    @Test
    void 코치_이름_중복_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> menuService.setCoaches("시원,시원"))
                .withMessageContaining(ErrorMessage.COACH_NAME_DUPLICATED_ERROR.getErrorMessage());
    }

    @Test
    void 코치_이름_길이_예외_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> menuService.setCoaches("시원스쿨닷컴,시원"))
                .withMessageContaining(ErrorMessage.COACH_NAME_LENGTH_ERROR.getErrorMessage());
    }

    @Test
    void 코치_수_예외_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> menuService.setCoaches("시원스쿨닷컴"))
                .withMessageContaining(ErrorMessage.COACH_NUMBER_ERROR.getErrorMessage());
    }

    @Test
    void 존재하지_않는_메뉴_예외_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> menuService.validateMenus(List.of("마라탕")))
                .withMessageContaining(ErrorMessage.MENU_NOT_EXIST_ERROR.getErrorMessage());
    }
}
