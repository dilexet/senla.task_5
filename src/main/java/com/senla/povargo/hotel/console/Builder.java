package com.senla.povargo.hotel.console;

import com.senla.povargo.hotel.console.actions.ExitAction;
import com.senla.povargo.hotel.console.actions.roomactions.*;
import com.senla.povargo.hotel.console.actions.serviceactions.AddServiceAction;
import com.senla.povargo.hotel.console.actions.serviceactions.ChangePriceServiceAction;
import com.senla.povargo.hotel.console.actions.serviceactions.SortServiceAction;
import com.senla.povargo.hotel.console.menu.Menu;
import com.senla.povargo.hotel.console.menu.items.MenuItem;
import com.senla.povargo.hotel.manager.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Builder {

    @Autowired
    private Administrator administrator;
    @Autowired
    private Menu rootMenu;

    public void buildMenu() {
        rootMenu.setName("Root Menu Options:");

        MenuItem accommodateInRoom = new MenuItem("Accommodate in a room", new AccommodateInRoomAction(administrator), rootMenu);
        MenuItem checkOutRoom = new MenuItem("Check out the room", new CheckOutRoomAction(administrator), rootMenu);
        MenuItem changePriceRoom = new MenuItem("Change room price", new ChangePriceRoomAction(administrator), rootMenu);
        MenuItem addRoom = new MenuItem("Add room", new AddRoomAction(administrator), rootMenu);
        MenuItem sortRoom = new MenuItem("Sorting rooms", new SortRoomAction(administrator), rootMenu);


        MenuItem changePriceService = new MenuItem("Change service price", new ChangePriceServiceAction(administrator), rootMenu);
        MenuItem addService = new MenuItem("Add service", new AddServiceAction(administrator), rootMenu);
        MenuItem sortService = new MenuItem("Sorting services", new SortServiceAction(administrator), rootMenu);

        MenuItem exit = new MenuItem("Exit", new ExitAction(), rootMenu);

        rootMenu.setMenuItems(new MenuItem[]
                {
                        accommodateInRoom,
                        checkOutRoom,
                        changePriceRoom,
                        addRoom,
                        sortRoom,
                        changePriceService,
                        addService,
                        sortService,
                        exit
                });
        setRootMenu(rootMenu);
    }

    public Menu getRootMenu() {
        return rootMenu;
    }

    public void setRootMenu(Menu rootMenu) {
        this.rootMenu = rootMenu;
    }

}
