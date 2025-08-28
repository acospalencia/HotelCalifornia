package org.esfe.servicios.implementaciones;

import org.esfe.modelos.Reservation;
import org.esfe.modelos.User;
import org.esfe.repositorios.IReservationRepository;
import org.esfe.servicios.interfaces.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService implements IReservationService {

    @Autowired
    private IReservationRepository reservationRepository;

    @Override
    public Page<Reservation> buscarTodosPaginados(Pageable pageable) {
        return reservationRepository.findAll(pageable);
    }

    @Override
    public List<Reservation> obtenerTodos() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> buscarPorId(Integer id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Reservation createOrEditOne(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void eliminarPorId(Integer reservation) {
        reservationRepository.deleteById(reservation);
    }

    @Override
    public List<Reservation> findByUser(User user) {
        return reservationRepository.findByUser(user);
    }

}
