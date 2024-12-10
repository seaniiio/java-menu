package menu.view;

import java.util.List;
import menu.constant.Weekdays;
import menu.dto.CategoriesDto;
import menu.dto.CoachDietDto;

public class OutputView {

    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printResult(CategoriesDto categoryDto, List<CoachDietDto> dietDtos) {
        System.out.println(System.lineSeparator() + "메뉴 추천 결과입니다.");
        System.out.println(Weekdays.getMessage());
        System.out.println(categoryDto);
        for (CoachDietDto dietDto : dietDtos) {
            System.out.println(dietDto);
        }
        System.out.println(System.lineSeparator() + "추천을 완료했습니다.");
    }
}
