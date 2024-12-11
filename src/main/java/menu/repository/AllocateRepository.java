package menu.repository;

import java.util.ArrayList;
import java.util.List;
import menu.constant.Weekdays;
import menu.domain.Category;
import menu.domain.Coach;
import menu.util.RandomNumberUtil;
import menu.util.RandomUtil;

public class AllocateRepository {

    private static final int MAX_CATEGORY_COUNT = 2;

    private static final AllocateRepository allocateRepository = new AllocateRepository();
    private static final CoachRepository coachRepository = CoachRepository.getInstance();
    private static final MenuRepository menuRepository = MenuRepository.getInstance();
    private static List<Category> allocatedCategories = new ArrayList<>();

    private AllocateRepository() {};

    public static AllocateRepository getInstance() {
        return allocateRepository;
    }

    public void allocateMenu(Weekdays day, RandomUtil randomUtil) {
        Category category = selectCategory();

        List<Coach> coaches = coachRepository.getCoaches();
        for (Coach coach : coaches) {
            allocateValidMenu(day, coach, category, randomUtil);
        }
    }

    private void allocateValidMenu(Weekdays day, Coach coach, Category category, RandomUtil randomUtil) {
        while (true) {
            String menu = menuRepository.getRandomMenuOfCategory(category, randomUtil);
            if (coach.allocateMenu(menu, day)) {
                break;
            }
        }
    }

    public List<Category> getCategories() {
        return new ArrayList<>(allocatedCategories);
    }

    private Category selectCategory() {
        Category category;
        do {
            category = Category.getRandomCategory(new RandomNumberUtil());
        } while (!checkCategoryHistory(category));

        allocatedCategories.add(category);
        return category;
    }

    private boolean checkCategoryHistory(Category category) {
        int history = 0;
        for (Category allocatedCategory : allocatedCategories) {
            if (allocatedCategory.equals(category)) {
                history += 1;
            }
        }
        if (history > MAX_CATEGORY_COUNT) {
            return false;
        }
        return true;
    }
}
