package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public String coachesInput() {
        System.out.println(System.lineSeparator() + "코치의 이름을 입력해 주세요. (, 로 구분)");
        return Console.readLine();
    }

    public String prohibitedMenuInput(String name) {
        System.out.println(System.lineSeparator() + name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        return Console.readLine();
    }
}
