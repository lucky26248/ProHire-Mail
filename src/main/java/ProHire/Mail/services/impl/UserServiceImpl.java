package ProHire.Mail.services.impl;

import ProHire.Mail.Repo.UserRepo;
import ProHire.Mail.entity.User;
import ProHire.Mail.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public User createUser(User user) {

        User saveUser = new User();
        saveUser.setName(user.getName());
        saveUser.setUsername(user.getUsername());
        userRepo.save(saveUser);
        return saveUser;
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(String username) {
        return userRepo.findById(username).orElse(null);
    }

}
