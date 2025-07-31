package org.esfe.servicios.interfaces;

import org.esfe.modelos.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IPaymentService {
    Page<Payment> buscarTodosPaginados(Pageable pageable);

    List<Payment> obtenerTodos();

    Optional<Payment> buscarPorId(Integer id);

    Payment createOrEditOne(Payment payment);

    void eliminarPorId(Integer payment);
}
