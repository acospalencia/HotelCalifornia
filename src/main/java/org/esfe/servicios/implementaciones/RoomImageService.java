package org.esfe.servicios.implementaciones;



import org.esfe.modelos.RoomImage;
import org.esfe.servicios.interfaces.IRoomImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.esfe.repositorios.IRoomImageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoomImageService implements IRoomImageService {

    @Autowired
    private IRoomImageRepository roomImageRepository;

    @Override
    public Page<RoomImage> buscarTodosPaginados(Pageable pageable) {
        return roomImageRepository.findAll(pageable);
    }

    @Override
    public List<RoomImage> obtenerTodos() {
        return roomImageRepository.findAll();
    }

    @Override
    public Optional<RoomImage> bucarPorId(Integer id) {
        return roomImageRepository.findById(id);
    }

    @Override
    public RoomImage createOrEditOne(RoomImage roomImage) {
        return roomImageRepository.save(roomImage);
    }

    @Override
    public void eliminarPorId(Integer roomImage) {
        roomImageRepository.deleteById(roomImage);
    }
}

