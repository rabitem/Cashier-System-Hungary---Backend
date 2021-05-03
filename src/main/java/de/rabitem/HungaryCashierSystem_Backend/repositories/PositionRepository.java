package de.rabitem.HungaryCashierSystem_Backend.repositories;

import de.rabitem.HungaryCashierSystem_Backend.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
    Optional<Position> findTopByOrderByIdDesc();
    Optional<List<Position>> findAllByIdsale(final int id);
}
