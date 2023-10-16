package az.transfer.moneytransfersystem.service;


import az.transfer.moneytransfersystem.dao.entity.RoleEntity;
import az.transfer.moneytransfersystem.dao.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class RoleService {
    private final RoleRepository roleRepository;

    public RoleEntity getRoleById(Long roleId){
        return roleRepository.findById(roleId).get();
    }


}
