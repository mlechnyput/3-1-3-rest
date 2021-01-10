package app.controllers;

import app.models.User;
import app.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String allUsers(Principal prince, Model model, @ModelAttribute("user") User user) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Set<String> roles = auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());

        StringBuilder sb = new StringBuilder();
        for (String ro : roles) sb.append(ro).append(" ");

        model.addAttribute("email", prince.getName());
        model.addAttribute("roles",sb);
        model.addAttribute("allUsers", userService.getAllUsers());

        return "users";
    }

    @GetMapping("/user")
    public String user(Principal principal, Model model) {
        String email= principal.getName();
        User user = userService.findUserByEmail(email);
        model.addAttribute("user", user);
        return "adminuser";
    }

    @GetMapping("/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        User user = userService.findUserById(id);

        model.addAttribute("user", user);
        return "/edit";
    }

    @GetMapping("/new")
    public String openPageNew(@ModelAttribute("user") User user) {
        return "/create";
    }

    @PostMapping
    public String createNewUser(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/admin/all";
    }

    @PostMapping("/{id}")
    public String postEdit(@ModelAttribute() User user) {
        userService.update(user);
        return "redirect:all";
    }

    @PostMapping("/del/{id}")
    public String deleteUserById(@ModelAttribute("user") User user) {
        userService.delete(user.getId());
        return "redirect:/admin/all";
    }

//    @PostMapping("/del/{id}")
//    public String deleteUserById(@PathVariable Long id) {
//        userService.delete(id);
//        return "redirect:/admin/all";
//    }
}