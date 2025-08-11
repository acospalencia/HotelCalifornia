package org.esfe.servicios.implementaciones;

import org.esfe.modelos.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.esfe.repositorios.IRoomTypeRepository;
import org.esfe.servicios.interfaces.IRoomTypeService;

import java.util.List;
import java.util.Optional;

@Service
public class RoomTypeService implements IRoomTypeService {

    @Autowired
    private IRoomTypeRepository roomTypeRepository;


    @Override
    public Page<RoomType> buscarTodosPaginados(Pageable pageable) {
        return roomTypeRepository.findAll(pageable);
    }

    @Override
    public List<RoomType> obtenerTodos() {
        return roomTypeRepository.findAll();
    }

    @Override
    public Optional<RoomType> bucarPorId(Integer id) {
        return roomTypeRepository.findById(id);
    }

    @Override
    public RoomType createOrEditOne(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    @Override
    public void eliminarPorId(Integer roomType) {
        roomTypeRepository.deleteById(roomType);
    }
}

