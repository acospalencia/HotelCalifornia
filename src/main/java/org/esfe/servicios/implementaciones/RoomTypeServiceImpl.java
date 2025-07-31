package org.esfe.servicios.implementaciones;

import org.esfe.modelos.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.esfe.repositorios.IRoomTypeRepository;
import org.esfe.servicios.interfaces.IRoomTypeService;

import java.util.List;

@Service
public class RoomTypeServiceImpl implements IRoomTypeService {

    @Autowired
    private IRoomTypeRepository roomTypeRepository;

    @Override
    public List<RoomType> findAll() {
        return List.of();
    }

    @Override
    public RoomType findById(Integer id) {
        return null;
    }

    @Override
    public RoomType save(RoomType roomType) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}

