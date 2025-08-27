package org.esfe.repositorios;

import org.esfe.modelos.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRoomRepository extends JpaRepository<Room, Integer> {
    @Query("SELECT DISTINCT r FROM Room r LEFT JOIN FETCH r.images")
    List<Room> findAllWithImages();
}
