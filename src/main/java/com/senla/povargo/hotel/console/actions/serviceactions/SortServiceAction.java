package com.senla.povargo.hotel.console.actions.serviceactions;

import com.senla.povargo.hotel.console.actions.IAction;
import com.senla.povargo.hotel.manager.Administrator;
import org.springframework.data.domain.Sort;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SortServiceAction implements IAction {
    private final Administrator administrator;

    public SortServiceAction(Administrator administrator) {
        this.administrator = administrator;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("Enter the sorting type: ");
        System.out.println("0 - Do not sort\n1 - Name\n2 - Price");
        int command = new Scanner(System.in).nextInt();

        switch (command) {
            case 0 -> {
                var services = administrator.getServices(Sort.by("id"));
                for (var service : services) {
                    System.out.println(administrator.getServiceDetails(service.getId()).toString());
                }
            }
            case 1 -> {
                var services = administrator.getServices(Sort.by("serviceName"));
                for (var service : services) {
                    System.out.println(administrator.getServiceDetails(service.getId()).toString());
                }
            }
            case 2 -> {
                var services = administrator.getServices(Sort.by("price"));
                for (var service : services) {
                    System.out.println(administrator.getServiceDetails(service.getId()).toString());
                }
            }
            default -> throw new InputMismatchException("Invalid input");
        }
    }
}
