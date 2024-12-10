package menu.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import menu.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuRepositoryTest {

    @Test
    void 메뉴_존재_예외_테스트() {
        MenuRepository menuRepository = MenuRepository.getInstance();
        menuRepository.initMenu();

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> menuRepository.validateMenus(List.of("고추잡채", "마라탕")))
                .withMessageContaining(ErrorMessage.MENU_NOT_EXIST_ERROR.getErrorMessage());
    }

    @Test
    void 메뉴_개수_예외_테스트() {
        MenuRepository menuRepository = MenuRepository.getInstance();
        menuRepository.initMenu();

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> menuRepository.validateMenus(List.of("팟타이", "카오 팟", "나시고렝")))
                .withMessageContaining(ErrorMessage.PROHIBITED_MENUS_NUMBER_ERROR.getErrorMessage());
    }
}
