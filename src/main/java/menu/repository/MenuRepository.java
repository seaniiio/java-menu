package menu.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.constant.ErrorMessage;
import menu.domain.Category;
import menu.util.RandomUtil;

public class MenuRepository {

    private static final int MAX_PROHIBITED_MENUS_NUMBER = 2;

    private static final MenuRepository instance = new MenuRepository();
    private static final Map<Category, List<String>> menus = new HashMap<>();

    public static MenuRepository getInstance() {
        return instance;
    }

    public void initMenu() {
        menus.put(Category.JAPANESE_FOOD, List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
        menus.put(Category.KOREAN_FOOD, List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
        menus.put(Category.CHINESE_FOOD, List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
        menus.put(Category.ASIAN_FOOD, List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
        menus.put(Category.WESTERN_FOOD, List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
    }

    public void validateMenus(List<String> parsedProhibitedMenus) {
        if (parsedProhibitedMenus.isEmpty()) {
            return;
        }

        // 이걸 여기서 하는 게 맞는지
        if (parsedProhibitedMenus.size() > MAX_PROHIBITED_MENUS_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.PROHIBITED_MENUS_NUMBER_ERROR.getErrorMessage());
        }

        for (String parsedProhibitedMenu : parsedProhibitedMenus) {
            if (!isMenuExist(parsedProhibitedMenu)) {
                throw new IllegalArgumentException(ErrorMessage.MENU_NOT_EXIST_ERROR.getErrorMessage());
            }
        }
    }

    public String getRandomMenuOfCategory(Category category, RandomUtil randomUtil) {
        return randomUtil.shuffle(menus.get(category)).get(0);
    }

    private boolean isMenuExist(String parsedProhibitedMenu) {
        for (Category category : menus.keySet()) {
            if (menus.get(category).contains(parsedProhibitedMenu)) {
                return true;
            }
        }
        return false;
    }
}
