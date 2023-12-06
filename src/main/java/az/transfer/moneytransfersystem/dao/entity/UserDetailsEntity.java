package az.transfer.moneytransfersystem.dao.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_details")
public class UserDetailsEntity {

    @Id
    private Long id;
}
