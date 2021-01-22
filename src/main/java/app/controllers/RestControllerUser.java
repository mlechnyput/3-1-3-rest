package app.controllers;

import app.models.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class RestControllerUser {

    private UserService userService;

    @Autowired
    public RestControllerUser(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value="api/user")
    public ResponseEntity<User> oneUser(Principal principal){
        String email= principal.getName();
        User user = userService.findUserByEmail(email);

        return user!=null?
                new ResponseEntity<>(user, HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}