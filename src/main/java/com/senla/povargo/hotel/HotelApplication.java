package com.senla.povargo.hotel;

import com.senla.povargo.hotel.console.Builder;
import com.senla.povargo.hotel.console.Navigator;
import com.senla.povargo.hotel.console.menu.MenuController;
import com.senla.povargo.hotel.manager.Administrator;
import com.senla.povargo.hotel.tools.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@SpringBootApplication
public class HotelApplication implements CommandLineRunner {

    @Autowired
    Administrator administrator;

    public static void main(String[] args) {
        SpringApplication.run(HotelApplication.class, args);
    }

    @Override
    public void run(String... args) {
        try {
            MenuController menu = new MenuController(new Builder(administrator), new Navigator());
            menu.run();
        } catch (Exception e) {
            Logger.Error(e.getMessage());
        }
    }
}
