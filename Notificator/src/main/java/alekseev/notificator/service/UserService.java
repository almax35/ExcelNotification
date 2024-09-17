package alekseev.notificator.service;

import alekseev.notificator.entity.User;
import alekseev.notificator.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Cacheable(cacheNames = {"users"}, key="#type")
    public ArrayList<User> getUsersByType(String type){
       return userRepository.findAllByType(type);
    }
}
