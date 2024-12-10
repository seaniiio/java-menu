package menu.repository;

public class MenuRepository {

    private static final MenuRepository instance = new MenuRepository();

    public static MenuRepository getInstance() {
        return instance;
    }
}
