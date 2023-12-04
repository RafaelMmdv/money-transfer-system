package az.transfer.moneytransfersystem.controller;


import az.transfer.moneytransfersystem.dto.request.UserRegisterRequestDto;
import az.transfer.moneytransfersystem.dto.response.UserResponseDto;
import az.transfer.moneytransfersystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @PreAuthorize("hasAuthority('write')")
    @GetMapping(value = "{id}")
    public UserResponseDto getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PreAuthorize("hasAuthority('update') or hasRole('ADMIN')")
    @PutMapping("{id}/roles")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addRolesToUser(@PathVariable Long id, @RequestParam Set<Long> roleIds){
        userService.addRolesToUser(id, roleIds);
    }

    @PutMapping("{id}/password")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePassword(@PathVariable Long id,@RequestBody UserRegisterRequestDto requestDto){
        userService.updatePassword(id, requestDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody UserRegisterRequestDto requestDto ){

        userService.saveUser(requestDto);

    }

}
