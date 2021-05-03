package de.rabitem.HungaryCashierSystem_Backend.repositories;

import de.rabitem.HungaryCashierSystem_Backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(final String username);
}
