package foods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User findByEmail(String email) {
		System.out.println(userRepository.findByEmail(email));
		return userRepository.findByEmail(email);
	}

	public User findByFullName(String fullName) {
		return userRepository.findByFullName(fullName);
	}
	
	public User findFirst() {
		return userRepository.findFirst();
	}

}
