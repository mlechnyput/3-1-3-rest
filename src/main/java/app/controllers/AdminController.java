package app.controllers;

import app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
//@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String allUsers() {
        return "users";
    }


    @GetMapping("/user")
    public String user() {
        return "adminuser";
    }

}