package app.controllers;

import app.models.User;
import app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class RestControllerAdm {

    private final UserService userService;

    public RestControllerAdm(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/all")
    public ResponseEntity<List<User>> allUsers() {
        final List<User> all = userService.getAllUsers();
        return all != null && !all.isEmpty() ?
                new ResponseEntity<>(all, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<?> createNewUser(@RequestBody User user) {
        userService.createAndUpdate(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/del/{id}")
    public ResponseEntity<Long> delUser(@PathVariable Long id) {
        if (userService.findUserById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            userService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping(value = "/one/{id}")
    public ResponseEntity<User> getOneForModal(@PathVariable Long id) {
        User user = userService.findUserById(id);
        return user != null ?
                new ResponseEntity<>(user, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping(value = "/edit/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Long id) {
        user.setId(id);
        userService.createAndUpdate(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}