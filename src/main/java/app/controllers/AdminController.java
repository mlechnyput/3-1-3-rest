package app.controllers;

import app.models.User;
import app.service.UserService;
import org.springframework.http.HttpStatus;
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
//
//    @PostMapping
//    public String createNewUser(@ModelAttribute("user") User user) {
//        userService.createAndUpdate(user);
//        return "redirect:/admin/all";
//    }
//
//    @PostMapping("/{id}")
//    public String postEdit(@ModelAttribute() User user) {
//        userService.createAndUpdate(user);
//        return "redirect:all";
//    }
//
//    @PostMapping("/del/{id}")
//    public String deleteUserById(@ModelAttribute() User user) {
//        userService.delete(user.getId());
//        return "redirect:/admin/all";
//    }
}