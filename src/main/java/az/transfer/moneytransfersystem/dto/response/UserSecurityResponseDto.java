package az.transfer.moneytransfersystem.dto.response;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserSecurityResponseDto {

    private final String username;
    private final String password;

}
