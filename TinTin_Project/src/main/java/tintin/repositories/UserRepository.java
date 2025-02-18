package tintin.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tintin.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public Optional<User> findOneByUsername(String username);
}
