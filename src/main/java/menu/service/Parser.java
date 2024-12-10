package menu.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.constant.ErrorMessage;

public class Parser {

    public static List<String> parseCoaches(String coachesInput) {
        try {
            return Arrays.stream(coachesInput.split(","))
                    .collect(Collectors.toList());
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_FORMAT_ERROR.getErrorMessage());
        }
    }
}
