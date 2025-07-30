package org.esfe.servicios.implementaciones;

import org.esfe.modelos.Role;
import org.esfe.repositorios.IRolesRepository;
import org.esfe.servicios.interfaces.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRolesService {

    @Autowired
    private IRolesRepository rolesRepository;

    @Override
    public Page<Role> buscarTodosPaginados(Pageable pageable) {
        return rolesRepository.findAll(pageable);
    }

    @Override
    public List<Role> obtenerTodos() {
        return rolesRepository.findAll();
    }

    @Override
    public Optional<Role> bucarPorId(Integer id) {
        return rolesRepository.findById(id);
    }

    @Override
    public Role createOrEditOne(Role role) {
        return rolesRepository.save(role);
    }

    @Override
    public void eliminarPorId(Integer role) {
        rolesRepository.deleteById(role);
    }
}
