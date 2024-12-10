package menu.repository;

import java.util.ArrayList;
import java.util.List;
import menu.constant.Weekdays;
import menu.domain.Category;
import menu.domain.Coach;

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

    // depth 3!
    public void allocateMenu(Weekdays day) {
        Category category = selectCategory();

        List<Coach> coaches = coachRepository.getCoaches();
        for (Coach coach : coaches) {
            while (true) {
                String menu = menuRepository.getRandomMenuOfCategory(category);
                if (coach.allocateMenu(menu, day)) {
                    break;
                }
            }

        }
    }

    private Category selectCategory() {
        Category category;
        do {
            category = Category.getRandomCategory();
        } while (!checkCategoryHistory(category));

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