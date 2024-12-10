package menu.controller;

import java.util.List;
import menu.constant.Weekdays;
import menu.dto.CoachDto;
import menu.service.MenuService;
import menu.util.InputProcessor;
import menu.util.Parser;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MenuService menuService;

    public MenuController(InputView inputView, OutputView outputView, MenuService menuService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuService = menuService;
    }

    public void run() {
        outputView.printStartMessage();
        menuService.initMenus();
        InputProcessor.continueUntilNormalInput(this::processCoachesInput, outputView::printErrorMessage);

        List<CoachDto> coaches = menuService.getCoaches();
        for (CoachDto coach : coaches) {
            InputProcessor.continueUntilNormalInput(this::processProhibitedMenusInput, outputView::printErrorMessage, coach);
        }

        menuService.allocateMenu();
    }

    private void processProhibitedMenusInput(CoachDto coach) {
        String prohibitedMenus = inputView.prohibitedMenuInput(coach.getName());
        List<String> parsedProhibitedMenus = Parser.parseMenus(prohibitedMenus);
        menuService.validateMenus(parsedProhibitedMenus);
        coach.setProhibitedMenus(parsedProhibitedMenus);
    }

    private void processCoachesInput() {
        String coachesInput = inputView.coachesInput();
        menuService.setCoaches(coachesInput);
    }
}
