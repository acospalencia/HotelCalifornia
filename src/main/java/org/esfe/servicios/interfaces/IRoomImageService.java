package org.esfe.servicios.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import org.esfe.modelos.RoomImage;

public interface IRoomImageService {
    Page<RoomImage> buscarTodosPaginados(Pageable pageable);

    List<RoomImage> obtenerTodos();

    Optional<RoomImage> bucarPorId(Integer id);

    RoomImage createOrEditOne(RoomImage roomImage);

    void eliminarPorId(Integer roomImage);
}
