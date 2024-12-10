package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.constant.ErrorMessage;
import menu.constant.Weekdays;

public class Coach {

    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;

    private final String name;
    private List<String> prohibitedMenu;
    private List<String> menus;

    public Coach(String name) {
        validate(name);
        this.name = name;
        this.prohibitedMenu = new ArrayList<>();
        this.menus = new ArrayList<>();
    }

    public void setProhibitedMenu(List<String> prohibitedMenu) {
        this.prohibitedMenu = new ArrayList<>(prohibitedMenu);
    }

    private void validate(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NAME_LENGTH_ERROR.getErrorMessage());
        }
    }

    public boolean allocateMenu(String menu, Weekdays day) {
        if (prohibitedMenu.contains(menu)) {
            return false;
        }

        if (menus.contains(menu)) {
            return false;
        }

        menus.add(menu);
        return true;
    }

    public boolean ofName(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }

    public List<String> getMenus() {
        return new ArrayList<>(menus);
    }
}
