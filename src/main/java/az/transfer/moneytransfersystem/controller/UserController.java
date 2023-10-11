package az.transfer.moneytransfersystem.controller;


import az.transfer.moneytransfersystem.dto.response.UserResponseDto;
import az.transfer.moneytransfersystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @GetMapping("{id}")
    public UserResponseDto getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

}
