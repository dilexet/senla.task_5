package com.senla.povargo.hotel.console.actions.serviceactions;

import com.senla.povargo.hotel.console.actions.IAction;
import com.senla.povargo.hotel.entity.Service;
import com.senla.povargo.hotel.manager.Administrator;

import java.util.Scanner;

public class ChangePriceServiceAction implements IAction {
    private final Administrator administrator;

    public ChangePriceServiceAction(Administrator administrator) {
        this.administrator = administrator;
    }

    @Override
    public void execute() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the service name: ");
        String serviceName = scanner.nextLine();
        System.out.println("Enter the service new price: ");
        double servicePrice = scanner.nextDouble();

        Service service = new Service(serviceName, servicePrice);

        administrator.changePriceService(service);
    }
}
