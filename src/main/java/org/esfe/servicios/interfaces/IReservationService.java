package org.esfe.servicios.interfaces;

import org.esfe.modelos.Reservation;
import org.esfe.modelos.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


import java.util.Optional;
import java.util.List;

public interface IReservationService {
    Page<Reservation> buscarTodosPaginados(Pageable pageable);

    List<Reservation> obtenerTodos();

    Optional<Reservation> buscarPorId(Integer id);

    Reservation createOrEditOne(Reservation reservation);

    void eliminarPorId(Integer reservation);

    List<Reservation> findByUser(User user);
}
