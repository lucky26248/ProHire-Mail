package ProHire.Mail.controller;

import ProHire.Mail.Repo.UserRepo;
import ProHire.Mail.entity.User;
import ProHire.Mail.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser , HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUser(){
        List<User>  users = userService.getUsers();
        return new ResponseEntity<>(users , HttpStatus.ACCEPTED);
    }
}
