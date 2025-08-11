package org.esfe.servicios.interfaces;


import java.util.List;
import java.util.Optional;

import org.esfe.modelos.RoomType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRoomTypeService {
    Page<RoomType> buscarTodosPaginados(Pageable pageable);

    List<RoomType> obtenerTodos();

    Optional<RoomType> bucarPorId(Integer id);

    RoomType createOrEditOne(RoomType roomType);

    void eliminarPorId(Integer roomType);
}