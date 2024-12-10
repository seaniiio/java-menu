package menu.domain;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.constant.ErrorMessage;
import menu.constant.Weekdays;

public class Coach {

    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;

    private final String name;
    private List<Menu> prohibitedMenu;
    private Map<Weekdays, String> menus;

    public Coach(String name) {
        validate(name);
        this.name = name;
        this.prohibitedMenu = new ArrayList<>();
        this.menus = new HashMap<>();
    }

    private void validate(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NAME_LENGTH_ERROR.getErrorMessage());
        }
    }
}
