package org.esfe.repositorios;

import org.esfe.modelos.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
