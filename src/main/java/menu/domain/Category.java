package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

public enum Category {

    JAPANESE_FOOD("일식", 1),
    KOREAN_FOOD("한식", 2),
    CHINESE_FOOD("중식", 3),
    ASIAN_FOOD("아시안", 4),
    WESTERN_FOOD("양식", 5),
    NULL("", 0),
    ;

    private final String name;
    private final int sequence;

    Category(String name, int sequence) {
        this.name = name;
        this.sequence = sequence;
    }

    public static Category getRandomCategory() {
         return Category.findBySequence(Randoms.pickNumberInRange(1, 5));
    }

    private static Category findBySequence(int sequence) {
        for (Category category : Category.values()) {
            if (category.sequence == sequence) {
                return category;
            }
        }
        return NULL;
    }
}
