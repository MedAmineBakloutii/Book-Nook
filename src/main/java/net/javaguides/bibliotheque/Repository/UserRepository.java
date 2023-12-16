package net.javaguides.bibliotheque.Repository;

import net.javaguides.bibliotheque.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
      
}
