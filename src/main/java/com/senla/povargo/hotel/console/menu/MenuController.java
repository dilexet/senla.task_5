package com.senla.povargo.hotel.console.menu;

import com.senla.povargo.hotel.console.Builder;
import com.senla.povargo.hotel.console.Navigator;
import com.senla.povargo.hotel.tools.Logger;

import java.util.Scanner;

public class MenuController {

    private final Builder builder;
    private final Navigator navigator;

    public MenuController(Builder builder, Navigator navigator) {
        this.builder = builder;
        this.navigator = navigator;
    }

    public void run() {
        builder.buildMenu();
        navigator.setCurrentMenu(builder.getRootMenu());
        navigator.printMenu();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int choice = scanner.nextInt();
            try {
                navigator.navigate(choice);
            } catch (Exception e) {
                Logger.Error(e.getMessage());
                break;
            }
        }
    }
}
