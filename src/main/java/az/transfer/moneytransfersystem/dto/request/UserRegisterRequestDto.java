package az.transfer.moneytransfersystem.dto.request;


import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequestDto {

    private String name;
    private String surname;
    private String password;
    private String username;


}
