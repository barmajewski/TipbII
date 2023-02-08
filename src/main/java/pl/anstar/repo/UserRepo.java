package pl.anstar.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.anstar.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
}
