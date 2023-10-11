package az.transfer.moneytransfersystem.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor


public class UserResponseDto {

    private String name;
    private String surname;
    private String username;


}
