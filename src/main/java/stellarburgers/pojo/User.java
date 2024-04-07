package stellarburgers.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

@Data
@AllArgsConstructor
public class User {
    private String email;
    private String password;
    private String name;

    public static User create(int passwordLength){
        return new User(
                RandomStringUtils.randomAlphabetic(9) + "@gmail.com",
                RandomStringUtils.randomAlphabetic(passwordLength),
                RandomStringUtils.randomAlphabetic(9)
        );
    }
}
