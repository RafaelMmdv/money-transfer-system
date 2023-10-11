package az.transfer.moneytransfersystem.dto.response;


import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class UserSecurityResponseDto {

    private final String username;
    private final String password;

}
