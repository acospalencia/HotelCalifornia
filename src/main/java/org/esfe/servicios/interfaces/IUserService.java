package org.esfe.servicios.interfaces;

import org.esfe.modelos.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    Page<User> buscarTodosPaginados(Pageable pageable);

    List<User> obtenerTodos();

    Optional<User> bucarPorId(Integer id);

    User createOrEditOne(User user);

    void eliminarPorId(Integer role);

    Optional<User> buscarPorEmail(String email);
}
