package menu.dto;

import java.util.List;
import menu.domain.Category;

public class CategoriesDto {

    private final List<Category> categories;

    public CategoriesDto(List<Category> categoryMap) {
        this.categories = categoryMap;
    }

    @Override
    public String toString() {
        String message = "[ 카테고리";

        for (Category category : categories) {
            message += (" | " + category);
        }
        message += " ]";

        return message;
    }
}
