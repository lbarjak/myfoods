package foods;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private Long id;
	private Optional<User> user;

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
	
	public User findById(long id) {
		user = userRepository.findById(id);
        if (user.isPresent()) {
            System.out.println(user.get());
            return user.get();
        }
        System.out.printf("No user found with id %d%n", id);
		return null;
	}
	
}
