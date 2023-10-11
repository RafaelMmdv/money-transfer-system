package az.transfer.moneytransfersystem.service;


import az.transfer.moneytransfersystem.dao.entity.UserEntity;
import az.transfer.moneytransfersystem.dao.repository.UserRepository;
import az.transfer.moneytransfersystem.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto getUserById(Long id){

        UserEntity userEntity = userRepository.findById(id).get();
        UserResponseDto userResponseDto = UserResponseDto.builder().
                username(userEntity.getUsername()).
                name(userEntity.getName()).
                surname(userEntity.getSurname()).build();


        return userResponseDto;
    }

}
