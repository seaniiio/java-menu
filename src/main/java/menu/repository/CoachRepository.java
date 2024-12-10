package menu.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import menu.constant.ErrorMessage;
import menu.domain.Coach;

public class CoachRepository {

    private static final int COACH_NUMBER_MIN = 2;
    private static final int COACH_NUMBER_MAX = 5;

    // 테스트 어케하쥥..
    private static final CoachRepository coachRepository = new CoachRepository();
    private static List<Coach> coaches = new ArrayList<>();

    private CoachRepository() {};

    public static CoachRepository getInstance() {
        return coachRepository;
    }

    public void saveCoaches(List<String> coachesRaw) {
        validateCoachNumber(coachesRaw);
        validateCoachDuplicated(coachesRaw);

        List<Coach> parsedCoaches = new ArrayList<>();
        for (String coach : coachesRaw) {
            parsedCoaches.add(new Coach(coach));
        }
        coaches = parsedCoaches;
    }

    public List<String> getCoachesNames() {
        return coaches.stream()
                .map(Coach::getName)
                .collect(Collectors.toList());
    }

    public List<Coach> getCoaches() {
        return new ArrayList<>(coaches);
    }

    public void setProhibitedMenus(String name, List<String> parsedProhibitedMenus) {
        for (Coach coach : coaches) {
            if (coach.ofName(name)) {
                coach.setProhibitedMenu(parsedProhibitedMenus);
            }
        }
    }

    public Map<String, List<String>> getDiets() {
        Map<String, List<String>> diets = new HashMap<>();
        for (Coach coach : coaches) {
            diets.put(coach.getName(), coach.getMenus());
        }
        return diets;
    }

    private void validateCoachNumber(List<String> coaches) {
        if (coaches.size() < COACH_NUMBER_MIN || coaches.size() > COACH_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NUMBER_ERROR.getErrorMessage());
        }
    }

    private void validateCoachDuplicated(List<String> coachesRaw) {
        Set<String> coachesWithoutDuplicate = new HashSet<>(coachesRaw);
        if (coachesRaw.size() != coachesWithoutDuplicate.size()) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NAME_DUPLICATED_ERROR.getErrorMessage());
        }
    }
}
