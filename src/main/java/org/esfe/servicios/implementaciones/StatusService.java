package org.esfe.servicios.implementaciones;

import org.esfe.modelos.Status;
import org.esfe.repositorios.IStatusRepository;
import org.esfe.servicios.interfaces.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class StatusService implements IStatusService {

    @Autowired
    private IStatusRepository statusRepository;

    @Override
    public Page<Status> buscarTodosPaginados(Pageable pageable) {
        return statusRepository.findAll(pageable);
    }

    @Override
    public List<Status> obtenerTodos() {
        return statusRepository.findAll();
    }

    @Override
    public Optional<Status> bucarPorId(Integer id) {
        return statusRepository.findById(id);
    }

    @Override
    public Status createOrEditOne(Status status) {
        return statusRepository.save(status);
    }

    @Override
    public void eliminarPorId(Integer status) {
        statusRepository.deleteById(status);
    }
}
