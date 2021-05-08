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
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
public class Administrator {

    @Autowired
    RoomManagement roomManagement;
    @Autowired
    ServiceManagement serviceManagement;
    @Autowired
    ClientManagement clientManagement;

    public List<Room> getRooms(Sort sort) {
        return roomManagement.getRooms(sort);
    }

    public List<Service> sortServices(Sort sort) {
        return serviceManagement.getServices(sort);
    }

    public void accommodateInRoom(Client client) {
        Logger.Info(roomManagement.accommodateInRoom(client));
    }

    public void checkOutRoom(int number) {
        Logger.Info(roomManagement.checkOutRoom(number));
    }

    public void changePriceRoom(Room room) {
        Logger.Info(roomManagement.changePriceRoom(room.getNumber(), room.getPrice()));
    }

    public void changePriceService(Service service) throws Exception {
        Logger.Info(serviceManagement.changePriceService(service.getServiceName(), service.getPrice()));
    }

    public void addRoom(Room room) {
        Logger.Info(roomManagement.addRoom(room));
    }

    public void addService(Service service) {
        Logger.Info(serviceManagement.addService(service));
    }

    public RoomDTO getRoomDetails(Long id) throws Exception {
        var room = roomManagement.getById(id);
        if (room.getClient() != null) {
            var client = clientManagement.getById(room.getClient().getId());
            return Converter.convertToDTO(room, client);
        }
        return Converter.convertToDTO(room);
    }

    public ServiceDTO getServiceDetails(Long id) {
        var service = serviceManagement.getById(id);
        return Converter.convertToDTO(service);
    }
}
