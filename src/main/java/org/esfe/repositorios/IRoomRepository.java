package org.esfe.repositorios;

import org.esfe.modelos.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoomRepository extends JpaRepository<Room, Integer> {
}
