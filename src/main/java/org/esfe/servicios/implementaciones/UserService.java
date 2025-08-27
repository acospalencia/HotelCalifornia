package org.esfe.servicios.implementaciones;

import org.esfe.modelos.User;
import org.esfe.repositorios.IUserRepository;
import org.esfe.servicios.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Page<User> buscarTodosPaginados(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public List<User> obtenerTodos() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> bucarPorId(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User createOrEditOne(User user) {
        return userRepository.save(user);
    }

    @Override
    public void eliminarPorId(Integer user) {
        userRepository.deleteById(user);
    }

    @Override
    public Optional<User> buscarPorEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
