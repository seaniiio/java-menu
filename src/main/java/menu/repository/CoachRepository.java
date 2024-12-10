package menu.repository;

import java.util.ArrayList;
import java.util.List;
import menu.constant.ErrorMessage;
import menu.domain.Coach;

public class CoachRepository {

    private static final int COACH_NUMBER_MIN = 2;
    private static final int COACH_NUMBER_MAX = 5;

    // 테스트 어케하쥥..
    private static final CoachRepository instance = new CoachRepository();
    private static List<Coach> coaches = new ArrayList<>();

    private CoachRepository() {};

    public static CoachRepository getInstance() {
        return instance;
    }

    public void saveCoaches(List<String> coachesRaw) {
        validateCoachNumber();

        List<Coach> parsedCoaches = new ArrayList<>();
        for (String coach : coachesRaw) {
            parsedCoaches.add(new Coach(coach));
        }
        coaches = parsedCoaches;
    }

    private void validateCoachNumber() {
        if (coaches.size() < COACH_NUMBER_MIN || coaches.size() > COACH_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NUMBER_ERROR.getErrorMessage());
        }
    }
}
