import com.example.usermanagement.model.User;
import com.example.usermanagement.repository.UserRepository;
import com.example.usermanagement.service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class TestUserService {
    public static void main(String[] args) {
        UserRepository fakeUserRepository = new UserRepository() {
            private final Map<Long, User> db = new HashMap<>();
            private long idCounter = 1;

            @Override
            public void deleteById(Long id) {
                super.deleteById(id);
            }

            @Override
            public Optional<User> findByUsername(String username) {
                return super.findByUsername(username);
            }

            @Override
            public Optional<User> findById(Long id) {
                return super.findById(id);
            }

            @Override
            public User save(User user) {
                return super.save(user);
            }
        };

    }
    public void testCreateUser() {}
}
