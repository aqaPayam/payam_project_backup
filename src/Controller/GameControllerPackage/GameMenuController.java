package Controller.GameControllerPackage;

import Controller.Controller;
import Model.Cheat;
import View.CurrentMenu;

import java.util.regex.Matcher;

public class GameMenuController extends Controller {
    //GameDataBase darim
    Cheat cheat;
    CheatController cheatConteroller;
    CityController cityController;
    InfoController infoController;
    MapController mapController;
    Unitcontroller unitcontroller;

    public String nextTurn(Matcher matcher) {
        //TODO INJA MIAD HARCHI GOLD O INAST RO EZAFE MIKONE BARA TURN BADI
        return null;
    }

    @Override
    public String menuNavigate(Matcher matcher) {
        return null;
    }

    public String exit() {
        CurrentMenu.set(CurrentMenu.MainMenu);
        return "entered main menu";
    }
}
