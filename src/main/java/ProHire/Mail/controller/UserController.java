package ProHire.Mail.controller;

import ProHire.Mail.entity.User;
import ProHire.Mail.services.DeleteService;
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

    @Autowired
    private DeleteService deleteService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser , HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        List<User>  users = userService.getUsers();
        return new ResponseEntity<>(users , HttpStatus.ACCEPTED);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username){
        return new ResponseEntity<>(userService.getUser(username) , HttpStatus.OK);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String username){
        deleteService.deleteUser(username);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
