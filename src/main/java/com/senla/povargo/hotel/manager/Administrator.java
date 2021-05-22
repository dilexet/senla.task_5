package com.senla.povargo.hotel.manager;


import com.senla.povargo.hotel.dto.RoomDTO;
import com.senla.povargo.hotel.dto.ServiceDTO;
import com.senla.povargo.hotel.entity.Client;
import com.senla.povargo.hotel.entity.Room;
import com.senla.povargo.hotel.entity.Service;
import com.senla.povargo.hotel.service.ClientManagement;
import com.senla.povargo.hotel.service.RoomManagement;
import com.senla.povargo.hotel.service.ServiceManagement;
import com.senla.povargo.hotel.tools.Converter;
import com.senla.povargo.hotel.tools.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Administrator {

    @Autowired
    RoomManagement roomManagement;
    @Autowired
    ServiceManagement serviceManagement;
    @Autowired
    ClientManagement clientManagement;

    public List<Room> getRooms(Sort sort) throws Exception {
        return roomManagement.getRooms(sort);
    }

    public RoomDTO getRoomDetails(Long id) throws Exception {
        var room = roomManagement.getById(id);
        return Converter.convertToDTO(room);
    }

    public void accommodateInRoom(Client client) {
        Logger.info(roomManagement.accommodateInRoom(client));
    }

    public void checkOutRoom(int number) {
        Logger.info(roomManagement.checkOutRoom(number));
    }

    public void changePriceRoom(Room room) {
        Logger.info(roomManagement.changePriceRoom(room.getNumber(), room.getPrice()));
    }

    public void addRoom(Room room) {
        Logger.info(roomManagement.addRoom(room));
    }

    // --------------------------------------------------------------------

    public List<Service> getServices(Sort sort) throws Exception {
        return serviceManagement.getServices(sort);
    }

    public ServiceDTO getServiceDetails(Long id) throws Exception {
        var service = serviceManagement.getById(id);
        return Converter.convertToDTO(service);
    }

    public void changePriceService(Service service) {
        Logger.info(serviceManagement.changePriceService(service.getServiceName(), service.getPrice()));
    }

    public void addService(Service service) {
        Logger.info(serviceManagement.addService(service));
    }
}
