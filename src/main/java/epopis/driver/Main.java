package epopis.driver;

import epopis.driver.utils.MainMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        menu.welcome();
        menu.printOptions();
        menu.selectMenu();
    }
}
