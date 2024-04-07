package stellarburgers.pojo;

import lombok.Data;

@Data
public class UserAuth {
    private boolean success;
    private User user;
    private String accessToken;
    private String refreshToken;
    private String message;

    public String getToken() {
        return accessToken.substring(7);
    }
}
