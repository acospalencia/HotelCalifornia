package org.esfe.servicios.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.esfe.repositorios.IRoomTypeRepository;
import org.esfe.servicios.interfaces.IRoomTypeService;

@Service
public class RoomTypeServiceImpl implements IRoomTypeRepository {

    @Autowired
    private IRoomTypeRepository roomTypeRepository;

}

