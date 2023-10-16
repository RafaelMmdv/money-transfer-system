package az.transfer.moneytransfersystem.controller;


import az.transfer.moneytransfersystem.dto.response.UserResponseDto;
import az.transfer.moneytransfersystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Set;

@RestController
@EnableWebMvc
@RequestMapping(value = "v1/users")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @GetMapping("{id}")
    public UserResponseDto getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("{id}/roles")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addRolesToUser(@PathVariable Long id, @RequestParam Set<Long> roleIds){
        userService.addRolesToUser(id, roleIds);
    }


}
