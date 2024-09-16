package alekseev.notificator.repository;

import alekseev.notificator.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    ArrayList<User> findAllByType(String type);
}
