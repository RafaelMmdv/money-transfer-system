package az.transfer.moneytransfersystem.dao.repository;

import az.transfer.moneytransfersystem.dao.entity.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Long> {
}
