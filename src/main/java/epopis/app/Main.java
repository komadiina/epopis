package epopis.app;

import epopis.app.utils.MainMenu;

public class Main {
    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        menu.welcome();
        menu.printOptions();
        menu.selectMenu();
    }
}
