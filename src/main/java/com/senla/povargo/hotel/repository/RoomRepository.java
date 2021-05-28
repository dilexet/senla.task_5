package com.senla.povargo.hotel.repository;

import com.senla.povargo.hotel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByNumber(int number);
}
