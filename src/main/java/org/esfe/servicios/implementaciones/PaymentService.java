package org.esfe.servicios.implementaciones;

import org.esfe.modelos.Payment;
import org.esfe.repositorios.IPaymentRepository;
import org.esfe.servicios.interfaces.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private IPaymentRepository paymentRepository;

    @Override
    public Page<Payment> buscarTodosPaginados(Pageable pageable){
        return paymentRepository.findAll(pageable);
    }
    @Override
    public List<Payment> obtenerTodos(){return paymentRepository.findAll();}

    @Override
    public Optional<Payment> buscarPorId(Integer id){return paymentRepository.findById(id);}

    @Override
    public Payment createOrEditOne(Payment payment){return paymentRepository.save(payment);}

    @Override
    public void eliminarPorId(Integer payment){paymentRepository.deleteById(payment);}

}
