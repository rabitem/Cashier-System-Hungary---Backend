package de.rabitem.HungaryCashierSystem_Backend.repositories;

import de.rabitem.HungaryCashierSystem_Backend.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;


@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {
    Optional<Sale> findByDate(final Date date);
}
