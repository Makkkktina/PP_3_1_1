package com.example.myart.controller;

import com.example.myart.model.Users;
import com.example.myart.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    private static final String REDIRECT_HOME = "redirect:/";

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String fullTable(ModelMap modelMap) {
        List<Users> users = userService.getAllUsers();
        modelMap.addAttribute("allUsers", users);
        return "home";
    }

    @GetMapping("/creat")
    public String createNewUser(ModelMap modelMap) {
        modelMap.addAttribute("userForm", new Users());
        return "createuser";
    }

    @PostMapping("/saveUser")
    public String saveNewUser(@ModelAttribute("userForm") @Valid Users user,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/createuser";
        }
        userService.creatUser(user);
        return REDIRECT_HOME;
    }

    @GetMapping("/updateUser")
    public String updateById(ModelMap modelMap, @RequestParam("id") long id) {
        Users user = userService.getUserId(id);
        modelMap.addAttribute("userForm", user);
        return "upd";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("userForm") @Valid Users user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/upd";
        }
        userService.updatUser(user);
        return REDIRECT_HOME;
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") long id) {
        userService.delUser(id);
        return REDIRECT_HOME;
    }
}