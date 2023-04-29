package com.example.demo.conroller;

import com.example.demo.model.Users;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

/*    @GetMapping
    public String hello(){
        return "hellow";
    }*/

    @GetMapping("/users")
    public String listStudents(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "main_users";
    }

    @GetMapping("/users/new")
    public String createStudentForm(Model model) {

        // create student object to hold student form data
        Users users = new Users();
        model.addAttribute("user", users);
        return "create_user";
    }

    @PostMapping("/users")
    public String saveStudent(@ModelAttribute("user") Users users) {
        userService.saveUser(users);
        return "redirect:/users";
    }

/*    @GetMapping("/users/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit_student";
    }*/

   /* @PostMapping("/users/{id}")
    public String updateStudent(@PathVariable int id,
                                @ModelAttribute("user") Users users,
                                Model model) {

        // get student from database by id
        Users existingUser = userService.getUserById(id);
        existingUser.setId(id);
        existingUser.setUserName(users.getUserName());
        existingUser.setEmail(users.getEmail());

        // save updated student object
        userService.updateUser(existingUser);
        return "redirect:/users";
    }*/

    // handler method to handle delete student request

    @GetMapping("/users/{id}")
    public String deleteStudent(@PathVariable int id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }


}
