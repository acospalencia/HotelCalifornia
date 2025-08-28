package org.esfe.repositorios;

import org.esfe.modelos.Reservation;
import org.esfe.modelos.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByUser(User user);
}
