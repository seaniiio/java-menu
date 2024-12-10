package menu.domain;

import menu.util.RandomUtil;

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

    public static Category getRandomCategory(RandomUtil randomUtil) {
         return Category.findBySequence(randomUtil.pickRandomNumber(1, 5));
    }

    public String getName() {
        return name;
    }

    private static Category findBySequence(int sequence) {
        for (Category category : Category.values()) {
            if (category.sequence == sequence) {
                return category;
            }
        }
        return NULL;
    }

    @Override
    public String toString() {
        return name;
    }
}
