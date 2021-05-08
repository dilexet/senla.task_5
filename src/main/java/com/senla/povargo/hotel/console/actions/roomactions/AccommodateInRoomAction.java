package com.senla.povargo.hotel.console.actions.roomactions;

import com.senla.povargo.hotel.console.actions.IAction;
import com.senla.povargo.hotel.entity.Client;
import com.senla.povargo.hotel.manager.Administrator;

import java.util.Scanner;

public class AccommodateInRoomAction implements IAction {
    private final Administrator administrator;

    public AccommodateInRoomAction(Administrator administrator) {
        this.administrator = administrator;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("Enter client name: ");
        String clientName = new Scanner(System.in).nextLine();

        Client client = new Client(clientName);

        administrator.accommodateInRoom(client);
    }
}
