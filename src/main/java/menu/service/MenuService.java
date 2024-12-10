package menu.service;

import java.util.List;
import java.util.stream.Collectors;
import menu.constant.Weekdays;
import menu.dto.CoachDto;
import menu.repository.AllocateRepository;
import menu.repository.CoachRepository;
import menu.repository.MenuRepository;
import menu.util.Parser;

public class MenuService {

    private final MenuRepository menuRepository = MenuRepository.getInstance();
    private final CoachRepository coachRepository = CoachRepository.getInstance();
    private final AllocateRepository allocateRepository = AllocateRepository.getInstance();

    public void initMenus() {
        menuRepository.initMenu();
    }

    public void setCoaches(String coachesInput) {
        List<String> coaches = Parser.parseCoaches(coachesInput);
        coachRepository.saveCoaches(coaches);
    }

    public List<CoachDto> getCoaches() {
        return coachRepository.getCoachesNames().stream()
                .map(CoachDto::new)
                .collect(Collectors.toList());
    }

    public void validateMenus(List<String> parsedProhibitedMenus) {
        menuRepository.validateMenus(parsedProhibitedMenus);
    }

    public void allocateMenu() {
        for (Weekdays day : Weekdays.values()) {
            allocateRepository.allocateMenu(day);
        }
    }
}
