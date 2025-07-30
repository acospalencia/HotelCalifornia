package org.esfe.servicios.interfaces;

import org.esfe.modelos.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IRolesService {
    Page<Role> buscarTodosPaginados(Pageable pageable);

    List<Role> obtenerTodos();

    Optional<Role> bucarPorId(Integer id);

    Role createOrEditOne(Role role);

    void eliminarPorId(Integer role);
}
