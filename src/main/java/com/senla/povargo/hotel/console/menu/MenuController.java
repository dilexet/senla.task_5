package com.senla.povargo.hotel.console.menu;

import com.senla.povargo.hotel.console.Builder;
import com.senla.povargo.hotel.console.Navigator;
import com.senla.povargo.hotel.tools.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MenuController {

    @Autowired
    private Builder builder;
    @Autowired
    private Navigator navigator;


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
                Logger.error(e.getMessage());
                break;
            }
        }
    }
}
