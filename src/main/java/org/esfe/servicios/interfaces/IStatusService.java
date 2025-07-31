package org.esfe.servicios.interfaces;

import org.esfe.modelos.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IStatusService {

    Page<Status> buscarTodosPaginados(Pageable pageable);

    List<Status> obtenerTodos();

    Optional<Status> bucarPorId(Integer id);

    Status createOrEditOne(Status status);

    void eliminarPorId(Integer status);
}
