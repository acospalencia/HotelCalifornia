package org.esfe.servicios.interfaces;


import java.util.List;
import org.esfe.modelos.RoomType;

public interface IRoomTypeService {
    List<RoomType> findAll();
    RoomType findById(Integer id);
    RoomType save(RoomType roomType);
    void deleteById(Integer id);
}