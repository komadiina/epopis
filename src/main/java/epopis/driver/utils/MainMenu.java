package epopis.driver.utils;

import epopis.driver.users.UserAdministrator;
import epopis.driver.users.UserElektricar;
import epopis.driver.users.UserKnjigovodja;
import epopis.driver.users.UserPotrosac;

import java.util.Scanner;

public class MainMenu {
    private Scanner scn = new Scanner(System.in);

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
        UserPotrosac user = new UserPotrosac();

        System.out.print("Unesite Vas aktivni PIB: ");
        String activePIB = scn.nextLine();
        user.setPib(activePIB);

        if (!user.exists(activePIB)) {
            System.out.println("Nepostojeci PIB.");
            return;
        }
        else System.out.printf("Dobrodosli, %s!\n", user.getEntity().getNaziv());

        // TODO
    }

    public void elektricarMenu() {
        UserElektricar user = new UserElektricar();

        System.out.print("Unesite Vas JMBG: ");
        String activeJMBG = scn.nextLine();
        user.setJmbg(activeJMBG);

        if (!user.exists(activeJMBG)) {
            System.out.println("Nepostojeci JMBG.");
            return;
        }
        else System.out.printf("Dobrodosli, %s!\n", user.getEntity().getIme());

        // TODO
    }

    public void knjigovodjaMenu() {
        UserKnjigovodja user = new UserKnjigovodja();

        System.out.print("Unesite Vas JMBG: ");
        String activeJMBG = scn.nextLine();
        user.setJmbg(activeJMBG);

        if (!user.exists(activeJMBG)) {
            System.out.println("Nepostojeci JMBG.");
            return;
        }
        else System.out.printf("Dobrodosli, %s!\n", user.getEntity().getIme());
    }

    public void administratorMenu() {
        UserAdministrator user = new UserAdministrator();

        int counter = 3;
        boolean status = false;
        while (counter >= 0) {
            System.out.print("Unesite Vase korisnicko ime: ");
            String username = scn.nextLine();

            System.out.print("Unesite vasu lozinku: ");
            String password = scn.nextLine();
            password = SecurityUtils.hash(password);

            status = user.login(password);
            counter--;

            if (status) break;
        }

        if (!status) {
            System.out.println("Previse promasenih pokusaja.");
            return;
        } else System.out.printf("Dobrodosli, %s!\n", user.getEntity().getPk_username());
    }
}
