package az.transfer.moneytransfersystem.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor


public class UserResponseDto {

    private String name;
    private String surname;
    private String username;


}
