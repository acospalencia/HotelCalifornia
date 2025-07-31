package org.esfe.servicios.implementaciones;

import org.esfe.modelos.Room;
import org.esfe.repositorios.IRoomRepository;
import org.esfe.servicios.interfaces.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService implements IRoomService {

    @Autowired
    private IRoomRepository roomRepository;

    @Override
    public Page<Room> buscarTodosPaginados(Pageable pageable) {
        return roomRepository.findAll(pageable);
    }

    @Override
    public List<Room> obtenerTodos() {
        return roomRepository.findAll();
    }

    @Override
    public Optional<Room> bucarPorId(Integer id) {
        return roomRepository.findById(id);
    }

    @Override
    public Room createOrEditOne(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public void eliminarPorId(Integer room) {
        roomRepository.deleteById(room);
    }
}
