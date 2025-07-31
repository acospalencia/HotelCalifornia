package org.esfe.repositorios;

import org.esfe.modelos.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusRepository extends JpaRepository<Status, Integer> {
}
