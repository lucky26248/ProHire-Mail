package ProHire.Mail.services;

import ProHire.Mail.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    List<User> getUsers();
    User getUser(String username);
}
