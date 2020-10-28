package foods;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
	//email alapján ezzel megkereshető egy felhasználó, ami visszaad egy User objektumot
	//a visszaadott User objektum alapján aztán a jelszó, role visszakereshető

	User findByFullName(String fullName);
	
	@Query(value = "SELECT * FROM users LIMIT 1", nativeQuery = true)
	User findFirst();
	
	Optional<User> findById(Long id);
	

}
