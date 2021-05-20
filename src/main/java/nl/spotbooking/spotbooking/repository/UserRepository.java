package nl.spotbooking.spotbooking.repository;

import nl.spotbooking.spotbooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
