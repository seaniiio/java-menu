package menu.dto;

import java.util.ArrayList;
import java.util.List;

public class CoachDto {

    private final String name;
    private List<String> prohibitedMenus;

    public CoachDto(String name) {
        this.name = name;
        this.prohibitedMenus = new ArrayList<>();
    }

    public void setProhibitedMenus(List<String> prohibitedMenus) {
        this.prohibitedMenus = prohibitedMenus;
    }

    public List<String> getProhibitedMenus() {
        return new ArrayList<>(prohibitedMenus);
    }

    public String getName() {
        return name;
    }
}
