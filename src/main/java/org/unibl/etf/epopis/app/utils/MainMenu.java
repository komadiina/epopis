package org.unibl.etf.epopis.app.utils;

import org.unibl.etf.epopis.app.users.UserAdministrator;
import org.unibl.etf.epopis.app.users.UserElektricar;
import org.unibl.etf.epopis.app.users.UserKnjigovodja;
import org.unibl.etf.epopis.app.users.UserPotrosac;

import java.util.Scanner;

public class MainMenu {
    private final Scanner scn = new Scanner(System.in);

    public void welcome() {
        System.out.println("ePopis (v1.0)");
        System.out.println("Baze podataka (2261) | 23/24");
        System.out.println("Ognjen Komadina - github.com/komadiina");

        System.out.println("Dobrodosli!");
    }

    public void selectMenu() {
        System.out.print("> ");
        int sel = scn.nextInt();
        scn.nextLine(); // ?

        if (sel == 1)
            potrosacMenu();
        else if (sel == 2)
            elektricarMenu();
        else if (sel == 3)
            knjigovodjaMenu();
        else if (sel == 4)
            administratorMenu();
        else if (sel == 5)
            System.exit(0x00);
        else {
            System.out.println("[!] Neispravna opcija.");
            selectMenu();
        }
    }

    public void printOptions() {
        System.out.println("--> Moguce opcije:");
        System.out.println("[1] Meni potrosaca");
        System.out.println("[2] Meni elektricara");
        System.out.println("[3] Meni knjigovodje");
        System.out.println("[4] Administratorski meni");
        System.out.println("[5] Izlaz");
    }

    public void potrosacMenu() {
    }

    public void elektricarMenu() {
    }

    public void knjigovodjaMenu() {
    }

    public void administratorMenu() {
    }
}
