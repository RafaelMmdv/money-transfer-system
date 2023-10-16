package az.transfer.moneytransfersystem.service;


import az.transfer.moneytransfersystem.dao.entity.RoleEntity;
import az.transfer.moneytransfersystem.dao.entity.UserEntity;
import az.transfer.moneytransfersystem.dao.repository.UserRepository;
import az.transfer.moneytransfersystem.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;

    public UserResponseDto getUserById(Long id){

        UserEntity userEntity = userRepository.findById(id).get();
        UserResponseDto userResponseDto = UserResponseDto.builder().
                username(userEntity.getUsername()).
                name(userEntity.getName()).
                surname(userEntity.getSurname()).build();


        return userResponseDto;
    }

    public void addRolesToUser(Long userId, Set<Long> roleIds){
        UserEntity userEntity = userRepository.findById(userId).get();
        Set<RoleEntity> roleEntities = new HashSet<>();

for (Long roleId : roleIds) {
    RoleEntity roleEntityById = roleService.getRoleById(roleId);
    roleEntities.add(roleEntityById);
}
        userEntity.setRoles(roleEntities);
    }

}
