package View;

public enum CurrentMenu {
    MainMenu, GameMenu, ProfileMenu, LoginMenu, EndGame;
    private static CurrentMenu currentMenu = CurrentMenu.LoginMenu;

    public static CurrentMenu get() {
        return currentMenu;
    }

    public static void set(CurrentMenu currentMenu) {
        CurrentMenu.currentMenu = currentMenu;
    }
}
