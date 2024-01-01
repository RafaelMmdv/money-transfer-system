package az.transfer.moneytransfersystem.dao.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transfers")
public class TransferEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private Long debtorAccountId;
    private Long creditorAmountId;

    private BigDecimal debtorAmount; //Recieve
    private BigDecimal creditAmount; //Send

    private String debtorCurrency;
    private String creditorCurrency;

    private String state; //SENT, CREATED, RECEIVED

    @CreationTimestamp
    private LocalDateTime createdAt;


}
