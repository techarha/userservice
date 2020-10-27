package com.manin.userservice.controller;

import com.manin.userservice.model.User;
import com.manin.userservice.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
public class UserController {
    public static final String USER_URL = "/user";
    public static final String USER_URL_ID = "/user/{id}";

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @ApiOperation("Get all users")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Retrieves Users", response = User.class)
    })
    @GetMapping(path = USER_URL, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @ApiOperation("Get user by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Retrieves User by Id", response = User.class)
    })
    @GetMapping(path = USER_URL_ID, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Optional<User> getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @ApiOperation("Saves user to db")
    @ApiResponses({
            @ApiResponse(code = 200, message = "User saved to Db", response = User.class)
    })
    @PostMapping(path = USER_URL, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public User saveUser(User user) {
        return userService.save(user);
    }
}
