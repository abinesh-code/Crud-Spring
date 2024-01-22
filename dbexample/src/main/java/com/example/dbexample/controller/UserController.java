package com.example.dbexample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.dbexample.model.User;
import com.example.dbexample.repository.UserRepository;
import com.example.dbexample.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @RequestMapping("index")
    public String index() {
        // Add any initialization logic here
        return "index";
    }

    @RequestMapping("store")
    public ModelAndView store(User user, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView("insert");

        if (result.hasErrors()) {
            // Handle validation errors
            modelAndView.setViewName("error"); // Assuming you have an "error" view
            return modelAndView;
        }

        if (userRepository.existsById(user.getId())) {
            // Handle duplicate ID error
            result.rejectValue("id", "error.user", "User with this ID already exists");
            modelAndView.setViewName("error"); // Assuming you have an "error" view
            return modelAndView;
        }

        userRepository.save(user);
        return modelAndView;
    }

    @RequestMapping("show")
    public ModelAndView display(@RequestParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("display");

        if (!userRepository.existsById(id)) {
            // Handle user not found
            return new ModelAndView("userNotFound"); // Assuming you have a "userNotFound" view
        }

        User user = userRepository.findById(id).orElse(null);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping("remove")
    public ModelAndView delete(@RequestParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("delete");

        if (!userRepository.existsById(id)) {
            // Handle user not found
            return new ModelAndView("userNotFound"); // Assuming you have a "userNotFound" view
        }

        User user = userRepository.findById(id).orElse(null);
        modelAndView.addObject("user", user);
        userRepository.deleteById(id);
        return modelAndView;
    }

    @RequestMapping("modify")
    public ModelAndView update(User user, BindingResult result) {
        if (result.hasErrors()) {
            // Handle validation errors
            return new ModelAndView("error"); // Assuming you have an "error" view
        }

        if (!userRepository.existsById(user.getId())) {
            // Handle user not found
            return new ModelAndView("userNotFound"); // Assuming you have a "userNotFound" view
        }

        ModelAndView modelAndView = new ModelAndView("update");

        user = userService.updateUser(user.getId(), user.getName(), user.getAge());
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping("fetchAll")
    public ModelAndView fetch() {

        ModelAndView modelAndView = new ModelAndView("fetch");
        Iterable<User> usersIterable = userRepository.findAll();
        List<User> userList = new ArrayList<>();
        usersIterable.forEach(userList::add);
        modelAndView.addObject("user", userList);

        return modelAndView;
    }

    @RequestMapping("removeAll")
    public String deleteAll() {

        userRepository.deleteAll();
       
        return "removeAll";
    }
}
