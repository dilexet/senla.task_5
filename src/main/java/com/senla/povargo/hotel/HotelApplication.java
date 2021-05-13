package com.senla.povargo.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelApplication {

//    @Autowired
//    MenuController menu;

    public static void main(String[] args) {
        SpringApplication.run(HotelApplication.class, args);
    }

//    @Override
//    public void run(String... args) {
//        try {
//            menu.run();
//        } catch (Exception e) {
//            Logger.Error(e.getMessage());
//        }
//    }
}
