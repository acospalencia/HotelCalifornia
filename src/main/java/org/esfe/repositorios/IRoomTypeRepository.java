package org.esfe.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.esfe.modelos.RoomType;

public interface IRoomTypeRepository extends JpaRepository<RoomType, Integer> {
}
