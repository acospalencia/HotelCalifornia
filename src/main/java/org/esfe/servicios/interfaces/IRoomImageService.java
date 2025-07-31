package org.esfe.servicios.interfaces;


import java.util.List;
import org.esfe.modelos.RoomImage;

public interface IRoomImageService {
    List<RoomImage> findAll();
    RoomImage findById(Integer id);
    RoomImage save(RoomImage roomImage);
    void deleteById(Integer id);
}
