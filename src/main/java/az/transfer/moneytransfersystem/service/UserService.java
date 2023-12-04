package az.transfer.moneytransfersystem.service;


import az.transfer.moneytransfersystem.dao.entity.RoleEntity;
import az.transfer.moneytransfersystem.dao.entity.UserEntity;
import az.transfer.moneytransfersystem.dao.repository.UserRepository;
import az.transfer.moneytransfersystem.dto.request.UserRegisterRequestDto;
import az.transfer.moneytransfersystem.dto.response.UserResponseDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDto getUserById(Long id){

        UserEntity userEntity = userRepository.findById(id).get();
        UserResponseDto userResponseDto = UserResponseDto.builder().
                username(userEntity.getUsername()).
                name(userEntity.getName()).
                surname(userEntity.getSurname()).build();


        return userResponseDto;
    }

    @Transactional
    public void addRolesToUser(Long userId, Set<Long> roleIds){
        UserEntity userEntity = userRepository.findById(userId).get();
        Set<RoleEntity> roleEntities = new HashSet<>();

for (Long roleId : roleIds) {
    RoleEntity roleEntityById = roleService.getRoleById(roleId);
    roleEntities.add(roleEntityById);
}
        userEntity.setRoles(roleEntities);
        userRepository.save(userEntity);
    }

    public void updatePassword(Long id, UserRegisterRequestDto requestDto) {
        if (!Objects.isNull(requestDto.getPassword())) {

            UserEntity userEntity = userRepository.findById(id).get();
            userEntity.setPassword(passwordEncoder.encode(requestDto.getPassword()));

            userRepository.save(userEntity);


        }
    }

    public void saveUser(UserRegisterRequestDto requestDto){

        UserEntity userEntity = UserEntity
                .builder()
                .username(requestDto.getUsername())
                .name(requestDto.getName())
                .surname(requestDto.getSurname())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .build();

        userRepository.save(userEntity);
    }

}
