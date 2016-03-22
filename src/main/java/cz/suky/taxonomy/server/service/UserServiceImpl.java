package cz.suky.taxonomy.server.service;

import cz.suky.taxonomy.server.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * Created by none_ on 03/14/16.
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public boolean verifyUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password) == null ? false : true;
    }
}
