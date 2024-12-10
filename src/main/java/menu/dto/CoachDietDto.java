package menu.dto;

import java.util.List;

public class CoachDietDto {

    private final String name;
    private final List<String> menus;

    public CoachDietDto(String name, List<String> menus) {
        this.name = name;
        this.menus = menus;
    }

    @Override
    public String toString() {
        String message =  "[ " + name;

        for (String menu : menus) {
            message += (" | " + menu);
        }

        message += " ]";
        return message;
    }
}
