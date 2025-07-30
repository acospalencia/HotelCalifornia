package org.esfe.repositorios;

import org.esfe.modelos.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolesRepository extends JpaRepository<Role, Integer> {
}
