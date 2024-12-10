package menu.service;

import java.util.List;
import menu.repository.CoachRepository;
import menu.repository.MenuRepository;

public class MenuService {

    private final MenuRepository menuRepository = MenuRepository.getInstance();
    private final CoachRepository coachRepository = CoachRepository.getInstance();

    public void setCoaches(String coachesInput) {
        List<String> coaches = Parser.parseCoaches(coachesInput);
        coachRepository.saveCoaches(coaches);
    }
}
