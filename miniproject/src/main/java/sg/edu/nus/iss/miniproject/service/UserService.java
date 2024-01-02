package sg.edu.nus.iss.miniproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.miniproject.repository.UserRepository;

@Service
public class UserService {

    private final static UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public boolean existingUser(String email) {
        return userRepository.userExists(email);
    }

    public static User checkUser(String email) {
        Optional<String> opt = userRepository.checkUser(email);
        if (opt.isEmpty()) {
            return null;
        }

        String value = opt.get();

        StringReader stringReader = new StringReader(value);
        JsonReader jsonReader = Json.createReader(stringReader);

        JsonObject jObject = jsonReader.readObject();
        return User.create(jObject);
    }
}

    /* public List<String> favorites(String email, List<String> s) {
        return userRepository.favourites(email, s);
    }

    public void saveUser(User user) {
    }
    
    public boolean saveUser(User user) {
        userRepository.saveUser(user);
        return true;
    }
 */