package stellarburgers.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import stellarburgers.pojo.User;
import stellarburgers.pojo.UserAuth;

import static stellarburgers.api.BaseApi.deleteRequest;
import static stellarburgers.api.BaseApi.postRequest;

public class UserApi {
    private final static String USER_REGISTRATION = "/api/auth/register";

    private final static String USER_AUTH = "/api/auth/login";

    private final static String USER_INFO = "/api/auth/user";

    @Step("Вызов api создания Пользователя")
    public static void createUser(User req){
        postRequest(req, USER_REGISTRATION);
    }

    @Step("Вызов api авторизации Пользователя")
    public static Response authUser(User req){
        return postRequest(req, USER_AUTH);
    }

    @Step("Вызов api удаления Пользователя")
    public static void deleteUser(UserAuth user){
        deleteRequest(user.getToken(), USER_INFO);
    }
}
