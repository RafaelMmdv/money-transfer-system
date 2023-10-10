package az.transfer.moneytransfersystem.dao.repository;

import az.transfer.moneytransfersystem.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
