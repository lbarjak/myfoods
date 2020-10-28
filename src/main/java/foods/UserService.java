package foods;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private Long id;

	@Autowired
	private UserRepository userRepository;

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User findByFullName(String fullName) {
		return userRepository.findByFullName(fullName);
	}
	
	public User findFirst() {
		return userRepository.findFirst();
	}
	
	public Optional<User> findById(long id) {
		return userRepository.findById(id);
	}

}
