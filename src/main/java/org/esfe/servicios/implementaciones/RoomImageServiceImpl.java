package org.esfe.servicios.implementaciones;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.esfe.modelos.RoomImage;
import org.esfe.repositorios.IRoomImageRepository;
import org.esfe.servicios.interfaces.IRoomImageService;

@Service
public class RoomImageServiceImpl {

    @Autowired
    private IRoomImageRepository roomImageRepository;
}

