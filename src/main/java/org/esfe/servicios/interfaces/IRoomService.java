package org.esfe.servicios.interfaces;

import org.esfe.modelos.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IRoomService {
    Page<Room> buscarTodosPaginados(Pageable pageable);

    List<Room> obtenerTodos();

    Optional<Room> bucarPorId(Integer id);

    Room createOrEditOne(Room room);

    void eliminarPorId(Integer room);

    List<Room> obtenerTodosConImagenes();
}
