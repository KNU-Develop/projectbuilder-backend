package knu.kproject.dto.token;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class TokenRefreshRequest {
    private String refreshToken;
}
