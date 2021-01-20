package app.controllers;

import app.models.User;
import app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RestControllerAdm {

    private final UserService userService;

    public RestControllerAdm(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/all")
    public ResponseEntity<List<User>> allUsers(){
        final List<User> all =userService.getAllUsers();
        return all != null && !all.isEmpty() ?
                new ResponseEntity<>(all, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> createNewUser(@RequestBody User user){
        userService.createAndUpdate(user);
        return new ResponseEntity<>(userService.findUserByEmail(user.getEmail()), HttpStatus.CREATED);
    }

}